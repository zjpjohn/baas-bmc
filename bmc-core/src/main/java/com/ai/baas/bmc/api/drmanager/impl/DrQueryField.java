package com.ai.baas.bmc.api.drmanager.impl;

public class DrQueryField {
	private String tenantId;
	private String systemId;
	private String msgSeq;
	private String custId;
	private String subsId;
	private String serviceNum;
	private String serviceType;
	private String pageNum;
	private String pagecountNum;
	private String beginDate;
	private String endDate;
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getMsgSeq() {
		return msgSeq;
	}
	public void setMsgSeq(String msgSeq) {
		this.msgSeq = msgSeq;
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
	public String getServiceNum() {
		return serviceNum;
	}
	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPagecountNum() {
		return pagecountNum;
	}
	public void setPagecountNum(String pagecountNum) {
		this.pagecountNum = pagecountNum;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "DrQueryField [tenantId=" + tenantId + ", systemId=" + systemId + ", msgSeq=" + msgSeq + ", custId="
				+ custId + ", subsId=" + subsId + ", serviceNum=" + serviceNum + ", serviceType=" + serviceType
				+ ", pageNum=" + pageNum + ", pagecountNum=" + pagecountNum + ", beginDate=" + beginDate + ", endDate="
				+ endDate + "]";
	}
	
}
