package com.ai.baas.bmc.api.initbasedata.interfaces;

import com.ai.baas.bmc.api.initbasedata.params.InitBaseParam;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

/**
 * 用户资料的初始化
 *
 * Date: 2016年6月24日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author biancx
 */
public interface IInitBaseSV {
    /**
     * 重批价服务
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author biancx
     * @ApiDocMethod
     * @ApiCode 
     */
	 public BaseResponse InitBaseData (InitBaseParam param) throws BusinessException,SystemException;
}
