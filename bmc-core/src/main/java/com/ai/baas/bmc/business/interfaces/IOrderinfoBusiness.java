package com.ai.baas.bmc.business.interfaces;

import java.io.IOException;

import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;

/**
 * 订购信息的业务逻辑<br>
 * Date: 2016年3月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public interface IOrderinfoBusiness {
    /**
     * 消息流水幂等性判断
     */
    public boolean hasSeq(String seq) throws IOException;

    /**
     * 写入hbase表
     */
    public void writeHbase(OrderInfoParams record) throws IOException;

    /**
     * 写入mysql表
     */
    public void writeData(OrderInfoParams record);
}
