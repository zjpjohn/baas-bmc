package com.ai.baas.bmc.api.queryidinfo.params;

import com.ai.opt.base.vo.BaseInfo;

public class OwnerIDInfo extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 属主ID,CUST_ID或者SUBS_ID
     */
    private String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

}
