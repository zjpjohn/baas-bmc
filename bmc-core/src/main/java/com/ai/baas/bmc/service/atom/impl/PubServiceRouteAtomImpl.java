package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.baas.bmc.constants.BmcConstants;
import com.ai.baas.bmc.dao.interfaces.PubServiceRouteMapper;
import com.ai.baas.bmc.dao.mapper.bo.PubServiceRoute;
import com.ai.baas.bmc.dao.mapper.bo.PubServiceRouteCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IPubServiceRouteAtomSV;
@Component
public class PubServiceRouteAtomImpl implements IPubServiceRouteAtomSV{
	@Autowired
	private PubServiceRouteMapper mapper;
	private StringBuilder routeParams=new StringBuilder();
	@Override
	public List<PubServiceRoute> getProcessClass(String tenantId,String serviceType) {
		PubServiceRouteCriteria example=new PubServiceRouteCriteria();
		PubServiceRouteCriteria.Criteria criteria=example.createCriteria();
		routeParams.append(tenantId).append(",").append(serviceType);
		criteria.andRouteTypeEqualTo(BmcConstants.SEQ.BMC_BAK_ROUTE_TYPE);
		criteria.andRouteParamsEqualTo(routeParams.toString());
		return mapper.selectByExample(example);
	}

}
