package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.dao.interfaces.CpUnitpriceItemMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItem;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItemCriteria;
import com.ai.baas.bmc.service.atom.interfaces.ICpUnitPriceItemAtom;
import com.ai.opt.sdk.util.StringUtil;
@Service
public class CpUnitPriceItemAtomImpl implements  ICpUnitPriceItemAtom{
    @Autowired
    private CpUnitpriceItemMapper cpUnitpriceItemMapper;
    @Override
    public List<CpUnitpriceItem> getUnitPriceItemByActiveState(String feeItemCode,String activeState) {
        CpUnitpriceItemCriteria cpUnitpriceItemCriteria = new CpUnitpriceItemCriteria();
        CpUnitpriceItemCriteria.Criteria  cpUnitpriceItemC = cpUnitpriceItemCriteria.or();
        //增加生效状态做为查询条件
        if(!StringUtil.isBlank(activeState)){
            cpUnitpriceItemC.andActiveStatusEqualTo(activeState);
        }
        cpUnitpriceItemC.andFeeItemCodeEqualTo(feeItemCode);
        List<CpUnitpriceItem> cpUnitpriceItemList =  cpUnitpriceItemMapper.selectByExample(cpUnitpriceItemCriteria);
        
        return cpUnitpriceItemList;
    }

}
