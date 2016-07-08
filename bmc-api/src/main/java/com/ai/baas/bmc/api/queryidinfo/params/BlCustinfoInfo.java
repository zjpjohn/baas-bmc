package com.ai.baas.bmc.api.queryidinfo.params;

import java.io.Serializable;
import java.sql.Timestamp;

public class BlCustinfoInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String custId;

    private String tenantId;

    private String custName;

    private String extCustId;

    private String custType;

    private String custGrade;

    private String provinceCode;

    private String cityCode;

    private String state;

    private Timestamp stateChgTime;

    private String remark;

    private String contactNo;

    private String email;

    private String custAddress;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getExtCustId() {
        return extCustId;
    }

    public void setExtCustId(String extCustId) {
        this.extCustId = extCustId == null ? null : extCustId.trim();
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
    }

    public String getCustGrade() {
        return custGrade;
    }

    public void setCustGrade(String custGrade) {
        this.custGrade = custGrade == null ? null : custGrade.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Timestamp getStateChgTime() {
        return stateChgTime;
    }

    public void setStateChgTime(Timestamp stateChgTime) {
        this.stateChgTime = stateChgTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo == null ? null : contactNo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress == null ? null : custAddress.trim();
    }
}