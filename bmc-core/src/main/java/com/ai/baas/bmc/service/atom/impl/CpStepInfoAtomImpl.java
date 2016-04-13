package com.ai.baas.bmc.service.atom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ai.baas.bmc.dao.interfaces.CpStepInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.ICpStepInfoAtom;
@Service
public class CpStepInfoAtomImpl implements ICpStepInfoAtom {
	@Autowired
	private CpStepInfoMapper cpStepInfoMapper;
	@Override
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
	public List<CpStepInfo> getCpStepInfoByDetailCode(CpStepInfo info) {
		CpStepInfoCriteria sql = new CpStepInfoCriteria();
		CpStepInfoCriteria.Criteria criteria = sql.createCriteria();
		criteria.andDetailCodeEqualTo(info.getDetailCode());
		//
		List<CpStepInfo> cpStepInfoList = new ArrayList<CpStepInfo>();
		cpStepInfoList = this.cpStepInfoMapper.selectByExample(sql);
		
		return cpStepInfoList;
		
	}

	@Override
	public void addCpStepInfo(CpStepInfo info) {
		this.cpStepInfoMapper.insertSelective(info);
		
	}
}
