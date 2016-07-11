package com.ai.baas.bmc.service.business.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;

public interface ICpStepInfoBusi {
	/**
	 * 通过detailCode修改信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateCpStepInfoByDetailCode(CpStepInfo info);
	/**
	 * 通过detailCode删除信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void deleteCpStepInfoByDetailCode(CpStepInfo info);
	/**
	 * 通过detailCode查询单条信息
	 * @param info
	 * @return
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public CpStepInfo getCpStepInfoByDetailCode(CpStepInfo info);
	/**
	 * 添加cpstepinfo信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void addCpStepInfo(CpStepInfo info);
}
