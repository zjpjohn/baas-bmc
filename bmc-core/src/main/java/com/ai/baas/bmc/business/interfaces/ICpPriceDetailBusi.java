package com.ai.baas.bmc.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;

/**
 * 资费计划明细
 *
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface ICpPriceDetailBusi {

	Integer addCpPriceDetail(CpPriceDetail info);
	List<CpPriceDetail> getCpPriceDetail(CpPriceDetail detail);
	CpPriceDetail getCpPriceDetail(String priceCode);
}
