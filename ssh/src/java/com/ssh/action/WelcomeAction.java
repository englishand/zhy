/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.action;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 * @Package Expression package_name is undefined on line 13, column 15 in
 * Templates/Classes/Class.java.
 * @author ZHY
 * @date 2018-9-29 17:31:12
 * @version V1.0
 */
public class WelcomeAction {

    private String name;
    private String error;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String execute() {
        System.out.println("WelcomeAction.execute()...");
        if (name == null || "".equals(name)) {
            error = "�û�������Ϊ��";
            return "fail";
        }
        System.out.println("name: " + name);//���ڲ���
        if ("test".equalsIgnoreCase(name)) {
            error = "����ʹ������text��¼";
            return "fail";
        } else {
            return "success";
        }
    }
}
