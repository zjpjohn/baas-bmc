package com.ai.baas.bmc.api.drmanager.parameters;

import java.util.List;

public class OperatorFlowQueryOutputObject implements java.io.Serializable {
	public static String strOutParent = "responseMessage";
	private String returnCode;		
	private String tenantId;
	private String systemId;
	private String msgSeq;
	private List<OperatorFlowQueryOutputObjectList> tenantIdlist;	
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
	public List<OperatorFlowQueryOutputObjectList> getTenantIdlist() {
		return tenantIdlist;
	}
	public void setTenantIdlist(
			List<OperatorFlowQueryOutputObjectList> tenantIdlist) {
		this.tenantIdlist = tenantIdlist;
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
		return "OperatorFlowQueryOutputObject [returnCode=" + returnCode + ", tenantId=" + tenantId + ", systemId="
				+ systemId + ", msgSeq=" + msgSeq + ", tenantIdlist=" + tenantIdlist + ", pageNum=" + pageNum
				+ ", totalcount=" + totalcount + "]";
	}
}
