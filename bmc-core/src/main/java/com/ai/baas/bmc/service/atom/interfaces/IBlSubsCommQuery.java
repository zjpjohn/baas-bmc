package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.BlSubsComm;

/**
 * Date: 2016年4月28日 <br>
 * @author zhoushanbin
 * Copyright (c) 2016 asiainfo.com <br>
 */
public interface IBlSubsCommQuery {

	/**
	 * 根据入参查询记录
	 * @param param
	 * @return
	 */
	List<BlSubsComm> query(String tenantId,String subsId);
	
}
