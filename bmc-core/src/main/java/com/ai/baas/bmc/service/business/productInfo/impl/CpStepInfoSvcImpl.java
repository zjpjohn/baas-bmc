package com.ai.baas.bmc.service.business.productInfo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.dao.interfaces.CpStepInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpStepInfoSvc;
@Service
@Transactional
public class CpStepInfoSvcImpl implements ICpStepInfoSvc{
	private static final Log log = LogFactory.getLog(CpStepInfoSvcImpl.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public String terrigerCpStepInfo(CpStepInfo record) {
		log.info("进入CpStepInfoSvc.triggerCpStepInfo方法,打印入参json:" + record);

		try {
			CpStepInfoMapper cpStepInfoMapper = sqlSessionTemplate.getMapper(CpStepInfoMapper.class);
			
			cpStepInfoMapper.insert(record);

		} catch (Exception e) {
			log.error("出现异常:" + e.getMessage());
			e.printStackTrace();
			return "401";
		}

		return "BMC-000000";
	}


}
