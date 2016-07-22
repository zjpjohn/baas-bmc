package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.queryidinfo.params.BlAcctInfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.BlCustinfoInfo;
import com.ai.baas.bmc.api.queryidinfo.params.CustIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.ExtCustIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.OwnerIDInfo;

public interface IQueryIdInfoAtomSV {
    /**
     * 根据外部客户id(ExtCustId)查询BlCustinfo<br>
     * 
     * @param extCustIdInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    List<BlCustinfoInfo> queryBlCustinfo(ExtCustIdInfo extCustIdInfo);

    /**
     * 根据ownerId查询 BlAcctInfo<br>
     * 
     * @param ownerIDInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    List<BlAcctInfoInfo> queryBlAcctInfo(OwnerIDInfo ownerIDInfo);
    
    /**
     * 根据客户id(ustId)查询BlCustinfo<br>
     * 
     * @param extCustIdInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     */
    List<BlCustinfoInfo> queryBlCustinfoByCustId(CustIdInfo custIdInfo);

}
