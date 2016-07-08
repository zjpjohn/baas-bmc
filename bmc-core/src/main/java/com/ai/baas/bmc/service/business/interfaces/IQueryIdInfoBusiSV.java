package com.ai.baas.bmc.service.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.queryidinfo.params.BlAcctInfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.ExtCustIdInfo;

public interface IQueryIdInfoBusiSV {

    /**
     * 根据外部客户id查询账户id<br>
     * 
     * @param extCustIdInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    List<BlAcctInfoInfo> queryAcctIdByExtCustId(ExtCustIdInfo extCustIdInfo);
}
