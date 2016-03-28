package com.ai.baas.bmc.api.priceinfo.params;

import java.util.List;

public class PriceCode {

    private String returnCode;
    private String tradeSeq;
    private String tenantId;
    private String standardId;
    private String priceName;
    private String serviceType;
    private List<UsageList> usageList;
    private String cycleType;
    private String cycleAmount;
    private String cycleId;
    private String priceType;
    private String price;
    private String comments;
    private String status;
    
    public String getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    public String getTradeSeq() {
        return tradeSeq;
    }
    public void setTradeSeq(String tradeSeq) {
        this.tradeSeq = tradeSeq;
    }
    public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    public String getStandardId() {
        return standardId;
    }
    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }
    public String getPriceName() {
        return priceName;
    }
    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }
    public String getServiceType() {
        return serviceType;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public List<UsageList> getUsageList() {
        return usageList;
    }
    public void setUsageList(List<UsageList> usageList) {
        this.usageList = usageList;
    }
    public String getCycleType() {
        return cycleType;
    }
    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }
    public String getCycleAmount() {
        return cycleAmount;
    }
    public void setCycleAmount(String cycleAmount) {
        this.cycleAmount = cycleAmount;
    }
    public String getCycleId() {
        return cycleId;
    }
    public void setCycleId(String cycleId) {
        this.cycleId = cycleId;
    }
    public String getPriceType() {
        return priceType;
    }
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


}
