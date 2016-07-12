package com.ai.baas.bmc.api.proferentialprocuct.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryParam;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.SingleProductInfo;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

/**
 * 优惠产品查询
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
@Path("/QueryProferProduct")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
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
	 * @RestRelativeURL QueryProferProduct/getProductInfo
	 */
    @POST
    @Path("/getProductInfo")
	ProferProductResponse getProductInfo(ProductQueryVO vo) throws BusinessException, SystemException;
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
	 * @RestRelativeURL QueryProferProduct/getProductById
	 */
	@POST
    @Path("/getProductById")
	SingleProductInfo  getProductById(ProductQueryParam param) throws BusinessException, SystemException;	
	@interface GetProductById{}
	/**
	 * 查询关联费用
	 * @param vo
	 * @return
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode
	 * @RestRelativeURL QueryProferProduct/getRelatedAccount
	 */
	@POST
    @Path("/getRelatedAccount")
	RelatedResponse getRelatedAccount(RelatedVO vo);
	@interface GetRelatedAccount{}
	
	
}
