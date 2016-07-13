package com.ai.baas.bmc.api.drmanager.parameters;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

public class OperatorFlowQueryInputObject extends BaseInfo {
	public static String strInParent = "dealerDataUsgQuery";
	//private String tenantId;
	private String systemId;
	private String msgSeq;
	private String dealerCode;
	private String dealerAreaCode;
	private String pageNum;
	private String pagecountNum;
	public static String getStrInParent() {
		return strInParent;
	}
	public static void setStrInParent(String strInParent) {
		OperatorFlowQueryInputObject.strInParent = strInParent;
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
	public String getDealerCode() {
		return dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}
	public String getDealerAreaCode() {
		return dealerAreaCode;
	}
	public void setDealerAreaCode(String dealerAreaCode) {
		this.dealerAreaCode = dealerAreaCode;
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
	@Override
	public String toString() {
		return "OperatorFlowQueryInputObject [systemId=" + systemId + ", msgSeq=" + msgSeq
				+ ", dealerCode=" + dealerCode + ", dealerAreaCode=" + dealerAreaCode + ", pageNum=" + pageNum
				+ ", pagecountNum=" + pagecountNum + "]";
	}

}
