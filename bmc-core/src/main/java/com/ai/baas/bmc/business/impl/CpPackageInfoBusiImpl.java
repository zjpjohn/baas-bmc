package com.ai.baas.bmc.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.business.interfaces.ICpPackageInfoBusi;
import com.ai.baas.bmc.dao.interfaces.CpPackageInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfoCriteria;
/**
 * 
 *
 * Date: 2016年4月10日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
@Service
public class CpPackageInfoBusiImpl implements ICpPackageInfoBusi {
	@Autowired
	private CpPackageInfoMapper cpPackageInfoMapper;
	
	@Override
	@Transactional
	public void updateCpPackageInfoByDetailCode(CpPackageInfo info) {
		CpPackageInfoCriteria sql = new CpPackageInfoCriteria();
		CpPackageInfoCriteria.Criteria criteria = sql.createCriteria();
		criteria.andDetailCodeEqualTo(info.getDetailCode());
		//
		this.cpPackageInfoMapper.updateByExampleSelective(info, sql);
	}

	@Override
	@Transactional
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
}
