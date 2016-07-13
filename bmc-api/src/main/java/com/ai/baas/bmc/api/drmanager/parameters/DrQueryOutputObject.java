package com.ai.baas.bmc.api.drmanager.parameters;

import java.util.List;

//import com.ai.runner.center.bmc.api.manager.interfaces.IDrQuery.DrQueryOutputObject;

public class DrQueryOutputObject implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5290640123040550601L;
	public static String strOutParent = "responseMessage";
	private String returnCode;		
	private String tenantId;
	private String systemId;
	private String msgSeq;
	private String custId;
	private String subsId;
	private String serviceNum;
	private String serviceType;
	private List<DrQueryOutputObjectList> drList;
	private String pageNum;
	private String totalcount;
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
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
	public List<DrQueryOutputObjectList> getDrList() {
		return drList;
	}
	public void setDrList(List<DrQueryOutputObjectList> drList) {
		this.drList = drList;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}
	@Override
	public String toString() {
		return "DrQueryOutputObject [returnCode=" + returnCode + ", tenantId=" + tenantId + ", systemId=" + systemId
				+ ", msgSeq=" + msgSeq + ", custId=" + custId + ", subsId=" + subsId + ", serviceNum=" + serviceNum
				+ ", serviceType=" + serviceType + ", drlist=" + drList + ", pageNum=" + pageNum + ", totalcount="
				+ totalcount + "]";
	}
	
}
