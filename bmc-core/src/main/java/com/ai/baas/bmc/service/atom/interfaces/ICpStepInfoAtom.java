package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;

public interface ICpStepInfoAtom {
	/**
	 * 通过detailCode修改信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateCpStepInfoByDetailCode(CpStepInfo info);
	/**
	 * 根据stepId修改信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateCpStepInfoByPrimaryKey(CpStepInfo info);
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
	public List<CpStepInfo> getCpStepInfoByDetailCode(CpStepInfo info);
	/**
	 * 添加cpstepinfo信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void addCpStepInfo(CpStepInfo info);
	/**
	 * 通过stepId修改subjectCode
	 * @param subjectCode
	 * @param stepId
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateSubjectCodeByStepId(String subjectCode,String stepId);
}
