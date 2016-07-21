package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.dao.interfaces.BlSubsCommMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsComm;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsCommCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsCommCriteria.Criteria;
import com.ai.baas.bmc.service.atom.interfaces.IBlSubsCommQuery;

/**
 * Date: 2016年4月28日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
@Component
public class BlSubsCommQueryImpl implements IBlSubsCommQuery{
	@Autowired
	private BlSubsCommMapper blSubsCommMapper;
	@Override
	public List<BlSubsComm> query(String tenantId,
			String subsId) {
		
		BlSubsCommCriteria example = new BlSubsCommCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andTenantIdEqualTo(tenantId);
		criteria.andSubsIdEqualTo(subsId);
		
		return blSubsCommMapper.selectByExample(example);
	}


}
