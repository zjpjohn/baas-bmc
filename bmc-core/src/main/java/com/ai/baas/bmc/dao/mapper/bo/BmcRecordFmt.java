package com.ai.baas.bmc.dao.mapper.bo;

public class BmcRecordFmt {
    private Integer id;

    private String tenantId;

    private String serviceId;

    private String source;

    private Short formatType;

    private Integer fieldSerial;

    private String fieldName;

    private String fieldCode;

    private String dataType;

    private String comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Short getFormatType() {
        return formatType;
    }

    public void setFormatType(Short formatType) {
        this.formatType = formatType;
    }

    public Integer getFieldSerial() {
        return fieldSerial;
    }

    public void setFieldSerial(Integer fieldSerial) {
        this.fieldSerial = fieldSerial;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode == null ? null : fieldCode.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}