package com.ai.baas.bmc.api.failedbillmaintain.iml;

import com.ai.baas.bmc.api.failedbillmaintain.interfaces.IFailedBillMaintainSV;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBill;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillCriteria;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillParam;
import com.ai.baas.bmc.business.interfaces.IFailedBillMaintainBusi;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.HBasePager;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xin on 16-4-11.
 */
@Service
@Component
public class FailedBillMaintainSVImpl implements IFailedBillMaintainSV {

    @Autowired
    private IFailedBillMaintainBusi failedBillMaintainBusi;

    @Override
    public HBasePager<FailedBill> queryFailedBills(FailedBillCriteria criteria) {
        HBasePager<FailedBill> hBasePager = criteria.getPager();
        try {
            if (hBasePager == null) {
                hBasePager = new HBasePager<FailedBill>();
            }
            List<FailedBill> result = failedBillMaintainBusi.queryFailedBills(criteria);
            hBasePager.setResult(result);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new SystemException("查询错单出错", e);
        }

        return hBasePager;
    }

    @Override
    public FailedBill queryFailedBillsById(FailedBillParam param) {
        try {
            param.validate();
            return failedBillMaintainBusi.queryFailedBillById(param.buildFailedBillRowKey());
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new SystemException("查询单条错单出错", e);
        }
    }

    @Override
    public void resendFailedBill(FailedBillParam param) {
        try {
            param.validate();
            failedBillMaintainBusi.doResendFailedBill(param);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new SystemException("重发单条错单出错", e);
        }
    }
}
