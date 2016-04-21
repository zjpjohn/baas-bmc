package com.ai.baas.bmc.api.proferentialprocuct.params;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.opt.base.vo.BaseInfo;

public class RelatedAccountVO extends BaseInfo {

	
	private static final long serialVersionUID = 1L;

	/**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     */
	@NotBlank(message="消息流水号不能为空")
	private String tradeSeq;
	/**
	 * 关联费用列表
	 */
	private List<Long> relAccounts;
	/** 
	 * 产品Id
	 */
	private Long productId;

	/**
	 * 满赠或满减表的id
	 */
	private List<Long> fullIds;
	
	/**
	 * 产品类型
	 */
	private String chargeType;
	/**
	 * 费用科目类型
	 */
	private String accountType;
	
	

	public String getTradeSeq() {
		return tradeSeq;
	}

	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}

	

	public List<Long> getRelAccounts() {
		return relAccounts;
	}

	public void setRelAccounts(List<Long> relAccounts) {
		this.relAccounts = relAccounts;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<Long> getFullIds() {
		return fullIds;
	}

	public void setFullIds(List<Long> fullIds) {
		this.fullIds = fullIds;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
