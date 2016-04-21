package com.ai.baas.bmc.api.marktableproduct.params;

import java.io.Serializable;
import java.util.List;
/**
 * 关联详单科目 供可销售产品关联查询用
 *
 * Date: 2016年4月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
public class ProductRelatedResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 产品编号
	 */
	private String productId;
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 科目编码
	 */
	private String subjectCode;
	/**
	 * 租户id
	 */
	private String tenantId;
	/**
	 * 计费类型
	 */
	private String billingType;
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
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
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
}
