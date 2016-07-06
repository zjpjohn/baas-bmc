package com.ai.baas.bmc.api.failedbillmaintain.iml;

import com.ai.baas.bmc.api.failedbillmaintain.interfaces.IFailedBillMaintainSV;
import com.ai.baas.bmc.api.failedbillmaintain.params.*;
import com.ai.baas.bmc.business.interfaces.IFailedBillMaintainBusi;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.HBasePager;
import com.ai.opt.base.vo.ResponseHeader;
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
    public FailedBillPagerResponse queryFailedBills(FailedBillCriteria criteria) {
        FailedBillPagerResponse response = new FailedBillPagerResponse();
        HBasePager<FailedBill> hBasePager = criteria.getPager();
        ResponseHeader header = new ResponseHeader(true, "000000", "Success");
        try {
            if (hBasePager == null) {
                hBasePager = new HBasePager<FailedBill>();
            }
            List<FailedBill> result = failedBillMaintainBusi.queryFailedBills(criteria);
            hBasePager.setResult(result);
            response.setBillHBasePager(hBasePager);
        } catch (BusinessException e) {
            header.setResultCode("000001");
            header.setIsSuccess(false);
            header.setResultMessage(e.getMessage());
        } catch (Exception e) {
            throw new SystemException("查询错单出错", e);
        }
        response.setResponseHeader(header);
        return response;
    }

    @Override
    public FailedBillResponse queryFailedBillsById(FailedBillParam param) {
        FailedBillResponse response = new FailedBillResponse();
        FailedBill failedBill = null;
        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "Success");
        try {
            param.validate();
            failedBill = failedBillMaintainBusi.queryFailedBillById(param.buildFailedBillRowKey());
            response.setFailedBill(failedBill);
        } catch (BusinessException e) {
            responseHeader.setResultCode("000001");
            responseHeader.setIsSuccess(false);
            responseHeader.setResultMessage(e.getMessage());
        } catch (Exception e) {
            throw new SystemException("查询单条错单出错", e);
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public BaseResponse resendFailedBill(FailedBillParam param) {
        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "Success");
        try {
            param.validate();
            failedBillMaintainBusi.doResendFailedBill(param);
        } catch (BusinessException e) {
            responseHeader.setResultCode("000001");
            responseHeader.setIsSuccess(false);
            responseHeader.setResultMessage(e.getMessage());
        } catch (Exception e) {
            throw new SystemException("重发单条错单出错", e);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
    }

    @Override
    public BaseResponse batchResendFailedBill(List<FailedBillParam> params) {
        ResponseHeader responseHeader = new ResponseHeader(true, "000000", "Success");
        try {
            failedBillMaintainBusi.batchResendFailedBill(params);
        } catch (BusinessException e) {
            responseHeader.setResultCode("000001");
            responseHeader.setIsSuccess(false);
            responseHeader.setResultMessage(e.getMessage());
        } catch (Exception e) {
            throw new SystemException("重发单条错单出错", e);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
    }
}
