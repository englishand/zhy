/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zhy.service;

import com.zhy.vo.User;

/**
 * @time 2019-6-19 15:57:28
 * @author ZHY
 * @version V01
 */
public interface UserService {

    public User getUserById(Integer id);
}
