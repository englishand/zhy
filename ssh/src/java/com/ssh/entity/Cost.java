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
    private Integer id; //�ʷ�ID		
    private String name; //�ʷ����� NAME
    private Integer baseDuration; //������ʱ�� BASE_DURATION
    private Float baseCost; //�¹̶��� BASE_COST
    private Float unitCost; //��λ���� UNIT_COST
    private String status; //0����ͨ��1����ͣ��STATUS
    private String descr; //�ʷ���Ϣ˵�� DESCR
    private Date startTime; //�������� STARTTIME
    private Date creaTime;//����ʱ�� CREATIME
    private String costType;//�ʷ����� COST_TYPE

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
