/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.action;

import com.ssh.dao.DAOException;
import com.ssh.entity.Cost;
import com.ssh.service.CostService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 * @Package Expression package_name is undefined on line 13, column 15 in
 * Templates/Classes/Class.java.
 * @author ZHY
 * @date 2018-9-30 10:43:14
 * @version V1.0
 */
public class CostListAction {

    public List<Cost> costList;
    private int page = 1;//添加当前页属性，input、output双重属性
    private int totalPages;//添加总页数属性，output

    private CostService costService;
    
    public void setCostService(CostService costService){
        this.costService=costService;
    }

    public String findAll() {
        try {
            costList = costService.findAll();
        } catch (DAOException ex) {
            Logger.getLogger(CostListAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (null == costList) {
            return "fail";
        } else {
            System.out.println(costList.size()+"------------"+costList.get(0).getName());
            return "success";
        }
    }
    
    public String findAllPage(){ 
        System.out.println("page="+page);
        System.out.println("costservice======="+costService);
        try {
            costList = costService.findAllPage(page, 2);
            totalPages = costService.getTotalPages(2);
        } catch (DAOException ex) {
            Logger.getLogger(CostListAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (null == costList) {
            return "fail";
        } else {
            System.out.println(costList);
            return "success";
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    
    
    public static void main(String[] args){		String conf="/applicationContext.xml";
	ApplicationContext ac=new ClassPathXmlApplicationContext(conf);//实例化容器
	CostListAction costDAO=(CostListAction)ac.getBean("costListAction");//获取Bean对象
        
            System.out.println(costDAO.findAll());
        
    }
}
