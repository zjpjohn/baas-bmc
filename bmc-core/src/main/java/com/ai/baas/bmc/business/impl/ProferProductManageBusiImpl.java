package com.ai.baas.bmc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.proferentialprocuct.params.ActiveProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.productDelVO;
import com.ai.baas.bmc.business.interfaces.IProferProductManageBusi;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;

public class ProferProductManageBusiImpl implements IProferProductManageBusi {
	@Autowired
	private CpPriceInfoMapper cpPriceInfoMapper;
	@Override
	public ProductResponse addProferProduct(ProferProductVO vo) {
			
		return null;
	}

	@Override
	public ProductResponse addDiscontProduct(ProferProductVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProferProductStatus(ActiveProductVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delProferProduct(productDelVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProferProduct(ProferProductVO vo) {
		// TODO Auto-generated method stub

	}

}
