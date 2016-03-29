package com.ai.baas.bmc.api.proferentialprocuct.params;

import com.ai.opt.base.vo.BaseResponse;

public class ProductResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	/**
	 * 消息流水<br>
	 * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
	 * 必填<br>
	 * VARCHAR(32)
	 */
	private String tradeSeq;
	/**
	 * 租户Id
	 */
	private String tenantId;
	/**
	 * 优惠产品Id
	 */
	private String productId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

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

}
