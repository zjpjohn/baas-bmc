package com.ai.baas.bmc.api.currmonthusgquery.parameters;

import java.io.Serializable;
import java.util.List;

/**
 * Date: 2016年4月27日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
public class SubsInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4316902880626847554L;
	
	
	private String subsId;
	
	private String serviceType;
	
	private String serviceNum;
	
	private List<ProductVO> productList;
	
	private String amount;
	
	public String getSubsId() {
		return subsId;
	}

	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}

	public List<ProductVO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductVO> productList) {
		this.productList = productList;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SubsInfoVO [subsId=" + subsId + ", serviceType=" + serviceType + ", serviceNum=" + serviceNum
				+ ", productList=" + productList + ", amount=" + amount + "]";
	}
	
}
