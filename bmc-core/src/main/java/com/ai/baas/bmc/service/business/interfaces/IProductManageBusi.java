package com.ai.baas.bmc.service.business.interfaces;

import com.ai.baas.bmc.api.marktableproduct.params.ProcductResponse;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamVo;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

public interface IProductManageBusi {
	public void updateProduct(ProductParamVo vo);
	
	public void deleteProduct(ProductParamKeyVo vo);
	
	public ProductParamVo editProduct(ProductParamKeyVo vo);
	
	public ProcductResponse insertProduct(ProductParamVo vo);
}
