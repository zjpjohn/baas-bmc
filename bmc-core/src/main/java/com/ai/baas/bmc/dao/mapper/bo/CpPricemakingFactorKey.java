package com.ai.baas.bmc.dao.mapper.bo;

public class CpPricemakingFactorKey {
    private String tenantId;

    private String priceProductType;

    private String factorName;

    private String priceProductId;

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

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName == null ? null : factorName.trim();
    }

    public String getPriceProductId() {
        return priceProductId;
    }

    public void setPriceProductId(String priceProductId) {
        this.priceProductId = priceProductId == null ? null : priceProductId.trim();
    }
}