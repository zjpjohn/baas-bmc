package com.ai.baas.bmc.service.business.productInfo.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;

public interface ICpPackageInfoSvc {
        public String insertCpPackageInfo(CpPackageInfo record);
		public String triggerCpPackageInfo(CpPackageInfo record);
}
