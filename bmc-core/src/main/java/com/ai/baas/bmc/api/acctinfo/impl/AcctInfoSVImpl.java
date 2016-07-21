package com.ai.baas.bmc.api.acctinfo.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.acctinfo.interfaces.IAcctInfoSV;
import com.ai.baas.bmc.api.acctinfo.params.AcctQueryRequest;
import com.ai.baas.bmc.api.acctinfo.params.ResponseMessage;
import com.ai.baas.bmc.service.business.interfaces.IAcctInfoBusiness;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class AcctInfoSVImpl implements IAcctInfoSV{
	private static final Logger log = LogManager
			.getLogger(AcctInfoSVImpl.class);
	@Autowired
	private IAcctInfoBusiness iAcctInfoBusiness;
	@Override
	public ResponseMessage getAcctInfo(AcctQueryRequest acctQueryRequest) 
			throws BusinessException, SystemException{
		if(StringUtil.isBlank(acctQueryRequest.getTenantId())){
			throw new BusinessException("TenantId不可为空");
		}
		return iAcctInfoBusiness.getAcctInfo(acctQueryRequest);
	}

}
