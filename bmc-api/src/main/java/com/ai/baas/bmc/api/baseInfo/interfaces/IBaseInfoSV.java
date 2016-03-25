package com.ai.baas.bmc.api.baseInfo.interfaces;

import com.ai.baas.bmc.api.baseInfo.params.BaseCodeInfo;
import com.ai.baas.bmc.api.baseInfo.params.QueryInfoParams;

public interface IBaseInfoSV {

	BaseCodeInfo getBaseInfo(QueryInfoParams param);
}
