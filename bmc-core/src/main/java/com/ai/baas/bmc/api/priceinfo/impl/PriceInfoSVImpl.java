package com.ai.baas.bmc.api.priceinfo.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.ResponseMessage;
import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.baas.bmc.business.interfaces.IGetPriceInfoBussiness;
import com.ai.baas.bmc.business.interfaces.IUpdatePriceInfoBussiness;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.StringUtil;

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
    public String updatePriceInfo(StandardPriceInfoParams record)
            throws BusinessException, SystemException {
        //幂等性判断（判重）
        try {
            if(aIUpdatePriceInfoBussiness.dupCheck(record)){
                return "tradeSeq已存在";
            }
        } catch (IOException e) {
            LoggerUtil.log.error(e);
            return "幂等性判断判断失败请联系管理员";
        }
        if (("UPDATE".equals(record.getUpdateId()) || "UPDATE".equals(record.getUpdateId()))
                && StringUtil.isBlank(record.getStandardId())) {
            return "删除或更新时updateId不能为0";
        }
        aIUpdatePriceInfoBussiness.writeData(record);
        return "BMC-000000";
    }

}
