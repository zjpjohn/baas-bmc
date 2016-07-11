package com.ai.baas.bmc.service.business.interfaces;

import com.ai.baas.bmc.api.acctinfo.params.AcctInfoParams;
import com.ai.baas.bmc.api.acctinfo.params.AcctQueryRequest;
import com.ai.baas.bmc.api.acctinfo.params.ResponseMessage;
import com.ai.opt.base.vo.PageInfo;

public interface IAcctInfoBusiness {
	public ResponseMessage getAcctInfo(AcctQueryRequest acctQueryRequest);

}
