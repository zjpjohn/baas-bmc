package com.ai.baas.bmc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.business.interfaces.ICpFullPresentBusi;
import com.ai.baas.bmc.dao.interfaces.CpFullPresentMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpFullPresent;
@Service
@Transactional
public class CpFullPresentBusiImpl implements ICpFullPresentBusi {

	@Autowired
	private CpFullPresentMapper CpFullPresentMapper;
	@Override
	public Integer addFullPresent(CpFullPresent present) {
		
		return CpFullPresentMapper.insert(present);
	}

}
