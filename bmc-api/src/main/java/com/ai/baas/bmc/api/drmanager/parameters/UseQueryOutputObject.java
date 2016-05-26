package com.ai.baas.bmc.api.drmanager.parameters;

import java.util.List;

public class UseQueryOutputObject implements java.io.Serializable {
	private String returnCode;		
	private String tenantId;
	private String systemId;
	private String msgSeq;
	private List<UseQueryOutputObjectList> MonthList;
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
	public List<UseQueryOutputObjectList> getMonthList() {
		return MonthList;
	}
	public void setMonthList(List<UseQueryOutputObjectList> monthList) {
		MonthList = monthList;
	}

	@Override
	public String toString() {
		return "UseQueryOutputObject [returnCode=" + returnCode + ", tenantId=" + tenantId + ", systemId=" + systemId
				+ ", msgSeq=" + msgSeq + ", MonthList=" + MonthList + "]";
	}
}
