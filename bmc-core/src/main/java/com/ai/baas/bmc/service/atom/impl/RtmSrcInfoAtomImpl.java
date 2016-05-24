package com.ai.baas.bmc.service.atom.impl;

import com.ai.baas.bmc.dao.interfaces.RtmSrcInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcInfo;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcInfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IRtmSrcInfoAtomSV;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RtmSrcInfoAtomImpl implements IRtmSrcInfoAtomSV {

    @Autowired
    private RtmSrcInfoMapper srcInfoMapper;

    @Override
    public void addRecord(RtmSrcInfo srcInfo) {
        if(!StringUtil.isBlank(srcInfo.getTenantId())&&!StringUtil.isBlank(srcInfo.getInfoType())){
            RtmSrcInfoCriteria example = new RtmSrcInfoCriteria();
            RtmSrcInfoCriteria.Criteria criteria = example.or();
            criteria.andTenantIdEqualTo(srcInfo.getTenantId());
            criteria.andInfoTypeEqualTo(srcInfo.getInfoType());
            List<RtmSrcInfo> rtmSrcInfos = srcInfoMapper.selectByExample(example);
            if(CollectionUtil.isEmpty(rtmSrcInfos)){
                srcInfoMapper.insertSelective(srcInfo);
            }
        }
    }
}
