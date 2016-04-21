package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.dao.interfaces.CpUnitpriceInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.ICpUnitPriceInfoAtom;
@Service
public class CpUnitPriceInfoAtomImpl implements ICpUnitPriceInfoAtom{

    @Autowired
    private CpUnitpriceInfoMapper cpUnitpriceInfoMapper;
    @Override
    public List<CpUnitpriceInfo> getCpUnitPriceInfo(String detailCode) {
        
        CpUnitpriceInfoCriteria cpUnitpriceInfoCriteria = new CpUnitpriceInfoCriteria();   
        cpUnitpriceInfoCriteria.createCriteria()
          .andUnitPriceCodeEqualTo(detailCode);
        //判空
        List<CpUnitpriceInfo> cpUnitpriceInfoList = cpUnitpriceInfoMapper.selectByExample(cpUnitpriceInfoCriteria);

        return cpUnitpriceInfoList;
    }
    
}
