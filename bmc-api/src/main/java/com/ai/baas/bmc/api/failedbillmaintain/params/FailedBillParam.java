package com.ai.baas.bmc.api.failedbillmaintain.params;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;

import java.util.Map;

/**
 * Created by xin on 16-4-12.
 */
public class FailedBillParam extends BaseInfo {
    private String serviceId;
    private String source;
    private String bsn;

    private String sn;
    private String failStep;
    private String failDate;
    private String accountPeriod;
    private String arrivalTime;

    private Map<String, String> failPacket;

    public void validate() {
        if (isBlank(getTenantId())) {
            throw new BusinessException("400", "tenant_id不能为空");
        }
        if (isBlank(serviceId)) {
            throw new BusinessException("400", "service_id不能为空");
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
        if (isBlank(failStep)) {
            throw new BusinessException("400", "fail_step不能为空");
        }
        if (isBlank(failDate)) {
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
        StringBuilder stringBuilder = new StringBuilder(getTenantId() + "\1");
        stringBuilder.append(serviceId + "\1");
        stringBuilder.append(source + "\1");
        stringBuilder.append(bsn + "\1");
        stringBuilder.append(sn + "\1");
        stringBuilder.append(failStep + "\1");
        stringBuilder.append(failDate);
        return stringBuilder.toString();
    }

    public String getService_id() {
        return serviceId;
    }

    public void setService_id(String service_id) {
        this.serviceId = service_id;
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

    public String getFailStep() {
        return failStep;
    }

    public void setFailStep(String failStep) {
        this.failStep = failStep;
    }

    public String getFailDate() {
        return failDate;
    }

    public void setFailDate(String failDate) {
        this.failDate = failDate;
    }

    public Map<String, String> getFailPacket() {
        if (failPacket == null){
            throw new BusinessException("400", "failPacket 不能为空");
        }
        return failPacket;
    }

    public void setFailPacket(Map<String, String> failPacket) {
        this.failPacket = failPacket;
    }

    public String getAccountPeriod() {
        if (isBlank(accountPeriod)){
            throw new BusinessException("400", "accountPeriod 不能为空");
        }
        return accountPeriod;
    }

    public void setAccountPeriod(String accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    public String getArrivalTime() {
        if (isBlank(arrivalTime)){
            throw new BusinessException("400", "arrivalTime 不能为空");
        }
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
