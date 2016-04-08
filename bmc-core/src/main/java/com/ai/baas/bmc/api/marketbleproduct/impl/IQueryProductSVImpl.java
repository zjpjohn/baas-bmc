package com.ai.baas.bmc.api.marketbleproduct.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.marketbleproduct.interfaces.IQueryProductSV;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductQueryVO;
import com.ai.baas.bmc.business.impl.QueryProductBusiImpl;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.alibaba.dubbo.config.annotation.Service;

@Service(validation = "true")
@Component
public class IQueryProductSVImpl implements IQueryProductSV{
	private static final Logger log = LogManager
			.getLogger(IQueryProductSVImpl.class);
	@Autowired
	private QueryProductBusiImpl iQueryProductBusiImpl;
	
	@Override
	public PageInfo<ProductInfo> getProductInfo(ProductQueryVO vo)
			throws BusinessException, SystemException {
		if (vo == null) {
			log.debug("addProduct() vo = [null]");
			return null;
		} else {
			log.debug("addProduct() vo = " + vo.toString() + "]");
		}
		
		
		
		PageInfo<ProductInfo> page=new PageInfo();
		
		List<ProductInfo>  pro= iQueryProductBusiImpl.Product(vo);
	
		page.setResult(pro);
		
		return page;
	}

}
