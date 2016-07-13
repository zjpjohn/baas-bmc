package com.ai.baas.bmc.dao.mapper.bo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AccInvoiceYYYYMM {
    private String invoiceSeq;

    private String systemId;

    private String tenantId;

    private String custId;

    private String acctId;

    private String subsId;

    private String busiOperCode;

    private String svcType;

    private String serviceNum;

    private BigDecimal total;

    private BigDecimal adjust;

    private BigDecimal disc;

    private BigDecimal balance;

    private String status;

    private Timestamp lastStatusDate;

    private String payStatus;

    private Timestamp lastPayDate;

    private String productId;

    private String provinceCode;

    private String areaCode;

    public String getInvoiceSeq() {
        return invoiceSeq;
    }

    public void setInvoiceSeq(String invoiceSeq) {
        this.invoiceSeq = invoiceSeq == null ? null : invoiceSeq.trim();
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId == null ? null : subsId.trim();
    }

    public String getBusiOperCode() {
        return busiOperCode;
    }

    public void setBusiOperCode(String busiOperCode) {
        this.busiOperCode = busiOperCode == null ? null : busiOperCode.trim();
    }

    public String getSvcType() {
        return svcType;
    }

    public void setSvcType(String svcType) {
        this.svcType = svcType == null ? null : svcType.trim();
    }

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum == null ? null : serviceNum.trim();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getAdjust() {
        return adjust;
    }

    public void setAdjust(BigDecimal adjust) {
        this.adjust = adjust;
    }

    public BigDecimal getDisc() {
        return disc;
    }

    public void setDisc(BigDecimal disc) {
        this.disc = disc;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Timestamp getLastStatusDate() {
        return lastStatusDate;
    }

    public void setLastStatusDate(Timestamp lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public Timestamp getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(Timestamp lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }
}