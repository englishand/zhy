/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ssh.entity;

import com.ssh.commutil.CommUtils;
import com.ssh.commutil.ValueObject;
import java.util.Set;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in Templates/Classes/Class.java. 
 * @Package Expression package_name is undefined on line 13, column 15 in Templates/Classes/Class.java. 
 * @author ZHY
 * @date 2018-9-7 11:05:58 
 * @version V1.0   
 */
public class MhTemplates implements ValueObject {

/** identifier field */
    private String ftemplatecode;

    /** nullable persistent field */
    private String ftempname;

    /** nullable persistent field */
    private String frealname;

    /** persistent field */
    private String ftemptype;

    /** persistent field */
    private String ftempclass;

    /** nullable persistent field */
    private String ftemppath;
    
    private String fsuitecode;

    /** persistent field */
    private Set mhFgpdmbs;
    
    private MhSuite mhSuite ;

    /** full constructor */
    public MhTemplates(String ftemplatecode, String ftempname, String frealname, String ftemptype, String ftempclass, String ftemppath, Set mhFgpdmbs) {
        this.ftemplatecode = ftemplatecode;
        this.ftempname = ftempname;
        this.frealname = frealname;
        this.ftemptype = ftemptype;
        this.ftempclass = ftempclass;
        this.ftemppath = ftemppath;
        this.mhFgpdmbs = mhFgpdmbs;
    }

    /** default constructor */
    public MhTemplates() {
    }

    /** minimal constructor */
    public MhTemplates(String ftemplatecode, String ftemptype, String ftempclass, Set mhFgpdmbs) {
        this.ftemplatecode = ftemplatecode;
        this.ftemptype = ftemptype;
        this.ftempclass = ftempclass;
        this.mhFgpdmbs = mhFgpdmbs;
    }

    public String getFtemplatecode() {
        return this.ftemplatecode;
    }

    public void setFtemplatecode(String ftemplatecode) {
        this.ftemplatecode = ftemplatecode;
    }

    public String getFtempname() {
        return CommUtils.chgEncoding(this.ftempname);
    }

    public void setFtempname(String ftempname) {
        this.ftempname = CommUtils.chgDecoding(ftempname);
    }

    public String getFrealname() {
        return CommUtils.chgEncoding(this.frealname);
    }

    public void setFrealname(String frealname) {
        this.frealname = CommUtils.chgDecoding(frealname);
    }

    public String getFtemptype() {
        return this.ftemptype;
    }

    public void setFtemptype(String ftemptype) {
        this.ftemptype = ftemptype;
    }

    public String getFtempclass() {
        return this.ftempclass;
    }

    public void setFtempclass(String ftempclass) {
        this.ftempclass = ftempclass;
    }

    public String getFtemppath() {
        return CommUtils.chgEncoding(this.ftemppath);
    }

    public void setFtemppath(String ftemppath) {
        this.ftemppath = CommUtils.chgDecoding(ftemppath);
    }

    public Set getMhFgpdmbs() {
        return this.mhFgpdmbs;
    }

    public void setMhFgpdmbs(Set mhFgpdmbs) {
        this.mhFgpdmbs = mhFgpdmbs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ftemplatecode", getFtemplatecode())
            .toString();
    }

	/**
	 * Function：根据用户ID从数据库中取出用户名
	 * @param paramname 参数中文含义
	 * @return 描述方法返回值
	 * @throws SQLException 描述异常抛出条件
	 */
	public String getFsuitecode()
	{
		return fsuitecode;
	}

	/**
	 * Function：根据用户ID从数据库中取出用户名
	 * @param paramname 参数中文含义
	 * @return 描述方法返回值
	 * @throws SQLException 描述异常抛出条件
	 */
	public MhSuite getMhSuite()
	{
		return mhSuite;
	}

	/**
	 * Function：根据用户ID从数据库中取出用户名
	 * @param paramname 参数中文含义
	 * @return 描述方法返回值
	 * @throws SQLException 描述异常抛出条件
	 */
	public void setFsuitecode(String string)
	{
		fsuitecode= string;
	}

	/**
	 * Function：根据用户ID从数据库中取出用户名
	 * @param paramname 参数中文含义
	 * @return 描述方法返回值
	 * @throws SQLException 描述异常抛出条件
	 */
	public void setMhSuite(MhSuite suite)
	{
		mhSuite= suite;
	}

}
