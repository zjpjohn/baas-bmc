package com.ai.baas.bmc.api.failedbillmaintain.params;

import com.ai.opt.base.vo.BaseResponse;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by xin on 16-4-11.
 */
public class FailedBill extends BaseResponse implements Serializable {
    private String bsn;
    /**
     * 错单编码
     */
    private String failCode;
    private String tenantId;
    private long failDate;
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
    private long arrivalTime;
    /**
     * 错单记录
     */
    private Map<String, String> fail_packet;

    public String getBsn() {
        return bsn;
    }

    public String getFailCode() {
        return failCode;
    }

    public long getFailDate() {
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

    public long getArrivalTime() {
        return arrivalTime;
    }

    public Map<String, String> getFail_packet() {
        return fail_packet;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    public void setFailDate(long failDate) {
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

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setFail_packet(Map<String, String> fail_packet) {
        this.fail_packet = fail_packet;
    }
}
