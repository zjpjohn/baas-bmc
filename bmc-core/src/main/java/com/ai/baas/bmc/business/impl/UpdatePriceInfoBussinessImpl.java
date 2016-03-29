package com.ai.baas.bmc.business.impl;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Table;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.baas.bmc.business.interfaces.IUpdatePriceInfoBussiness;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.context.TableCon;
import com.ai.baas.bmc.context.TableCon.ConTradeSeqLog;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.sdk.util.DateUtil;

@Service
@Transactional
public class UpdatePriceInfoBussinessImpl implements IUpdatePriceInfoBussiness {

    @Override
    public boolean dupCheck(StandardPriceInfoParams param) throws IOException {
        String rowkey = param.getTenantId() + Context.SPLIT + Context.UPDATE_PRICEINFO
                + Context.SPLIT + param.getTradeSeq();
        Table table = MyHbaseUtil.getTable(TableCon.TRADE_SEQ_LOG);
        if (MyHbaseUtil.hasExists(table, rowkey)) {
            return true;
        }
        MyHbaseUtil.addData(table, rowkey,
                CellTemp.inst(ConTradeSeqLog.TENANT_ID, param.getTenantId()),
                CellTemp.inst(ConTradeSeqLog.INTERFACE_CODE, Context.UPDATE_PRICEINFO),
                CellTemp.inst(ConTradeSeqLog.TRADE_SEQ, param.getTradeSeq()),
                CellTemp.inst(ConTradeSeqLog.RECEIVE_TIME,
                        DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS)),
                CellTemp.inst(ConTradeSeqLog.MSG_CONTENT, MyJsonUtil.toJson(param)));
        return false;
    }

    @Override
    public void writeData(StandardPriceInfoParams param) {
        
    }

}
