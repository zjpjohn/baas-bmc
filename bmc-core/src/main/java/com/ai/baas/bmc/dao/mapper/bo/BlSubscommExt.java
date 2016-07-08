package com.ai.baas.bmc.dao.mapper.bo;

public class BlSubscommExt {
    private Integer extId;

    private String productId;

    private String subsProductId;

    private String extName;

    private String extValue;

    private String subsId;

    public Integer getExtId() {
        return extId;
    }

    public void setExtId(Integer extId) {
        this.extId = extId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getSubsProductId() {
        return subsProductId;
    }

    public void setSubsProductId(String subsProductId) {
        this.subsProductId = subsProductId == null ? null : subsProductId.trim();
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName == null ? null : extName.trim();
    }

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue == null ? null : extValue.trim();
    }

    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId == null ? null : subsId.trim();
    }
}