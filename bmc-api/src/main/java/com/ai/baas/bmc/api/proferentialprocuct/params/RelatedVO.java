package com.ai.baas.bmc.api.proferentialprocuct.params;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.opt.base.vo.BaseInfo;

public class RelatedVO extends BaseInfo {
	 
	private static final long serialVersionUID = 1L;

	/**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     */
	@NotNull(message="消息流水号不能为空")
	private String tradeSeq;
	/**
	 * 租户Id
	 */
	@NotBlank(message="租户Id不能为空")
	private String tenantId;
	
	/**
	 * 产品Id
	 */
	@NotNull(message="产品Id不能为空")
	private Long productId;

	public String getTradeSeq() {
		return tradeSeq;
	}

	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
}
