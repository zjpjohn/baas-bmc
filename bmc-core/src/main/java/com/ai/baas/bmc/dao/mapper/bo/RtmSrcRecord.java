package com.ai.baas.bmc.dao.mapper.bo;

public class RtmSrcRecord {
    private String infoId;

    private String fieldId;

    private String fieldName;

    private String startLocal;

    private String fieldLength;

    private String fieldType;

    private String isSn;

    private String remark;

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId == null ? null : fieldId.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getStartLocal() {
        return startLocal;
    }

    public void setStartLocal(String startLocal) {
        this.startLocal = startLocal == null ? null : startLocal.trim();
    }

    public String getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(String fieldLength) {
        this.fieldLength = fieldLength == null ? null : fieldLength.trim();
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    public String getIsSn() {
        return isSn;
    }

    public void setIsSn(String isSn) {
        this.isSn = isSn == null ? null : isSn.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}