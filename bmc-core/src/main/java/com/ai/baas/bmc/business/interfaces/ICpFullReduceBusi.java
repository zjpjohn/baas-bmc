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
	
	CpFullReduce getFullReduce(String detailCode);
	
	CpFullReduce getFullReduce(Long id);
	/**
	 * 更新满减
	 * @param present
	 * @author gaogang
	 * @ApiDocMethod
	 * @ApiCode
	 */
	void updateFullReduce(CpFullReduce present);
	

}
