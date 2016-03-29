package com.ai.baas.bmc.api.marketbleproduct.params;

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
	private BigDecimal price;
	
	
	private List<ServiceDetail> list;


	public Integer getCycleAmount() {
		return cycleAmount;
	}


	public void setCycleAmount(Integer cycleAmount) {
		this.cycleAmount = cycleAmount;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public List<ServiceDetail> getList() {
		return list;
	}


	public void setList(List<ServiceDetail> list) {
		this.list = list;
	}
	
	

}
