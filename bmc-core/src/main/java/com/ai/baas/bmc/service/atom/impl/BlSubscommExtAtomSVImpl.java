package com.ai.baas.bmc.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.baas.bmc.constants.BmcCacheConstant;
import com.ai.baas.bmc.dao.mapper.bo.BlSubscommExt;
import com.ai.baas.bmc.service.atom.interfaces.IBlSubscommExtAtomSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.opt.base.exception.BusinessException;
import com.alibaba.fastjson.JSON;

@Component
public class BlSubscommExtAtomSVImpl implements IBlSubscommExtAtomSV {

    @Override
    public void addDshmData(BlSubscommExt blSubscommExt) {
        int result = DshmUtil.getIdshmSV().initLoader(
                BmcCacheConstant.Dshm.TableName.BL_SUBSCOMM_EXT,
                JSON.toJSONString(BusinessUtil.assebleDshmData(blSubscommExt)),
                BmcCacheConstant.Dshm.OptType.INSERT);
        if (BmcCacheConstant.Dshm.InitLoaderReault.SUCCESS != result) {
            throw new BusinessException("产品订购信息写入缓存失败");
        }
    }

}
