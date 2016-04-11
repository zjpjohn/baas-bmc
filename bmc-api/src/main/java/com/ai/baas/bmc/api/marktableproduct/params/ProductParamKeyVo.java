package com.ai.baas.bmc.api.marktableproduct.params;

import java.io.Serializable;

public class ProductParamKeyVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String priceCode;
	private String chargeType;

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}
}
