package com.ai.baas.bmc.api.marktableproduct.params;

public class ServiceDetail {
	/**
	 * 业务类型细分
	 */
	private String serviceTypeDetail;
	/**
	 * 使用量
	 */
	private double amount;
	
	/**
	 * 单位 
	 */
	private String unit;

	public String getServiceTypeDetail() {
		return serviceTypeDetail;
	}

	public void setServiceTypeDetail(String serviceTypeDetail) {
		this.serviceTypeDetail = serviceTypeDetail;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
