package com.ai.baas.bmc.api.feeReBatch.params;

import com.ai.opt.base.vo.BaseResponse;

public class FeeParamResponse extends BaseResponse{

	private FeeParam feeParam;

	public FeeParam getFeeParam() {
		return feeParam;
	}

	public void setFeeParam(FeeParam feeParam) {
		this.feeParam = feeParam;
	}
}
