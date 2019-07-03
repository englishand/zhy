/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.service;

import com.ssh.dao.MhTemplateDao;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @Title: Expression file_name is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 * @Package Expression package_name is undefined on line 13, column 15 in
 * Templates/Classes/Class.java.
 * @author ZHY
 * @date 2018-9-7 14:00:32
 * @version V1.0
 */
public class MhTemplateServiceImpl implements MhTemplateService {

    private MhTemplateDao templatedao;
    
    public void setTemplatedao(MhTemplateDao templatedao){
        this.templatedao = templatedao;
    }

    @Override
    public List getTemplate(String suitecode) {
        return templatedao.getTemplate(suitecode);
    }

}
