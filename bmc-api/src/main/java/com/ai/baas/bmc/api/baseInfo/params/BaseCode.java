package com.ai.baas.bmc.api.baseInfo.params;

import java.io.Serializable;

public class BaseCode implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String paramCode;
	private String paramName;
	private String defaultValue;
	private String comments;
	public String getParamCode() {
		return paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
