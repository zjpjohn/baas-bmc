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
	private Double priceStart;
	/**
	 * 产品价格结尾
	 */
	private Double priceEnd;
	
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
	/**
	 * 生效状态 ACTIVE:生效;INACTIVE:失效;
	 */
	private String activeStatus;
	
	
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
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
	
	public Double getPriceStart() {
		return priceStart;
	}
	public void setPriceStart(Double priceStart) {
		this.priceStart = priceStart;
	}
	public Double getPriceEnd() {
		return priceEnd;
	}
	public void setPriceEnd(Double priceEnd) {
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
