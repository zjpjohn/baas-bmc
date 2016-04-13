package com.ai.baas.bmc.api.marktableproduct.params;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IProductManageSV;
import com.ai.opt.base.vo.BaseInfo;
/**
 * 删除产品入参
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProductDelVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 产品Id
	 */
	@NotNull(message="产品Id不能为空",groups={IProductManageSV.DelProduct.class})
	private String productId;
	
	@NotNull(message="计费类型不能为空",groups={IProductManageSV.DelProduct.class})
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
