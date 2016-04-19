package com.ai.baas.bmc.api.marktableproduct.params;

import java.io.Serializable;
import java.util.List;

public class ProductQueryByIdListVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tenantId;
	private List<String> productIdList;

	public List<String> getProductIdList() {
		return productIdList;
	}

	public void setProductIdList(List<String> productIdList) {
		this.productIdList = productIdList;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
