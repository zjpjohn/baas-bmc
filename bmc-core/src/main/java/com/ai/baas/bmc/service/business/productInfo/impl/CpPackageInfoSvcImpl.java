package com.ai.baas.bmc.service.business.productInfo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.dao.interfaces.CpPackageInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfoCriteria;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpPackageInfoSvc;



@Service
@Transactional
public class CpPackageInfoSvcImpl implements ICpPackageInfoSvc{
	private static final Log log = LogFactory.getLog(CpPackageInfoSvcImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public String insertCpPackageInfo(CpPackageInfo record) {
	    System.out.println("进入CpPackageInfoSvc.triggerCpPackageInfo方法,打印入参json:" + record);
        log.info("进入CpPackageInfoSvc.triggerCpPackageInfo方法,打印入参json:" + record);
        
        CpPackageInfoMapper aCpPackageInfoMapper = sqlSessionTemplate.getMapper(CpPackageInfoMapper.class);

        aCpPackageInfoMapper.insert(record);
        
        return "BMC-000000";
	}
	

	@Override
	public String triggerCpPackageInfo(CpPackageInfo record) {
		System.out.println("进入CpPackageInfoSvc.triggerCpPackageInfo方法,打印入参json:" + record);
		log.info("进入CpPackageInfoSvc.triggerCpPackageInfo方法,打印入参json:" + record);

		
		CpPackageInfoMapper aCpPackageInfoMapper = sqlSessionTemplate.getMapper(CpPackageInfoMapper.class);
		CpPackageInfoCriteria cpPackageInfoCriteria = new CpPackageInfoCriteria();
		cpPackageInfoCriteria.createCriteria().andAmountEqualTo(record.getAmount())
	     	.andExceedTypeEqualTo(record.getExceedType())
		    .andUnitCodeEqualTo(record.getUnitCode());
		aCpPackageInfoMapper.deleteByExample(cpPackageInfoCriteria);
		aCpPackageInfoMapper.insert(record);
		
		return "BMC-000000";
	

		
	}



	

}
