package com.ai.baas.bmc.service.business.interfaces;

import com.ai.baas.bmc.api.custInfo.params.CustInfoResponse;
import com.ai.baas.bmc.api.custInfo.params.QueryCustInfoRequest;

public interface ICustInfoQueryBusiSV {
	CustInfoResponse getCustInfos(QueryCustInfoRequest param);
}
