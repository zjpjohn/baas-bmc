package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryByIdListVO;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryParam;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedVO;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
/**
 * 信息资费
 *
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface ICpPriceInfoAtom {
	
	Long addCpPriceInfo(CpPriceInfo info);
	
	int delCpRpriceInfo(CpPriceInfo info);
	
	List<CpPriceInfo> getCpPriceInfo(ProductQueryVO vo);
	
	CpPriceInfo getCpPriceInfo(ProductQueryParam param);
	
	CpPriceInfo getCpPriceInfo(RelatedVO vo);
	
	void updatePriceInfo(CpPriceInfo info);
	/**
	 * 通过priceCode修改信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	void updatePriceInfoByPriceCode(CpPriceInfo info);
	/**
	 * 通过priceCode删除信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	void deletePriceInfoByPriceCode(CpPriceInfo info);
	/**
	 * 根据priceCode查询信息
	 * @param info
	 * @return
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	CpPriceInfo getCpPriceInfoByPriceCode(CpPriceInfo info);
	/**
	 * 修改产品状态根据priceCode
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	void updateProductStatus(CpPriceInfo info);
	
	/**
	 * 根据priceCode进行模糊查询
	 * @param info
	 * @return
	 * @author wangkai16
	 * @ApiCode
	 */
	List<CpPriceInfo> getCpPriceInfoByPriceCodeLike(QueryInfoParams record );
	
	List<CpPriceInfo> getActiveProduct(ProductQueryByIdListVO vo);
	
}
