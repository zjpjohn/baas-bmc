package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.dao.interfaces.CpFactorInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.ICpFactorInfoAtom;


@Service
public class CpFactorInfoAtomImpl implements ICpFactorInfoAtom{

    @Autowired
    private CpFactorInfoMapper cpFactorInfoMapper;
    @Override
    public List<CpFactorInfo> getFactorInfo(String factorCode,String factorName) {
        CpFactorInfoCriteria cpFactorInfoCriteria = new CpFactorInfoCriteria();
        cpFactorInfoCriteria.createCriteria()
         .andFactorCodeEqualTo(factorCode)
         .andFactorNameEqualTo(factorName);
        
        List<CpFactorInfo>cpFactorInfoList = cpFactorInfoMapper.selectByExample(cpFactorInfoCriteria) ;

        return cpFactorInfoList;
    }

}
