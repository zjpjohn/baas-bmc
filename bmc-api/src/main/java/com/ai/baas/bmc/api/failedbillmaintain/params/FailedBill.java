package com.ai.baas.bmc.api.failedbillmaintain.params;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by xin on 16-4-11.
 */
public class FailedBill implements Serializable {
    private String bsn;
    /**
     * 错单编码
     */
    private String failCode;
    private String tenantId;
    private String failDate;
    private String failReason;
    /**
     * 错单处理断点
     */
    private String failStep;
    /**
     * 业务类型
     */
    private String serviceId;
    private String sn;
    private String source;
    private String accountPeriod;
    private String arrivalTime;
    /**
     * 错单记录
     */
    private Map<String, String> failPacket;


    private String rowKey;
    
    private String rowKeyRaw;
    
    

    public String getRowKeyRaw() {
		return rowKeyRaw;
	}

	public void setRowKeyRaw(String rowKeyRaw) {
		this.rowKeyRaw = rowKeyRaw;
	}

	public String getBsn() {
        return bsn;
    }

    public String getFailCode() {
        return failCode;
    }

    public String getFailDate() {
        return failDate;
    }

    public String getFailReason() {
        return failReason;
    }

    public String getFailStep() {
        return failStep;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getSn() {
        return sn;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getSource() {
        return source;
    }

    public String getAccountPeriod() {
        return accountPeriod;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public Map<String, String> getFailPacket() {
        return failPacket;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    public void setFailDate(String failDate) {
        this.failDate = failDate;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public void setFailStep(String failStep) {
        this.failStep = failStep;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setAccountPeriod(String accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setFailPacket(Map<String, String> failPacket) {
        this.failPacket = failPacket;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }
}
