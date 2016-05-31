package com.ai.baas.bmc.service.atom.impl;

import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
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
    public void addRecordList(List<BmcRecord> srcInfos) {
        if(!CollectionUtil.isEmpty(srcInfos)){
            BmcRecord record = srcInfos.get(0);
            if(!StringUtil.isBlank(record.getTenantId())&&!StringUtil.isBlank(record.getServiceType())){
                RtmSrcInfoCriteria example = new RtmSrcInfoCriteria();
                RtmSrcInfoCriteria.Criteria criteria = example.or();
                criteria.andTenantIdEqualTo(record.getTenantId());
                criteria.andInfoTypeEqualTo(record.getServiceType());
                List<RtmSrcInfo> rtmSrcInfos = srcInfoMapper.selectByExample(example);
                if(CollectionUtil.isEmpty(rtmSrcInfos)){
                    RtmSrcInfo srcInfo = new RtmSrcInfo();
                    srcInfo.setTenantId(record.getTenantId());
                    srcInfo.setInfoType(record.getServiceType());
                    srcInfoMapper.insertSpec(srcInfo);
                }
            }
        }
    }
}
