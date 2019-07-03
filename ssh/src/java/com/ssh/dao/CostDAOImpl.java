/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssh.dao;

import com.ssh.entity.Cost;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in Templates/Classes/Class.java. 
 * @Package Expression package_name is undefined on line 13, column 15 in Templates/Classes/Class.java. 
 * @author ZHY
 * @date 2018-9-30 10:28:35 
 * @version V1.0   
 */
public class CostDAOImpl implements CostDAO{

    private static final String findAll = "from Cost";
    
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Cost> findAll() throws DAOException {
        System.out.println("sessionFactory-----"+sessionFactory);
        Session session = sessionFactory.openSession();
        List<Cost> list = null;
        Query query = session.createQuery(findAll);
        list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Cost> findAll(int start, int size) throws DAOException {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(findAll);
        //得到滚动结果集
//        ScrollableResults scroll = query.scroll();
//        //滚动到最后一行
//        scroll.last();
//        int i = scroll.getRowNumber() + 1;
//        System.out.println("总计路数：" + i);
        //设置分页位置
        query.setFirstResult(start);
        query.setMaxResults(size);
        List<Cost> costList = query.list();
        session.close();
        return costList;
    }

    @Override
    public int getTotalPages(int rowsperpage) throws DAOException {
        Session session = sessionFactory.openSession();
        int count = session.createQuery(findAll).list().size();
        session.close();
        int totalpages = count/rowsperpage;
        return totalpages;
    }

}
