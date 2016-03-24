package com.ai.baas.bmc.business.impl;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.business.interfaces.IOrderinfoBusiness;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.dao.interfaces.BlUserinfoMapper;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.DubboConsumerFactory;
import com.ai.runner.center.dshm.api.dshmprocess.interfaces.IdshmSV;

@Service
@Transactional
public class OrderinfoBusinessImpl implements IOrderinfoBusiness{
    @Autowired
    BlUserinfoMapper aBlUserinfoMapper;
    
    //远程调用缓存接口
    private IdshmSV dshmSV = DubboConsumerFactory.getService("IdshmSV", IdshmSV.class);
    
    @Override
    public boolean hasSeq(OrderInfoParams record) throws IOException {
        String rowkey = record.getTradeSeq();
        Table table = MyHbaseUtil.getTable("BMC_TRADE_SEQ_LOG");
        
        if(MyHbaseUtil.hasExists(table, rowkey)){
            return true;
        }
        MyHbaseUtil.addData(table, rowkey, 
                CellTemp.inst("TENANT_ID", record.getTenantId()),
                CellTemp.inst("INTERFACE_CODE", Context.ORDER_INFO_CODE),
                CellTemp.inst("TRADE_SEQ", record.getTradeSeq()),
                CellTemp.inst("RECEIVE_TIME", DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS)),
                CellTemp.inst("MSG_CONTENT", MyJsonUtil.toJson(record)));
        return false;
    }

    @Override
    public void writeData(OrderInfoParams record) {
    }
    
    //用户信息表操作
    private void writeBlUserinfo(OrderInfoParams record){
//        BlUserinfo blUserinfo = new BlUserinfo();
//        blUserinfo.setCustId(record.getExtCustId());
//        blUserinfo.setUserType(record.getUsetype());
////        blUserinfo.setServType(record.getServiceId());
//        blUserinfo.setUserState(record.getState());
//        blUserinfo.setServiceNum(record.getServiceId());
//        if(!StringUtil.isBlank(record.getOrderTime())){
//            blUserinfo.setJoinTime(DateUtil.getTimestamp(record.getOrderTime(), DateUtil.YYYYMMDDHHMMSS));
//        }
//        blUserinfo.setProvinceCode(record.getProvinceCode());
//        blUserinfo.setCityCode(record.getCityCode());
//        blUserinfo.setChlId(record.getChlId());
//        blUserinfo.setDevId(record.getDevId());
//        blUserinfo.setActiveTime(DateUtil.getTimestamp(record.getActiveTime(), DateUtil.YYYYMMDDHHMMSS));
//        blUserinfo.setInactiveTime(DateUtil.getTimestamp(record.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS));
//        blUserinfo.setTenantId(record.getTenantId());
//        blUserinfo.setRemark(record.getRemark());
        
    }
    
    //用户扩展信息表操作
    private void writeBlUserinfoExt(){
        
    }
    
    //写入
    
}
