package com.ai.baas.bmc.dao.mapper.bo;

public class BmcDrqueryFieldrule {
    private String tableid;

    private String fieldDesc;

    private String fieldName;

    private Integer fieldType;

    private Integer fieldLength;

    private String parentNode;

    private String srcContent;

    private Integer defaultOutput;

    private String srcWhere;

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid == null ? null : tableid.trim();
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc == null ? null : fieldDesc.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode == null ? null : parentNode.trim();
    }

    public String getSrcContent() {
        return srcContent;
    }

    public void setSrcContent(String srcContent) {
        this.srcContent = srcContent == null ? null : srcContent.trim();
    }

    public Integer getDefaultOutput() {
        return defaultOutput;
    }

    public void setDefaultOutput(Integer defaultOutput) {
        this.defaultOutput = defaultOutput;
    }

    public String getSrcWhere() {
        return srcWhere;
    }

    public void setSrcWhere(String srcWhere) {
        this.srcWhere = srcWhere == null ? null : srcWhere.trim();
    }
}