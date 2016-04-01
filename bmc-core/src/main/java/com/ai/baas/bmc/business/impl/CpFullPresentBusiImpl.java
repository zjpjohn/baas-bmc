package com.ai.baas.bmc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.business.interfaces.ICpFullPresentBusi;
import com.ai.baas.bmc.dao.interfaces.CpFullPresentMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpFullPresent;

public class CpFullPresentBusiImpl implements ICpFullPresentBusi {

	@Autowired
	private CpFullPresentMapper CpFullPresentMapper;
	@Override
	public Integer addFullPresent(CpFullPresent present) {
		
		return CpFullPresentMapper.insert(present);
	}

}
