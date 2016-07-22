package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;

public class StatYyyymm extends StatYyyymmKey {
    private String serviceNum;

    private String serviceType;

    private Double gprsUp;

    private Double gprsDown;

    private Double duration;

    private Timestamp updateTime;

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum == null ? null : serviceNum.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public Double getGprsUp() {
        return gprsUp;
    }

    public void setGprsUp(Double gprsUp) {
        this.gprsUp = gprsUp;
    }

    public Double getGprsDown() {
        return gprsDown;
    }

    public void setGprsDown(Double gprsDown) {
        this.gprsDown = gprsDown;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}