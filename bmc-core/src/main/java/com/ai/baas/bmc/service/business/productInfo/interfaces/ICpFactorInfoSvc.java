package com.ai.baas.bmc.service.business.productInfo.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfo;

public interface ICpFactorInfoSvc {
	public String triggerCpFactorInfo(CpFactorInfo record);
	
	public String InsertCpFactorInfo(CpFactorInfo record);

	public String factorInfoDEL(CpFactorInfo record);
}
