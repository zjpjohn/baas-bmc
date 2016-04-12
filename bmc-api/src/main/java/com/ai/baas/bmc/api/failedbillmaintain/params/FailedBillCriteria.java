package com.ai.baas.bmc.api.failedbillmaintain.params;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.HBasePager;

/**
 * Created by xin on 16-4-11.
 */
public class FailedBillCriteria extends BaseInfo {
    private HBasePager<FailedBill> pager;

    private String tenantId;

    private String serviceType;

    private String errorCode;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public HBasePager<FailedBill> getPager() {
        return pager;
    }

    public void setPager(HBasePager<FailedBill> pager) {
        this.pager = pager;
    }
}
