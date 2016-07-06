package com.ai.baas.bmc.api.proferentialprocuct.params;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class ProferProductResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1L;
	
	private PageInfo<ProferProductInfo> pageInfo;

	public PageInfo<ProferProductInfo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<ProferProductInfo> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
}
