package com.ai.baas.bmc.service.business.productInfo.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.CpExtInfo;

public interface ICpExtInfoSvc {
	public String triggerCpExtInfo(CpExtInfo record);
	
	public List<CpExtInfo> getSameParamList(CpExtInfo record);
}
