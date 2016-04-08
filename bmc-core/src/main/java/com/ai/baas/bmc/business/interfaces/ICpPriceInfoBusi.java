package com.ai.baas.bmc.business.interfaces;

import java.util.List;

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
public interface ICpPriceInfoBusi {
	
	Long addCpPriceInfo(CpPriceInfo info);
	
	void delCpRpriceInfo(CpPriceInfo info);
	
	List<CpPriceInfo> getCpPriceInfo(ProductQueryVO vo);
	
	CpPriceInfo getCpPriceInfo(ProductQueryParam param);
	
	CpPriceInfo getCpPriceInfo(RelatedVO vo);
	
	void updatePriceInfo(CpPriceInfo info);
	
}
