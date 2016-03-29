package com.ai.baas.bmc.api.billmanage.interfaces;

import com.ai.baas.bmc.api.billmanage.params.BillInfoResponse;
import com.ai.baas.bmc.api.billmanage.params.BillQueryVO;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;

/**
 * 账单科目查询
 *
 * Date: 2016年3月29日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface IBillQuerySV {

	/**
	 * 账单科目查询
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode bmc-00015
	 */
	PageInfo<BillInfoResponse> queryBillList(BillQueryVO vo)throws BusinessException,SystemException;;
}
