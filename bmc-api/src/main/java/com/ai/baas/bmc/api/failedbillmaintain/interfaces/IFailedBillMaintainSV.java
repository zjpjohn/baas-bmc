package com.ai.baas.bmc.api.failedbillmaintain.interfaces;

import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBill;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillCriteria;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillParam;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.HBasePager;

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
    HBasePager<FailedBill> queryFailedBills(FailedBillCriteria criteria);

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
    FailedBill queryFailedBillsById(FailedBillParam param);


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
    void resendFailedBill(FailedBillParam param);
}
