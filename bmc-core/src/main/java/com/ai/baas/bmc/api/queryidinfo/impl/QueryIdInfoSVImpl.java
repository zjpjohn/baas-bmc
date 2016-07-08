package com.ai.baas.bmc.api.queryidinfo.impl;

import com.ai.baas.bmc.api.queryidinfo.interfaces.IQueryIdInfoSV;
import com.ai.baas.bmc.api.queryidinfo.params.BlAcctInfoResponse;
import com.ai.baas.bmc.api.queryidinfo.params.BlCustinfoResponse;
import com.ai.baas.bmc.api.queryidinfo.params.ExtCustIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.OwnerIDInfo;
import com.ai.baas.bmc.constants.ExceptCodeConstant;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class QueryIdInfoSVImpl implements IQueryIdInfoSV {

    @Override
    public BlCustinfoResponse queryBlCustinfo(ExtCustIdInfo extCustIdInfo) {
        BlCustinfoResponse blCustinfoResponse = new BlCustinfoResponse();
        BusinessUtil.checkBaseInfo(extCustIdInfo);
        if (StringUtil.isBlank(extCustIdInfo.getExtCustId())) {
            throw new BusinessException("ExtCustId不可为空");
        }
        ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
        blCustinfoResponse.setResponseHeader(responseHeader);
        return null;
    }

    @Override
    public BlAcctInfoResponse queryBlAcctInfo(OwnerIDInfo ownerIDInfo) {
        BlAcctInfoResponse blAcctInfoResponse = new BlAcctInfoResponse();
        BusinessUtil.checkBaseInfo(ownerIDInfo);
        if (StringUtil.isBlank(ownerIDInfo.getOwnerId())) {
            throw new BusinessException("OwnerId不可为空");
        }
        ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
        blAcctInfoResponse.setResponseHeader(responseHeader);
        return blAcctInfoResponse;
    }

    @Override
    public BlAcctInfoResponse queryAcctIdByExtCustId(ExtCustIdInfo extCustIdInfo) {
        BlAcctInfoResponse blAcctInfoResponse = new BlAcctInfoResponse();
        BusinessUtil.checkBaseInfo(extCustIdInfo);
        if (StringUtil.isBlank(extCustIdInfo.getExtCustId())) {
            throw new BusinessException("ExtCustId不可为空");
        }
        ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
        blAcctInfoResponse.setResponseHeader(responseHeader);
        return null;
    }

}
