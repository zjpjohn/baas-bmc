package com.ai.baas.bmc.api.BaseInfo.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.baseInfo.interfaces.IBaseInfoSV;
import com.ai.baas.bmc.api.baseInfo.params.BaseCodeInfo;
import com.ai.baas.bmc.api.baseInfo.params.ChildeCodeResponse;
import com.ai.baas.bmc.api.baseInfo.params.QueryChildCodeRequest;
import com.ai.baas.bmc.api.baseInfo.params.QueryInfoParams;
import com.ai.baas.bmc.business.interfaces.IBaseInfoBussiness;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

@Service(validation="true")
@Component
public class BaseInfoSVImpl implements IBaseInfoSV {

	@Autowired
	private DataSource  ds;

	@Autowired
	private IBaseInfoBussiness iBaseInfoBussiness;
	@Override
	public BaseCodeInfo getBaseInfo(QueryInfoParams param) {
		System.out.println("-----msg------"+JSON.toJSONString(ds));
		
		return iBaseInfoBussiness.getBaseInfo(param);
	}
	@Override
	public ChildeCodeResponse getChildCode(QueryChildCodeRequest request) throws BusinessException, SystemException {
		
		return iBaseInfoBussiness.getChildCode(request);
	}

}
