package com.ai.baas.bmc.api.proferentialprocuct.interfaces;

import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryParam;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductInfo;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.SingleProductInfo;
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
public interface IQueryProferProductSV {

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
	PageInfo<ProferProductInfo> getProductInfo(ProductQueryVO vo) throws BusinessException, SystemException;
	@interface GetProductInfo{}
	/**
	 * 查询单个产品
	 * @param param
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode
	 */
	SingleProductInfo  getProductById(ProductQueryParam param) throws BusinessException, SystemException;	
	
	/**
	 * 查询关联费用
	 * @param vo
	 * @return
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode
	 */
	RelatedResponse getRelatedAccount(RelatedVO vo);
}
