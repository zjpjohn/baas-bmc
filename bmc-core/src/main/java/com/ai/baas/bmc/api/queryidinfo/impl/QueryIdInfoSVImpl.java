package com.ai.baas.bmc.api.queryidinfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.queryidinfo.interfaces.IQueryIdInfoSV;
import com.ai.baas.bmc.api.queryidinfo.params.AcctIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.BlAcctInfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.BlAcctInfoResponse;
import com.ai.baas.bmc.api.queryidinfo.params.BlCustinfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.BlCustinfoResponse;
import com.ai.baas.bmc.api.queryidinfo.params.CustIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.ExtCustIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.OwnerIDInfo;
import com.ai.baas.bmc.constants.ExceptCodeConstant;
import com.ai.baas.bmc.service.atom.interfaces.IQueryIdInfoAtomSV;
import com.ai.baas.bmc.service.business.interfaces.IQueryIdInfoBusiSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class QueryIdInfoSVImpl implements IQueryIdInfoSV {

    @Autowired
    private IQueryIdInfoAtomSV iQueryIdInfoAtomSV;

    @Autowired
    private IQueryIdInfoBusiSV iQueryIdInfoBusiSV;

    @Override
    public BlCustinfoResponse queryBlCustinfo(ExtCustIdInfo extCustIdInfo) {
        BlCustinfoResponse blCustinfoResponse = new BlCustinfoResponse();
        BusinessUtil.checkBaseInfo(extCustIdInfo);
        if (StringUtil.isBlank(extCustIdInfo.getExtCustId())) {
            throw new BusinessException("ExtCustId不可为空");
        }
        List<BlCustinfoInfo> blCustinfoInfos = iQueryIdInfoAtomSV.queryBlCustinfo(extCustIdInfo);
        ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
        blCustinfoResponse.setResponseHeader(responseHeader);
        blCustinfoResponse.setBlCustinfoInfos(blCustinfoInfos);
        return blCustinfoResponse;
    }

    @Override
    public BlAcctInfoResponse queryBlAcctInfo(OwnerIDInfo ownerIDInfo) {
        BlAcctInfoResponse blAcctInfoResponse = new BlAcctInfoResponse();
        BusinessUtil.checkBaseInfo(ownerIDInfo);
        if (StringUtil.isBlank(ownerIDInfo.getOwnerId())) {
            throw new BusinessException("OwnerId不可为空");
        }
        List<BlAcctInfoInfo> blAcctInfoInfos = iQueryIdInfoAtomSV.queryBlAcctInfo(ownerIDInfo);
        ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
        blAcctInfoResponse.setResponseHeader(responseHeader);
        blAcctInfoResponse.setBlAcctInfoInfos(blAcctInfoInfos);
        return blAcctInfoResponse;
    }

    @Override
    public BlAcctInfoResponse queryAcctIdByExtCustId(ExtCustIdInfo extCustIdInfo) {
        BlAcctInfoResponse blAcctInfoResponse = new BlAcctInfoResponse();
        BusinessUtil.checkBaseInfo(extCustIdInfo);
        if (StringUtil.isBlank(extCustIdInfo.getExtCustId())) {
            throw new BusinessException("ExtCustId不可为空");
        }

        List<BlAcctInfoInfo> blAcctInfoInfos = iQueryIdInfoBusiSV
                .queryAcctIdByExtCustId(extCustIdInfo);
        ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
        blAcctInfoResponse.setResponseHeader(responseHeader);
        blAcctInfoResponse.setBlAcctInfoInfos(blAcctInfoInfos);
        return blAcctInfoResponse;
    }

    @Override
    public BlCustinfoResponse queryExtCustIdByAcctId(AcctIdInfo acctIdInfo) {
        BlCustinfoResponse blCustinfoResponse = new BlCustinfoResponse();
        BusinessUtil.checkBaseInfo(acctIdInfo);
        if (StringUtil.isBlank(acctIdInfo.getAcctId())) {
            throw new BusinessException("AcctId不可为空");
        }
        List<BlCustinfoInfo> blCustinfoInfos = iQueryIdInfoBusiSV
                .queryExtCustIdByAcctId(acctIdInfo);
        ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
        blCustinfoResponse.setResponseHeader(responseHeader);
        blCustinfoResponse.setBlCustinfoInfos(blCustinfoInfos);
        return blCustinfoResponse;
    }

    @Override
    public BlCustinfoResponse queryBlCustinfoByCustId(CustIdInfo custIdInfo) {
        BlCustinfoResponse blCustinfoResponse = new BlCustinfoResponse();
        BusinessUtil.checkBaseInfo(custIdInfo);
        if (StringUtil.isBlank(custIdInfo.getCustId())) {
            throw new BusinessException("CustId不可为空");
        }
        List<BlCustinfoInfo> blCustinfoInfos = iQueryIdInfoAtomSV.queryBlCustinfoByCustId(custIdInfo);
        ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
        blCustinfoResponse.setResponseHeader(responseHeader);
        blCustinfoResponse.setBlCustinfoInfos(blCustinfoInfos);
        return blCustinfoResponse;
    }

}
