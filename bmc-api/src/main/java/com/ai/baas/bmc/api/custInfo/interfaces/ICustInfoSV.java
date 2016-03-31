package com.ai.baas.bmc.api.custInfo.interfaces;

import com.ai.baas.bmc.api.custInfo.params.CustInfoParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;


/**
 * 客户信息dubbo服务<br>
 * Date: 2016年3月15日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangzhi
 */ 
public interface ICustInfoSV {

	
	/**
     * 将客户信息基础资料同步插入到计费域对应的表中
     *
     * @return BaaS-000000成功；其他失败
     * @throws BusinessException
     * @throws SystemException
     * @author wangzhi 
     * @ApiCode BaaS-0001
     * @param cust java beans 对象
     */
	@interface CustNotify{}
	public String custNotify(CustInfoParams custInfo)throws BusinessException, SystemException;

}
