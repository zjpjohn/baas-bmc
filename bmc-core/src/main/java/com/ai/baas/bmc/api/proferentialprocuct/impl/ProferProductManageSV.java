package com.ai.baas.bmc.api.proferentialprocuct.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IProferProductManageSV;
import com.ai.baas.bmc.api.proferentialprocuct.params.ActiveProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedAccountVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.productDelVO;
import com.ai.baas.bmc.service.business.interfaces.IProferProductManageBusi;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service(validation = "true")
@Component
public class ProferProductManageSV implements IProferProductManageSV {

	
	@Autowired
	private IProferProductManageBusi iProferProductManageBusi;
	/**
	 * 满赠添加
	 */
	@Override
	public ProductResponse addProferProduct(ProferProductVO vo) throws BusinessException, SystemException {
		if (StringUtil.isBlank(vo.getTenantId())) {
			throw new BusinessException("888888", "[租户Id]不能为空");
		}
		return iProferProductManageBusi.addProferProduct(vo);
	}

	@Override
	public ProductResponse addDiscontProduct(ProferProductVO vo) throws BusinessException, SystemException {
		if (StringUtil.isBlank(vo.getTenantId())) {
			throw new BusinessException("888888", "[租户Id]不能为空");
		}
		return iProferProductManageBusi.addDiscontProduct(vo);
	}

	@Override
	public BaseResponse updateProferProductStatus(ActiveProductVO vo) throws BusinessException, SystemException {
		if (StringUtil.isBlank(vo.getTenantId())) {
			throw new BusinessException("888888", "[租户Id]不能为空");
		}
		return iProferProductManageBusi.updateProferProductStatus(vo);

	}

	@Override
	public BaseResponse delProferProduct(productDelVO vo) throws BusinessException, SystemException {
		if (StringUtil.isBlank(vo.getTenantId())) {
			throw new BusinessException("888888", "[租户Id]不能为空");
		}
		return iProferProductManageBusi.delProferProduct(vo);
	}

	@Override
	public BaseResponse updateProferProduct(ProferProductVO vo) throws BusinessException, SystemException {
		if (StringUtil.isBlank(vo.getTenantId())) {
			throw new BusinessException("888888", "[租户Id]不能为空");
		}
	
		return iProferProductManageBusi.updateProferProduct(vo);
	}

	@Override
	public BaseResponse relatedAccout(RelatedAccountVO vo) throws BusinessException, SystemException {
		if (StringUtil.isBlank(vo.getTenantId())) {
			throw new BusinessException("888888", "[租户Id]不能为空");
		}
		return iProferProductManageBusi.relatedAccout(vo);
	}

}
