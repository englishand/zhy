/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zhy.dao;

import com.zhy.vo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @time 2019-6-19 15:59:38
 * @author ZHY
 * @version V01
 */

public interface UserDao {

    User selectByPrimaryKey(Integer userId);
}
