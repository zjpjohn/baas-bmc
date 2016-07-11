package com.ai.baas.bmc.api.orderrequest.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.orderrequest.interfaces.IOrderRequestSV;
import com.ai.baas.bmc.api.orderrequest.params.OrderRequestInfo;
import com.ai.baas.bmc.api.orderrequest.params.ResponseMessage;
import com.ai.baas.bmc.service.business.interfaces.IOrderRequestBusiSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;

public class OrderRequestSVImpl implements IOrderRequestSV {
    @Autowired
    private transient IOrderRequestBusiSV iOrderRequestBusiSV;

    @Override
    public ResponseMessage orderRequest(OrderRequestInfo request) throws SystemException,
            BusinessException {
        BusinessUtil.checkBaseInfo(request);
        ResponseMessage response = iOrderRequestBusiSV.orderRequest(request);
        response.setResponseHeader(new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS,
                "成功"));
        return response;
    }

}
