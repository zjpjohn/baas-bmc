package com.ai.baas.bmc.business.interfaces;

import java.io.IOException;

import com.ai.baas.bmc.api.marketbleproduct.params.ProductVO;

public interface IProductManageBusiness {
	
	 public void addproduct(ProductVO vo);

	boolean hasSeq(ProductVO vo) throws IOException;
}
