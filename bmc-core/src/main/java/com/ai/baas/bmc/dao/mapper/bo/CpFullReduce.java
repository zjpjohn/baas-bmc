package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;

public class CpFullReduce {
    private Long reduceId;

    private String detailCode;

    private Double reachAmount;

    private Double reduceAmount;

    private Timestamp activeTime;

    private Timestamp inactiveTime;

    private String reduceCode;

    private String productIds;

    private String unit;

    private String accountType;

    private String relatedAccount;

    public Long getReduceId() {
        return reduceId;
    }

    public void setReduceId(Long reduceId) {
        this.reduceId = reduceId;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode == null ? null : detailCode.trim();
    }

    public Double getReachAmount() {
        return reachAmount;
    }

    public void setReachAmount(Double reachAmount) {
        this.reachAmount = reachAmount;
    }

    public Double getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(Double reduceAmount) {
        this.reduceAmount = reduceAmount;
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

    public String getReduceCode() {
        return reduceCode;
    }

    public void setReduceCode(String reduceCode) {
        this.reduceCode = reduceCode == null ? null : reduceCode.trim();
    }

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds == null ? null : productIds.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    public String getRelatedAccount() {
        return relatedAccount;
    }

    public void setRelatedAccount(String relatedAccount) {
        this.relatedAccount = relatedAccount == null ? null : relatedAccount.trim();
    }
}