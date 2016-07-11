package com.ai.baas.bmc.service.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceInfo;

public interface IPricemakingBusiSV {

    /**
     * 定价查询
     * 
     * @param request
     * @return
     * @author mayt
     */
    List<PriceInfo> queryPricemaking(PriceElementInfo request);

}
