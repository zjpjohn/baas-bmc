package com.ai.baas.bmc.dao.mapper.bo;

import java.sql.Timestamp;

public class BmcOutputInfo {
    private Long infoCode;

    private String tenantId;

    private String serviceType;

    private String source;

    private String tablePrefix;

    private String tablePostfix;

    private String outputType;

    private String outputName;

    private String keySeq;

    private String seqName;

    private String status;

    private Timestamp createDate;

    public Long getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(Long infoCode) {
        this.infoCode = infoCode;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix == null ? null : tablePrefix.trim();
    }

    public String getTablePostfix() {
        return tablePostfix;
    }

    public void setTablePostfix(String tablePostfix) {
        this.tablePostfix = tablePostfix == null ? null : tablePostfix.trim();
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType == null ? null : outputType.trim();
    }

    public String getOutputName() {
        return outputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName == null ? null : outputName.trim();
    }

    public String getKeySeq() {
        return keySeq;
    }

    public void setKeySeq(String keySeq) {
        this.keySeq = keySeq == null ? null : keySeq.trim();
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName == null ? null : seqName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}