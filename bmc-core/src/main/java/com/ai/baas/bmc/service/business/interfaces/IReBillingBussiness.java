package com.ai.baas.bmc.service.business.interfaces;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

public interface IReBillingBussiness {
    /**
     * 重批价服务
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author LiangMeng
     * @ApiDocMethod
     * @ApiCode BMC_0028
     */
    public long reBilling (ReBillingParam param) throws BusinessException,SystemException;
}
