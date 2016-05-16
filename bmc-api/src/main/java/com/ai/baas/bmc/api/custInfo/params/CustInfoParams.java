package com.ai.baas.bmc.api.custInfo.params;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.ai.baas.bmc.api.custInfo.interfaces.ICustInfoSV;
import com.ai.opt.base.vo.BaseInfo;


/**
 * 客户基本信息.<br>
 * Date: 2016年3月15日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author biancx
 */
public class CustInfoParams extends BaseInfo {
    private static final long serialVersionUID = 4079811955726211786L;

    /**
     * 交易流水，最大长度32字节
     */
    @NotNull(message="交易流水不能为空",groups={ICustInfoSV.CustNotify.class})
    private String tradeSeq;

    /**
     * 外部客户ID，必填，最大长度32字节，外部值
     */
    @NotNull(message="外部客户ID不能为空",groups={ICustInfoSV.CustNotify.class})
    private String extCustId;

    /**
     * 客户姓名,最大长度128字节                            
     */
    @NotNull(message="客户姓名不能为空",groups={ICustInfoSV.CustNotify.class})
    private String custName;

    /**
     * 客户类型，非必填，最大长度1字节
     */
    private String custType;

    /**
     * 客户等级，非必填，最大长度1字节  取值范围：A,B,C,D,E
     */
    private String custGrade;

    /**
     * 归属省，必填，最大长度6字节 ，参考省份定义表
     */
    @NotNull(message=" 归属省不能为空",groups={ICustInfoSV.CustNotify.class})
    private String provinceCode;

    /**
     * 归属地市，必填，最大长度6字节 
     */
    @NotNull(message="归属地市不能为空",groups={ICustInfoSV.CustNotify.class})
    private String cityCode;
    
    /**
     * 状态，非必填，最大长度4字节 
     */
    private String state;

    /**
     * 状态变更时间，非必填，最大长度14字节  YYYYMMDDHH24MISS
     */
    private String stateChgTime;
    
	/**
     * 备注
     */
    private String remark;

    /**
     * 联系电话，非必填，最大长度32字节 
     */
    private String contactNo;
    
    /**
     * 邮箱，非必填，最大长度32字节 
     */
    private String email;
    
    /**
     * 邮箱，非必填，最大长度32字节 
     */
    private String custAddress;
    /**
     * 客户编码标识，非必填
     */
    private String idNumber;
    

	/**
     * 扩展信息列表  当这个字段有值，需要调用扩展因素接口传递扩展因素
     */
    private List<ExtInfo> extInfoList;

    public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

    public String getTradeSeq() {
		return tradeSeq;
	}


	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}

	public String getExtCustId() {
		return extCustId;
	}


	public void setExtCustId(String extCustId) {
		this.extCustId = extCustId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getCustType() {
		return custType;
	}


	public void setCustType(String custType) {
		this.custType = custType;
	}


	public String getCustGrade() {
		return custGrade;
	}


	public void setCustGrade(String custGrade) {
		this.custGrade = custGrade;
	}


	public String getProvinceCode() {
		return provinceCode;
	}


	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}


	public String getCityCode() {
		return cityCode;
	}


	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getStateChgTime() {
		return stateChgTime;
	}


	public void setStateChgTime(String stateChgTime) {
		this.stateChgTime = stateChgTime;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCustAddress() {
		return custAddress;
	}


	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}


	public List<ExtInfo> getExtInfoList() {
		return extInfoList;
	}


	public void setExtInfoList(List<ExtInfo> extInfoList) {
		this.extInfoList = extInfoList;
	}


	@Override
    public String toString() {
        return "CustInfoParams [tradeSeq=" + tradeSeq + ", extCustId="
                + extCustId +",custName="+custName+",custType="+custType+ ", custGrade=" + custGrade + ", provinceCode=" + provinceCode
                + ", cityCode=" + cityCode + ", state=" + state + ", stateChgTime=" + stateChgTime+", remark=" + remark 
                + ", contactNo=" + contactNo + ", email=" + email + ", custAddress=" + custAddress
                + ",extInfoList"+extInfoList+ "] TenantId = [" + super.getTenantId() + "]";
    }

    
}
