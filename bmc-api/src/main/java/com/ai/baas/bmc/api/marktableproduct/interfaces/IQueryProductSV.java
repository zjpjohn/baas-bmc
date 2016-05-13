package com.ai.baas.bmc.api.marktableproduct.interfaces;

import com.ai.baas.bmc.api.marktableproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryByIdListVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductRelatedRequest;
import com.ai.baas.bmc.api.marktableproduct.params.ProductRelatedResponse;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;

/**
 * 可销售产品查询服务
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
public interface IQueryProductSV {

	
	/**
	 * 分页查询产品信息信息
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	PageInfo<ProductInfo> getProductInfo(ProductQueryVO vo) throws BusinessException, SystemException;
	@interface GetProductInfo{}
	/**
	 * 根据租户编号和产品编号列表查询产品信息 分页
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	PageInfo<ProductInfo> getProductInfoByProductIdList(ProductQueryByIdListVO vo) throws BusinessException, SystemException;
	@interface GetProductInfoByProductIdList{}
	/**
	 * 
	 * 可销售产品>>>关联详单科目
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	ProductRelatedResponse getProductRelated(ProductRelatedRequest vo) throws BusinessException,SystemException;
	@interface GetProductRelated{}
}
