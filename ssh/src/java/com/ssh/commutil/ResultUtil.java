package com.ssh.commutil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 *
 * @author admins
 */
public class ResultUtil {
    private final Integer no;
    private final String msg;
    private final Object obj;
    private final String other;
    
    public static final class Builder{
        private Integer no;
        private String msg;
        private Object obj;
        private String other;
        
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
        public Builder other(String val){
            other = val;
            return this;
        }
        public ResultUtil build(){
            return new ResultUtil(this);
        }
        
    }
    
    private ResultUtil(Builder builder){
        no = builder.no;
        msg = builder.msg;
        obj = builder.obj;
        other = builder.other;
        
    }
    public String result(){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }

    public Integer getNo() {
        return no;
    }

    public String getMsg() {
        return msg;
    }

    public Object getObj() {
        return obj;
    }

    public String getOther() {
        return other;
    }
}
