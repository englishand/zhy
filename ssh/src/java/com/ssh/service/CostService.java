/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.service;

import com.ssh.dao.DAOException;
import com.ssh.entity.Cost;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface CostService {
    
    public List<Cost> findAll() throws DAOException;
    
    public List<Cost> findAllPage(int page,int rowsPerPage) throws DAOException;
    
    public int getTotalPages(int rowsperpage) throws DAOException;//获取总页数
}
