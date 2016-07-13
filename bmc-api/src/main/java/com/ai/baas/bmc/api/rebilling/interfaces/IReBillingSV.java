package com.ai.baas.bmc.api.rebilling.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
@Path("/rebilling")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IReBillingSV {
    /**
     * 重批价服务
     * @param param
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author LiangMeng
     * @ApiDocMethod
     * @ApiCode BMC_0028
     * @RestRelativeURL rebilling/reBilling
     */
    @POST
    @Path("/reBilling")
    public BaseResponse reBilling (ReBillingParam param) throws BusinessException,SystemException;
}
