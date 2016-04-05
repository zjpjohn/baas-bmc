package com.ai.baas.bmc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.business.interfaces.ICpPriceInfoBusi;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;

public class CpPriceInfoBusiImpl implements ICpPriceInfoBusi {
	@Autowired
	private CpPriceInfoMapper cpPriceInfoMapper;

	@Override
	public Integer addCpPriceInfo(CpPriceInfo info) {
		
		Integer cpPriceInfoId=cpPriceInfoMapper.insert(info);
		
		return cpPriceInfoId;
	}
	
}
