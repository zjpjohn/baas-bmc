package com.ai.baas.bmc.api.proferentialprocuct.params;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IProferProductManageSV;
import com.ai.opt.base.vo.BaseInfo;

public class ActiveProductVO extends BaseInfo {

	
	private static final long serialVersionUID = 1L;
	
	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotBlank(message="消息流水号不能为空",groups={IProferProductManageSV.UpdateProferProductStatus.class})
	private String tradeSeq;
	
	/**
	 * 产品Id
	 */
	@NotNull(message="产品Id不能为空")
	private Long productId;
	/**
	 * 负责状态
	 */
	@NotBlank(message="状态信息不能为空")
	private String status;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
