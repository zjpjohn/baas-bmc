package com.ai.baas.bmc.business.interfaces;

import com.ai.baas.bmc.api.priceinfo.params.ResponseMessage;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;


public interface IGetPriceInfoBussiness {
    public ResponseMessage getPriceInfo(QueryInfoParams record) ;
}
