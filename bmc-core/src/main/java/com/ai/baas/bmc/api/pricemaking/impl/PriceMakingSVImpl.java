package com.ai.baas.bmc.api.pricemaking.impl;

import com.ai.baas.bmc.api.pricemaking.interfaces.IPriceMakingSV;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfoZX;
import com.ai.baas.bmc.api.pricemaking.params.ResponseMessage;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class PriceMakingSVImpl implements IPriceMakingSV {

    @Override
    public ResponseMessage queryPriceMakingZX(PriceElementInfoZX request) throws BusinessException,
            SystemException {
        BusinessUtil.checkBaseInfo(request);
        if (StringUtil.isBlank(request.getService_id())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "service_id不能为空");
        }
        if (StringUtil.isBlank(request.getAccepts_incomplete())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                    "accepts_incomplete不能为空");
        }
        if (StringUtil.isBlank(request.getParameters())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "parameters不能为空");
        }
        ResponseMessage response = new ResponseMessage();
        response.setResponseHeader(new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS,
                "成功"));
        return response;
    }

    @Override
    public ResponseMessage queryPriceMaking(PriceElementInfo request) {
        ResponseMessage response = new ResponseMessage();
        response.setResponseHeader(new ResponseHeader(true, ExceptCodeConstants.Special.SUCCESS,
                "成功"));
        return response;
    }

}
