package com.ai.baas.bmc.dao.mapper.bo;

public class CpFactorInfo {
    private Integer factorInfoId;

    private String systemId;

    private String tenantId;

    private String factorCode;

    private String factorName;

    private String factorValue;

    public Integer getFactorInfoId() {
        return factorInfoId;
    }

    public void setFactorInfoId(Integer factorInfoId) {
        this.factorInfoId = factorInfoId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode == null ? null : factorCode.trim();
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName == null ? null : factorName.trim();
    }

    public String getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(String factorValue) {
        this.factorValue = factorValue == null ? null : factorValue.trim();
    }
}