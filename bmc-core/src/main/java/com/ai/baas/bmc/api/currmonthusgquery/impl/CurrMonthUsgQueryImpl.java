package com.ai.baas.bmc.api.currmonthusgquery.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.paas.ipaas.util.StringUtil;
import com.ai.baas.bmc.api.currmonthusgquery.interfaces.ICurrMonthUsgQuery;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryReq;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryResp;
import com.ai.baas.bmc.constants.ExceptCodeConstant;
import com.ai.baas.bmc.service.business.interfaces.ICurrMonthUsgQuerySV;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

/**
 * 用户查询当月套餐使用量
 * Date: 2016年4月27日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
@Service
@Component
public class CurrMonthUsgQueryImpl implements ICurrMonthUsgQuery{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CurrMonthUsgQueryImpl.class);
	
	@Autowired
	ICurrMonthUsgQuerySV currMonthUsgQuerySV;
	
	@Override
	public CurrMonthUsgQueryResp currMonthUsgQuery(CurrMonthUsgQueryReq req)
			throws BusinessException,SystemException{
		
		//参数检验
		if(null == req){
			throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL,"[参数不合法]");
		}
		if(StringUtil.isBlank(req.getTenantId())){
			throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL,"[租户ID参数不能为空]");
		}
//		if(StringUtil.isBlank(req.getSystemId())){
//			throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL,"[系统ID参数不能为空]");
//		}
		if(StringUtil.isBlank(req.getCustId())){
			throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL,"[客户ID参数不能为空]");
		}
		if(StringUtil.isBlank(req.getSubsId())){
			throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL,"[用户ID参数不能为空]");
		}
		/*if(StringUtil.isBlank(req.getApnCode())){
			throw new BusinessException(ExceptCodeConstant.PARAM_IS_NULL,"[ApnCode参数不能为空]");
		}*/
		LOGGER.info("query param:"+JSON.toJSONString(req));
		return currMonthUsgQuerySV.currMonthUsgQuery(req);
	}

	

}
