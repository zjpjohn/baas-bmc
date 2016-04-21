package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItem;

/**
 * 单价费用项信息
 *
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author wangkai16
 */
public interface ICpUnitPriceItemAtom {

    /**
     * 根据状态和feeItemCode查询
     * @param feeItemCode
     * @param activeState
     * @return
     * @author wangkai16
     * @ApiDocMethod
     */
    List<CpUnitpriceItem> getUnitPriceItemByActiveState (String feeItemCode, String activeState); 
}
