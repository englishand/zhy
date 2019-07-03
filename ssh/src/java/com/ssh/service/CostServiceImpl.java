/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssh.service;

import com.ssh.dao.CostDAO;
import com.ssh.dao.DAOException;
import com.ssh.entity.Cost;
import java.util.List;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in Templates/Classes/Class.java. 
 * @Package Expression package_name is undefined on line 13, column 15 in Templates/Classes/Class.java. 
 * @author ZHY
 * @date 2018-9-30 10:45:46 
 * @version V1.0   
 */
public class CostServiceImpl implements CostService{
    
    private CostDAO costDao;
    
    public void setCostDao(CostDAO costDao){
        this.costDao=costDao;
    }

    @Override
    public List<Cost> findAll() throws DAOException {
        return costDao.findAll();
    }

    @Override
    public List<Cost> findAllPage(int page, int rowsPerPage) throws DAOException {
        int start = (page-1)*rowsPerPage;
        List<Cost> costList = costDao.findAll(start, rowsPerPage);
        return costList;
    }

    @Override
    public int getTotalPages(int rowsperpage) throws DAOException {
        int totalpages = costDao.getTotalPages(rowsperpage);
        return totalpages;
    }
    
    

}
