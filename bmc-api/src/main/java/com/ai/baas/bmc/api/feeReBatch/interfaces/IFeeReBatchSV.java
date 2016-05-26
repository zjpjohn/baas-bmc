package com.ai.baas.bmc.api.feeReBatch.interfaces;

import com.ai.baas.bmc.api.feeReBatch.params.FeeParamPagerResponse;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchCriteria;
import com.ai.baas.bmc.api.feeReBatch.params.FeeReBatchParam;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

/**
 * 费用重批相关服务
 * @author wangluyang
 *
 */
public interface IFeeReBatchSV {

	/**
     * 查询费用
     *
     * @param criteria
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author wangly8
     * @ApiDocMethod
     * @ApiCode bmc-feerebatch-0001
     */
	FeeParamPagerResponse queryFeeReBatch(FeeReBatchCriteria criteria);

    /**
     * 费用重批
     *
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author wangly8
     * @ApiDocMethod
     * @ApiCode bmc-feerebatch-00002
     */
    BaseResponse batchResendFee(FeeReBatchParam param);
}
