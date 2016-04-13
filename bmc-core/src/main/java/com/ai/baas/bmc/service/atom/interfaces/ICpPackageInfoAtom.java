package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;

/**
 * 组合套餐类型接口
 *
 * Date: 2016年4月10日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
public interface ICpPackageInfoAtom {
	/**
	 * 通过detailCode修改信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateCpPackageInfoByDetailCode(CpPackageInfo info);
	/**
	 * 通过detailCode删除信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void deleteCpPackageInfoByDetailCode(CpPackageInfo info);
	/**
	 * 通过detailCode查询信息
	 * @param info
	 * @return
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public List<CpPackageInfo> getCpPackageInfoByDetailCode(CpPackageInfo info);
	/**
	 * 添加cppackageinfo信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void addCpPackageInfo(CpPackageInfo info);
}
