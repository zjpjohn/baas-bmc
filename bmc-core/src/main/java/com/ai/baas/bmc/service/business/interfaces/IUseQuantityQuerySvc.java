package com.ai.baas.bmc.service.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.drmanager.parameters.UseQueryInputObject;
import com.ai.baas.bmc.dao.mapper.bo.BmcUseQuery;

public interface IUseQuantityQuerySvc {
	
	public List<BmcUseQuery> selectUseQuery(UseQueryInputObject userQuery);
}
