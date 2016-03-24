package com.ai.baas.bmc.dao.mapper.bo;

public class BlAcctinfoExt {
    private Integer extId;

    private String acctId;

    private String extName;

    private String extValue;

    public Integer getExtId() {
        return extId;
    }

    public void setExtId(Integer extId) {
        this.extId = extId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId == null ? null : acctId.trim();
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
}