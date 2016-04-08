package com.ai.baas.bmc.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.marketbleproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductQueryVO;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;

public interface IQueryProductBusi {
	public List<ProductInfo> Product(ProductQueryVO vo);
}
