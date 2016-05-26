package com.ai.baas.bmc.service.business.productInfo.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.dao.interfaces.CpExtInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpExtInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpExtInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpExtInfoCriteria.Criteria;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpExtInfoSvc;
import com.ai.paas.ipaas.util.StringUtil;

/**
 * 把扩展信息保存到mysql表中
 * Date: 2015年12月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author ygz
 */
@Service
@Transactional
public class CpExtInfoSvcImpl implements ICpExtInfoSvc {
	private static final Log log = LogFactory.getLog(CpExtInfoSvcImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**先删除再插入
	 * 
	 */
	@Override
	public String triggerCpExtInfo(CpExtInfo record){
		log.info("进入CpExtInfoSvc.triggerCpCpExtInfo方法,打印入参json:[" + record.toString() + "]");
		    
		CpExtInfoMapper cpExtInfoMapper = sqlSessionTemplate.getMapper(CpExtInfoMapper.class);

		CpExtInfoCriteria ceiCriteria = new CpExtInfoCriteria();
        ceiCriteria.createCriteria()
        .andExtCodeEqualTo(record.getExtCode())
        .andExtOwnerEqualTo(record.getExtOwner())
        .andTenantIdEqualTo(record.getTenantId())
        .andExtNameEqualTo(record.getExtName())
        .andExtValueEqualTo(record.getExtValue());
        
        //先删除
        cpExtInfoMapper.deleteByExample(ceiCriteria);
        
        //再插入
		cpExtInfoMapper.insert(record); 

		return "BMC-000000";
	}

    @Override
    public List<CpExtInfo> getSameParamList(CpExtInfo cei) {
        
        CpExtInfoMapper ceiMapper = sqlSessionTemplate.getMapper(CpExtInfoMapper.class);
        CpExtInfoCriteria ceiCriteria = new CpExtInfoCriteria();
        
        Criteria criteria = ceiCriteria.createCriteria()
        .andExtCodeEqualTo(cei.getExtCode())
        .andExtOwnerEqualTo(cei.getExtOwner())
        //.andSystemIdEqualTo(cei.getSystemId())
        .andTenantIdEqualTo(cei.getTenantId());
        
        if(!StringUtil.isBlank(cei.getExtName())){
            criteria.andExtNameEqualTo(cei.getExtName());
        }
        
        if(!StringUtil.isBlank(cei.getExtValue())){
            criteria.andExtValueEqualTo(cei.getExtValue()); 
        }

        List<CpExtInfo> ceiList = ceiMapper.selectByExample(ceiCriteria);
        
        return ceiList;
    }
	
	

}
