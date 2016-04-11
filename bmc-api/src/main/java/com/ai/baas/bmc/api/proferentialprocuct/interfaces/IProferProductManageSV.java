package com.ai.baas.bmc.api.proferentialprocuct.interfaces;

import com.ai.baas.bmc.api.proferentialprocuct.params.ActiveProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedAccountVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.productDelVO;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

/**
 * 优惠产品管理
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
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
	 */
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
	 */
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
	 */
	void updateProferProductStatus(ActiveProductVO vo) throws BusinessException, SystemException;
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
	void delProferProduct(productDelVO vo) throws BusinessException, SystemException;
	@interface DelProferProduct{}
	/**
	 * 更新优惠产品
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00013
	 */
	void updateProferProduct(ProferProductVO vo) throws BusinessException, SystemException;
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
	void relatedAccout(RelatedAccountVO vo) throws BusinessException, SystemException;
	
}
