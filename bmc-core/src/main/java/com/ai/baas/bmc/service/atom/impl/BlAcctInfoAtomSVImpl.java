package com.ai.baas.bmc.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.baas.bmc.constants.BmcCacheConstant;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.service.atom.interfaces.IBlAcctInfoAtomSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.alibaba.fastjson.JSON;

@Component
public class BlAcctInfoAtomSVImpl implements IBlAcctInfoAtomSV {

    @Override
    public void addDshmData(BlAcctInfo blAcctInfo) {
        DshmUtil.getIdshmSV().initLoader(BmcCacheConstant.Dshm.TableName.BL_ACCT_INFO,
                JSON.toJSONString(BusinessUtil.assebleDshmData(blAcctInfo)),
                BmcCacheConstant.Dshm.OptType.INSERT);
    }

}
