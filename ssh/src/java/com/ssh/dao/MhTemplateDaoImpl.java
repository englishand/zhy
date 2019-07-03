/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.dao;

import com.ssh.entity.MhTemplates;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 * @Package Expression package_name is undefined on line 13, column 15 in
 * Templates/Classes/Class.java.
 * @author ZHY
 * @date 2018-9-7 14:01:22
 * @version V1.0
 */
public class MhTemplateDaoImpl implements MhTemplateDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List getTemplate(String suitecode) {
        Session session = sessionFactory.openSession();
        List<MhTemplates> list = null;
        try {
            Query query = session.createQuery("from MhTemplates");
            list = query.list();
        } catch (Exception e) {

        } finally {
            session.close();
            sessionFactory.close();
        }
        return list;
    }

}
