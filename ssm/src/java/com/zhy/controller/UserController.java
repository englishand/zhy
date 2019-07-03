/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zhy.controller;

import com.alibaba.fastjson.JSON;
import com.zhy.service.UserService;
import com.zhy.util.ResultUtil;
import com.zhy.vo.User;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @date 2019-6-12 17:34:24
 * @author ZHY
 * @version 01
 */
@Controller
@RequestMapping("user")
public class UserController {
    
    private static Logger logger = Logger.getLogger(UserController.class);  
    
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping("getUserById")
    public String getUserById(Integer userId){
        System.out.println("userId-----------"+userId);
        User user = userService.getUserById(userId);
        System.out.println(user);
        String result = new ResultUtil.Builder().no(1).obj(user).build().result() ;
        logger.info(JSON.toJSON(user));
        return result;
    }
    
}
