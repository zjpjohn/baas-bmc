package com.ai.baas.bmc.api.marketbleproduct.interfaces;

import com.ai.baas.bmc.api.marketbleproduct.params.ProcductResponse;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductActiveVO;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductDelVO;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductParamVo;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductVO;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

/**
 * 可销售产品管理
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface IProductManageSV {

	/**
	 * 新建产品
	 * @param vo
	 * @return
	 * @throws BusinessException
     * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00005
	 */
	@interface AddProduct{}
	ProcductResponse addProduct(ProductVO vo) throws BusinessException, SystemException;
	
	/**
	 * 修改产品状态
	 * @param vo
	 * @throws BusinessException
     * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00006
	 */
	@interface UpdateProductStatus{}
	void updateProductStatus(ProductActiveVO vo) throws BusinessException, SystemException;
	/**
	 * 删除可销售产品
	 * @param vo
	 * @throws BusinessException
     * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00011
	 */
	@interface DelProduct{}
	void delProduct(ProductParamKeyVo vo) throws BusinessException, SystemException;
	

	
	/**
	 * 更新产品信息
	 * @param vo
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00012
	 */
	@interface UpdateProduct{}
	void updateProduct(ProductParamVo vo) throws BusinessException, SystemException;
	/**
	 * 根据priceCode编辑信息
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	ProductParamVo editProduct(ProductParamKeyVo vo) throws BusinessException, SystemException;
}
