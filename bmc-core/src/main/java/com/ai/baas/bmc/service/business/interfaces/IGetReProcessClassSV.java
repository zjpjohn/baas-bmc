package com.ai.baas.bmc.service.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.PubServiceRoute;
import com.ai.baas.bmc.service.processor.IDeductProcessor;

public interface IGetReProcessClassSV {
	IDeductProcessor getProcessor(String tenantId,String serviceType);
}
