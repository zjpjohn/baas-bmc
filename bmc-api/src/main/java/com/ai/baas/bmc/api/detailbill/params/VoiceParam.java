package com.ai.baas.bmc.api.detailbill.params;

import java.io.Serializable;
/**
 * 语音相关数据
 *
 * Date: 2016年5月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class VoiceParam implements Serializable{

	private static final long serialVersionUID = 1L;

	private String accountPeriod;
	
	private String bsn;
	/**
	 * 通话时长
	 */
	private String duration;
	/**
	 * 本地通话费用
	 */
	private String fee1;
	/**
	 * 长途通话费用
	 */
	private String fee2;
	/**
	 * 其他费用
	 */
	private String fee3;
	/**
	 * 产品Id
	 */
	private String productId;
	/**
	 * 服务资源号码
	 */
	private String serviceId;
	/**
	 * 服务类型
	 */
	private String serviceType;
	/**
	 * 开始时间
	 */
	private String startTime;
	
	private String sn;
	/**
	 * 来源
	 */
	private String source;
	/**
	 * 科目1
	 */
	private String subject1;
	/**
	 * 科目2
	 */
	private String subject2;
	/**
	 * 科目3
	 */
	private String subject3;
	/**
	 * 租户Id
	 */
	private String tenantId;
	/**
	 * 呼叫类型
	 */
	private String callType;
	/**
	 * 对方号码
	 */
	private String oppNumber;
	/**
	 * 通话地点
	 */
	private String visitArea;
	/**
	 * 通话类型,比如本地通话，长途，漫游等
	 */
	private String longType;
	
    private String custId;
    
    private String subsId;

	

	public String getBsn() {
		return bsn;
	}

	public void setBsn(String bsn) {
		this.bsn = bsn;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getFee1() {
		return fee1;
	}

	public void setFee1(String fee1) {
		this.fee1 = fee1;
	}

	public String getFee2() {
		return fee2;
	}

	public void setFee2(String fee2) {
		this.fee2 = fee2;
	}

	public String getFee3() {
		return fee3;
	}

	public void setFee3(String fee3) {
		this.fee3 = fee3;
	}

	

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getSubsId() {
		return subsId;
	}

	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}

	public String getAccountPeriod() {
		return accountPeriod;
	}

	public void setAccountPeriod(String accountPeriod) {
		this.accountPeriod = accountPeriod;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getOppNumber() {
		return oppNumber;
	}

	public void setOppNumber(String oppNumber) {
		this.oppNumber = oppNumber;
	}

	public String getVisitArea() {
		return visitArea;
	}

	public void setVisitArea(String visitArea) {
		this.visitArea = visitArea;
	}

	public String getLongType() {
		return longType;
	}

	public void setLongType(String longType) {
		this.longType = longType;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
    
    
	
	
	
	
}
