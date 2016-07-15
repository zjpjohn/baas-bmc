package com.ai.baas.bmc.api.acctinfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.acctinfo.params.AcctInfoParams;
import com.ai.baas.bmc.api.acctinfo.params.AcctQueryRequest;
import com.ai.baas.bmc.api.acctinfo.params.ResponseMessage;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;

/**
 * 账户查询服务
 * 
 * Date: 2016年7月4日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author luoxuan
 */
@Path("/acctinfo")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IAcctInfoSV {
    /**
     * 分页查询账户信息
     * 
     * @param acctQueryRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author luoxuan
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL acctinfo/getAcctInfo
     */
    @POST
    @Path("/getAcctInfo")
    ResponseMessage getAcctInfo(AcctQueryRequest acctQueryRequest) throws BusinessException,
            SystemException;

    @interface getAcctInfo {
    }

}
