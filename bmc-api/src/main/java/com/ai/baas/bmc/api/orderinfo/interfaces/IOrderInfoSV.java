package com.ai.baas.bmc.api.orderinfo.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;

/**
 * 订购信息接口<br>
 * Date: 2016年3月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
@Path("/orderinfo")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderInfoSV {

    /**
     * 订购信息接口
     * 
     * @param OrderInfoParams
     * @return BaaS-000000成功；其他失败
     * @author caoyf
     * @ApiCode BaaS-0002
     * @RestRelativeURL orderinfo/orderInfo
     */
    @Path("/orderinfo/orderInfo")
    @POST
    public BaseResponse orderInfo(OrderInfoParams request) throws BusinessException,
            SystemException;

    @interface OrderInfo {
    }
}
