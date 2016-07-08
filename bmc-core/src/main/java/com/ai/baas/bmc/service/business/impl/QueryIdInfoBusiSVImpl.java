package com.ai.baas.bmc.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.api.queryidinfo.params.BlAcctInfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.BlCustinfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.ExtCustIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.OwnerIDInfo;
import com.ai.baas.bmc.service.atom.interfaces.IQueryIdInfoAtomSV;
import com.ai.baas.bmc.service.business.interfaces.IQueryIdInfoBusiSV;
import com.ai.opt.sdk.util.CollectionUtil;

@Service
public class QueryIdInfoBusiSVImpl implements IQueryIdInfoBusiSV {

    @Autowired
    private IQueryIdInfoAtomSV iQueryIdInfoAtomSV;

    @Override
    public List<BlAcctInfoInfo> queryAcctIdByExtCustId(ExtCustIdInfo extCustIdInfo) {
        List<BlAcctInfoInfo> blAcctInfoInfos = null;
        List<BlCustinfoInfo> blCustinfoInfos = iQueryIdInfoAtomSV.queryBlCustinfo(extCustIdInfo);
        if (CollectionUtil.isEmpty(blCustinfoInfos)) {
            return null;
        } else {
            OwnerIDInfo ownerIDInfo = new OwnerIDInfo();
            ownerIDInfo.setTenantId(extCustIdInfo.getTenantId());
            ownerIDInfo.setOwnerId(blCustinfoInfos.get(0).getCustId());
            blAcctInfoInfos = iQueryIdInfoAtomSV.queryBlAcctInfo(ownerIDInfo);
        }
        return blAcctInfoInfos;
    }

}
