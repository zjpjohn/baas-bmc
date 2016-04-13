package com.ai.baas.bmc.api.marktableproduct.params;

import javax.validation.constraints.NotNull;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IProductManageSV;
import com.ai.opt.base.vo.BaseInfo;
/**
 * 修改产品状态入参
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProductActiveVO extends BaseInfo {

	
	private static final long serialVersionUID = 1L;
	/**
	 * 产品Id
	 */
	@NotNull(message="产品Id不能为空",groups={IProductManageSV.UpdateProductStatus.class})
	private String productId;
	/**
	 * 状态
	 */
	@NotNull(message="状态不能为空",groups={IProductManageSV.UpdateProductStatus.class})
	private String status;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
