package com.ai.baas.bmc.api.acctinfo.params;

import java.io.Serializable;



/**
 * 账户基本信息.<br>
 * Date: 2016年7月4日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author luoxuan
 */
public class AcctInfoParams implements Serializable{
	private static final long serialVersionUID = -4908033086241439685L;
	private String tenantId;
	private String acctID;
	private String acctName;
	private String custID;
	private String ownerType;
	private String acctType;
	private String creatTime;
	private String comments;
	
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getAcctID() {
		return acctID;
	}
	public void setAcctID(String acctID) {
		this.acctID = acctID;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
