package com.ai.baas.bmc.api.proferentialprocuct.params;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IProferProductManageSV;
import com.ai.opt.base.vo.BaseInfo;

public class productDelVO extends BaseInfo{
	
	
	private static final long serialVersionUID = 1L;
	/**
	 *优惠产品Id
	 */
	@NotNull(message="产品Id不能为空",groups={IProferProductManageSV.DelProferProduct.class})
	private Long productId;
	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotBlank(message="消息流水号不能为空",groups={IProferProductManageSV.DelProferProduct.class})
	private String tradeSeq;

	

	

	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getTradeSeq() {
		return tradeSeq;
	}

	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	

}
