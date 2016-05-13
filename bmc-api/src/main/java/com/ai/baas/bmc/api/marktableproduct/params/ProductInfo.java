package com.ai.baas.bmc.api.marktableproduct.params;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

/**
 * 可销售产品查询返回参数
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProductInfo extends BaseResponse{

	
	private static final long serialVersionUID = 1L;
	/**
	 * 交易流水号
	 */
	private String tradeSeq;
	/**
	 * 租户Id
	 */
	private String tenantId;
	/**
	 * 产品Id
	 */
	private String productId;
	/**
	 * 产品（包）名称
	 */
	private String productName;
	

	/**
	 * 产品计费类型
	 */
	private String billingType;

	/**
	 * 业务细分
	 */
	private List<ServiceVO> usageList;

	/**
	 * 生效时间
	 */
	private Timestamp activeDate;
	
	/**
	 * 失效时间
	 */
	private Timestamp invalidDate;
	
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 总价
	 */
	private BigDecimal totalPrice;

	/**
	 * 批价类型
	 */
	private String pricingType;

	public String getPricingType() {
		return pricingType;
	}

	public void setPricingType(String pricingType) {
		this.pricingType = pricingType;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<ServiceVO> getUsageList() {
		return usageList;
	}

	public void setUsageList(List<ServiceVO> usageList) {
		this.usageList = usageList;
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
	
	
	
}
