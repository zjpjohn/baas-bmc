package com.ai.baas.bmc.api.BaseInfo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.baseInfo.interfaces.IBaseInfoSV;
import com.ai.baas.bmc.api.baseInfo.params.BaseCodeInfo;
import com.ai.baas.bmc.api.baseInfo.params.QueryInfoParams;
import com.ai.baas.bmc.business.interfaces.IBaseInfoBussiness;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class BaseInfoSVImpl implements IBaseInfoSV {

	@Autowired
	private IBaseInfoBussiness iBaseInfoBussiness;
	@Override
	public BaseCodeInfo getBaseInfo(QueryInfoParams param) {
		
		return iBaseInfoBussiness.getBaseInfo(param);
	}

}
