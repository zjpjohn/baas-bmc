package com.ai.baas.bmc.api.businessdatamaintain.impl;

import com.ai.baas.bmc.api.businessdatamaintain.interfaces.IBillingBusinessDataMaintainSV;
import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryRequest;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryResponse;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(validation="true")
@Component
public class BillingBusinessDataMaintainSVImpl implements IBillingBusinessDataMaintainSV{

    @Override
    public BaseResponse businessDataImport(List<BmcRecord> importData) throws BusinessException, SystemException {
        return null;
    }

    @Override
    public BusinessDataQueryResponse getDataFormatList(BusinessDataQueryRequest businessDataQueryRequest) throws BusinessException, SystemException {
        return null;
    }
}
