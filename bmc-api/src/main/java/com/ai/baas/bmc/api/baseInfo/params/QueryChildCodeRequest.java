package com.ai.baas.bmc.api.baseInfo.params;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.opt.base.vo.BaseInfo;

public class QueryChildCodeRequest extends BaseInfo {

	
	private static final long serialVersionUID = 1L;

	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     */
	@NotBlank(message="消息流水号不能为空")
	private String tradeSeq;
	/**
	 * 父节点Code
	 */
	@NotBlank(message="父节点Id不能为空")
	private String parentCode;
	
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	
}
