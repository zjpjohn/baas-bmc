package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.baas.bmc.dao.interfaces.BmcOutputDetailMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputDetail;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputDetailCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputInfo;
import com.ai.baas.bmc.service.atom.interfaces.IBmcOutputDetailAtomSV;
@Component
public class BmcOutputDetailAtomImpl implements IBmcOutputDetailAtomSV{
	@Autowired
	private BmcOutputDetailMapper detailMapper;
	@Override
	public List<BmcOutputDetail> getRowKeys(BmcOutputInfo param) {
		// TODO Auto-generated method stub
		BmcOutputDetailCriteria example= new BmcOutputDetailCriteria();
		BmcOutputDetailCriteria.Criteria criteria=example.createCriteria();
		criteria.andInfoCodeEqualTo(param.getInfoCode());
		criteria.andIsKeyEqualTo("Y");
		example.setOrderByClause("display_order");
		return detailMapper.selectByExample(example);
	}

}
