package com.ai.baas.bmc.api.priceinfo.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.ResponseMessage;
import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.StanderdPriceInfoUsage;
import com.ai.baas.bmc.service.business.interfaces.IGetPriceInfoBussiness;
import com.ai.baas.bmc.service.business.interfaces.IUpdatePriceInfoBussiness;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service(validation = "true")
public class PriceInfoSVImpl implements IPriceInfoSV {

    @Autowired
    private IGetPriceInfoBussiness IGetPriceInfoBussiness;

    @Autowired
    private IUpdatePriceInfoBussiness aIUpdatePriceInfoBussiness;

    @Override
    public ResponseMessage getPriceInfo(QueryInfoParams record)
            throws BusinessException, SystemException {
        return IGetPriceInfoBussiness.getPriceInfo(record);
    }

    @Override
    public BaseResponse updatePriceInfo(StandardPriceInfoParams record)
            throws BusinessException, SystemException {
        BaseResponse result = new BaseResponse();
        // 幂等性判断（判重）
        try {
            if (aIUpdatePriceInfoBussiness.dupCheck(record)) {
                result.setResponseHeader(new ResponseHeader(false, "000001", "tradeSeq已存在"));
                return result;
            }
        } catch (IOException e) {
            LoggerUtil.log.error(e);
            result.setResponseHeader(new ResponseHeader(false, "000001", "幂等性判断判断失败请联系管理员"));
            return result;
        }
        if(StringUtil.isBlank(record.getTenantId())){
            result.setResponseHeader(new ResponseHeader(false, "000001", "租户ID为空，更新失败"));
            return result;
        }
        List<StanderdPriceInfoUsage> standerdPriceInfoUsageList = record.getUsageList();
        if(standerdPriceInfoUsageList.size()== 0 ){
            result.setResponseHeader(new ResponseHeader(false, "000001", "usageList为空，更新失败"));
            return result;
        }
        if (("UPDATE".equals(record.getUpdateId()))&& StringUtil.isBlank(record.getStandardId())) {
            result.setResponseHeader(new ResponseHeader(false, "000001", "更新时StandarId不能为空"));
            return result;
        }
        aIUpdatePriceInfoBussiness.writeData(record);
        result.setResponseHeader(new ResponseHeader(true, "BMC-000000", "成功"));
        return result;
    }

    @Override
    public BaseResponse deletePriceInfo(StandardPriceInfoParams record) throws BusinessException, SystemException {
        BaseResponse result = new BaseResponse();
        if (("UPDATE".equals(record.getUpdateId()) || "DELETE".equals(record.getUpdateId()))&&StringUtil.isBlank(record.getStandardId())) {
            result.setResponseHeader(new ResponseHeader(false, "000001", "删除和更改状态字段时StandarId不能为空"));
            return result;
        }
        aIUpdatePriceInfoBussiness.deleteData(record);
        result.setResponseHeader(new ResponseHeader(true, "BMC-000000", "成功"));
        return result;
    }

}
