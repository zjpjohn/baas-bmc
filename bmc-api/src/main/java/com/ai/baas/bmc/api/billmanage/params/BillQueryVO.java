package com.ai.baas.bmc.api.billmanage.params;

import com.ai.opt.base.vo.BaseInfo;
/**
 * 账单科目查询入参
 *
 * Date: 2016年3月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class BillQueryVO extends BaseInfo {

	
	private static final long serialVersionUID = 1L;
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
	 * 关联业务类型
	 */
	private String relateServicedType;
	 /**
     * 当前第几页,必填
     */
    private Integer pageNo;

    /**
     * 每页数据条数,必填
     */
    private Integer pageSize;

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

	public String getRelateServicedType() {
		return relateServicedType;
	}

	public void setRelateServicedType(String relateServicedType) {
		this.relateServicedType = relateServicedType;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
    
}
