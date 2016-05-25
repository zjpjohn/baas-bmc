package com.ai.baas.bmc.api.feeReBatch.params;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.HBasePager;

/**
 * 分页
 * @author wangluyang
 *
 */
public class FeeParamPagerResponse extends BaseResponse{

	private HBasePager<FeeParam> FeeParamPager;

	public HBasePager<FeeParam> getFeeParamPager() {
		return FeeParamPager;
	}

	public void setFeeParamPager(HBasePager<FeeParam> feeParamPager) {
		FeeParamPager = feeParamPager;
	}
}
