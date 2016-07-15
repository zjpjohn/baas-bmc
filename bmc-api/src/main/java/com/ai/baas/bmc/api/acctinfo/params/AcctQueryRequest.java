package com.ai.baas.bmc.api.acctinfo.params;

import java.util.List;

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
     * 账户ID
     * VARCHAR(32)
     */
	private List<String> custIDs;
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
    

	public List<String> getCustIDs() {
		return custIDs;
	}
	public void setCustIDs(List<String> custIDs) {
		this.custIDs = custIDs;
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
