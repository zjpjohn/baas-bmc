package com.ai.baas.bmc.api.custInfo.params;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.opt.base.vo.BaseInfo;

public class QueryCustInfoRequest extends BaseInfo {

	private static final long serialVersionUID = 1L;

	/**
	 * 交易流水，最大长度32字节
	 */
	@NotBlank(message = "交易流水不能为空")
	private String tradeSeq;
	/**
	 * 客户名称
	 */
	private String custName;
	/**
	 * 客户证件号
	 */
	@NotBlank(message = "客户证件号不能为空")
	private String idNumber;
	/**
	 * 客户等级
	 */
	private String custGrade;
	/**
	 * 资源号码
	 */
	private String serviceId;
	
	 /**
     * 当前第几页,必填
     */
    private Integer pageNo;

    /**
     * 每页数据条数,必填
     */
    private Integer pageSize;
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getCustGrade() {
		return custGrade;
	}
	public void setCustGrade(String custGrade) {
		this.custGrade = custGrade;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
