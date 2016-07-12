package com.ai.baas.bmc.api.acctinfo.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.acctinfo.interfaces.IAcctInfoSV;
import com.ai.baas.bmc.api.acctinfo.params.AcctQueryRequest;
import com.ai.baas.bmc.api.acctinfo.params.ResponseMessage;
import com.ai.baas.bmc.service.business.interfaces.IAcctInfoBusiness;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class AcctInfoSVImpl implements IAcctInfoSV{
	private static final Logger log = LogManager
			.getLogger(AcctInfoSVImpl.class);
	@Autowired
	private IAcctInfoBusiness iAcctInfoBusiness;
	public ResponseMessage getAcctInfo(AcctQueryRequest acctQueryRequest) 
			throws BusinessException, SystemException{
		if (null == acctQueryRequest) {
			log.debug("addProduct() vo = [null]");
			return null;
		} else {
			log.debug("addProduct() vo = " + acctQueryRequest.toString() + "]");
		}
		if(null == acctQueryRequest.getTenantId() || StringUtil.isBlank(acctQueryRequest.getTenantId())){
			throw new BusinessException("tenantId is not null", "租户id不能为空");
		}
//		if(null == acctQueryRequest.getCustID() || StringUtil.isBlank(acctQueryRequest.getCustID())){
//			throw new BusinessException("custID is not null", "客户id不能为空");
//		}
		return iAcctInfoBusiness.getAcctInfo(acctQueryRequest);
	}

}
