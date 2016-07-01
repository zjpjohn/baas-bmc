package com.ai.baas.bmc.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceInfo;

public interface IPriceMakingBusiSV {

    /**
     * 定价查询
     * 
     * @param request
     * @return
     * @author mayt
     */
    List<PriceInfo> queryPriceMaking(PriceElementInfo request);

}
