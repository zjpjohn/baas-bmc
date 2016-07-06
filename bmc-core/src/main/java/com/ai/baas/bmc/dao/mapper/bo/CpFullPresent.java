package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;

public class CpFullPresent {
    private Long presentId;

    private String detailCode;

    private String presentType;

    private Double presentAmount;

    private Timestamp activeTime;

    private Timestamp inactiveTime;

    private String productIds;

    private String productGiftIds;

    private String presentCode;

    private Double reachAmount;

    private String unit;

    private String accountType;

    private String relatedAccount;

    private String activeFlag;

    private String activeCycle;

    public Long getPresentId() {
        return presentId;
    }

    public void setPresentId(Long presentId) {
        this.presentId = presentId;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode == null ? null : detailCode.trim();
    }

    public String getPresentType() {
        return presentType;
    }

    public void setPresentType(String presentType) {
        this.presentType = presentType == null ? null : presentType.trim();
    }

    public Double getPresentAmount() {
        return presentAmount;
    }

    public void setPresentAmount(Double presentAmount) {
        this.presentAmount = presentAmount;
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

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds == null ? null : productIds.trim();
    }

    public String getProductGiftIds() {
        return productGiftIds;
    }

    public void setProductGiftIds(String productGiftIds) {
        this.productGiftIds = productGiftIds == null ? null : productGiftIds.trim();
    }

    public String getPresentCode() {
        return presentCode;
    }

    public void setPresentCode(String presentCode) {
        this.presentCode = presentCode == null ? null : presentCode.trim();
    }

    public Double getReachAmount() {
        return reachAmount;
    }

    public void setReachAmount(Double reachAmount) {
        this.reachAmount = reachAmount;
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

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag == null ? null : activeFlag.trim();
    }

    public String getActiveCycle() {
        return activeCycle;
    }

    public void setActiveCycle(String activeCycle) {
        this.activeCycle = activeCycle == null ? null : activeCycle.trim();
    }
}