package com.ai.baas.bmc.api.baseInfo.interfaces;

import com.ai.baas.bmc.api.baseInfo.params.BaseCodeInfo;
import com.ai.baas.bmc.api.baseInfo.params.QueryInfoParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

public interface IBaseInfoSV {

	BaseCodeInfo getBaseInfo(QueryInfoParams param) throws BusinessException,
    SystemException;
}
