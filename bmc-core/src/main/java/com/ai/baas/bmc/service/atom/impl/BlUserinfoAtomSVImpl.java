package com.ai.baas.bmc.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.baas.bmc.constants.BmcCacheConstant;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;
import com.ai.baas.bmc.service.atom.interfaces.IBlUserinfoAtomSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.alibaba.fastjson.JSON;
@Component
public class BlUserinfoAtomSVImpl implements IBlUserinfoAtomSV {

    @Override
    public void addDshmData(BlUserinfo blUserinfo) {
        DshmUtil.getIdshmSV().initLoader(BmcCacheConstant.Dshm.TableName.BL_USERINFO,
                JSON.toJSONString(BusinessUtil.assebleDshmData(blUserinfo)),
                BmcCacheConstant.Dshm.OptType.INSERT); // redis 0更新 1插入
    }

}
