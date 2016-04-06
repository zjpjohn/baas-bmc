package com.ai.baas.bmc.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.CpFullPresent;

public interface ICpFullPresentBusi {

	Integer addFullPresent(CpFullPresent present);
	CpFullPresent getFullPresent(String detailCode);
	//通过detailcode 获取满赠数据列表
	List<CpFullPresent> getFullPresents(String detailCode);
}
