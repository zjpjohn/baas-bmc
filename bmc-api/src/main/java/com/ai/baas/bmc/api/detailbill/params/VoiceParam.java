package com.ai.baas.bmc.api.detailbill.params;

import java.io.Serializable;
/**
 * 语音相关数据
 *
 * Date: 2016年5月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class VoiceParam implements Serializable{

	private static final long serialVersionUID = 1L;

	private String account_period;
	
	private String bsn;
	
	private String duration;
	/**
	 * 本地通话费用
	 */
	private String fee1;
	/**
	 * 长途通话费用
	 */
	private String fee2;
	/**
	 * 其他费用
	 */
	private String fee3;
	/**
	 * 产品Id
	 */
	private String product_id;
	/**
	 * 服务资源号码
	 */
	private String service_id;
	
	
	private String sn;
	/**
	 * 来源
	 */
	private String source;
	/**
	 * 科目1
	 */
	private String subject1;
	/**
	 * 科目2
	 */
	private String subject2;
	/**
	 * 科目3
	 */
	private String subject3;
	/**
	 * 租户Id
	 */
	private String tenant_id;
	/**
	 * 呼叫类型
	 */
	private String call_type;
	/**
	 * 对方号码
	 */
	private String opp_number;
	/**
	 * 通话地点
	 */
	private String visit_area;
	/**
	 * 通话类型,比如本地通话，长途，漫游等
	 */
	private String long_type;
	
    private String custId;
    
    private String subsId;

	public String getAccount_period() {
		return account_period;
	}

	public void setAccount_period(String account_period) {
		this.account_period = account_period;
	}

	public String getBsn() {
		return bsn;
	}

	public void setBsn(String bsn) {
		this.bsn = bsn;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getFee1() {
		return fee1;
	}

	public void setFee1(String fee1) {
		this.fee1 = fee1;
	}

	public String getFee2() {
		return fee2;
	}

	public void setFee2(String fee2) {
		this.fee2 = fee2;
	}

	public String getFee3() {
		return fee3;
	}

	public void setFee3(String fee3) {
		this.fee3 = fee3;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	public String getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}

	public String getCall_type() {
		return call_type;
	}

	public void setCall_type(String call_type) {
		this.call_type = call_type;
	}

	public String getOpp_number() {
		return opp_number;
	}

	public void setOpp_number(String opp_number) {
		this.opp_number = opp_number;
	}

	public String getVisit_area() {
		return visit_area;
	}

	public void setVisit_area(String visit_area) {
		this.visit_area = visit_area;
	}

	public String getLong_type() {
		return long_type;
	}

	public void setLong_type(String long_type) {
		this.long_type = long_type;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getSubsId() {
		return subsId;
	}

	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}
    
    
	
	
	
	
}
