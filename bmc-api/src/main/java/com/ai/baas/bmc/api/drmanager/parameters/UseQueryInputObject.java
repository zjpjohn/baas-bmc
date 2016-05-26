package com.ai.baas.bmc.api.drmanager.parameters;

import com.ai.opt.base.vo.BaseInfo;

public class UseQueryInputObject extends BaseInfo {
	public static String strInParent = "CurrMonthUsgQuery";
	//private String tenantId;
	private String systemId;
	private String msgSeq;
	private String custId;
	private String subsId;
	private String serviceNum;
	private String beginMonth;

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
	public String getBeginMonth() {
		return beginMonth;
	}
	public void setBeginMonth(String beginMonth) {
		this.beginMonth = beginMonth;
	}
	@Override
	public String toString() {
		return "UseQueryInputObject [systemId=" + systemId + ", msgSeq=" + msgSeq
				+ ", custId=" + custId + ", subsId=" + subsId + ", serviceNum=" + serviceNum + ", beginMonth="
				+ beginMonth + "]";
	}		

}
