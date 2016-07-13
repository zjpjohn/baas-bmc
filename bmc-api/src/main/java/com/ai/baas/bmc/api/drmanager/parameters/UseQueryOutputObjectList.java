package com.ai.baas.bmc.api.drmanager.parameters;

import java.util.List;

public class UseQueryOutputObjectList implements java.io.Serializable {
	private String beginMonth;
	private String custId;
	private List<UseQueryOutputObjectSubListList> subList;
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
	public List<UseQueryOutputObjectSubListList> getSubList() {
		return subList;
	}
	public void setSubsId(List<UseQueryOutputObjectSubListList> subList) {
		this.subList = subList;
	}
	@Override
	public String toString() {
		return "UseQueryOutputObjectList [beginMonth=" + beginMonth + ", custId=" + custId + ", subList=" + subList + "]";
	}
}
