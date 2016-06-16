package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.baas.bmc.dao.interfaces.BmcOutputInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputInfo;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputInfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBmcOutputInfoAtomSV;
@Component
public class BmcOutputInfoAtomImpl implements IBmcOutputInfoAtomSV {

	@Autowired
	private BmcOutputInfoMapper mapper;
	@Override
	public List<BmcOutputInfo> getOutputInfo(String tenantId, String tablePrefix) {
	
		
		BmcOutputInfoCriteria example=new BmcOutputInfoCriteria();
		
		BmcOutputInfoCriteria.Criteria criteria=example.createCriteria();
		
		criteria.andTenantIdEqualTo(tenantId);
		criteria.andTablePrefixEqualTo(tablePrefix);
		
		return mapper.selectByExample(example);
	}
	@Override
	public List<BmcOutputInfo> getInfoCode(ReBillingParam param) {
		BmcOutputInfoCriteria example=new BmcOutputInfoCriteria();
		BmcOutputInfoCriteria.Criteria criteria=example.createCriteria();
		criteria.andTenantIdEqualTo(param.getTenantId());
		criteria.andServiceTypeEqualTo(param.getBusiType());
		return mapper.selectByExample(example);
	}

}
