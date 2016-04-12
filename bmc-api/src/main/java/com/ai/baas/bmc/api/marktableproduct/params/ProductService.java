package com.ai.baas.bmc.api.marktableproduct.params;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

	
	/**
	 * 单次/周期 数量
	 */
	private Integer cycleAmount;
	
	
	/**
	 * 单价
	 */
	private double price;
	
	
	private List<ServiceDetail> list;


	public Integer getCycleAmount() {
		return cycleAmount;
	}


	public void setCycleAmount(Integer cycleAmount) {
		this.cycleAmount = cycleAmount;
	}


	


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public List<ServiceDetail> getList() {
		return list;
	}


	public void setList(List<ServiceDetail> list) {
		this.list = list;
	}
	
	

}
