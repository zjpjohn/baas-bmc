package com.ai.baas.bmc.api.orderinfo.interfaces;

import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

/**
 * 订购信息接口<br>
 * Date: 2016年3月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public interface IOrderInfoSV {
    @interface OrderInfo{}
    /**
     * 订购信息接口 
     * @param OrderInfoParams
     * @return BaaS-000000成功；其他失败
     * @author caoyf
     * @ApiCode BaaS-0002
     */
    public String orderInfo(OrderInfoParams record) throws BusinessException,SystemException;
}
