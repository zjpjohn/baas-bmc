package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.baas.bmc.dao.mapper.bo.PubServiceRoute;

public interface IPubServiceRouteAtomSV {
	List<PubServiceRoute> getProcessClass(String tenantId,String serviceType);
}
