package com.ai.baas.bmc.business.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.hbase.client.Table;
import org.apache.zookeeper.KeeperException.SystemErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.orderinfo.params.OrderExt;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.api.orderinfo.params.Product;
import com.ai.baas.bmc.api.orderinfo.params.ProductExt;
import com.ai.baas.bmc.business.interfaces.IOrderinfoBusiness;
import com.ai.baas.bmc.business.interfaces.ISysSequenceSvc;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.context.ErrorCode;
import com.ai.baas.bmc.context.TableCon;
import com.ai.baas.bmc.context.TableCon.ConTradeSeqLog;
import com.ai.baas.bmc.dao.interfaces.BlAcctInfoMapper;
import com.ai.baas.bmc.dao.interfaces.BlSubsCommMapper;
import com.ai.baas.bmc.dao.interfaces.BlSubscommExtMapper;
import com.ai.baas.bmc.dao.interfaces.BlUserinfoExtMapper;
import com.ai.baas.bmc.dao.interfaces.BlUserinfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsComm;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsCommCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BlSubscommExt;
import com.ai.baas.bmc.dao.mapper.bo.BlSubscommExtCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfoExt;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfoExtCriteria;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.KafkaUtil;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.mds.MDSClientFactory;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.paas.ipaas.mds.IMessageSender;
import com.alibaba.fastjson.JSON;

import net.sf.json.JSONObject;

@Service
@Transactional
public class OrderinfoBusinessImpl implements IOrderinfoBusiness {
    @Autowired
    private BlUserinfoMapper aBlUserinfoMapper;

    @Autowired
    private BlUserinfoExtMapper aBlUserinfoExtMapper;

    @Autowired
    private BlAcctInfoMapper aBlAcctInfoMapper;

    // @Autowired
    // private BlAcctinfoExtMapper aBlAcctinfoExtMapper;

    @Autowired
    private BlSubsCommMapper aBlSubsCommMapper;

    @Autowired
    private BlSubscommExtMapper aBlSubscommExtMapper;

    @Autowired
    private ISysSequenceSvc aISysSequenceSvc;

    @Override
    public boolean hasSeq(OrderInfoParams record) throws IOException {
        String rowkey = record.getTenantId() + Context.SPLIT + Context.ORDER_INFO_CODE
                + Context.SPLIT + record.getTradeSeq();
        Table table = MyHbaseUtil.getTable(TableCon.TRADE_SEQ_LOG);

        if (MyHbaseUtil.hasExists(table, rowkey)) {
            return true;
        }
        MyHbaseUtil.addData(table, rowkey,
                CellTemp.inst(ConTradeSeqLog.TENANT_ID, record.getTenantId()),
                CellTemp.inst(ConTradeSeqLog.INTERFACE_CODE, Context.ORDER_INFO_CODE),
                CellTemp.inst(ConTradeSeqLog.TRADE_SEQ, record.getTradeSeq()),
                CellTemp.inst(ConTradeSeqLog.RECEIVE_TIME,
                        DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS)),
                CellTemp.inst(ConTradeSeqLog.MSG_CONTENT, MyJsonUtil.toJson(record)));
        return false;
    }
    
    public boolean checkProduct (OrderInfoParams orderInfoParams){
   
        if (orderInfoParams.getProductList() != null) {
            for (Product p : orderInfoParams.getProductList()) {
                if(p.getProductType().equals("dr")){
                    //校验产品ID
                    checkDr(p.getProductId(),orderInfoParams.getTenantId());
                }
                if(p.getProductType().equals("bill")){
                    //校验 查amc_product_info表是否有这个产品ID
                    checkBill(p.getProductId(),orderInfoParams.getTenantId());
                }
            }
        }
        return true;
    }
    private void checkDr(String productId,String tenantId){
        //共享内存校验 查cp_price_info表
        Map<String, String> checkDr = new TreeMap<String, String>();
        checkDr.put("price_code", productId);
        checkDr.put("tenant_id", tenantId);
        List<Map<String, String>> bmcResult = DshmUtil.getClient().list("cp_price_info")
                .where(checkDr).executeQuery(DshmUtil.getCacheClient());
        if (bmcResult == null || bmcResult.isEmpty()) {
            throw new BusinessException("000001", "cp_price_info表中，该productId(priceCode)： "+productId+" 不存在");
        }
    }
    
    private void checkBill(String productId,String tenantId){
      //校验 查amc_product_info表
        Map<String, String> checkBill = new TreeMap<String, String>();
        checkBill.put("product_id", productId);
        checkBill.put("tenant_id", tenantId);
        List<Map<String, String>> amcResult = DshmUtil.getClient().list("amc_product_info")
                .where(checkBill).executeQuery(DshmUtil.getCacheClient());
        if (amcResult == null || amcResult.isEmpty()) {
            throw new BusinessException("000001","amc_product_info表中，该productId： "+productId+" 不存在");
        }
    }
    
    private boolean checkOnly(String productId,String productType,String tenantId,BlUserinfo BlUserinfo){
      //判断唯一，bl_subs_comm表中，productId是否存在，如果存在，existFlag=true ，update，如果不,存在 existFlag=false insert                   
        Map<String, String> checkOnly = new TreeMap<String, String>();
        checkOnly.put("product_id", productId);
        checkOnly.put("product_type",productType);
        checkOnly.put("tenant_id", tenantId);
        checkOnly.put("subs_id", BlUserinfo.getSubsId());//一个SubsId下，bill类productId必须唯一
        
        List<Map<String, String>> amcResult = DshmUtil.getClient().list("bl_subs_comm")
                .where(checkOnly).executeQuery(DshmUtil.getCacheClient());
       
        System.err.println("bluserinfoList："+JSON.toJSONString(amcResult));
        String product_id = null;
        boolean existFlag = false;
       //获得缓存中第一条有效数据
        if (!(amcResult == null || amcResult.isEmpty())) {
            for(Map<String, String> r : amcResult){
                if(!r.isEmpty()){
                    product_id = r.get("product_id");      
                    existFlag = true;//productId已存在，更新数据
                    System.err.println("product_id："+product_id+"已存在，更新" ); 
                    break;
                }          
            }
        }
        System.err.println("productId : "+product_id+" existFlag : "+existFlag);
        return existFlag;
    }
    
    @Override
    public void writeData(OrderInfoParams orderInfoParams, String custId) {
        // 判重
        // 通过共享内存查找subsId
        String subsId = null;
        String acctId = null;
        Map<String, String> params = new TreeMap<String, String>();
        params.put("cust_id", custId);
        params.put("service_id", orderInfoParams.getServiceId());
        params.put("tenant_id", orderInfoParams.getTenantId());
        //params.put("ACTIVE_TIME", DateUtil.getTimestamp(orderInfoParams.getActiveTime(), DateUtil.YYYYMMDDHHMMSS).toString());
        List<Map<String, String>> result = DshmUtil.getClient().list("bl_userinfo")
                .where(params).executeQuery(DshmUtil.getCacheClient());
       
        System.err.println("bluserinfoList："+JSON.toJSONString(result));
        //获得缓存中第一条有效数据
        if (!(result == null || result.isEmpty())) {
            for(Map<String, String> r : result){
                if(!r.isEmpty()){
                    subsId = r.get("subs_id");
                    acctId = r.get("acct_id");
                    break;
                }          
            }
        }

        if(subsId == null){
            System.err.println("当前custID下没有subsId");
        }else{
            System.err.println("找到subs_id为"+subsId);
        }
        BlUserinfo aBlUserinfo = writeBlUserinfo(orderInfoParams, custId, subsId, acctId);
        System.err.println(MyJsonUtil.toJson(aBlUserinfo));
        
        // 当产品列表不为空时，循环插入产品表
        if (orderInfoParams.getProductList() != null) {
            for (Product p : orderInfoParams.getProductList()) {
                if(p.getProductType().equals("dr")){
                    //校验产品ID
                    checkDr(p.getProductId(),orderInfoParams.getTenantId());
                    writeBlSubsComm(aBlUserinfo, p);
                }
                if(p.getProductType().equals("bill")){
                    //校验 查amc_product_info表是否有这个产品ID
                    checkBill(p.getProductId(),orderInfoParams.getTenantId());
                    //判断唯一，bl_subs_comm表中，productId是否存在，如果存在，existFlag=true ，update，如果不存在 existFlag=false insert    
                    boolean existFlag = checkOnly(p.getProductId(),p.getProductType(),orderInfoParams.getTenantId(),aBlUserinfo);
               
                    if(existFlag){
                        updateBlSubsComm(aBlUserinfo,p);
                    }else{
                        writeBlSubsComm(aBlUserinfo, p);
                    }
                }
            }
        }
        // 根据用户信息创建账户信息
        if(StringUtil.isBlank(subsId)){
            writeAcctInfo(aBlUserinfo);
        }
    }

    private void updateBlSubsComm(BlUserinfo userInfo, Product product) {
        BlSubsComm aBlSubsComm = new BlSubsComm();
        BlSubsCommCriteria blSubsCommCriteria = new BlSubsCommCriteria();
        JSONObject json = new JSONObject();
        
        //时间格式转换
        Date dDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try{
            dDate = sdf.parse(product.getActiveTime());
            Timestamp actTime = new Timestamp(dDate.getTime());
            System.out.println("actTime = [" + actTime + "]");
            aBlSubsComm.setActiveTime(actTime);
            
            dDate = sdf.parse(product.getInactiveTime());
            Timestamp inactTime = new Timestamp(dDate.getTime());
            System.out.println("inactTime = [" + inactTime + "]");
            aBlSubsComm.setInactiveTime(inactTime);
                 
            json.put("active_time", actTime.toString());
            json.put("inactive_time", inactTime.toString());
        }catch (ParseException e){
            throw new SystemException("时间格式转换异常");
        }
        aBlSubsComm.setProductType(product.getProductType());//新增字段
        
        aBlSubsComm.setSubsId(userInfo.getSubsId());
        aBlSubsComm.setSubsProductId(
                aISysSequenceSvc.terrigerSysSequence("SUBS_PRODUCT_ID", 1).get(0));
        aBlSubsComm.setProductId(product.getProductId());
        aBlSubsComm.setResBonusFlag(product.getResBonusFlag());
        aBlSubsComm.setTenantId(userInfo.getTenantId());
        aBlSubsComm.setCustId(userInfo.getCustId());
        
        blSubsCommCriteria.createCriteria()
            .andProductTypeEqualTo(product.getProductType())
            .andSubsIdEqualTo(userInfo.getSubsId())
            .andProductIdEqualTo(product.getProductId());

        aBlSubsCommMapper.updateByExampleSelective(aBlSubsComm, blSubsCommCriteria);
        
        
        
        // 刷新产品订购信息的内存表
        json.put("subs_id", aBlSubsComm.getSubsId());
        json.put("subs_product_id", aBlSubsComm.getSubsProductId());
        json.put("product_id", aBlSubsComm.getProductId());
        json.put("res_bonus_flag", aBlSubsComm.getResBonusFlag());
        json.put("tenant_id", aBlSubsComm.getTenantId());
        json.put("cust_id", aBlSubsComm.getCustId());
        json.put("product_type", aBlSubsComm.getProductType());
        DshmUtil.getIdshmSV().initLoader("bl_subs_comm", json.toString(),0);//0为更新
        LoggerUtil.log.debug("刷新产品订购信息表共享内存：" + json.toString());        
        
        sendKafka("COM",null,aBlSubsComm);
    }
    
    // 产品订购信息表操作
    private void writeBlSubsComm(BlUserinfo userInfo, Product product) {
        System.err.println("BlSubsComm有 "+product.getProductNumber()+" 个相同的产品");
        for (int i = 0; i < product.getProductNumber(); i++) {
            BlSubsComm aBlSubsComm = new BlSubsComm();
            JSONObject json = new JSONObject();
      
            //时间格式转换
            Date dDate = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            try{
                dDate = sdf.parse(product.getActiveTime());
                Timestamp actTime = new Timestamp(dDate.getTime());
                System.out.println("actTime = [" + actTime + "]");
                aBlSubsComm.setActiveTime(actTime);
                
                dDate = sdf.parse(product.getInactiveTime());
                Timestamp inactTime = new Timestamp(dDate.getTime());
                System.out.println("inactTime = [" + inactTime + "]");
                aBlSubsComm.setInactiveTime(inactTime);
                     
                json.put("active_time", actTime.toString());
                json.put("inactive_time", inactTime.toString());
            }catch (ParseException e){
                throw new SystemException("时间格式转换异常");
            }
            aBlSubsComm.setProductType(product.getProductType());//新增字段
            
            aBlSubsComm.setSubsId(userInfo.getSubsId());
            
            if(product.getSubsProductId()!=null){
                aBlSubsComm.setSubsProductId(product.getSubsProductId());
            }else{
                aBlSubsComm.setSubsProductId(
                        aISysSequenceSvc.terrigerSysSequence("SUBS_PRODUCT_ID", 1).get(0));
            }
            
            aBlSubsComm.setProductId(product.getProductId());
            aBlSubsComm.setResBonusFlag(product.getResBonusFlag());
            aBlSubsComm.setTenantId(userInfo.getTenantId());
            aBlSubsComm.setCustId(userInfo.getCustId());
            aBlSubsCommMapper.insertSelective(aBlSubsComm);
            
            // 刷新产品订购信息的内存表
            json.put("subs_id", aBlSubsComm.getSubsId());
            json.put("subs_product_id", aBlSubsComm.getSubsProductId());
            json.put("product_id", aBlSubsComm.getProductId());
            json.put("res_bonus_flag", aBlSubsComm.getResBonusFlag());
            json.put("tenant_id", aBlSubsComm.getTenantId());
            json.put("cust_id", aBlSubsComm.getCustId());
            json.put("product_type", aBlSubsComm.getProductType());
            DshmUtil.getIdshmSV().initLoader("bl_subs_comm", json.toString(),1);
            LoggerUtil.log.debug("刷新产品订购信息表共享内存：" + json.toString());            
            
            sendKafka("COM",null,aBlSubsComm);
          }
//        String PRODUCT_ID = product.getProductId();
        
//                              暂时不写扩展表
//         如果产品订购扩展信息不为空则对产品订购扩展信息表进行操作
//        if (product.getProductExtInfoList() != null) {
//            for (ProductExt pe : product.getProductExtInfoList()) {
//                writeBlSubsCommExt(PRODUCT_ID,pe,userInfo.getTenantId());
//        }
//      }
  }

    // 用户信息表操作,成功返回用户信息
    private BlUserinfo writeBlUserinfo(OrderInfoParams orderInfoParams, String custId, String subsId, String acctId) {
        // 设置插入用户表模板
        BlUserinfo aBluserinfo = new BlUserinfo();
        // 刷新用户的内存表
        JSONObject json = new JSONObject();
        
        
        
        aBluserinfo.setCustId(custId);
        aBluserinfo.setTenantId(orderInfoParams.getTenantId());
        
        Date dDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try{
            dDate = sdf.parse(orderInfoParams.getActiveTime());
            Timestamp actTime = new Timestamp(dDate.getTime());
            System.out.println("actTime = [" + actTime + "]");
            aBluserinfo.setActiveTime(actTime);
            
            dDate = sdf.parse(orderInfoParams.getInactiveTime());
            Timestamp inactTime = new Timestamp(dDate.getTime());
            System.out.println("inactTime = [" + inactTime + "]");
            aBluserinfo.setInactiveTime(inactTime);
            
            if(!StringUtil.isBlank(orderInfoParams.getOrderTime())){
                dDate = sdf.parse(orderInfoParams.getOrderTime());
                Timestamp dealTime = new Timestamp(dDate.getTime());
                System.out.println("dealTime = [" + dealTime + "]");
                aBluserinfo.setDealTime(dealTime);
                json.put("deal_time", dealTime.toString());
            }
            json.put("active_time", actTime.toString());           
            json.put("inactive_time", inactTime.toString());
        }catch (ParseException e){
            throw new SystemException("时间格式转换异常");
        }
        aBluserinfo.setPolicyId(orderInfoParams.getScoutPolocyID()); 
        //aBluserinfo.setActiveTime(DateUtil.getTimestamp(orderInfoParams.getActiveTime(), DateUtil.YYYYMMDDHHMMSS));
        aBluserinfo.setServiceId(orderInfoParams.getServiceId());
        // 受理时间设为订购时间
        //aBluserinfo.setDealTime(DateUtil.getTimestamp(orderInfoParams.getOrderTime(), DateUtil.YYYYMMDDHHMMSS));
        aBluserinfo.setServType(orderInfoParams.getServType());
        aBluserinfo.setProvinceCode(orderInfoParams.getProvinceCode());
        aBluserinfo.setCityCode(orderInfoParams.getCityCode());
        aBluserinfo.setChlId(orderInfoParams.getChlId());
        aBluserinfo.setDevId(orderInfoParams.getDevId());
        //aBluserinfo.setInactiveTime( DateUtil.getTimestamp(orderInfoParams.getInactiveTime(), DateUtil.YYYYMMDDHHMMSS));
        aBluserinfo.setRemark(orderInfoParams.getRemark());
        aBluserinfo.setUserType(orderInfoParams.getUsetype());
        aBluserinfo.setUserState(orderInfoParams.getState());
        // 业务类型不确定，暂为空
        // 如果subsId为空则认为需要插入，否则执行更新
        if (StringUtil.isBlank(subsId)) {
            // subsId调用序列 
            aBluserinfo.setSubsId(
                    aISysSequenceSvc.terrigerSysSequence("SUBS_ID", 1).get(0));
            // acctId调用序列
            aBluserinfo.setAcctId(
                    aISysSequenceSvc.terrigerSysSequence("ACCT_ID", 1).get(0));
            System.err.println("新增数据，subs_id为："+aBluserinfo.getSubsId());
            aBlUserinfoMapper.insertSelective(aBluserinfo);
        } else {
            System.err.println("更新数据，subs_id为："+subsId);
            aBluserinfo.setSubsId(subsId);
            aBluserinfo.setAcctId(acctId);
            aBlUserinfoMapper.updateByPrimaryKeySelective(aBluserinfo);
        }
   
//        Date dDate = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//
//        dDate = sdf.parse(aBluserinfo.getActiveTime());
//        Timestamp st = new Timestamp(dDate.getTime());
//        System.out.println("st = [" + st + "]");
//        json.put("active_time", st.toString().substring(0,19));

        json.put("tenant_id", aBluserinfo.getTenantId());
        json.put("subs_id", aBluserinfo.getSubsId());       
        json.put("cust_id", aBluserinfo.getCustId());
        json.put("acct_id", aBluserinfo.getAcctId());
        json.put("service_id", aBluserinfo.getServiceId());        
        json.put("province_code", aBluserinfo.getProvinceCode());
        json.put("city_code", aBluserinfo.getCityCode());
        json.put("chl_id", aBluserinfo.getChlId());
        json.put("dev_id", aBluserinfo.getDevId());
        json.put("remark", aBluserinfo.getRemark());
        json.put("serv_type", aBluserinfo.getServType());
        json.put("user_type", aBluserinfo.getUserType());
        json.put("user_state", aBluserinfo.getUserState());
        json.put("serv_type", aBluserinfo.getServType());//新增
        json.put("policy_id", aBluserinfo.getPolicyId());
//        DshmUtil.getIdshmSV().initDel(TableCon.BL_USERINFO, json.toString());
        // 如果subsId为空则认为需要插入，否则执行更新
        if (StringUtil.isBlank(subsId)) {
            System.err.println("共享内存中插入数据");
            DshmUtil.getIdshmSV().initLoader("bl_userinfo", json.toString(),1); //redis  0更新 1插入
        } else {
            System.err.println("共享内存中更新数据");
            DshmUtil.getIdshmSV().initLoader("bl_userinfo", json.toString(),0);
        }
        LoggerUtil.log.debug("刷新用户表共享内存：" + json.toString());
        System.err.println("刷新用户表共享内存：" + json.toString());

        // 当扩展信息为空退出，否则循环操作用户扩展信息
        if (orderInfoParams.getOrderExtInfo() != null) {
            for (OrderExt orderExt : orderInfoParams.getOrderExtInfo()) {
                writeBlUserinfoExt(aBluserinfo.getSubsId(), orderExt, orderInfoParams.getTenantId());
            }
        }
        
        sendKafka("USR",aBluserinfo,null);//触发入账
        
        return aBluserinfo;
    }

    private void sendKafka(String type, BlUserinfo aBluserinfo, BlSubsComm aBlSubsComm) {
        String mdsns = "baas-ResourceClient-topic";//
        IMessageSender msgSender = MDSClientFactory.getSenderClient(mdsns);
        
        if(type.equals("USR")){
            JSONObject userInfoObject = new JSONObject();
            userInfoObject.put("SUBS_ID", aBluserinfo.getSubsId());
            userInfoObject.put("TENANT_ID", aBluserinfo.getTenantId());
            userInfoObject.put("MSG_TYPE", "USR");//表示来自bl_userinfo表的触发消息
            userInfoObject.put("USER_STATE",aBluserinfo.getUserState());
            int part=0;
            msgSender.send(userInfoObject.toString(), part);//第二个参数为分区键，如果不分区，传入0
        }
        
        if(type.equals("COM")){
            JSONObject subsCommObject = new JSONObject();
            
            subsCommObject.put("MSG_TYPE", "COM");
            subsCommObject.put("SUBS_ID", aBlSubsComm.getSubsId());
            subsCommObject.put("TENANT_ID", aBlSubsComm.getTenantId());
            subsCommObject.put("PRODUCT_ID", aBlSubsComm.getProductId());
            subsCommObject.put("SUBS_PRODUCT_ID", aBlSubsComm.getSubsProductId());
            int part=0;
            msgSender.send(aBlSubsComm.toString(), part);//第二个参数为分区键，如果不分区，传入0           
        }
        
    }

    // 用户扩展信息表操作
    private void writeBlUserinfoExt(String subsId, OrderExt orderExt,String tenantId) {
        if ("D".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria()
                    .andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            // 查出要删除的记录
            try {
                List<BlUserinfoExt> tempList = aBlUserinfoExtMapper.selectByExample(example);
                BlUserinfoExt temp = new BlUserinfoExt();
                if(tempList.size()==0){
                   System.out.println("blUserinfoExt表中不存在对应的数据，无法删除");
                }else{
                    temp = aBlUserinfoExtMapper.selectByExample(example).get(0);
                    aBlUserinfoExtMapper.deleteByExample(example);
                }
                // 刷新用户扩展信息表的内存表
                JSONObject json = new JSONObject();
                json.put("EXT_ID", temp.getExtId());
                json.put("SUBS_ID", temp.getSubsId());
                json.put("EXT_NAME", temp.getExtName());
                json.put("EXT_VALUE", temp.getExtValue());
                json.put("TENANT_ID", tenantId);
                DshmUtil.getIdshmSV().initdel("bl_userinfo_ext", json.toString());

            } catch (NullPointerException e) {
                throw new BusinessException(ErrorCode.NULL, "用户扩展信息不在表中，无法删除");
            }
        } else if ("U".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExt aBlUserinfoExt = new BlUserinfoExt();
            aBlUserinfoExt.setExtValue(orderExt.getExtValue());
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria()
                    .andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());

                // 查出要更新的记录
//                BlUserinfoExt temp = aBlUserinfoExtMapper.selectByExample(example).get(0);
            BlUserinfoExt temp = new BlUserinfoExt();
            try{
                List<BlUserinfoExt> tempList = aBlUserinfoExtMapper.selectByExample(example);
                if(tempList.size()==0){
                   System.out.println("blUserinfoExt表中不存在对应的数据，无法更新");
                }else{
                    aBlUserinfoExtMapper.updateByExampleSelective(aBlUserinfoExt, example);
                    temp = aBlUserinfoExtMapper.selectByExample(example).get(0);
                    JSONObject json = new JSONObject();
                    json.put("EXT_ID", temp.getExtId());
                    json.put("SUBS_ID", temp.getSubsId());
                    json.put("EXT_NAME", temp.getExtName());
                    json.put("EXT_VALUE", temp.getExtValue());
                    json.put("TENANT_ID", tenantId);
                    DshmUtil.getIdshmSV().initLoader("bl_userinfo_ext", json.toString(),0);
                }

                // 刷新用户扩展信息表的内存表
                // ********************************
//                JSONObject json = new JSONObject();
//                json.put("EXT_ID", temp.getExtId());
//                json.put("SUBS_ID", temp.getSubsId());
//                json.put("EXT_NAME", temp.getExtName());
//                json.put("EXT_VALUE", temp.getExtValue());
//                json.put("TENANT_ID", tenantId);
//                DshmUtil.getIdshmSV().initdel("bl_userinfo_ext",json.toString());
                // 查出更新后的记录
                 
                

            } catch (NullPointerException e) {
                throw new BusinessException(ErrorCode.NULL, "用户扩展信息不在表中，无法更新");
            }
        } else if ("N".equals(orderExt.getUpdateFlag())) {
            BlUserinfoExtCriteria check = new BlUserinfoExtCriteria();
            check.createCriteria()
                    .andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            List<BlUserinfoExt> blUserinfoExtCheck = aBlUserinfoExtMapper.selectByExample(check);
            if(blUserinfoExtCheck.size() != 0){
                System.err.println("已存在subs_id："+subsId+"无法新增");
                throw new BusinessException(ErrorCode.NULL, "已存在subs_id："+subsId+"无法新增");
            }
            System.err.println("新增BlUserInfoExt表信息");
            BlUserinfoExt aBlUserinfoExt = new BlUserinfoExt();
            aBlUserinfoExt.setSubsId(subsId);
            
            System.err.println(" 1: "+subsId);
            
            aBlUserinfoExt.setExtName(orderExt.getExtName());
            aBlUserinfoExt.setExtValue(orderExt.getExtValue());
            aBlUserinfoExtMapper.insertSelective(aBlUserinfoExt);
            // 刷新用户扩展信息表的内存表
            System.err.println("  2  "+subsId);
            BlUserinfoExtCriteria example = new BlUserinfoExtCriteria();
            example.createCriteria().andSubsIdEqualTo(subsId)
                    .andExtNameEqualTo(orderExt.getExtName());
            BlUserinfoExt temp = aBlUserinfoExtMapper.selectByExample(example).get(0);
            JSONObject json = new JSONObject();
            json.put("EXT_ID", temp.getExtId());
            json.put("SUBS_ID", temp.getSubsId());
            json.put("EXT_NAME", temp.getExtName());
            json.put("EXT_VALUE", temp.getExtValue());
            json.put("TENANT_ID", tenantId);
            DshmUtil.getIdshmSV().initLoader("bl_userinfo_ext", json.toString(),1); //redis  0更新 1插入

        }
    }



    // 产品订购扩展信息表操作
    private void writeBlSubsCommExt(String productId,  ProductExt productExt,String tenantId) {
        if ("D".equals(productExt.getUpdateFlag())) {
            System.err.println("删除 BlSubsCommExt表");
            BlSubscommExtCriteria example = new BlSubscommExtCriteria();
            example.createCriteria()
                    .andProductIdEqualTo(productId)
                    .andExtNameEqualTo(productExt.getExtName());
            try {
                BlSubscommExt temp = aBlSubscommExtMapper.selectByExample(example).get(0);
                aBlSubscommExtMapper.deleteByExample(example);
                // 刷新用户扩展信息表的内存表
                JSONObject json = new JSONObject();
                json.put("EXT_ID", temp.getExtId());
                json.put("PRODUCT_ID", temp.getProductId());
                json.put("EXT_NAME", temp.getExtName());
                json.put("EXT_VALUE", temp.getExtValue());
                json.put("TENANT_ID", tenantId);
                DshmUtil.getIdshmSV().initdel("bl_subscomm_ext", json.toString());

            } catch (NullPointerException e) {
                throw new BusinessException(ErrorCode.NULL, "产品订购扩展信息不在表中，无法删除");
            }
        } else if ("U".equals(productExt.getUpdateFlag())) {
            System.err.println("更新 BlSubsCommExt表");
            System.err.println("productId  "+productId+","+JSON.toJSONString(productExt));
            BlSubscommExt aBlSubscommExt = new BlSubscommExt();
            aBlSubscommExt.setExtValue(productExt.getExtValue());
            BlSubscommExtCriteria example = new BlSubscommExtCriteria();
            example.createCriteria()
                    .andProductIdEqualTo(productId)
                    .andExtNameEqualTo(productExt.getExtName());
            try {
//                BlSubscommExt temp = aBlSubscommExtMapper.selectByExample(example).get(0);
                aBlSubscommExtMapper.updateByExampleSelective(aBlSubscommExt, example);
                // 刷新用户扩展信息表的内存表
//                DshmUtil.getIdshmSV().initdel("bl_subscomm_ext", MyJsonUtil.toJson(temp));
                List<BlSubscommExt> blSubsExtList = aBlSubscommExtMapper.selectByExample(example);
                if(blSubsExtList.size() ==0){
                    System.err.println("BlSubscommExt表中无数据，更新失败");
                }
                BlSubscommExt temp = blSubsExtList.get(0);
                JSONObject json = new JSONObject();
                json.put("EXT_ID", temp.getExtId());
                json.put("PRODUCT_ID", temp.getProductId());
                json.put("SUBS_PRODUCT_ID", temp.getSubsProductId());
                json.put("EXT_NAME", temp.getExtName());
                json.put("EXT_VALUE", temp.getExtValue());
                json.put("TENANT_ID", tenantId);
                DshmUtil.getIdshmSV().initLoader("bl_subscomm_ext", json.toString(),0);

            } catch (NullPointerException e) {
                throw new BusinessException(ErrorCode.NULL, "产品订购扩展信息不在表中，无法更新");
            }
        } else if ("N".equals(productExt.getUpdateFlag())) {
            System.err.println("新增 BlSubsCommExt表");
            System.err.println("productId  "+productId+","+"ProductExt :"+JSON.toJSONString(productExt));
            BlSubscommExt aBlSubscommExt = new BlSubscommExt();
            aBlSubscommExt.setProductId(productId);
            aBlSubscommExt.setExtName(productExt.getExtName());
            aBlSubscommExt.setExtValue(productExt.getExtValue());
            aBlSubscommExtMapper.insertSelective(aBlSubscommExt);
            // 刷新用户扩展信息表的内存表
            BlSubscommExtCriteria example = new BlSubscommExtCriteria();
            example.createCriteria()
                    .andProductIdEqualTo(productId)
                    .andExtNameEqualTo(productExt.getExtName());
            BlSubscommExt temp = aBlSubscommExtMapper.selectByExample(example).get(0);
            JSONObject json = new JSONObject();
            json.put("EXT_ID", temp.getExtId());
            json.put("PRODUCT_ID", temp.getProductId());
            json.put("SUBS_PRODUCT_ID", temp.getSubsProductId());
            json.put("EXT_NAME", temp.getExtName());
            json.put("EXT_VALUE", temp.getExtValue());
            json.put("TENANT_ID", tenantId);
            DshmUtil.getIdshmSV().initLoader("bl_subscomm_ext", json.toString(),1);
        }
    }

    // 账户信息表操作
    private void writeAcctInfo(BlUserinfo userinfo) {
        BlAcctInfo aBlAcctInfo = new BlAcctInfo();
        aBlAcctInfo.setAcctId(userinfo.getAcctId());
        aBlAcctInfo.setTenantId(userinfo.getTenantId());
        aBlAcctInfo.setOwnerType("USER");
        aBlAcctInfo.setOwnerId(userinfo.getSubsId());
        // ^^账户名称和账户类型不确定
        aBlAcctInfo.setCreateTime(DateUtil.getTimestamp(System.currentTimeMillis()));
        // ^^说明为空
        aBlAcctInfoMapper.deleteByPrimaryKey(aBlAcctInfo.getAcctId());
        aBlAcctInfoMapper.insertSelective(aBlAcctInfo);
        // 刷新用户扩展信息表的内存表

        JSONObject json = new JSONObject();
        json.put("acct_id", aBlAcctInfo.getAcctId());
        json.put("tenant_id", aBlAcctInfo.getTenantId());
        json.put("owner_type", aBlAcctInfo.getOwnerType());
        json.put("owner_id", aBlAcctInfo.getOwnerId());
        json.put("acct_name", aBlAcctInfo.getAcctName());
        json.put("acct_type", aBlAcctInfo.getAcctType());
        json.put("create_time", aBlAcctInfo.getCreateTime());
        json.put("comments", aBlAcctInfo.getComments());
//        DshmUtil.getIdshmSV().initdel(TableCon.BL_ACCT_INFO, json.toString());
        DshmUtil.getIdshmSV().initLoader("bl_acct_info", json.toString(),1);
        LoggerUtil.log.debug("刷新账户表共享内存：" + json.toString());

    }
    // 账户扩展信息表操作   目前不使用
    // private void writeAcctInfoExt(BlAcctinfoExt aBlAcctinfoExt){
    //
    // }
}
