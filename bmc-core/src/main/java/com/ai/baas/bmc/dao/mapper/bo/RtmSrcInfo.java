package com.ai.baas.bmc.dao.mapper.bo;

public class RtmSrcInfo {
    private String tenantId;

    private String infoType;

    private String infoSplitFlag;

    private String recordSplitFlag;

    private String fieldSplitFlag;

    private String comments;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType == null ? null : infoType.trim();
    }

    public String getInfoSplitFlag() {
        return infoSplitFlag;
    }

    public void setInfoSplitFlag(String infoSplitFlag) {
        this.infoSplitFlag = infoSplitFlag == null ? null : infoSplitFlag.trim();
    }

    public String getRecordSplitFlag() {
        return recordSplitFlag;
    }

    public void setRecordSplitFlag(String recordSplitFlag) {
        this.recordSplitFlag = recordSplitFlag == null ? null : recordSplitFlag.trim();
    }

    public String getFieldSplitFlag() {
        return fieldSplitFlag;
    }

    public void setFieldSplitFlag(String fieldSplitFlag) {
        this.fieldSplitFlag = fieldSplitFlag == null ? null : fieldSplitFlag.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}