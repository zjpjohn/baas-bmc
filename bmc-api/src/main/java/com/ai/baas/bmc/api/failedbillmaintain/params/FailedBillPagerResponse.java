package com.ai.baas.bmc.api.failedbillmaintain.params;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.HBasePager;

/**
 * Created by xin on 16-4-14.
 */
public class FailedBillPagerResponse extends BaseResponse {

    private HBasePager<FailedBill> billHBasePager;



    public HBasePager<FailedBill> getBillHBasePager() {
        return billHBasePager;
    }

    public void setBillHBasePager(HBasePager<FailedBill> billHBasePager) {
        this.billHBasePager = billHBasePager;
    }
}
