package com.ai.baas.bmc.business.interfaces;

import java.io.IOException;

import com.ai.baas.bmc.api.marktableproduct.params.ProductVO;

public interface IProductManageBusiness {
	
	 public void addproduct(ProductVO vo);

	String hasSeq(ProductVO vo) throws IOException;
}
