package com.ai.baas.bmc.dao.mapper.bo;

public class BmcOutputDetail {
    private Long detailCode;

    private Long infoCode;

    private String columnName;

    private String paramName;

    private String isKey;

    private Integer displayOrder;

    private String status;

    public Long getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(Long detailCode) {
        this.detailCode = detailCode;
    }

    public Long getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(Long infoCode) {
        this.infoCode = infoCode;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getIsKey() {
        return isKey;
    }

    public void setIsKey(String isKey) {
        this.isKey = isKey == null ? null : isKey.trim();
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}