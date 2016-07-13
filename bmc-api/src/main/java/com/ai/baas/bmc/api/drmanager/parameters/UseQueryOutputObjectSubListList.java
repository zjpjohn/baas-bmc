package com.ai.baas.bmc.api.drmanager.parameters;

import java.util.List;

public class UseQueryOutputObjectSubListList implements java.io.Serializable {
	private String subsId;
	private String serviceType;
	private String serviceNum;
	private List<UseQueryOutputObjectSubListProductList> productList;
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
	
	public List<UseQueryOutputObjectSubListProductList> getProductList() {
		return productList;
	}
	public void setProductList(
			List<UseQueryOutputObjectSubListProductList> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return "UseQueryOutputObjectSubsIdList [subsId=" + subsId + ", serviceType=" + serviceType + ", serviceNum="
				+ serviceNum + ", productList=" + productList + "]";
	}

}
