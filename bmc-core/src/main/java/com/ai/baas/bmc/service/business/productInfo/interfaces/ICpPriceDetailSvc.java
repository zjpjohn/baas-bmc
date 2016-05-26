package com.ai.baas.bmc.service.business.productInfo.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;

public interface ICpPriceDetailSvc {
	 public String triggerCpPriceDetail(CpPriceDetail record, String systemId, String tenantId);
	 public String insertCpPriceDetail(CpPriceDetail record);
}
