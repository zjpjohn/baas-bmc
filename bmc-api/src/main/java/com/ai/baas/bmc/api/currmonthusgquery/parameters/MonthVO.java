package com.ai.baas.bmc.api.currmonthusgquery.parameters;

import java.io.Serializable;
import java.util.List;

/**
 * Date: 2016年4月27日 <br>
 * 
 * @author zhoushanbin Copyright (c) 2016 asiainfo.com <br>
 */
public class MonthVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4120625268653481728L;

	private String beginMonth;

	private String custId;

	private List<SubsInfoVO> subList;

	public String getBeginMonth() {
		return beginMonth;
	}

	public void setBeginMonth(String beginMonth) {
		this.beginMonth = beginMonth;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public List<SubsInfoVO> getSubList() {
		return subList;
	}

	public void setSubList(List<SubsInfoVO> subList) {
		this.subList = subList;
	}

	@Override
	public String toString() {
		return "MonthVO [beginMonth=" + beginMonth + ", custId=" + custId + ", subList=" + subList + "]";
	}
	
	
}
