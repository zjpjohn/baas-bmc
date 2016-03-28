package com.ai.baas.bmc.api.proferentialprocuct.params;

import com.ai.opt.base.vo.BaseResponse;

public class ProductResponse extends BaseResponse {

	
	private static final long serialVersionUID = 1L;
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
	
}
