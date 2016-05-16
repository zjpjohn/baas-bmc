package com.ai.baas.bmc.api.marktableproduct.params;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 业务信息
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ServiceVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编码id
	 */
	private String serviceId;

	/**
	 * 业务类型
	 */
	private String serviceType;
	/**
	 * 业务类型细分
	 */
	private String serviceTypeDetail;
	/**
	 * 使用量开头
	 */
	private Double amountStart;
	/**
	 * 使用量结尾
	 */
	private Double amountEnd;
	/**
	 * 单位 
	 */
	private String unit;
	/**
	 *单次/周期 
	 */
	private String  cycleType;
	
	/**
	 * 单次/周期 数量
	 */
	private Integer cycleAmount;
	
	/**
	 * 单词/周期 标识
	 */
	private String cycleId;
	/**
	 * 单价
	 */
	private BigDecimal price;
	/**
	 * 科目编码
	 */
	private String subjectCode;
	
	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceTypeDetail() {
		return serviceTypeDetail;
	}

	public void setServiceTypeDetail(String serviceTypeDetail) {
		this.serviceTypeDetail = serviceTypeDetail;
	}

	public Double getAmountStart() {
		return amountStart;
	}

	public void setAmountStart(Double amountStart) {
		this.amountStart = amountStart;
	}

	public Double getAmountEnd() {
		return amountEnd;
	}

	public void setAmountEnd(Double amountEnd) {
		this.amountEnd = amountEnd;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCycleType() {
		return cycleType;
	}

	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
	}

	public Integer getCycleAmount() {
		return cycleAmount;
	}

	public void setCycleAmount(Integer cycleAmount) {
		this.cycleAmount = cycleAmount;
	}

	public String getCycleId() {
		return cycleId;
	}

	public void setCycleId(String cycleId) {
		this.cycleId = cycleId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}

