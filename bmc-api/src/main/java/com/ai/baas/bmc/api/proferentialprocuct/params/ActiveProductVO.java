package com.ai.baas.bmc.api.proferentialprocuct.params;

import javax.validation.constraints.NotNull;

import com.ai.opt.base.vo.BaseInfo;

public class ActiveProductVO extends BaseInfo {

	
	private static final long serialVersionUID = 1L;
	
	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotNull(message="消息流水号不能为空")
	private String tradeSeq;
	
	/**
	 * 产品Id
	 */
	private String productId;
	/**
	 * 负责状态
	 */
	private String status;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}