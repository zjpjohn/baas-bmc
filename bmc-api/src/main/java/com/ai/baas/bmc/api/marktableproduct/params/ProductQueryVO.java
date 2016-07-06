package com.ai.baas.bmc.api.marktableproduct.params;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IQueryProductSV;
import com.ai.opt.base.vo.BaseInfo;
/**
 * 可销售产品查询入参
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProductQueryVO extends BaseInfo {

	private static final long serialVersionUID = 1L;
	 
	/**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	//@NotNull(message="消息流水号不能为空",groups={IQueryProductSV.GetProductInfo.class})
	private String tradeSeq;
	
	/**
	 * 产品ID
	 */
	private String productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 业务类型
	 */
	private String serviceType;
	
	/**
	 * 计费类型
	 */
	private String billingType;

	/**
	 * 生效日期
	 */
	private Timestamp activeDate;
	/**
	 * 失效日期
	 */
	private Timestamp invalidDate;
	/**
	 * 产品价格开头
	 */
	private double priceStart;
	/**
	 * 产品价格结尾
	 */
	private double priceEnd;
	
	 /**
     * 当前第几页,必填
     */
	@NotNull(message="页码不能为空",groups={IQueryProductSV.GetProductInfo.class})
    private Integer pageNo;

    /**
     * 每页数据条数,必填
     */
	@NotNull(message="数据条数不能为空",groups={IQueryProductSV.GetProductInfo.class})
    private Integer pageSize;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
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
	
	public double getPriceStart() {
		return priceStart;
	}
	public void setPriceStart(double priceStart) {
		this.priceStart = priceStart;
	}
	public double getPriceEnd() {
		return priceEnd;
	}
	public void setPriceEnd(double priceEnd) {
		this.priceEnd = priceEnd;
	}
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
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
