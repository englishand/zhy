/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zhy.service;

import com.zhy.dao.UserDao;
import com.zhy.vo.User;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @date 2019-6-19 15:58:27
 * @author ZHY
 * @version 01
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserDao userDao;
    
    @Override
    public User getUserById(Integer userId) {
        return userDao.selectByPrimaryKey(userId);
    }

}
