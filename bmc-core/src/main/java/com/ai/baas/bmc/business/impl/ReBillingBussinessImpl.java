package com.ai.baas.bmc.business.impl;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.baas.bmc.business.interfaces.IReBillingBussiness;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

public class ReBillingBussinessImpl implements IReBillingBussiness {

    @Override
    public long reBilling(ReBillingParam param) throws BusinessException, SystemException {
        return 0;
    }

}
