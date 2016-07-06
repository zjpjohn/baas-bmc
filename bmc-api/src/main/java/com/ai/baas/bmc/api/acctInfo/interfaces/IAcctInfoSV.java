package com.ai.baas.bmc.api.acctInfo.interfaces;

import com.ai.baas.bmc.api.acctInfo.params.AcctInfoParams;
import com.ai.baas.bmc.api.acctInfo.params.AcctQueryRequest;
import com.ai.baas.bmc.api.acctInfo.params.ResponseMessage;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;

/**
 * 账户查询服务
 *
 * Date: 2016年7月4日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author luoxuan
 */
public interface IAcctInfoSV {
	/**
	 * 分页查询账户信息
	 * @param vo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author luoxuan
	 * @ApiDocMethod
	 * @ApiCode
	 */
	ResponseMessage getAcctInfo(AcctQueryRequest acctQueryRequest) throws BusinessException, SystemException;
	@interface getAcctInfo{}

}
