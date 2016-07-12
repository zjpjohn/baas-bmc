package com.ai.baas.bmc.api.orderrequest.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.orderrequest.params.OrderRequestInfo;
import com.ai.baas.bmc.api.orderrequest.params.ResponseMessage;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
@Path("/orderrequest")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderRequestSV {
    /**
     * 订购请求接口(不使用)
     * 
     * @param request
     * @return
     * @throws SystemException
     * @throws BusinessException
     * @author mayt
     * @ApiDocMethod BaaS-0020
     * @RestRelativeURL orderrequest/orderRequest
     */
    @POST
    @Path("/orderRequest")
    ResponseMessage orderRequest(OrderRequestInfo request) throws SystemException,
            BusinessException;
}
