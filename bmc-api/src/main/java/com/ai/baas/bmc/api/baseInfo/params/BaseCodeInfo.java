package com.ai.baas.bmc.api.baseInfo.params;

import java.io.Serializable;
import java.util.List;

public class BaseCodeInfo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String tradeSeq;
	private String tenantId;
	private String paramType;
	
	private List<BaseCode> list;

	public String getTradeSeq() {
		return tradeSeq;
	}

	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public List<BaseCode> getList() {
		return list;
	}

	public void setList(List<BaseCode> list) {
		this.list = list;
	}
	
	
}
