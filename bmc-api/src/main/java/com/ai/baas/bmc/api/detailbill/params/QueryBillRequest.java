package com.ai.baas.bmc.api.detailbill.params;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.opt.base.vo.BaseInfo;

public class QueryBillRequest extends BaseInfo {

	
	private static final long serialVersionUID = 1L;
	/**
	 * 流水号
	 */
	@NotBlank(message="消息流水号不能为空")
	private String tradeSeq;
	@NotBlank(message="custId不能为空")
	private String custId;
	@NotBlank(message="serviceId不能为空")
	private String serviceId;
	@NotBlank(message="subsId不能为空")
	private String subsId;
	@NotBlank(message="查询时间不能为空")
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
