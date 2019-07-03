/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.webservice;

@javax.jws.WebService
public class WebServiceImpl implements WebService {

    @Override
    public String TestWeb(String arg0, String arg1) {
        System.out.println("arg1====================================="+arg1);
        return arg1;
    }
    
    
}
