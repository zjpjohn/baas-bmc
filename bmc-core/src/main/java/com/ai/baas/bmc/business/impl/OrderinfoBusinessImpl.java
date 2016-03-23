package com.ai.baas.bmc.business.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.business.interfaces.IOrderinfoBusiness;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.sdk.util.DateUtil;

@Service
@Transactional
public class OrderinfoBusinessImpl implements IOrderinfoBusiness{

    @Override
    public boolean hasSeq(String seq) throws IOException {
        return MyHbaseUtil.hasExists(MyHbaseUtil.getTable("BMC_TRADE_SEQ_LOG"), seq);
    }

    @Override
    public void writeHbase(OrderInfoParams record)throws IOException {
        String rowkey = record.getTradeSeq();
        MyHbaseUtil.addData(MyHbaseUtil.getTable("BMC_TRADE_SEQ_LOG"), rowkey, 
                CellTemp.inst("TENANT_ID", record.getTenantId()),
                CellTemp.inst("INTERFACE_CODE", Context.ORDER_INFO_CODE),
                CellTemp.inst("TRADE_SEQ", record.getTradeSeq()),
                CellTemp.inst("RECEIVE_TIME", DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS)),
                CellTemp.inst("MSG_CONTENT", MyJsonUtil.toJson(record)));
    }

    @Override
    public void writeData(OrderInfoParams record) {
    }

}
