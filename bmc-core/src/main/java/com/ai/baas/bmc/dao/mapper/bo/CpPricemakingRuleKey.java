package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;

public class CpPricemakingRuleKey {
    private String tenantId;

    private String priceProductType;

    private String priceProductId;

    private String priceType;

    private Timestamp activeTime;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getPriceProductType() {
        return priceProductType;
    }

    public void setPriceProductType(String priceProductType) {
        this.priceProductType = priceProductType == null ? null : priceProductType.trim();
    }

    public String getPriceProductId() {
        return priceProductId;
    }

    public void setPriceProductId(String priceProductId) {
        this.priceProductId = priceProductId == null ? null : priceProductId.trim();
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType == null ? null : priceType.trim();
    }

    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }
}