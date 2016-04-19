package com.ai.baas.bmc.dao.mapper.bo;

public class CpStepInfo {
    private Long setpId;

    private Long detailCode;

    private Long stepSeq;

    private Double sectionA;

    private Double sectionB;

    private String factorCode;

    private Double priceValue;

    private String unitType;

    private Double totalPriceValue;

    private Long extCode;

    private String subjectCode;

    private String serviceType;

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

    public String getFactorCode() {
        return factorCode;
    }

    public void setFactorCode(String factorCode) {
        this.factorCode = factorCode == null ? null : factorCode.trim();
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
}