package com.ai.baas.bmc.service.business.interfaces;

import java.io.IOException;

import com.ai.baas.bmc.api.marktableproduct.params.ProductDelVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductVO;

public interface IProductManageBusi {
	public void updateProduct(ProductVO vo);
	
	public void deleteProduct(ProductDelVO vo);
	
	public ProductVO editProduct(ProductParamKeyVo vo);
	
	
	public String hasSeq(ProductVO vo) throws IOException;
	
	public void addProduct(ProductVO vo);
	
}
