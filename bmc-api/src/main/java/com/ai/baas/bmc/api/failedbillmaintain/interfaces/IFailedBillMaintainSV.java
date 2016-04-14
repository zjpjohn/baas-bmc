package com.ai.baas.bmc.api.failedbillmaintain.interfaces;

import com.ai.baas.bmc.api.failedbillmaintain.params.*;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

import java.util.List;

/**
 * Created by xin on 16-4-11.
 */
public interface IFailedBillMaintainSV {

    /**
     * 查询错单
     *
     * @param criteria
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxin
     * @ApiDocMethod
     * @ApiCode bmc-failedbill-00001
     */
    FailedBillPagerResponse queryFailedBills(FailedBillCriteria criteria);

    /**
     * 查询单个错单
     *
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxin
     * @ApiDocMethod
     * @ApiCode bmc-failedbill-00002
     */
    FailedBillResponse queryFailedBillsById(FailedBillParam param);


    /**
     * 重发单个错单
     *
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxin
     * @ApiDocMethod
     * @ApiCode bmc-failedbill-00003
     */
    BaseResponse resendFailedBill(FailedBillParam param);


    /**
     * 批量重发错单
     *
     * @param params
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhangxin
     * @ApiDocMethod
     * @ApiCode bmc-failedbill-00003
     */
    BaseResponse batchResendFailedBill(List<FailedBillParam> params);

}
