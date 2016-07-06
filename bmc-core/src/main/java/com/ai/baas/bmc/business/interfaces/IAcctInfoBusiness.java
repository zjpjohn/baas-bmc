package com.ai.baas.bmc.business.interfaces;

import com.ai.baas.bmc.api.acctInfo.params.AcctInfoParams;
import com.ai.baas.bmc.api.acctInfo.params.AcctQueryRequest;
import com.ai.baas.bmc.api.acctInfo.params.ResponseMessage;
import com.ai.opt.base.vo.PageInfo;

public interface IAcctInfoBusiness {
	public ResponseMessage getAcctInfo(AcctQueryRequest acctQueryRequest);

}
