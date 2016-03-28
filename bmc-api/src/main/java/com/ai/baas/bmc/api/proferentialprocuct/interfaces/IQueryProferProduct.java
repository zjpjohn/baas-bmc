package com.ai.baas.bmc.api.proferentialprocuct.interfaces;

import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductInfo;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;

/**
 * 优惠产品查询
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface IQueryProferProduct {

	/**
	 * 优惠产品查询服务
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00008
	 */
	@interface GetProductInfo{}
	PageInfo<ProferProductInfo> getProductInfo(ProductQueryVO vo) throws BusinessException, SystemException;
}
