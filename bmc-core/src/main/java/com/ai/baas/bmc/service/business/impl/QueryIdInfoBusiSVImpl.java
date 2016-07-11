package com.ai.baas.bmc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.queryidinfo.params.AcctIdInfo;
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
import com.ai.baas.bmc.service.business.interfaces.IQueryIdInfoBusiSV;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;

@Service
@Transactional
public class QueryIdInfoBusiSVImpl implements IQueryIdInfoBusiSV {

    @Autowired
    private IQueryIdInfoAtomSV iQueryIdInfoAtomSV;

    @Autowired
    private BlCustinfoMapper blCustinfoMapper;

    @Autowired
    private BlAcctInfoMapper blAcctInfoMapper;

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

    @Override
    public List<BlCustinfoInfo> queryExtCustIdByAcctId(AcctIdInfo acctIdInfo) {
        List<BlCustinfoInfo> blCustinfoInfos = null;
        BlAcctInfoCriteria blAcctInfoCriteria = new BlAcctInfoCriteria();
        BlAcctInfoCriteria.Criteria criteria = blAcctInfoCriteria.createCriteria();
        criteria.andTenantIdEqualTo(acctIdInfo.getTenantId());
        criteria.andAcctIdEqualTo(acctIdInfo.getAcctId());
        List<BlAcctInfo> blAcctInfos = blAcctInfoMapper.selectByExample(blAcctInfoCriteria);
        if (CollectionUtil.isEmpty(blAcctInfos)) {
            return null;
        } else {

            BlCustinfoCriteria blCustinfoCriteria = new BlCustinfoCriteria();
            BlCustinfoCriteria.Criteria criteria1 = blCustinfoCriteria.createCriteria();
            criteria1.andTenantIdEqualTo(blAcctInfos.get(0).getTenantId());
            criteria1.andCustIdEqualTo(blAcctInfos.get(0).getOwnerId());
            List<BlCustinfo> blCustinfos = blCustinfoMapper.selectByExample(blCustinfoCriteria);
            if (CollectionUtil.isEmpty(blCustinfos)) {
                return null;
            } else {
                blCustinfoInfos = new ArrayList<BlCustinfoInfo>();
                for (int i = 0; i < blCustinfos.size(); i++) {
                    BlCustinfoInfo blCustinfoInfo = new BlCustinfoInfo();
                    BeanUtils.copyVO(blCustinfoInfo, blCustinfos.get(i));
                    blCustinfoInfos.add(blCustinfoInfo);
                }
            }
        }
        return blCustinfoInfos;
    }

}
