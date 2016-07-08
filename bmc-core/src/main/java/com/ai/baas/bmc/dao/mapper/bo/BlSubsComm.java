package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;

public class BlSubsComm extends BlSubsCommKey {
    private String productId;

    private String resBonusFlag;

    private Timestamp inactiveTime;

    private String tenantId;

    private String custId;

    private String productType;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getResBonusFlag() {
        return resBonusFlag;
    }

    public void setResBonusFlag(String resBonusFlag) {
        this.resBonusFlag = resBonusFlag == null ? null : resBonusFlag.trim();
    }

    public Timestamp getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }
}