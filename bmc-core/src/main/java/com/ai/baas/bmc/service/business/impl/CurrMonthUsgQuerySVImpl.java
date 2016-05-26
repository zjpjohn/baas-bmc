package com.ai.baas.bmc.service.business.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryReq;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryResp;
import com.ai.baas.bmc.service.business.interfaces.ICurrMonthUsgQuerySV;
import com.ai.baas.bmc.service.atom.interfaces.ICurrMonthUsgQueryAtom;

/**
 * Date: 2016年4月27日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
@Service
@Transactional
public class CurrMonthUsgQuerySVImpl implements ICurrMonthUsgQuerySV {
	private static final Logger LOGGER = Logger.getLogger(CurrMonthUsgQuerySVImpl.class);
	@Autowired
	ICurrMonthUsgQueryAtom currMonthUsgQueryAtom;
	@Override
	public CurrMonthUsgQueryResp currMonthUsgQuery(CurrMonthUsgQueryReq req) {
		CurrMonthUsgQueryResp resp = null;
		try{
			resp = currMonthUsgQueryAtom.currMonthUsgQuery(req);
			resp.setReturnCode(CurrMonthUsgQueryResp.SUCCESS);
		}
		catch(Exception e){
			LOGGER.error("",e);
			resp = new CurrMonthUsgQueryResp();
			resp.setReturnCode(CurrMonthUsgQueryResp.ERROR);
		}
		return resp;
		
	}
	
}
