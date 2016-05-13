package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.custInfo.params.QueryCustInfoRequest;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfo;

public interface IBlCustInfoAtomSV {
	List<BlCustinfo> getCustInfos(QueryCustInfoRequest param);
	
	int getCustInfoCount(QueryCustInfoRequest param);
}
