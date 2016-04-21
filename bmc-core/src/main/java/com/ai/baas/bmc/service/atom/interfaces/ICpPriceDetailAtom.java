package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;

/**
 * 资费计划明细
 *
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface ICpPriceDetailAtom {

	Long addCpPriceDetail(CpPriceDetail info);
	List<CpPriceDetail> getCpPriceDetail(CpPriceDetail detail);
	CpPriceDetail getCpPriceDetail(String priceCode);
	void updatePriceDetail(CpPriceDetail info);
	/**
	 * 通过priceCode修改信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	void updatePriceDetailByPriceCode(CpPriceDetail info);
	/**
	 * 通过priceCode删除信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	void deletePriceDetailByPriceCode(CpPriceDetail info);
	/**
	 * 根据priceCode查询信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	CpPriceDetail getCpPriceDetailByPriceCode(CpPriceDetail info);
	
	/**
	 * 根据priceCode和serviceType查询信息
	 * @param
	 * @author wangkai16
	 * @ApiDocMethod
	 */
	List<CpPriceDetail> getCpPriceDetailByServiceType(String priceCode, String serviceType);
	
	
}
