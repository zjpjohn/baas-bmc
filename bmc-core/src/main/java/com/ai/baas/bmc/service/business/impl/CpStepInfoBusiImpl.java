package com.ai.baas.bmc.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.dao.interfaces.CpStepInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfoCriteria;
import com.ai.baas.bmc.service.business.interfaces.ICpStepInfoBusi;
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
	@Override
	public CpStepInfo getCpStepInfoByDetailCode(CpStepInfo info) {
		CpStepInfoCriteria sql = new CpStepInfoCriteria();
		CpStepInfoCriteria.Criteria criteria = sql.createCriteria();
		criteria.andDetailCodeEqualTo(info.getDetailCode());
		//
		List<CpStepInfo> cpStepInfoList = this.cpStepInfoMapper.selectByExample(sql);
		CpStepInfo cpStepInfo = new CpStepInfo();
		if(null != cpStepInfoList){
			cpStepInfo = cpStepInfoList.get(0);
		}
		return cpStepInfo;
		
	}

	@Override
	public void addCpStepInfo(CpStepInfo info) {
		this.cpStepInfoMapper.insertSelective(info);
		
	}
}
