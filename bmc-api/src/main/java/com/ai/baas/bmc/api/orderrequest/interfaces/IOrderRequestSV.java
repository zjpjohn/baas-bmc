package com.ai.baas.bmc.api.orderrequest.interfaces;

import com.ai.baas.bmc.api.orderrequest.params.OrderRequestInfo;
import com.ai.baas.bmc.api.orderrequest.params.ResponseMessage;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

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
     */
    ResponseMessage orderRequest(OrderRequestInfo request) throws SystemException,
            BusinessException;
}
