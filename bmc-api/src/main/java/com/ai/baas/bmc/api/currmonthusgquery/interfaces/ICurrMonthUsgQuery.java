package com.ai.baas.bmc.api.currmonthusgquery.interfaces;

import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryReq;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryResp;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

/**
 * 当月使用量查询
 * Date: 2016年4月27日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
public interface ICurrMonthUsgQuery {
	
	
	/**
	 * 当月使用量查询
	 * @param req
	 * @return
	 */
	CurrMonthUsgQueryResp currMonthUsgQuery(CurrMonthUsgQueryReq req) throws BusinessException,SystemException ;
	
}
