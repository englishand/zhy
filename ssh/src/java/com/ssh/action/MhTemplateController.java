/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.entity.MhTemplates;
import com.ssh.service.MhTemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in Templates/Classes/Class.java. 
 * @Package Expression package_name is undefined on line 13, column 15 in Templates/Classes/Class.java. 
 * @author ZHY
 * @date 2018-9-7 14:07:15 
 * @version V1.0   
 */
public class MhTemplateController extends ActionSupport{

   
    private MhTemplateService mhtemplateService;
    
    public void setMhtemplateService(MhTemplateService mhtemplateService){
        this.mhtemplateService = mhtemplateService;
    }
    
    @ResponseBody
    public Object getTemplate(){
        String suitecode="e11111";
        return mhtemplateService.getTemplate(suitecode);
    }
    
    //编写execute()方法
    public String execute() {
        
        String suitecode="e11111";
        List<MhTemplates> list = mhtemplateService.getTemplate(suitecode);
        
        //将查询出来的结构集打印到控制台
        System.out.println("结果集："+list.get(0).getMhSuite()+"////"+list.get(0).getFtemplatecode());
        
        //获取Context上下文对象
        ActionContext ac = ActionContext.getContext();
        //将myBookCardList集合添加到上下文对象里
        ac.put("myBookCardList", list);
        
        //返回一个字符串
        return "success";
    }
    
}
