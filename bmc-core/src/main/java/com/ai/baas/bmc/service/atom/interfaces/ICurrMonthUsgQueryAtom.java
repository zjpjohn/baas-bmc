package com.ai.baas.bmc.service.atom.interfaces;

import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryReq;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryResp;

/**
 * Date: 2016年4月27日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
public interface ICurrMonthUsgQueryAtom {
	
	
	/**
	 * @param req
	 * @return
	 */
	CurrMonthUsgQueryResp currMonthUsgQuery(CurrMonthUsgQueryReq req);
	
	
}
