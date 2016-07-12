package com.ai.baas.bmc.api.marktableproduct.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.marktableproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryByIdListVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryVO;
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
@Path("/marktableproduct")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
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
	 * @RestRelativeURL marktableproduct/getProductInfo
	 */
    @POST
    @Path("/getProductInfo")
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
	 * @RestRelativeURL marktableproduct/getProductInfoByProductIdList
	 */
	@POST
    @Path("/getProductInfoByProductIdList")
	PageInfo<ProductInfo> getProductInfoByProductIdList(ProductQueryByIdListVO vo) throws BusinessException, SystemException;
	@interface getProductInfoByProductIdList{}
}
