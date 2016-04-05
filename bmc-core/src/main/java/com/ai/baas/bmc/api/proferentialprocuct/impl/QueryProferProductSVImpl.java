package com.ai.baas.bmc.api.proferentialprocuct.impl;

import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IQueryProferProductSV;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductInfo;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;

public class QueryProferProductSVImpl implements IQueryProferProductSV {

	@Override
	public PageInfo<ProferProductInfo> getProductInfo(ProductQueryVO vo) throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		
		return null;
	}
	

}
