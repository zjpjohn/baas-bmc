package com.ai.baas.bmc.api.detailbill.params;

import java.io.Serializable;
import java.util.List;

public class GPRSResponse  implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	/**
	 * gprs 总钱数
	 */
	private Double totalMoney;
	/**
	 * 总流量
	 */
	private Long gprsTotal;
	/**
	 * 详细信息
	 */
	private List<GPRSParam> gprs;
	
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Long getGprsTotal() {
		return gprsTotal;
	}
	public void setGprsTotal(Long gprsTotal) {
		this.gprsTotal = gprsTotal;
	}
	public List<GPRSParam> getGprs() {
		return gprs;
	}
	public void setGprs(List<GPRSParam> gprs) {
		this.gprs = gprs;
	}
	
	
}
