package com.ai.baas.bmc.business.interfaces;

import com.ai.baas.bmc.api.marketbleproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductParamVo;

public interface IProductManageBusi {
	public void updateProduct(ProductParamVo vo);
	
	public void deleteProduct(ProductParamKeyVo vo);
	
	public ProductParamVo editProduct(ProductParamKeyVo vo);
}
