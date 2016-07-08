package com.ai.baas.bmc.service.atom.impl;

import com.ai.baas.bmc.constants.BmcCacheConstant;
import com.ai.baas.bmc.dao.mapper.bo.BlSubscommExt;
import com.ai.baas.bmc.service.atom.interfaces.IBlSubscommExtAtomSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.alibaba.fastjson.JSON;

public class BlSubscommExtAtomSVImpl implements IBlSubscommExtAtomSV {

    @Override
    public void addDshmData(BlSubscommExt blSubscommExt) {
        DshmUtil.getIdshmSV().initLoader(BmcCacheConstant.Dshm.TableName.BL_SUBSCOMM_EXT,
                JSON.toJSONString(BusinessUtil.assebleDshmData(blSubscommExt)),
                BmcCacheConstant.Dshm.OptType.INSERT);
    }

}
