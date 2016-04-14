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
    private String tenant_id;
    private String source;
    private String account_period;
    private long arrival_time;
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

    public String getTenant_id() {
        return tenant_id;
    }

    public String getSource() {
        return source;
    }

    public String getAccount_period() {
        return account_period;
    }

    public long getArrival_time() {
        return arrival_time;
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

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setAccount_period(String account_period) {
        this.account_period = account_period;
    }

    public void setArrival_time(long arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setFail_packet(Map<String, String> fail_packet) {
        this.fail_packet = fail_packet;
    }
}
