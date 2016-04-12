package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.dao.interfaces.CpPackageInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.ICpPackageInfoAtom;
/**
 * 
 *
 * Date: 2016年4月10日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
@Service
public class CpPackageInfoAtomImpl implements ICpPackageInfoAtom {
	@Autowired
	private CpPackageInfoMapper cpPackageInfoMapper;
	
	@Override
	public void updateCpPackageInfoByDetailCode(CpPackageInfo info) {
		CpPackageInfoCriteria sql = new CpPackageInfoCriteria();
		CpPackageInfoCriteria.Criteria criteria = sql.createCriteria();
		criteria.andDetailCodeEqualTo(info.getDetailCode());
		//
		this.cpPackageInfoMapper.updateByExampleSelective(info, sql);
	}

	@Override
	public void deleteCpPackageInfoByDetailCode(CpPackageInfo info) {

		CpPackageInfoCriteria sql = new CpPackageInfoCriteria();
		CpPackageInfoCriteria.Criteria criteria = sql.createCriteria();
		criteria.andDetailCodeEqualTo(info.getDetailCode());
		//
		this.cpPackageInfoMapper.deleteByExample(sql);
	}
	@Override
	public CpPackageInfo getCpPackageInfoByDetailCode(CpPackageInfo info) {
		CpPackageInfoCriteria sql = new CpPackageInfoCriteria();
		CpPackageInfoCriteria.Criteria criteria = sql.createCriteria();
		criteria.andDetailCodeEqualTo(info.getDetailCode());
		List<CpPackageInfo> cpPackageInfoList = this.cpPackageInfoMapper.selectByExample(sql);
		CpPackageInfo cpPackageInfo = new CpPackageInfo();
		
		if(null != cpPackageInfoList){
			cpPackageInfo = cpPackageInfoList.get(0);
		}
		return cpPackageInfo;
	}

	@Override
	public void addCpPackageInfo(CpPackageInfo info) {

		this.cpPackageInfoMapper.insertSelective(info);
	}
}
