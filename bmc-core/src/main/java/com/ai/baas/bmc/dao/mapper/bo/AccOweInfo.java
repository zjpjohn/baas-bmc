package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;

/**
 * 欠费信息表类
 * Date: 2015年12月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author ygz
 */
public class AccOweInfo {
    private String systemId;

    private String tenantId;

    private String acctId;

    private Integer balance;

    private String month;

    private Timestamp createTime;

    /**
     * getSystemId()
     * @return
     * @author ygz
     * @ApiDocMethod
     */
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

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AccOweInfo [systemId=" + systemId + ", tenantId=" + tenantId + ", acctId=" + acctId
                + ", balance=" + balance + ", month=" + month + ", createTime=" + createTime + "]";
    }
    
    
}