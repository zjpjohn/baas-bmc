package com.ai.baas.bmc.business.interfaces;

import com.ai.baas.bmc.api.marketbleproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductQueryVO;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;

public interface IQueryProductBusi {
	public ProductInfo Product(ProductQueryVO vo);
}
