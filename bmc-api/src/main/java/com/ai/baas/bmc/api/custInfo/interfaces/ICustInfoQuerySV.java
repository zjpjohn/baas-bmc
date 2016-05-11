package com.ai.baas.bmc.api.custInfo.interfaces;

import com.ai.baas.bmc.api.custInfo.params.CustInfoResponse;
import com.ai.baas.bmc.api.custInfo.params.QueryCustInfoRequest;

/**
 * 详单查询服务
 *
 * Date: 2016年5月11日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public interface ICustInfoQuerySV {

	/**
	 * 详单查询
	 * @param param
	 * @return
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode
	 */
	CustInfoResponse getCustInfos(QueryCustInfoRequest param);
    
    
    
}
