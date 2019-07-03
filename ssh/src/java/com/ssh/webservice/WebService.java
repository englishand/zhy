/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Administrator
 */
@javax.jws.WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebService {
    
    @WebMethod
    public String TestWeb(@WebParam(name="arg0")String arg0,@WebParam(name="arg1")String arg1);
}
