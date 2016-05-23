package com.ai.baas.bmc.api.businessdatamaintain.interfaces;

import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryRequest;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryResponse;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

import java.util.List;

/**
 * 计费业务数据格式维护
 *
 * Date: 2016年5月23日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author wangyx13
 */
public interface IBillingBusinessDataMaintainSV {

    /**
     * 计费业务数据格式导入
     * @param importData
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author wangyx13
     * @ApiDocMethod
     * @ApiCode
     */
    BaseResponse businessDataImport(List<BmcRecord> importData) throws BusinessException,SystemException;
    @interface BusinessDataImport{}

    /**
     * 计费业务数据格式查询
     * @param businessDataQueryRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author wangyx13
     * @ApiDocMethod
     * @ApiCode
     */
    BusinessDataQueryResponse getDataFormatList(BusinessDataQueryRequest businessDataQueryRequest) throws BusinessException,SystemException;
    @interface GetDataFormatList{}

}
