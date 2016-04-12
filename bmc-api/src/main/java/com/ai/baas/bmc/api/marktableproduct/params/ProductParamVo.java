package com.ai.baas.bmc.api.marktableproduct.params;

import java.io.Serializable;

public class ProductParamVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String priceCode;
	private String chargeType;
	//
	private CpPriceInfoParamVo cpPriceInfoParamVo;
	private CpPriceDetailParamVo cpPriceDetailParamVo;
	private CpStepInfoParamVo cpStepInfoParamVo;
	private CpPackageInfoParamVo cpPackageInfoParamVo;
	
	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public CpPackageInfoParamVo getCpPackageInfoParamVo() {
		return cpPackageInfoParamVo;
	}

	public void setCpPackageInfoParamVo(CpPackageInfoParamVo cpPackageInfoParamVo) {
		this.cpPackageInfoParamVo = cpPackageInfoParamVo;
	}

	public CpPriceInfoParamVo getCpPriceInfoParamVo() {
		return cpPriceInfoParamVo;
	}

	public void setCpPriceInfoParamVo(CpPriceInfoParamVo cpPriceInfoParamVo) {
		this.cpPriceInfoParamVo = cpPriceInfoParamVo;
	}

	public CpPriceDetailParamVo getCpPriceDetailParamVo() {
		return cpPriceDetailParamVo;
	}

	public void setCpPriceDetailParamVo(CpPriceDetailParamVo cpPriceDetailParamVo) {
		this.cpPriceDetailParamVo = cpPriceDetailParamVo;
	}

	public CpStepInfoParamVo getCpStepInfoParamVo() {
		return cpStepInfoParamVo;
	}

	public void setCpStepInfoParamVo(CpStepInfoParamVo cpStepInfoParamVo) {
		this.cpStepInfoParamVo = cpStepInfoParamVo;
	}
}
