package com.ai.baas.bmc.api.failedbillmaintain.params;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xin on 16-4-12.
 */
public class FailedBillParam extends BaseInfo {
    private String tenantId;
    private String service_id;
    private String source;
    private String bsn;
    private String sn;
    private String fail_step;
    private String fail_date;

    private String account_period;
    private String arrival_time;
    private Map<String, String> fail_packet;

    public void validate() {
        if (isBlank(tenantId)) {
            throw new BusinessException("400", "tenantId不能为空");
        }
        if (isBlank(service_id)) {
            throw new BusinessException("400", "ServiceId不能为空");
        }
        if (isBlank(source)) {
            throw new BusinessException("400", "Source不能为空");
        }
        if (isBlank(bsn)) {
            throw new BusinessException("400", "bsn不能为空");
        }
        if (isBlank(sn)) {
            throw new BusinessException("400", "sn不能为空");
        }
        if (isBlank(fail_step)) {
            throw new BusinessException("400", "fail_step不能为空");
        }
        if (isBlank(fail_date)) {
            throw new BusinessException("400", "fail_date不能为空");
        }
    }

    private boolean isBlank(String value){
        if (value== null || value.length() == 0){
            return true;
        }

        return false;
    }



    public String buildFailedBillRowKey() {
        StringBuilder stringBuilder = new StringBuilder(tenantId + "\1");
        stringBuilder.append(service_id + "\1");
        stringBuilder.append(source + "\1");
        stringBuilder.append(bsn + "\1");
        stringBuilder.append(sn + "\1");
        stringBuilder.append(fail_step + "\1");
        stringBuilder.append(fail_date);
        return stringBuilder.toString();
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBsn() {
        return bsn;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getFail_step() {
        return fail_step;
    }

    public void setFail_step(String fail_step) {
        this.fail_step = fail_step;
    }

    public String getFail_date() {
        return fail_date;
    }

    public void setFail_date(String fail_date) {
        this.fail_date = fail_date;
    }

    public Map<String, String> getFail_packet() {
        if (fail_packet == null){
            throw new BusinessException("400", "fail_packet 不能为空");
        }
        return fail_packet;
    }

    public void setFail_packet(Map<String, String> fail_packet) {
        this.fail_packet = fail_packet;
    }

    public String getAccount_period() {
        if (isBlank(account_period)){
            throw new BusinessException("400", "account_period 不能为空");
        }
        return account_period;
    }

    public void setAccount_period(String account_period) {
        this.account_period = account_period;
    }

    public String getArrival_time() {
        if (isBlank(arrival_time)){
            throw new BusinessException("400", "arrival_time 不能为空");
        }
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }
}
