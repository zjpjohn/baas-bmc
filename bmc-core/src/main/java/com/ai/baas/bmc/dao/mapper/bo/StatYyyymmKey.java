package com.ai.baas.bmc.dao.mapper.bo;

public class StatYyyymmKey {
    private String custId;

    private String subsId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId == null ? null : subsId.trim();
    }
}