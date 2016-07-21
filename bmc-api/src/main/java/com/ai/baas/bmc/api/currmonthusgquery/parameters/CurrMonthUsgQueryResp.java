package com.ai.baas.bmc.api.currmonthusgquery.parameters;

import java.io.Serializable;
import java.util.List;

/**
 * Date: 2016年4月27日 <br>
 * 
 * @author zhoushanbin Copyright (c) 2016 asiainfo.com <br>
 */
public class CurrMonthUsgQueryResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 355289340897721269L;
	/**
	 * 成功
	 */
	public static final String SUCCESS = "BMC-000000";
	/**
	 * 失败
	 */
	public static final String ERROR = "error";
	/**
	 * 返回码 BMC-000000成功；其他失败
	 */
	private String returnCode;

	private String tenantId;

	private String systemId;

	private String msgSeq;
	
	private List<MonthVO> monthList;

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

	public List<MonthVO> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<MonthVO> monthList) {
		this.monthList = monthList;
	}
	
	
}
