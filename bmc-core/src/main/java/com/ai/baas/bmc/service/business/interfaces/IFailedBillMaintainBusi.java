package com.ai.baas.bmc.service.business.interfaces;

import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBill;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillCriteria;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillParam;

import java.io.IOException;
import java.util.List;

/**
 * Created by xin on 16-4-11.
 */
public interface IFailedBillMaintainBusi {

    List<FailedBill> queryFailedBills(FailedBillCriteria criteria) throws IOException;

    FailedBill queryFailedBillById(String failedBillRowKey) throws IOException;

    void doResendFailedBill(FailedBillParam failedBillRowKey) throws IOException;

    void batchResendFailedBill(List<FailedBillParam> param) throws IOException;
}
