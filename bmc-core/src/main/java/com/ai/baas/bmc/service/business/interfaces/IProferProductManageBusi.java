package com.ai.baas.bmc.service.business.interfaces;

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
public interface IProferProductManageBusi {

	/**
	 * 添加优惠产品(满赠)
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00007
	 */
	ProductResponse addProferProduct(ProferProductVO vo);
	@interface AddProferProduct{}
	/**
	 * 添加优惠产品(满减)
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00014
	 */
	ProductResponse addDiscontProduct(ProferProductVO vo);
	@interface AddDiscontProduct{}
	
	/**
	 * 状态管理
	 * @param vo
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00009
	 */
	BaseResponse updateProferProductStatus(ActiveProductVO vo) ;
	@interface UpdateProferProductStatus{}
	
	/**
	 * 删除优惠产品
	 * @param vo
	 * @author gaogang
	 * @throws BusinessException
	 * @throws SystemException
	 * @ApiDocMethod
	 * @ApiCode bmc-00010
	 */
	BaseResponse delProferProduct(productDelVO vo);
	@interface DelProferProduct{}
	/**
	 * 更新优惠产品
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00013
	 */
	BaseResponse updateProferProduct(ProferProductVO vo);
	@interface UpdateProferProduct{}
	
	/**
	 * 关联费用科目
	 * @param vo
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode
	 */
	BaseResponse relatedAccout(RelatedAccountVO vo);
	
}
