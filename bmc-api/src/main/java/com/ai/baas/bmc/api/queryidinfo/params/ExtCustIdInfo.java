package com.ai.baas.bmc.api.queryidinfo.params;

import com.ai.opt.base.vo.BaseInfo;

public class ExtCustIdInfo extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 租户系统中设定的标识(外部客户id) 必填
     */
    private String extCustId;

    public String getExtCustId() {
        return extCustId;
    }

    public void setExtCustId(String extCustId) {
        this.extCustId = extCustId;
    }

}
