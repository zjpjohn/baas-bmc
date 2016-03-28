package com.ai.baas.bmc.api.marketbleproduct.interfaces;

import com.ai.baas.bmc.api.marketbleproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductQueryVO;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;

/**
 * 可销售产品查询服务
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface IQueryProductSV {

	/**
	 * 可销售产品列表
	 * @param vo
	 * @return
	 * @throws BusinessException
     * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00004
	 */
	@interface GetProductInfo{}
	PageInfo<ProductInfo> getProductInfo(ProductQueryVO vo) throws BusinessException, SystemException;
	
	
}
