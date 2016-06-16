package com.ai.baas.bmc.service.business.interfaces;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;

public interface IGetRowKey {
	String getRowKey(ReBillingParam param);
}
