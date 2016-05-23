package com.ai.baas.bmc.api.businessdatamaintain.params;

import com.ai.baas.bmc.api.businessdatamaintain.interfaces.IBillingBusinessDataMaintainSV;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BmcRecord implements Serializable{
    private Integer id;

    @NotNull(message="tenantId不能为空",groups={IBillingBusinessDataMaintainSV.BusinessDataImport.class})
    private String tenantId;

    @NotNull(message="serviceId不能为空",groups={IBillingBusinessDataMaintainSV.BusinessDataImport.class})
    private String serviceId;

    @NotNull(message="source不能为空",groups={IBillingBusinessDataMaintainSV.BusinessDataImport.class})
    private String source;

    private Short formatType;

    private Integer fieldSerial;

    private String fieldName;

    private String fieldCode;

    private String dataType;

    private String comments;

    private String nullable;

    private String isSn;

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

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable == null ? null : nullable.trim();
    }

    public String getIsSn() {
        return isSn;
    }

    public void setIsSn(String isSn) {
        this.isSn = isSn == null ? null : isSn.trim();
    }
}