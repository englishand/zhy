/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 * @Package Expression package_name is undefined on line 13, column 15 in
 * Templates/Classes/Class.java.
 * @author ZHY
 * @date 2018-9-30 10:16:32
 * @version V1.0
 */
@Entity
public class Cost implements Serializable {

    @Id
    private Integer id; //资费ID		
    private String name; //资费名称 NAME
    private Integer baseDuration; //包在线时长 BASE_DURATION
    private Float baseCost; //月固定费 BASE_COST
    private Float unitCost; //单位费用 UNIT_COST
    private String status; //0：开通；1：暂停；STATUS
    private String descr; //资费信息说明 DESCR
    private Date startTime; //启用日期 STARTTIME
    private Date creaTime;//创建时间 CREATIME
    private String costType;//资费类型 COST_TYPE

    public Cost() {
    }

    
    public Cost(Integer id, String name, Integer baseDuration, Float baseCost, Float unitCost, String status, String descr, Date startTime, Date creaTime, String costType) {
        this.id = id;
        this.name = name;
        this.baseDuration = baseDuration;
        this.baseCost = baseCost;
        this.unitCost = unitCost;
        this.status = status;
        this.descr = descr;
        this.startTime = startTime;
        this.creaTime = creaTime;
        this.costType = costType;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(Integer baseDuration) {
        this.baseDuration = baseDuration;
    }

    public Float getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Float baseCost) {
        this.baseCost = baseCost;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCreaTime() {
        return creaTime;
    }

    public void setCreaTime(Date creaTime) {
        this.creaTime = creaTime;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }
    
    
}
