package com.ai.baas.bmc.dao.mapper.bo;

public class CpUnitpriceInfo {
    private Integer unitPriceId;

    private String unitPriceCode;

    private String priceName;

    private String factorCode;

    private String feeItemCode;

    public Integer getUnitPriceId() {
        return unitPriceId;
    }

    public void setUnitPriceId(Integer unitPriceId) {
        this.unitPriceId = unitPriceId;
    }

    public String getUnitPriceCode() {
        return unitPriceCode;
    }

    public void setUnitPriceCode(String unitPriceCode) {
        this.unitPriceCode = unitPriceCode == null ? null : unitPriceCode.trim();
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName == null ? null : priceName.trim();
    }

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode == null ? null : factorCode.trim();
    }

    public String getFeeItemCode() {
        return feeItemCode;
    }

    public void setFeeItemCode(String feeItemCode) {
        this.feeItemCode = feeItemCode == null ? null : feeItemCode.trim();
    }
}