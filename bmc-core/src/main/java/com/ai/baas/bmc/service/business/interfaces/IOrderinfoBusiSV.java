package com.ai.baas.bmc.service.business.interfaces;

import java.io.IOException;

import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;

/**
 * 订购信息的业务逻辑<br>
 * Date: 2016年3月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public interface IOrderinfoBusiSV {
    /**
     * 消息流水幂等性判断，如果没有，则插入hbase，返回false
     */
    public boolean hasSeq(OrderInfoParams request) throws IOException;

    /**
     * 写入mysql表,同时刷新内存
     */
    public void writeData(OrderInfoParams request);
}
