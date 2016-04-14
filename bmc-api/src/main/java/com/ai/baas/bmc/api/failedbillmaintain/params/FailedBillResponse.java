package com.ai.baas.bmc.api.failedbillmaintain.params;

import com.ai.opt.base.vo.BaseResponse;

/**
 * Created by xin on 16-4-14.
 */
public class FailedBillResponse extends BaseResponse {
    private FailedBill failedBill;

    public FailedBill getFailedBill() {
        return failedBill;
    }

    public void setFailedBill(FailedBill failedBill) {
        this.failedBill = failedBill;
    }
}
