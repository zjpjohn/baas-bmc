package com.ai.baas.bmc.api.proferentialprocuct.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.proferentialprocuct.params.ActiveProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedAccountVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.productDelVO;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

/**
 * 优惠产品管理
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
@Path("/proferentialproduct")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IProferProductManageSV {

	/**
	 * 添加优惠产品(满赠)
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00007
	 * @RestRelativeURL proferentialproduct/addProferProduct
	 */
    @POST
    @Path("/addProferProduct")
	ProductResponse addProferProduct(ProferProductVO vo) throws BusinessException, SystemException;
	@interface AddProferProduct{}
	/**
	 * 添加优惠产品(满减)
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00014
	 * @RestRelativeURL proferentialproduct/addDiscontProduct
	 */
	@POST
    @Path("/addDiscontProduct")
	ProductResponse addDiscontProduct(ProferProductVO vo)throws BusinessException, SystemException;
	@interface AddDiscontProduct{}
	
	/**
	 * 状态管理
	 * @param vo
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00009
	 * @RestRelativeURL proferentialproduct/updateProferProductStatus
	 */
	@POST
    @Path("/updateProferProductStatus")
	BaseResponse updateProferProductStatus(ActiveProductVO vo) throws BusinessException, SystemException;
	@interface UpdateProferProductStatus{}
	
	/**
	 * 删除优惠产品
	 * @param vo
	 * @author gaogang
	 * @throws BusinessException
	 * @throws SystemException
	 * @ApiDocMethod
	 * @ApiCode bmc-00010
	 * @RestRelativeURL proferentialproduct/delProferProduct
	 */
	@POST
    @Path("/delProferProduct")
	BaseResponse delProferProduct(productDelVO vo) throws BusinessException, SystemException;
	@interface DelProferProduct{}
	/**
	 * 更新优惠产品
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00013
	 * @RestRelativeURL proferentialproduct/updateProferProduct
	 */
	@POST
    @Path("/updateProferProduct")
	BaseResponse updateProferProduct(ProferProductVO vo) throws BusinessException, SystemException;
	@interface UpdateProferProduct{}
	
	/**
	 * 关联费用科目
	 * @param vo
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode
	 * @RestRelativeURL proferentialproduct/relatedAccout
	 */
	@POST
    @Path("/relatedAccout")
	BaseResponse relatedAccout(RelatedAccountVO vo) throws BusinessException, SystemException;
	
}
