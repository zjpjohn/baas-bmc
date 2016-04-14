package com.ai.baas.bmc.api.failedbillmaintain.params;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by xin on 16-4-11.
 */
public class FailedBill implements Serializable {
    private String bsn;
    private String fail_code;
    private long fail_date;
    private String fail_reason;
    private String fail_step;
    private String service_id;
    private String sn;
    private String tenant_id;
    private String source;
    private String account_period;
    private long arrival_time;
    private Map<String, String> fail_packet;

    public String getBsn() {
        return bsn;
    }

    public String getFail_code() {
        return fail_code;
    }

    public long getFail_date() {
        return fail_date;
    }

    public String getFail_reason() {
        return fail_reason;
    }

    public String getFail_step() {
        return fail_step;
    }

    public String getService_id() {
        return service_id;
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

    public void setFail_code(String fail_code) {
        this.fail_code = fail_code;
    }

    public void setFail_date(long fail_date) {
        this.fail_date = fail_date;
    }

    public void setFail_reason(String fail_reason) {
        this.fail_reason = fail_reason;
    }

    public void setFail_step(String fail_step) {
        this.fail_step = fail_step;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
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
