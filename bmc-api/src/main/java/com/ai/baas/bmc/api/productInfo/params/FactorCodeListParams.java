package com.ai.baas.bmc.api.productInfo.params;

import java.io.Serializable;

/**
 * 客户基本信息.<br>
 * Date: 2015年10月29日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author biancx
 */

public class FactorCodeListParams implements Serializable{
	   private static final long serialVersionUID = 1L;
	/**
	 * 名称     缺省长市漫，取值参考：参考因素定义表
	 */
	private String factorName;
	/**
	 * 值  缺省长市漫，取值参考：参考因素定义表 
	 */
	private String factorValue;
	public String getFactorName() {
		return factorName==null?null:factorName.trim();
	}
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}
	public String getFactorValue() {
		return factorValue==null?null:factorValue.trim();
	}
	public void setFactorValue(String factorValue) {
		this.factorValue = factorValue;
	}

}
