package com.ai.baas.bmc.api.currmonthusgquery.parameters;

import com.ai.opt.base.vo.BaseInfo;

/**
 * Date: 2016年4月27日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
public class CurrMonthUsgQueryReq extends BaseInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7066247092891105201L;
	
	/**
	 * 系统ID
	 */
	//private String systemId;
	/**
	 * 消息流水
	 */
	private String msgSeq;
	/**
	 * 客户ID
	 */
	private String custId;
	/**
	 * 用户订购标识
	 */
	private String subsId;
	/**
	 * 服务号码
	 */
	private String serviceNum;
	/**
	 * 开始账期 yyyymm
	 */
	private String beginMonth;
	/**
	 * 结束账期 yyyymm
	 */
	private String endMonth;
	/**
	 * 通道类型
	 */
	private String apnCode;
	
public String getApnCode() {
		return apnCode;
	}
	public void setApnCode(String apnCode) {
		this.apnCode = apnCode;
	}
	//	public String getSystemId() {
//		return systemId;
//	}
//	public void setSystemId(String systemId) {
//		this.systemId = systemId;
//	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	
}
