package com.ai.baas.bmc.service.atom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.api.queryidinfo.params.BlAcctInfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.BlCustinfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.ExtCustIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.OwnerIDInfo;
import com.ai.baas.bmc.dao.interfaces.BlAcctInfoMapper;
import com.ai.baas.bmc.dao.interfaces.BlCustinfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IQueryIdInfoAtomSV;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;

@Service
public class QueryIdInfoAtomSVImpl implements IQueryIdInfoAtomSV {
    @Autowired
    private BlCustinfoMapper blCustinfoMapper;

    @Autowired
    private BlAcctInfoMapper blAcctInfoMapper;

    @Override
    public List<BlCustinfoInfo> queryBlCustinfo(ExtCustIdInfo extCustIdInfo) {
        List<BlCustinfoInfo> blCustinfoInfos = new ArrayList<BlCustinfoInfo>();
        BlCustinfoCriteria blCustinfoCriteria = new BlCustinfoCriteria();
        BlCustinfoCriteria.Criteria criteria = blCustinfoCriteria.createCriteria();
        criteria.andTenantIdEqualTo(extCustIdInfo.getTenantId());
        criteria.andExtCustIdEqualTo(extCustIdInfo.getExtCustId());
        List<BlCustinfo> blCustinfos = blCustinfoMapper.selectByExample(blCustinfoCriteria);
        if (CollectionUtil.isEmpty(blCustinfos)) {
            return null;
        } else {
            for (int i = 0; i < blCustinfos.size(); i++) {
                BlCustinfoInfo blCustinfoInfo = new BlCustinfoInfo();
                BeanUtils.copyVO(blCustinfoInfo, blCustinfos.get(i));
                blCustinfoInfos.add(blCustinfoInfo);
            }
        }
        return blCustinfoInfos;
    }

    @Override
    public List<BlAcctInfoInfo> queryBlAcctInfo(OwnerIDInfo ownerIDInfo) {

        List<BlAcctInfoInfo> blAcctInfoInfos = new ArrayList<BlAcctInfoInfo>();
        BlAcctInfoCriteria blAcctInfoCriteria = new BlAcctInfoCriteria();
        BlAcctInfoCriteria.Criteria criteria = blAcctInfoCriteria.createCriteria();
        criteria.andTenantIdEqualTo(ownerIDInfo.getTenantId());
        criteria.andOwnerIdEqualTo(ownerIDInfo.getOwnerId());
        List<BlAcctInfo> blAcctInfos = blAcctInfoMapper.selectByExample(blAcctInfoCriteria);
        if (CollectionUtil.isEmpty(blAcctInfos)) {
            return null;
        } else {
            for (int i = 0; i < blAcctInfos.size(); i++) {
                BlAcctInfoInfo blAcctInfoInfo = new BlAcctInfoInfo();
                BeanUtils.copyVO(blAcctInfoInfo, blAcctInfos.get(i));
                blAcctInfoInfos.add(blAcctInfoInfo);
            }
        }
        return blAcctInfoInfos;
    }

}
