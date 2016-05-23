package com.ai.baas.bmc.api.custInfo.params;

import java.io.Serializable;
/**
 * 详单查询细节
 *
 * Date: 2016年5月11日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class CustInfo implements  Serializable{

	
	private static final long serialVersionUID = 1L;
	/**
	 * 客户名称
	 */
	private String custName;
	
	/**
	 * 客户等级
	 */
	private String custGrade;
	/**
	 * 资源号码
	 */
	private String serviceId;
	
	/**
	 * 客户标识
	 */
	private String custId;
	/**
	 * 订购标识
	 */
	private String subsId;
	
	
	/**
	 * 交易流水号
	 */
	private String tradeSeq;
	
	/**
	 * 租户Id
	 */
	private String tenantId;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustGrade() {
		return custGrade;
	}
	public void setCustGrade(String custGrade) {
		this.custGrade = custGrade;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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
	
}
