package com.ai.baas.bmc.api.proferentialprocuct.params;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;
/**
 * 关联费用获取返回参数
 *
 * Date: 2016年4月7日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class RelatedResponse extends BaseResponse {

	
	private static final long serialVersionUID = 1L;
	/**
	 * 产品Id
	 */
	private Long productId;
	/**
	 * 关联费用科目
	 */
    List<String> accounts;
    
    /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     */
	private String tradeSeq;
	/**
	 * 租户Id
	 */
	private String tenantId;

	/**
	 * 产品类型
	 */
	private String chargeType;
	/**
	 * 满赠或满减id
	 */
	private List<Long> Ids;
	
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<String> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<String> accounts) {
		this.accounts = accounts;
	}

	public String getTradeSeq() {
		return tradeSeq;
	}

	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public List<Long> getIds() {
		return Ids;
	}

	public void setIds(List<Long> ids) {
		Ids = ids;
	}


}
