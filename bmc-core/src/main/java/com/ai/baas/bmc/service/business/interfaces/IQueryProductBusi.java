package com.ai.baas.bmc.service.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.marktableproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryByIdListVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryVO;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.opt.base.vo.PageInfo;

public interface IQueryProductBusi {
	public PageInfo<ProductInfo> Product(ProductQueryVO vo);
	public PageInfo<ProductInfo> getProductInfoByProductIdList(ProductQueryByIdListVO vo);
}
