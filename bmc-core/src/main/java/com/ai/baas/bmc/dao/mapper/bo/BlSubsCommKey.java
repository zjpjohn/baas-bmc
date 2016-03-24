package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;

public class BlSubsCommKey {
    private String subsId;

    private String subsProductId;

    private Timestamp activeTime;

    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId == null ? null : subsId.trim();
    }

    public String getSubsProductId() {
        return subsProductId;
    }

    public void setSubsProductId(String subsProductId) {
        this.subsProductId = subsProductId == null ? null : subsProductId.trim();
    }

    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }
}