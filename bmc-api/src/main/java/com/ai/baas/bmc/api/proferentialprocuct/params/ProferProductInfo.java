package com.ai.baas.bmc.api.proferentialprocuct.params;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;
/**
 * 优惠产品查询返回参数
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProferProductInfo extends BaseResponse {

	
	private static final long serialVersionUID = 1L;

	 /**
    * 消息流水<br>
    * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
    * 必填<br>
    * VARCHAR(32)
    */
	private String tradeSeq;
	/**
	 * 租户Id
	 */
	private String tenantId;
	/**
	 * 优惠产品Id
	 */
	private Long productId;
	/**
	 * 优惠类型
	 */
	private String ProferType;
	/**
	 * 优惠产品（包）名称
	 */
	private String productName;
	/**
	 * 优惠规则
	 */
	private String rule;
	/**
	 * 产品生效日期
	 */
	private Timestamp activeDate;
	/**
	 * 产品失效日期
	 */
	private Timestamp invalidDate;
	/**
	 * 状态
	 */
	private String status;
	
	private String priceCode;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProferType() {
		return ProferType;
	}
	public void setProferType(String proferType) {
		ProferType = proferType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public Timestamp getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(Timestamp activeDate) {
		this.activeDate = activeDate;
	}
	public Timestamp getInvalidDate() {
		return invalidDate;
	}
	public void setInvalidDate(Timestamp invalidDate) {
		this.invalidDate = invalidDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}
	
	

}
