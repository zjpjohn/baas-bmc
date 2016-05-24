package com.ai.baas.bmc.api.businessdatamaintain.params;

import com.ai.baas.bmc.api.businessdatamaintain.interfaces.IBillingBusinessDataMaintainSV;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BusinessDataQueryRequest implements Serializable {

    @NotNull(message="tenantId不能为空",groups={IBillingBusinessDataMaintainSV.GetDataFormatList.class})
    private String tenantId;

    @NotNull(message="serviceId不能为空",groups={IBillingBusinessDataMaintainSV.GetDataFormatList.class})
    private String serviceId;

    @NotNull(message="source不能为空",groups={IBillingBusinessDataMaintainSV.GetDataFormatList.class})
    private String source;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}