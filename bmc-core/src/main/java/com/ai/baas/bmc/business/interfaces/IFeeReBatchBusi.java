package com.ai.baas.bmc.business.interfaces;

import java.io.IOException;
import java.util.List;

import com.ai.baas.bmc.api.feeReBatch.params.FeeParam;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchCriteria;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchParam;

/**
 * 
 * @author wangluyang
 *
 */
public interface IFeeReBatchBusi {

	List<FeeParam> queryFeeReBatch(FeeReBatchCriteria criteria) throws IOException, IllegalArgumentException, IllegalAccessException;
	void batchResendFee(FeeReBatchParam param) throws IOException, IllegalArgumentException, IllegalAccessException;
}
