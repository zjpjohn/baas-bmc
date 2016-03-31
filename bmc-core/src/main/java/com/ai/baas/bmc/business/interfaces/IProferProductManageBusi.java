package com.ai.baas.bmc.business.interfaces;

import com.ai.baas.bmc.api.proferentialprocuct.params.ActiveProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.productDelVO;

public interface IProferProductManageBusi {
	
	ProductResponse addProferProduct(ProferProductVO vo);
	
	ProductResponse addDiscontProduct(ProferProductVO vo);
	
	void updateProferProductStatus(ActiveProductVO vo);
	
	void delProferProduct(productDelVO vo);
	
	void updateProferProduct(ProferProductVO vo);
	
}
