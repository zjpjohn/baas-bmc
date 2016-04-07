package com.ai.baas.bmc.dao.mapper.bo;

public class CpStepInfo {
    private Long setpId;

    private Long detailCode;

    private Long stepSeq;

    private Double sectionA;

    private Double sectionB;

    private Long factorCode;

    private Double priceValue;

    private String unitType;

    private Double totalPriceValue;

    private Long extCode;

    public Long getSetpId() {
        return setpId;
    }

    public void setSetpId(Long setpId) {
        this.setpId = setpId;
    }

    public Long getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(Long detailCode) {
        this.detailCode = detailCode;
    }

    public Long getStepSeq() {
        return stepSeq;
    }

    public void setStepSeq(Long stepSeq) {
        this.stepSeq = stepSeq;
    }

    public Double getSectionA() {
        return sectionA;
    }

    public void setSectionA(Double sectionA) {
        this.sectionA = sectionA;
    }

    public Double getSectionB() {
        return sectionB;
    }

    public void setSectionB(Double sectionB) {
        this.sectionB = sectionB;
    }

    public Long getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(Long factorCode) {
        this.factorCode = factorCode;
    }

    public Double getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(Double priceValue) {
        this.priceValue = priceValue;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public Double getTotalPriceValue() {
        return totalPriceValue;
    }

    public void setTotalPriceValue(Double totalPriceValue) {
        this.totalPriceValue = totalPriceValue;
    }

    public Long getExtCode() {
        return extCode;
    }

    public void setExtCode(Long extCode) {
        this.extCode = extCode;
    }
}