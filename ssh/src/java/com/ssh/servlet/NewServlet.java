/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.servlet;

import com.ssh.commutil.AjaxResult;
import com.ssh.commutil.ResultUtil;
import com.ssh.entity.NewClass;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author Administrator
 */
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //response.setContentType("application/xml");
        PrintWriter  pw = null;  
        String name = request.getParameter("user");
        System.out.println("name-----------"+name);
        try {
            String xml = "";
            xml = "<?xml version=\"1.0\"?>"
                    + "<request>"
                    + "<jkbz> fply_qcdkd_bc </jkbz>" //�ӿڱ�־     fply_qcdkd_bc ȫ�Ǵ��� ,  "
                    + "<nsrsbh>nsrsbh��˰��ʶ���</nsrsbh>"
                    + "<djxh>djxh�Ǽ����</djxh>"
                    + "<nsrmc>nsrmc��˰������</nsrmc>     "
                    + "<id>id���������</id>" // idΪ�գ�                           "
                    + "<gpr>gpr��Ʊ��</gpr>"
                    + "<gpgt>gpgt��Ʊ��̨</gpgt>"
                    + "<swjg_dm>swjg_dm˰����ش���</swjg_dm>"
                    + "<tddz>tddzͶ�ݵ�ַ</tddz>"
                    + "<ybnsr_bz>ybnsr_bzһ����˰�˱�־</ybnsr_bz>"
                    //+ "// ���� rd_nsrzgxx_jgb 201  205  203 ��һ����˰�˵ı�־"
                    + "<nsxyjb>nsxyjb��˰���ü���</nsxyjb>"
                    + "<sjly><![CDATA[sjd]]></sjly >" //������Դ"
                    //+ "==========���ַ�Ʊ====ѭ����ʼ===="
                    + "<row>"
                    + "<fpzl>fpzl��Ʊ����1</fpzl>"
                    + "<bfs>bfs������1</bfs>"
                    + "</row>"
                    + "<row>"
                    + "<fpzl>fpzl��Ʊ����2</fpzl>"
                    + "<bfs>bfs������2</bfs>"
                    + "</row>"
                    //+ "..."
                    //+ "==========���ַ�Ʊ====ѭ������===="
                    + "</request>";
            
            SAXReader saxReader = new SAXReader();  
        Document document = null; 
        String rootName = null;
        document = saxReader.read(new ByteArrayInputStream(xml.getBytes())); 
       
        document.asXML();
            NewClass cla = new NewClass();
            cla.setXml(xml);
            pw = response.getWriter();
            pw.print(document.asXML());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
