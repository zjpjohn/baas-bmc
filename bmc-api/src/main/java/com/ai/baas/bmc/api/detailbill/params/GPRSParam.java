package com.ai.baas.bmc.api.detailbill.params;

import java.io.Serializable;
/**
 * 流量相关
 *
 * Date: 2016年5月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class GPRSParam implements Serializable {

	private static final long serialVersionUID = 1L;
	private String custId;
	private String subsId;
	private String serviceId;
	/**
	 * 计费类型
	 */
	private String calType;
	/**
	 * 起始时间
	 */
	private String startTime;
	/**
	 * 上行流量
	 */
	private String gprsUp;
	/**
	 * 下行流量
	 */
	private String gprsDown;
	/**
	 * 通信地点
	 */
	private String visitArea;
	/**
	 * 费用
	 */
	private String fee1;
	/**
	 * 是否是定向流量
	 */
	private String isSpecial;
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
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	public String getCalType() {
		return calType;
	}
	public void setCalType(String calType) {
		this.calType = calType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getGprsUp() {
		return gprsUp;
	}
	public void setGprsUp(String gprsUp) {
		this.gprsUp = gprsUp;
	}
	public String getGprsDown() {
		return gprsDown;
	}
	public void setGprsDown(String gprsDown) {
		this.gprsDown = gprsDown;
	}
	public String getVisitArea() {
		return visitArea;
	}
	public void setVisitArea(String visitArea) {
		this.visitArea = visitArea;
	}
	public String getFee1() {
		return fee1;
	}
	public void setFee1(String fee1) {
		this.fee1 = fee1;
	}
	public String getIsSpecial() {
		return isSpecial;
	}
	public void setIsSpecial(String isSpecial) {
		this.isSpecial = isSpecial;
	}
	
	
	
	
	
}
