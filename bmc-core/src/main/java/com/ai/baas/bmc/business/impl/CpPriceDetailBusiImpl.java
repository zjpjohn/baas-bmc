package com.ai.baas.bmc.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.business.interfaces.ICpPriceDetailBusi;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetailCriteria;
@Service
@Transactional
public class CpPriceDetailBusiImpl implements ICpPriceDetailBusi {

	@Autowired
	private CpPriceDetailMapper cpPriceDetailMapper;
	@Override
	public Integer addCpPriceDetail(CpPriceDetail info) {
		//TODO 还需要刷到缓存当中去
		
		return cpPriceDetailMapper.insert(info);
	}
	@Override
	public List<CpPriceDetail> getCpPriceDetail(CpPriceDetail detail) {
		// TODO Auto-generated method stub 看一下方法是什么样的
		
		
		return null;
	}
	@Override
	public CpPriceDetail getCpPriceDetail(String priceCode) {
		CpPriceDetailCriteria sql=new CpPriceDetailCriteria();	
		CpPriceDetailCriteria.Criteria criteria =sql.createCriteria();
		criteria.andPriceCodeEqualTo(priceCode);
		return cpPriceDetailMapper.selectByExample(sql).get(0);
	}
	

}
