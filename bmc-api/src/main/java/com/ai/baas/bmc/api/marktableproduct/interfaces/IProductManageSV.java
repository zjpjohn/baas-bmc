package com.ai.baas.bmc.api.marktableproduct.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.marktableproduct.params.ProductActiveVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductDelVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductVO;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

/**
 * 可销售产品管理
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
@Path("/marktableproduct")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
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
	 * @RestRelativeURL marktableproduct/addProduct
	 */
    @POST
    @Path("/addProduct")
	BaseResponse addProduct(ProductVO vo) throws BusinessException, SystemException;
	@interface AddProduct{}
	/**
	 * 修改产品状态
	 * @param vo
	 * @throws BusinessException
     * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode bmc-00006
	 * @RestRelativeURL marktableproduct/updateProductStatus
	 */
	@POST
    @Path("/updateProductStatus")
	BaseResponse updateProductStatus(ProductActiveVO vo) throws BusinessException, SystemException;
	@interface UpdateProductStatus{}
	
	/**
	 * 删除可销售产品
	 * @param vo
	 * @throws BusinessException
     * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode bmc-00011
	 * @RestRelativeURL marktableproduct/delProduct
	 */
	@POST
    @Path("/delProduct")
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
	 * @RestRelativeURL marktableproduct/updateProduct
	 */
	@POST
    @Path("/updateProduct")
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
	 * @RestRelativeURL marktableproduct/editProduct
	 */
	@POST
    @Path("/editProduct")
	ProductVO editProduct(ProductParamKeyVo vo) throws BusinessException, SystemException;
	@interface EditProduct{}
}
