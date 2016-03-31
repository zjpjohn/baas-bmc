package com.ai.baas.bmc.api.custInfo.params;

import java.io.Serializable;

/**
 * Date: 2016年3月15日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author wangzhi
 */
public class ExtInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 名称，最大长度32字节
	 */
	private String extName;
	
	/**
	 * 值，最大长度64字节
	 */
	private String extValue;

	/**
	 * 更新标识，最大长度1字节 取值范围：D：删除，U：更新，N：新增
	 */
	private String updateFlag;

	public String getExtName() {
		return extName;
	}

	public void setExtName(String extName) {
		this.extName = extName;
	}

	public String getExtValue() {
		return extValue;
	}

	public void setExtValue(String extValue) {
		this.extValue = extValue;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	@Override
    public String toString() {
        return "ExtInfoListParams[extName="+extName+",extValue="+extValue+",updateFlag="+updateFlag+"]";
    }
}
