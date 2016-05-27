package com.ai.baas.bmc.api.detailbill.params;

import com.ai.opt.base.vo.BaseInfo;

public class QueryBillRequest extends BaseInfo {

	
	private static final long serialVersionUID = 1L;
	private String tradeSeq;
	private String custId;
	private String serviceId;
	private String subsId;
	private String searchTime;
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getSubsId() {
		return subsId;
	}
	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}
	public String getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	
	
}
