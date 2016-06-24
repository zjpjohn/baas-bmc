package com.ai.baas.bmc.api.initbasedata.params;

import com.ai.opt.base.vo.BaseInfo;

public class InitBaseParam extends BaseInfo{

	private static final long serialVersionUID = 8681181667846672018L;
	/**
	 * 用户标识
	 */
	private String serviceId;
	/**
	 * 外部客户id
	 */
	private String extCustId;
	/**
	 * 租户id
	 */
	private String tenantId;
	/**
	 * 用户号
	 */
	private String subsId;
	/**
	 * 客户号
	 */
	private String custId;
	/**
	 * 账户号
	 */
	private String acctId;
	
	public String getSubsId() {
		return subsId;
	}
	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getExtCustId() {
		return extCustId;
	}
	public void setExtCustId(String extCustId) {
		this.extCustId = extCustId;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
