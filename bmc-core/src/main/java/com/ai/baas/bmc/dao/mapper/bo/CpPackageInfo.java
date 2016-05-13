package com.ai.baas.bmc.dao.mapper.bo;

public class CpPackageInfo extends CpPackageInfoKey {
    private Double amount;

    private Double priceValue;

    private Double totalPriceValue;

    private String unitCode;

    private String unitType;

    private String factorCode;

    private String exceedType;

    private String unitpriceCode;

    private String extCode;

    private String subjectCode;

    private String serviceType;

    private String isTotalPrice;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(Double priceValue) {
        this.priceValue = priceValue;
    }

    public Double getTotalPriceValue() {
        return totalPriceValue;
    }

    public void setTotalPriceValue(Double totalPriceValue) {
        this.totalPriceValue = totalPriceValue;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode == null ? null : factorCode.trim();
    }

    public String getExceedType() {
        return exceedType;
    }

    public void setExceedType(String exceedType) {
        this.exceedType = exceedType == null ? null : exceedType.trim();
    }

    public String getUnitpriceCode() {
        return unitpriceCode;
    }

    public void setUnitpriceCode(String unitpriceCode) {
        this.unitpriceCode = unitpriceCode == null ? null : unitpriceCode.trim();
    }

    public String getExtCode() {
        return extCode;
    }

    public void setExtCode(String extCode) {
        this.extCode = extCode == null ? null : extCode.trim();
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode == null ? null : subjectCode.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getIsTotalPrice() {
        return isTotalPrice;
    }

    public void setIsTotalPrice(String isTotalPrice) {
        this.isTotalPrice = isTotalPrice == null ? null : isTotalPrice.trim();
    }
}