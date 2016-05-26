package com.ai.baas.bmc.dao.mapper.bo;

public class BmcUseQuery {
    private Integer uniqueId;

    private String tenantId;

    private String systemId;

    private String beginMonth;

    private Integer custId;

    private String serviceType;

    private String serviceNum;

    private Integer productId;

    private String visitArea;

    private String resType;

    private Integer amount;

    private Integer productAmount;

    private String msgSeq;

    private Integer subsId;

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    public String getBeginMonth() {
        return beginMonth;
    }

    public void setBeginMonth(String beginMonth) {
        this.beginMonth = beginMonth == null ? null : beginMonth.trim();
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum == null ? null : serviceNum.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getVisitArea() {
        return visitArea;
    }

    public void setVisitArea(String visitArea) {
        this.visitArea = visitArea == null ? null : visitArea.trim();
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public String getMsgSeq() {
        return msgSeq;
    }

    public void setMsgSeq(String msgSeq) {
        this.msgSeq = msgSeq == null ? null : msgSeq.trim();
    }

    public Integer getSubsId() {
        return subsId;
    }

    public void setSubsId(Integer subsId) {
        this.subsId = subsId;
    }
}