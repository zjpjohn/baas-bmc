package com.ai.baas.bmc.api.pricemaking.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfoZX;
import com.ai.baas.bmc.api.pricemaking.params.PricemakingResponseZX;
import com.ai.baas.bmc.api.pricemaking.params.ResponseMessage;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

@Path("/pricemaking")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IPricemakingSV {
    /**
     * 定价查询-中信
     * 
     * @param request
     * @return
     * @author mayt
     * @ApiDocMethod BaaS-0019
     * @RestRelativeURL pricemaking/queryPricemakingZX
     */
    @POST
    @Path("/queryPricemakingZX")
    PricemakingResponseZX queryPricemakingZX(PriceElementInfoZX request) throws BusinessException,
            SystemException;

    /**
     * 定价查询
     * 
     * @param request
     * @return
     * @author mayt
     * @ApiDocMethod BaaS-0019
     * @RestRelativeURL pricemaking/queryPricemaking
     */
    @POST
    @Path("/queryPricemaking")
    ResponseMessage queryPricemaking(PriceElementInfo request) throws BusinessException,
            SystemException;
}
