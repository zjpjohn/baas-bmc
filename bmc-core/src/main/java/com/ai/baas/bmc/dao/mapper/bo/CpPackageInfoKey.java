package com.ai.baas.bmc.dao.mapper.bo;

public class CpPackageInfoKey {
    private Long packageId;

    private String detailCode;

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode == null ? null : detailCode.trim();
    }
}