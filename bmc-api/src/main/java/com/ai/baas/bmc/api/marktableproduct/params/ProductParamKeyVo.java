package com.ai.baas.bmc.api.marktableproduct.params;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IProductManageSV;

public class ProductParamKeyVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message="产品Id不能为空",groups={IProductManageSV.EditProduct.class})
	private String productId;
	
	@NotNull(message="计费类型不能为空",groups={IProductManageSV.EditProduct.class})
	private String billingType;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	
}
