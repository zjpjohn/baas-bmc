package com.ai.baas.bmc.api.detailbill.interfaces;

import com.ai.baas.bmc.api.detailbill.params.DetailBillResponse;
import com.ai.baas.bmc.api.detailbill.params.QueryBillRequest;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

/**
 * 详单查询相关服务
 *
 * Date: 2016年5月20日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface IDetailBillQuerySV {

	/**
	 * 详单查询
	 * @param request
	 * @return
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public DetailBillResponse getDetailBill(QueryBillRequest request) throws BusinessException,SystemException;
	@interface GetDetailBill{}
}
