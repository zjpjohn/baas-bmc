package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;

public class CpUnitpriceItem {
    private Integer unitItemId;

    private String feeItemCode;

    private Integer feeType;

    private Double priceValue;

    private Double unitTypeValue;

    private String unitType;

    private String subjectCode;

    private Timestamp activeTime;

    private Timestamp inactiveTime;

    private String activeStatus;

    private String itemExtCode;

    private String comments;

    public Integer getUnitItemId() {
        return unitItemId;
    }

    public void setUnitItemId(Integer unitItemId) {
        this.unitItemId = unitItemId;
    }

    public String getFeeItemCode() {
        return feeItemCode;
    }

    public void setFeeItemCode(String feeItemCode) {
        this.feeItemCode = feeItemCode == null ? null : feeItemCode.trim();
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public Double getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(Double priceValue) {
        this.priceValue = priceValue;
    }

    public Double getUnitTypeValue() {
        return unitTypeValue;
    }

    public void setUnitTypeValue(Double unitTypeValue) {
        this.unitTypeValue = unitTypeValue;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode == null ? null : subjectCode.trim();
    }

    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }

    public Timestamp getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus == null ? null : activeStatus.trim();
    }

    public String getItemExtCode() {
        return itemExtCode;
    }

    public void setItemExtCode(String itemExtCode) {
        this.itemExtCode = itemExtCode == null ? null : itemExtCode.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}