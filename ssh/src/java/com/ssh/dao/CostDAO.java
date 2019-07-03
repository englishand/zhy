/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssh.dao;

import com.ssh.entity.Cost;
import java.util.List;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in Templates/Classes/Class.java. 
 * @Package Expression package_name is undefined on line 13, column 15 in Templates/Classes/Class.java. 
 * @author ZHY
 * @date 2018-9-30 10:26:44 
 * @version V1.0   
 */
public interface CostDAO {

    public List<Cost> findAll() throws DAOException;
    
    public List<Cost> findAll(int start,int size) throws DAOException;//分页查询
    
    public int getTotalPages(int rowsperpage) throws DAOException;//获取总页数
}
