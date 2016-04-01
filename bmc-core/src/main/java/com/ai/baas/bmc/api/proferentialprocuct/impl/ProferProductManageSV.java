package com.ai.baas.bmc.api.proferentialprocuct.impl;

import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IProferProductManageSV;
import com.ai.baas.bmc.api.proferentialprocuct.params.ActiveProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.productDelVO;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.alibaba.dubbo.config.annotation.Service;

@Service(validation="true")
@Component
public class ProferProductManageSV implements IProferProductManageSV{

	/**
	 * 满赠添加
	 */
	@Override
	public ProductResponse addProferProduct(ProferProductVO vo) throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductResponse addDiscontProduct(ProferProductVO vo) throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProferProductStatus(ActiveProductVO vo) throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delProferProduct(productDelVO vo) throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProferProduct(ProferProductVO vo) throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		
	}

}
