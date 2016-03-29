package com.ai.baas.bmc.api.billmanage.params;

import com.ai.opt.base.vo.BaseResponse;
/**
 * 账单科目查询出参
 *
 * Date: 2016年3月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class BillInfoResponse extends BaseResponse {

	
	private static final long serialVersionUID = 1L;
	/**
	 * 租户Id
	 */
	private String tenantId;
	/**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	private String tradeSeq;
	
	/**
	 * 账单Id
	 */
	private String billId;
	/**
	 * 账单名称
	 */
	private String billName;
	/**
	 * 账单类型
	 */
	private String billType;
	/**
	 * 账单科目描述
	 */
	private String comments;
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getBillName() {
		return billName;
	}
	public void setBillName(String billName) {
		this.billName = billName;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	
}
