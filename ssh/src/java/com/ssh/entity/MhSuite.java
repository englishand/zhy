/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssh.entity;

import com.ssh.commutil.ValueObject;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in Templates/Classes/Class.java. 
 * @Package Expression package_name is undefined on line 13, column 15 in Templates/Classes/Class.java. 
 * @author ZHY
 * @date 2018-9-7 11:12:08 
 * @version V1.0   
 */
public class MhSuite implements ValueObject {

    /** identifier field */
    private String fsuitecode;

    /** nullable persistent field */
    private String fsuitename;

    /** nullable persistent field */
    private String fsuitpath;

    /** persistent field */
    private String fstateflag;

    /** persistent field */
    private String fdeleteflag;
    
    private String fportalcode;
    
    /** default constructor */
    public MhSuite() {
    }

    public String getFsuitecode() {
        return fsuitecode;
    }

    public void setFsuitecode(String fsuitecode) {
        this.fsuitecode = fsuitecode;
    }

    public String getFsuitename() {
        return fsuitename;
    }

    public void setFsuitename(String fsuitename) {
        this.fsuitename = fsuitename;
    }

    public String getFsuitpath() {
        return fsuitpath;
    }

    public void setFsuitpath(String fsuitpath) {
        this.fsuitpath = fsuitpath;
    }

    public String getFstateflag() {
        return fstateflag;
    }

    public void setFstateflag(String fstateflag) {
        this.fstateflag = fstateflag;
    }

    public String getFdeleteflag() {
        return fdeleteflag;
    }

    public void setFdeleteflag(String fdeleteflag) {
        this.fdeleteflag = fdeleteflag;
    }

    public String getFportalcode() {
        return fportalcode;
    }

    public void setFportalcode(String fportalcode) {
        this.fportalcode = fportalcode;
    }
    
    
}
