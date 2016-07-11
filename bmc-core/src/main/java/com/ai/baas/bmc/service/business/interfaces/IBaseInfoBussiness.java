package com.ai.baas.bmc.service.business.interfaces;

import com.ai.baas.bmc.api.baseInfo.params.BaseCodeInfo;
import com.ai.baas.bmc.api.baseInfo.params.ChildeCodeResponse;
import com.ai.baas.bmc.api.baseInfo.params.QueryChildCodeRequest;
import com.ai.baas.bmc.api.baseInfo.params.QueryInfoParams;

/**
 * 基本信息编码业务逻辑
 *
 * Date: 2016年3月24日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface IBaseInfoBussiness {

	BaseCodeInfo getBaseInfo(QueryInfoParams param);
	
	ChildeCodeResponse getChildCode(QueryChildCodeRequest request);
}
