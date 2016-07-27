package com.ai.baas.bmc.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.baas.bmc.constants.BmcCacheConstant;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;
import com.ai.baas.bmc.service.atom.interfaces.IBlUserinfoAtomSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.opt.base.exception.BusinessException;
import com.alibaba.fastjson.JSON;

@Component
public class BlUserinfoAtomSVImpl implements IBlUserinfoAtomSV {

    @Override
    public void addDshmData(BlUserinfo blUserinfo) {
        int result = DshmUtil.getIdshmSV().initLoader(BmcCacheConstant.Dshm.TableName.BL_USERINFO,
                JSON.toJSONString(BusinessUtil.assebleDshmData(blUserinfo)),
                BmcCacheConstant.Dshm.OptType.INSERT); // redis 0更新 1插入
        if (BmcCacheConstant.Dshm.InitLoaderReault.SUCCESS != result) {
            throw new BusinessException("用户信息写入缓存失败");
        }
    }
}
