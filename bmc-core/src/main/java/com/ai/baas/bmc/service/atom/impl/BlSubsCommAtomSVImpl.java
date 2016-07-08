package com.ai.baas.bmc.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.baas.bmc.constants.BmcCacheConstant;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsComm;
import com.ai.baas.bmc.service.atom.interfaces.IBlSubsCommAtomSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.alibaba.fastjson.JSON;
@Component
public class BlSubsCommAtomSVImpl implements IBlSubsCommAtomSV {

    @Override
    public void addDshmData(BlSubsComm aBlSubsComm) {
        DshmUtil.getIdshmSV().initLoader(BmcCacheConstant.Dshm.TableName.BL_SUBS_COMM,
                JSON.toJSONString(BusinessUtil.assebleDshmData(aBlSubsComm)),
                BmcCacheConstant.Dshm.OptType.INSERT); // redis 0更新 1插入
    }

}
