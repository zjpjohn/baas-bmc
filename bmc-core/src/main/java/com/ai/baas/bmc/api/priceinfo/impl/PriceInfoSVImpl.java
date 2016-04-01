package com.ai.baas.bmc.api.priceinfo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.baas.bmc.api.priceinfo.params.ResponseMessage;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.baas.bmc.business.interfaces.IGetPriceInfoBussiness;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

public class PriceInfoSVImpl implements IPriceInfoSV{

    @Autowired
    private IGetPriceInfoBussiness IGetPriceInfoBussiness;
    @Override
    public ResponseMessage getPriceInfo(QueryInfoParams record) throws BusinessException, SystemException {
        return IGetPriceInfoBussiness.getPriceInfo(record);
    }

    @Override
    public String updatePriceInfo(StandardPriceInfoParams record)
            throws BusinessException, SystemException {
        return null;
    }

}
