package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.dao.interfaces.BlSubsCommMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsComm;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsCommCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBlSubsCommonAtomSV;
@Component
public class BlSubsCommonAtomImpl implements IBlSubsCommonAtomSV {

	@Autowired
	private BlSubsCommMapper mapper;
	@Override
	public List<BlSubsComm> getSubsCommon(String subsId,String tenantId) {
		BlSubsCommCriteria example=new BlSubsCommCriteria();
		BlSubsCommCriteria.Criteria criteria=example.createCriteria();
		criteria.andTenantIdEqualTo(tenantId);
		criteria.andSubsIdEqualTo(subsId);
		
		 return mapper.selectByExample(example);
	}

	

}
