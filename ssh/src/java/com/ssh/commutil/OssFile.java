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
 * Oss�����ļ��ϴ�������
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
            String filepath = DzdaSequence.getFilepath(uuid, filename, "pdf");  //��ȡ�ϴ������ļ���ַ
            boolean rtn = HcpObjectUtil.putObjectToHCP("d:\\aaa.txt", filepath);//�ϴ�����
        } catch (Exception ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * �����ϴ������ļ���ַ��ȡ�ļ���
     *
     * @param filepath
     */
    public void getInputStream(String filepath) {
        String filename = "";                                            //oss�����ϵ��ļ���

        try {
            String[] paths = filepath.split("/");
            filename = paths[paths.length - 1];

            InputStream in = HcpObjectUtil.getObjectFromHCP(filepath);
            if (null != in) {
                System.out.println("�ļ�������");
            }
            FileUtils.copyInputStreamToFile(in, new File("d:\\aaa2.txt"));//���ļ���ֱ��д��Ŀ���ļ���
        } catch (Exception ex) {
            Logger.getLogger(OssFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * �����е�InputStreamתString,�õ�Base64,������Ŀ���㴫����
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
     * ���ݻ�ȡ����������ַ��������ļ�
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
     * ��һ�ֻ�ȡ���ķ�ʽ��HttpEntity.getContent()��ȡ��
     */
    public void getInputStream() {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httppost = new HttpPost("url" + "param");
            HttpResponse res = client.execute(httppost);

            //OutputStream out = response.getOutputStream();
            //��ȡ����ֵ�������Ƚ�ֵ�ŵ�header��
            //response.setHeader("Content-Disposition","attachment;filename="+new String(filename.getBytes("gb2312"),"iso8859-1"));
            Header h[] = res.getHeaders("Content-Disposition");
            String filename = "";
            if (h.length != 0) {
                filename = new String(h[0].toString().getBytes("iso-8859-1"), "GB2312");
            }

            //ǰ�᣺��inputstreamд��out�������
            HttpEntity entity = res.getEntity();
            ByteArrayOutputStream out1 = null;
            if (entity != null) {
                BufferedInputStream bis = new BufferedInputStream(entity.getContent());  //��entity�л�ȡ��
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
     * ���ļ������ļ��ύpost���󣬽��������������ļ�
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
            builder.addPart("filetype", filetype);  //�ύ��ͨ�ı�
            
            //�������ֶ�ѡ��һ
            builder.addBinaryBody("upfile", file, ContentType.MULTIPART_FORM_DATA, "test.txt"); //�ύ�ļ�
            builder.addBinaryBody("upfile", new FileInputStream(file), ContentType.MULTIPART_FORM_DATA, "test.txt");//�ύ�ļ���
            
            HttpEntity entity = builder.build();
            post.setEntity(entity);
            response = httpclient.execute(post);
            
            System.out.println(response.getStatusLine());
            HttpEntity resentity = response.getEntity();
            if(resentity!=null){
                result = EntityUtils.toString(entity, Charset.forName("UTF-8"));
            }
            
            EntityUtils.consume(resentity); //�ر���
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
