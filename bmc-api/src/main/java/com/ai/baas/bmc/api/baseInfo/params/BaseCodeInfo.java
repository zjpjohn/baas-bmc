package com.ai.baas.bmc.api.baseInfo.params;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;
/**
 * 基本信息查询出参
 *
 * Date: 2016年3月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class BaseCodeInfo extends BaseResponse{

	
	private static final long serialVersionUID = 1L;
	/**
	 * 交易流水号
	 */
	private String tradeSeq;
	/**
	 * 租户Id
	 */
	private String tenantId;
	/**
	 * 参数类型
	 */
	private String paramType;
	/**
	 * 参数列表
	 */
	private List<BaseCode> paramList;

	private Long id;
	public String getTradeSeq() {
		return tradeSeq;
	}

	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public List<BaseCode> getParamList() {
		return paramList;
	}

	public void setParamList(List<BaseCode> paramList) {
		this.paramList = paramList;
	}

	
	
	
}
