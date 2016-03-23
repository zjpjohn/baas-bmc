package com.ai.baas.bmc.business.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.business.interfaces.IOrderinfoBusiness;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;

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
                CellTemp.inst("", "", ""));
    }

    @Override
    public void writeData(OrderInfoParams record) {
    }

}
