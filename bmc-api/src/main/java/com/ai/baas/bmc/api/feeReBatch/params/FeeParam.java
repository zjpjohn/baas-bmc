package com.ai.baas.bmc.api.feeReBatch.params;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;

/**
 * 
 * @author wangluyang
 *
 */
public class FeeParam extends BaseInfo{

	/**
	 * 主键
	 */
	private String rowKey;
	/**
     * 服务号（不能为空）
     */
    private String serviceId;
    /**
     * 业务类型(不能为空)
     */
    private String serviceType;
    /**
     * 来源（不能为空）
     */
    private String source;
    /**
     * 批次号（不能为空）
     */
    private String bsn;
    /**
     * 业务流水（不能为空）
     */
    private String sn;
    /**
     * 账期
     */
    private String accountPeriod;
    
    private String custNo;
    private String userNo;
    
	private Map<String, String> feePacket;
	
	public Map<String, String> getCommonAttrMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("serviceId", "service_id");
		map.put("serviceType","service_type");
		map.put("source","source");
		map.put("bsn","bsn");
		map.put("sn","sn");
		map.put("accountPeriod","account_period");
		return map;
	}
	
	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public String getServiceId() {
		return serviceId;
	}


	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getBsn() {
		return bsn;
	}


	public void setBsn(String bsn) {
		this.bsn = bsn;
	}


	public String getSn() {
		return sn;
	}


	public void setSn(String sn) {
		this.sn = sn;
	}


	public String getAccountPeriod() {
		return accountPeriod;
	}


	public void setAccountPeriod(String accountPeriod) {
		this.accountPeriod = accountPeriod;
	}


	public String getCustNo() {
		return custNo;
	}


	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}


	public String getUserNo() {
		return userNo;
	}


	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public Map<String, String> getFeePacket() {
		return feePacket;
	}


	public void setFeePacket(Map<String, String> feePacket) {
		this.feePacket = feePacket;
	}
	
}
