package com.ai.baas.bmc.api.pricemaking.interfaces;

import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfoZX;
import com.ai.baas.bmc.api.pricemaking.params.PricemakingResponseZX;
import com.ai.baas.bmc.api.pricemaking.params.ResponseMessage;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

public interface IPricemakingSV {
    /**
     * 定价查询-中信
     * 
     * @param request
     * @return
     * @author mayt
     * @ApiDocMethod BaaS-0019
     */
    PricemakingResponseZX queryPricemakingZX(PriceElementInfoZX request) throws BusinessException,
            SystemException;

    /**
     * 定价查询
     * 
     * @param request
     * @return
     * @author mayt
     * @ApiDocMethod BaaS-0019
     */
    ResponseMessage queryPricemaking(PriceElementInfo request)throws BusinessException,
    SystemException;
}
