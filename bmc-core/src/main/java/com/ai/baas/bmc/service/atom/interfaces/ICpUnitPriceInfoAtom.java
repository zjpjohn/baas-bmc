package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfo;

/**
 * 单价列表
 *
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author wangkai16
 */
public interface ICpUnitPriceInfoAtom {

    List<CpUnitpriceInfo> getCpUnitPriceInfo(String detailCode);
}
