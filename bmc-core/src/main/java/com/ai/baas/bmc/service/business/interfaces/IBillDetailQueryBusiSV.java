package com.ai.baas.bmc.service.business.interfaces;

import com.ai.baas.bmc.api.detailbill.params.DetailBillResponse;
import com.ai.baas.bmc.api.detailbill.params.QueryBillRequest;

public interface IBillDetailQueryBusiSV {
	DetailBillResponse getDetailBill(QueryBillRequest request);
}
