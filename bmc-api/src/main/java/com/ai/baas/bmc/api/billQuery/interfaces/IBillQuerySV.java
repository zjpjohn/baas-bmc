package com.ai.baas.bmc.api.billQuery.interfaces;

import com.ai.baas.bmc.api.billQuery.params.BillInfo;
import com.ai.baas.bmc.api.billQuery.params.BillQueryParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

public interface IBillQuerySV {
    @interface GetBillInfo{}
    /**
     * 账单查询接口
     * @param BillQueryParams
     * @return BaaS-000000成功；其他失败
     * @throws BusinessException
     * @throws SystemException
     * @author wangkai16
     * @ApiCode
     */
    public BillInfo getBillInfo (BillQueryParams record)throws BusinessException,SystemException;
}
