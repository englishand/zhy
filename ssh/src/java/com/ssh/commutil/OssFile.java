/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.commutil;

import com.digitalchina.sequence.DzdaSequence;
import ctais.business.yxcx.htcobject.HcpObjectUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Oss服务文件上传，下载
 *
 * @date 2019-6-21 16:49:57
 * @author ZHY
 * @version 01
 */
public class OssFile {

    public void getOssUrl() {
        try {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String filename = DzdaSequence.getNewFilename("WSBS");
            String filepath = DzdaSequence.getFilepath(uuid, filename, "pdf");  //获取上传服务文件地址
            boolean rtn = HcpObjectUtil.putObjectToHCP("d:\\aaa.txt", filepath);//上传操作
        } catch (Exception ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 根据上传服务文件地址获取文件流
     *
     * @param filepath
     */
    public void getInputStream(String filepath) {
        String filename = "";                                            //oss服务上的文件名

        try {
            String[] paths = filepath.split("/");
            filename = paths[paths.length - 1];

            InputStream in = HcpObjectUtil.getObjectFromHCP(filepath);
            if (null != in) {
                System.out.println("文件不存在");
            }
            FileUtils.copyInputStreamToFile(in, new File("d:\\aaa2.txt"));//将文件流直接写在目的文件上
        } catch (Exception ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 将现有的InputStream转String,用到Base64,用于项目方便传递流
     *
     * @param in
     */
    public void inputStreamToString(InputStream in) {
        ByteArrayOutputStream bos = null;

        try {
            bos = new ByteArrayOutputStream();
            int len = 0;
            byte[] bt = new byte[1024];
            while ((len = in.read(bt)) > 0) {
                bos.write(bt, 0, len);
            }

            String boss = Base64.encodeBase64String(bos.toByteArray());

        } catch (IOException ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 根据获取的输出流的字符串下载文件
     *
     * @param boss
     */
    public void downFileByInputStream(String boss) {

        FileOutputStream fous = null;
        try {
            byte by[] = Base64.decodeBase64(boss);
            ByteArrayInputStream bis = new ByteArrayInputStream(by);
            fous = new FileOutputStream("d:\\aaa3.txt");

            int len = 0;
            byte bb[] = new byte[1024];
            while ((len = bis.read(bb)) > 0) {
                fous.write(bb, 0, len);
            }
            bis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fous.close();
            } catch (IOException ex) {
                Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 另一种获取流的方式，HttpEntity.getContent()获取流
     */
    public void getInputStream() {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httppost = new HttpPost("url" + "param");
            HttpResponse res = client.execute(httppost);

            //OutputStream out = response.getOutputStream();
            //获取其他值，首先先将值放到header中
            //response.setHeader("Content-Disposition","attachment;filename="+new String(filename.getBytes("gb2312"),"iso8859-1"));
            Header h[] = res.getHeaders("Content-Disposition");
            String filename = "";
            if (h.length != 0) {
                filename = new String(h[0].toString().getBytes("iso-8859-1"), "GB2312");
            }

            //前提：将inputstream写入out输出流中
            HttpEntity entity = res.getEntity();
            ByteArrayOutputStream out1 = null;
            if (entity != null) {
                BufferedInputStream bis = new BufferedInputStream(entity.getContent());  //从entity中获取流
                out1 = new ByteArrayOutputStream();
                int leng = 0;
                while ((leng = bis.read()) != 0) {
                    out1.write(leng);
                }
                bis.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 将文件流或文件提交post请求，接收类正常接受文件
     */
    public void postFile() {

        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String result = "";
        
        try {
            File file = new File("D:\\test.txt");
            HttpPost post = new HttpPost("http://127.0.0.1:7001/oss_file_server/file/UploadServlet");
            StringBody filetype = new StringBody("txt", ContentType.MULTIPART_FORM_DATA);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addPart("filetype", filetype);  //提交普通文本
            
            //以下两种二选其一
            builder.addBinaryBody("upfile", file, ContentType.MULTIPART_FORM_DATA, "test.txt"); //提交文件
            builder.addBinaryBody("upfile", new FileInputStream(file), ContentType.MULTIPART_FORM_DATA, "test.txt");//提交文件流
            
            HttpEntity entity = builder.build();
            post.setEntity(entity);
            response = httpclient.execute(post);
            
            System.out.println(response.getStatusLine());
            HttpEntity resentity = response.getEntity();
            if(resentity!=null){
                result = EntityUtils.toString(entity, Charset.forName("UTF-8"));
            }
            
            EntityUtils.consume(resentity); //关闭流
            response.close();
            
            httpclient.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result); ;
    }
}
