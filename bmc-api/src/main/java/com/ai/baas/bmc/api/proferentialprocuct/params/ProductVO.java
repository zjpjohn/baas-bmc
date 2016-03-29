package com.ai.baas.bmc.api.proferentialprocuct.params;
/**
 * 产品信息
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProductVO {
	
	/**
	 * 产品类型
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
	 * 单价/总价
	 */
	private double price;
	/**
	 * 状态
	 */
	private String status;
	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
