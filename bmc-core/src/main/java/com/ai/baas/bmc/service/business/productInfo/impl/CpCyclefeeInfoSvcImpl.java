package com.ai.baas.bmc.service.business.productInfo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.dao.interfaces.CpCyclefeeInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpCyclefeeInfo;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpCyclefeeInfoSvc;
@Service
@Transactional
public class CpCyclefeeInfoSvcImpl implements ICpCyclefeeInfoSvc {
	private static final Log log = LogFactory.getLog(CpCyclefeeInfoSvcImpl.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public String terrigerCpCyclefeeInfo(CpCyclefeeInfo record) {
		log.info("进入CpCyclefeeInfoSvc.terrigerCpCyclefeeInfo方法,打印入参json:" + record);
		try {
			CpCyclefeeInfoMapper cpCyclefeeInfoMapper= sqlSessionTemplate.getMapper(CpCyclefeeInfoMapper.class);			
			cpCyclefeeInfoMapper.insert(record);

		} catch (Exception e) {
			log.error("出现异常:" + e.getMessage());
			e.printStackTrace();
			return "401";
		}

		return "BMC-000000";
		
	}
		

}
