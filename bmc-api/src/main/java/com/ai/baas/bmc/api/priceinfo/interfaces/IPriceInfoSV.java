package com.ai.baas.bmc.api.priceinfo.interfaces;

import com.ai.baas.bmc.api.priceinfo.params.PriceCode;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;


public interface IPriceInfoSV {
    /**
     * 资费查询接口
     * Date: 2016年3月28日 <br>
     * Copyright (c) 2016 asiainfo.com <br>
     * 
     * @author KAI
     */
     @interface GetPriceInfo{}
     public PriceCode getPriceInfo(QueryInfoParams record)throws BusinessException,SystemException;
     
     
     
}
