package com.ai.baas.bmc.api.queryidinfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.queryidinfo.params.AcctIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.BlAcctInfoResponse;
import com.ai.baas.bmc.api.queryidinfo.params.BlCustinfoResponse;
import com.ai.baas.bmc.api.queryidinfo.params.ExtCustIdInfo;
import com.ai.baas.bmc.api.queryidinfo.params.OwnerIDInfo;

/**
 * Date: 2016年7月7日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangjl9
 */
@Path("/queryIdInfo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IQueryIdInfoSV {

    /**
     * 根据外部客户id(ExtCustId)查询BlCustinfo<br>
     * 
     * @param extCustIdInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL queryIdInfo/queryBlCustinfo
     */
    @POST
    @Path("/queryBlCustinfo")
    BlCustinfoResponse queryBlCustinfo(ExtCustIdInfo extCustIdInfo);

    /**
     * 根据ownerId查询 BlAcctInfo<br>
     * 
     * @param ownerIDInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL queryIdInfo/queryBlAcctInfo
     */
    @POST
    @Path("/queryBlAcctInfo")
    BlAcctInfoResponse queryBlAcctInfo(OwnerIDInfo ownerIDInfo);

    /**
     * 根据外部客户id查询账户ID<br>
     * 
     * @param extCustIdInfo
     * @return
     * @author wangjl9
     * @ApiCode
     * @ApiDocMethod
     * @RestRelativeURL queryIdInfo/queryAcctIdByExtCustId
     */
    @POST
    @Path("/queryAcctIdByExtCustId")
    BlAcctInfoResponse queryAcctIdByExtCustId(ExtCustIdInfo extCustIdInfo);

    /**
     * 根据账户id查询外部客户id<br>
     * 
     * @param acctIdInfo
     * @return
     * @author wangjl9
     * @ApiDocMethod
     * @RestRelativeURL queryIdInfo/queryExtCustIdByAcctId
     */
    @POST
    @Path("/queryExtCustIdByAcctId")
    BlCustinfoResponse queryExtCustIdByAcctId(AcctIdInfo acctIdInfo);

}
