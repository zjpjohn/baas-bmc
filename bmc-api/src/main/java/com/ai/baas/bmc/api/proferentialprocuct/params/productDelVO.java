package com.ai.baas.bmc.api.proferentialprocuct.params;

import javax.validation.constraints.NotNull;

import com.ai.opt.base.vo.BaseInfo;

public class productDelVO extends BaseInfo{
	
	
	private static final long serialVersionUID = 1L;
	/**
	 *优惠产品Id
	 */
	private String ProdutId;
	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotNull(message="消息流水号不能为空")
	private String tradeSeq;

	public String getProdutId() {
		return ProdutId;
	}

	public void setProdutId(String produtId) {
		ProdutId = produtId;
	}

	public String getTradeSeq() {
		return tradeSeq;
	}

	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	

}
