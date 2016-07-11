package com.ai.baas.bmc.api.marktableproduct.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IQueryProductSV;
import com.ai.baas.bmc.api.marktableproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryByIdListVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryVO;
import com.ai.baas.bmc.service.business.interfaces.IQueryProductBusi;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service(validation = "true")
@Component
public class QueryProductSVImpl implements IQueryProductSV{
	private static final Logger log = LogManager
			.getLogger(QueryProductSVImpl.class);
	@Autowired
	private IQueryProductBusi iQueryProductBusiImpl;
	
	@Override
	public PageInfo<ProductInfo> getProductInfo(ProductQueryVO vo)
			throws BusinessException, SystemException {
		if (null == vo) {
			log.debug("addProduct() vo = [null]");
			return null;
		} else {
			log.debug("addProduct() vo = " + vo.toString() + "]");
		}
		if(null == vo.getTenantId() || StringUtil.isBlank(vo.getTenantId())){
			throw new BusinessException("tenantId is not null", "租户id不能为空");
		}
		return iQueryProductBusiImpl.Product(vo);
		
	
	}

	@Override
	public PageInfo<ProductInfo> getProductInfoByProductIdList(ProductQueryByIdListVO vo)
			throws BusinessException, SystemException {
		return this.iQueryProductBusiImpl.getProductInfoByProductIdList(vo);
	}

}
