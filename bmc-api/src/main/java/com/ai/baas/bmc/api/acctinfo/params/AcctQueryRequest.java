package com.ai.baas.bmc.api.acctinfo.params;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 账户查询入参.<br>
 * Date: 2016年7月4日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author luoxuan
 */
public class AcctQueryRequest extends BaseInfo{
	private static final long serialVersionUID = 8822616585208049757L;
	/**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     */
    @NotBlank(message="消息流水不能为空")
   //@Size(max=32)
    private String tradeSeq;

    /**
     * 账户ID
     * VARCHAR(32)
     */
    @Size(max=32)
	private String custID;
	 /**
     * 请求查询的页码
     */
    //@Size(max=32)
    private Integer pageNo;
    
    /**
     * 每页显示条数
     */
    //@Size(max=32)
    private Integer pageSize;
    
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
