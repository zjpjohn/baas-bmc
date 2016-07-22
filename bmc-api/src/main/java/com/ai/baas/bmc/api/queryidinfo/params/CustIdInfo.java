package com.ai.baas.bmc.api.queryidinfo.params;

import com.ai.opt.base.vo.BaseInfo;

public class CustIdInfo extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    private String custId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

   
}
