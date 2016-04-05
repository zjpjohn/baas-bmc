package com.ai.baas.bmc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.business.interfaces.ICpFullReduceBusi;
import com.ai.baas.bmc.dao.interfaces.CpFullReduceMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpFullReduce;

public class CpFullReduceBusiImpl implements ICpFullReduceBusi {
	@Autowired
	private CpFullReduceMapper CpFullReduceMapper;
	@Override
	public Integer add(CpFullReduce present) {
		
		return null;
	}

}
