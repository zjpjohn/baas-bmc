package com.ai.baas.bmc.api.custInfo.params;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
/**
 * 分页返回信息
 *
 * Date: 2016年5月11日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class CustInfoResponse extends BaseResponse {

	
	private static final long serialVersionUID = 1L;

	private PageInfo<CustInfo> pageInfo;

	public PageInfo<CustInfo> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<CustInfo> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	
}
