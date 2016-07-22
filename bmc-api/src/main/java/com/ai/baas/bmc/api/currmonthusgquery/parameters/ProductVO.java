package com.ai.baas.bmc.api.currmonthusgquery.parameters;

import java.io.Serializable;

/**
 * 目前计费中只沉淀商品id 所以除去productId 其他为空
 * Date: 2016年4月27日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
public class ProductVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2351164081673347686L;
	
	
	private String productId;
	
	private String visitArea;
	
	private String resType;
	
	private String amount;
	
	private String productAmount;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getVisitArea() {
		return visitArea;
	}

	public void setVisitArea(String visitArea) {
		this.visitArea = visitArea;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}

	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", visitArea=" + visitArea + ", resType=" + resType + ", amount="
				+ amount + ", productAmount=" + productAmount + "]";
	}
	
	
}
