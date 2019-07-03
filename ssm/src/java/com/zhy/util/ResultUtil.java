/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zhy.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/** 
 * @date 2019-6-19 16:05:29
 * @author ZHY
 * @version 01
 */
public class ResultUtil {

    private Integer no;
    private String msg;
    private Object obj;

    private ResultUtil(Builder builder) {
        no = builder.no;
        msg = builder.msg;
        obj = builder.obj;
    }

    public static final class Builder{
        private Integer no;
        private String msg;
        private Object obj;
        
        public Builder no(Integer val){
            no = val;
            return this;
        }
        
        public Builder msg(String val){
            msg = val;
            return this;
        }
        
        public Builder obj(Object val){
            obj = val;
            return this;
        }
        
        public ResultUtil build(){
            return new ResultUtil(this);
        }
    }
    
    public String result(){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}
