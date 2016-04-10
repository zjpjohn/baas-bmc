package com.ai.baas.bmc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.business.interfaces.ICpStepInfoBusi;
import com.ai.baas.bmc.dao.interfaces.CpStepInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfoCriteria;
@Service
public class CpStepInfoBusiImpl implements ICpStepInfoBusi {
	@Autowired
	private CpStepInfoMapper cpStepInfoMapper;
	@Override
	@Transactional
	public void updateCpStepInfoByDetailCode(CpStepInfo info) {
		CpStepInfoCriteria sql = new CpStepInfoCriteria();
		CpStepInfoCriteria.Criteria criteria = sql.createCriteria();
		criteria.andDetailCodeEqualTo(info.getDetailCode());
		//
		this.cpStepInfoMapper.updateByExampleSelective(info, sql);
		
	}

	@Override
	public void deleteCpStepInfoByDetailCode(CpStepInfo info) {
		CpStepInfoCriteria sql = new CpStepInfoCriteria();
		CpStepInfoCriteria.Criteria criteria = sql.createCriteria();
		criteria.andDetailCodeEqualTo(info.getDetailCode());
		//
		this.cpStepInfoMapper.deleteByExample(sql);
		
	}

}
