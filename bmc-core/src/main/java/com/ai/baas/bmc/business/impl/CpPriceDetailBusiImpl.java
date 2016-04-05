package com.ai.baas.bmc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.business.interfaces.ICpPriceDetailBusi;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
@Service
@Transactional
public class CpPriceDetailBusiImpl implements ICpPriceDetailBusi {

	@Autowired
	private CpPriceDetailMapper cpPriceDetailMapper;
	@Override
	public Integer addCpPriceDetal(CpPriceDetail info) {
		cpPriceDetailMapper.insert(info);
		return null;
	}

}
