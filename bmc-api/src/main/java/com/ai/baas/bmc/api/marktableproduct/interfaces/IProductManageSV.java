package com.ai.baas.bmc.api.marktableproduct.interfaces;

import com.ai.baas.bmc.api.marktableproduct.params.ProcductResponse;
import com.ai.baas.bmc.api.marktableproduct.params.ProductActiveVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductDelVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductVO;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

/**
 * 可销售产品管理
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
public interface IProductManageSV {

	/**
	 * 新建产品
	 * @param vo
	 * @return
	 * @throws BusinessException
     * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode bmc-00005
	 */
	
	ProcductResponse addProduct(ProductVO vo) throws BusinessException, SystemException;
	@interface AddProduct{}
	/**
	 * 修改产品状态
	 * @param vo
	 * @throws BusinessException
     * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode bmc-00006
	 */
	
	void updateProductStatus(ProductActiveVO vo) throws BusinessException, SystemException;
	@interface UpdateProductStatus{}
	
	/**
	 * 删除可销售产品
	 * @param vo
	 * @throws BusinessException
     * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode bmc-00011
	 */
	
	void delProduct(ProductDelVO vo) throws BusinessException, SystemException;
	@interface DelProduct{}

	
	/**
	 * 更新产品信息
	 * @param vo
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode bmc-00012
	 */
	
	void updateProduct(ProductVO vo) throws BusinessException, SystemException;
	@interface UpdateProduct{}
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
	ProductVO editProduct(ProductParamKeyVo vo) throws BusinessException, SystemException;
	@interface EditProduct{}
}
