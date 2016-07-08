package com.ai.baas.bmc.api.baseInfo.params;

import java.io.Serializable;
/**
 * 基本信息
 *
 * Date: 2016年3月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class BaseCode implements Serializable{

	
	private static final long serialVersionUID = 1L;
	/**
	 * 编码Id
	 */
	private Long id;
	/**
	 * 参数编码
	 */
	private String paramCode;
	/**
	 * 参数名称
	 */
	private String paramName;
	/**
	 * 默认值
	 */
	private String defaultValue;
	/**
	 * 说明
	 */
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
