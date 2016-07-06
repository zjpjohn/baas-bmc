package com.ai.baas.bmc.business.interfaces;

import com.ai.baas.bmc.api.orderrequest.params.OrderRequestInfo;
import com.ai.baas.bmc.api.orderrequest.params.ResponseMessage;

public interface IOrderRequestBusiSV {

    ResponseMessage orderRequest(OrderRequestInfo request);

}
