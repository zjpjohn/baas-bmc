package com.ai.baas.bmc.business.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpFullReduce;

public interface ICpFullReduceBusi {

	/**
	 * 满减数据添加
	 * @param present
	 * @return
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode 
	 */
	Integer add(CpFullReduce present);
}
