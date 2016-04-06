package com.ai.baas.bmc.business.impl;

import java.util.List;

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
		
		return cpPriceDetailMapper.insert(info);
	}
	@Override
	public List<CpPriceDetail> getCpPriceDetail(CpPriceDetail detail) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CpPriceDetail getCpPriceDetail(String priceCode) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
