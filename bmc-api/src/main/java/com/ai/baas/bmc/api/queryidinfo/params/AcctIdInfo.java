package com.ai.baas.bmc.api.queryidinfo.params;

import com.ai.opt.base.vo.BaseInfo;

public class AcctIdInfo extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 账户id 必填
     */
    private String acctId;

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

}
