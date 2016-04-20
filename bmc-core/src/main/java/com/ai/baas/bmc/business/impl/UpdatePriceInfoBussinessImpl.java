package com.ai.baas.bmc.business.impl;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.hbase.client.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.StanderdPriceInfoUsage;
import com.ai.baas.bmc.api.priceinfo.params.SubjectInput;
import com.ai.baas.bmc.business.interfaces.ISysSequenceSvc;
import com.ai.baas.bmc.business.interfaces.IUpdatePriceInfoBussiness;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.context.TableCon;
import com.ai.baas.bmc.context.TableCon.ConTradeSeqLog;
import com.ai.baas.bmc.dao.interfaces.CpFactorInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpUnitpriceInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpUnitpriceItemMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetailCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItem;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItemCriteria;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.DateUtil;

@Service
@Transactional
public class UpdatePriceInfoBussinessImpl implements IUpdatePriceInfoBussiness {
    @Autowired
    private CpPriceInfoMapper aCpPriceInfoMapper;

    @Autowired
    private CpPriceDetailMapper aCpPriceDetailMapper;

    @Autowired
    private CpUnitpriceInfoMapper aCpUnitpriceInfoMapper;

    @Autowired
    private CpUnitpriceItemMapper aCpUnitpriceItemMapper;

    @Autowired
    private CpFactorInfoMapper aCpFactorInfoMapper;

    @Autowired
    private ISysSequenceSvc aISysSequenceSvc;

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
        if ("UPDATE".equals(param.getUpdateId())) {
           
            // 更新cp_price_info表
            CpPriceInfo priceInfo = new CpPriceInfo();
            priceInfo.setTenantId(param.getTenantId());
            priceInfo.setPriceName(param.getPriceName());
            priceInfo.setComments(param.getComments());
            // ^^操作员和产品类型为空

            CpPriceInfoCriteria priceInfoC = new CpPriceInfoCriteria();
            priceInfoC.createCriteria().andPriceCodeEqualTo(param.getStandardId());
            if (aCpPriceInfoMapper.updateByExampleSelective(priceInfo, priceInfoC) < 1) {
                throw new BusinessException("BaaS-000001", "cp_price_info表没有相关信息，无法更新");
            }
            priceInfo = aCpPriceInfoMapper.selectByExample(priceInfoC).get(0);

            // 更新cp_price_detail表
            CpPriceDetail priceDetail = new CpPriceDetail();
            priceDetail.setServiceType(param.getServiceType());
            // ^^明细项名称为空，计费类型为空，说明为空

            CpPriceDetailCriteria priceDetailC = new CpPriceDetailCriteria();
            priceDetailC.createCriteria().andPriceCodeEqualTo(priceInfo.getPriceCode());
            if (aCpPriceDetailMapper.updateByExampleSelective(priceDetail, priceDetailC) < 1) {
                throw new BusinessException("BaaS-000001", "cp_price_detail表没有相关信息，无法更新");
            }
            priceDetail = aCpPriceDetailMapper.selectByExample(priceDetailC).get(0);

            // 更新cp_unitprice_info表
            CpUnitpriceInfo unitpriceInfo;

            CpUnitpriceInfoCriteria unitpriceInfoC = new CpUnitpriceInfoCriteria();
            unitpriceInfoC.createCriteria()
                .andUnitPriceCodeEqualTo(priceDetail.getDetailCode());
            // if(aCpUnitpriceInfoMapper.updateByExampleSelective(unitpriceInfo,unitpriceInfoC)<1){
            // throw new BusinessException("BaaS-000001", "cp_price_info表没有相关信息，无法更新");
            // }
            unitpriceInfo = aCpUnitpriceInfoMapper.selectByExample(unitpriceInfoC).get(0);

            // 目前只有一条数据
            List<StanderdPriceInfoUsage> standerdPriceInfoUsageList = param.getUsageList();
            if(standerdPriceInfoUsageList.size()== 0 ){
                throw new BusinessException("BaaS-000001", "usageList不能为空");
            }
            
            StanderdPriceInfoUsage u = param.getUsageList().get(0);
            // 更新cp_unitprice_item表
            CpUnitpriceItem unitpriceItem = new CpUnitpriceItem();
            unitpriceItem.setPriceValue(param.getPrice());
            unitpriceItem.setUnitTypeValue(u.getAmount());
            unitpriceItem.setUnitType(u.getUnit());

            CpUnitpriceItemCriteria unitpriceItemC = new CpUnitpriceItemCriteria();
            unitpriceItemC.createCriteria().andFeeItemCodeEqualTo(unitpriceInfo.getFeeItemCode());
            if (aCpUnitpriceItemMapper.updateByExampleSelective(unitpriceItem,
                    unitpriceItemC) < 1) {
                throw new BusinessException("BaaS-000001", "cp_unitprice_item表没有相关信息，无法更新");
            }

            // 更新cp_factor_info表
            CpFactorInfo factorInfo = new CpFactorInfo();
            factorInfo.setFactorValue(u.getSubServiceType());

            CpFactorInfoCriteria factorInfoC = new CpFactorInfoCriteria();
            factorInfoC.createCriteria().andFactorCodeEqualTo(unitpriceInfo.getFactorCode())
                    .andTenantIdEqualTo(param.getTenantId()).andFactorNameEqualTo("subServiceType");
            if(aCpFactorInfoMapper.updateByExampleSelective(factorInfo, factorInfoC)<1){
                throw new BusinessException("BaaS-000001", "cp_factor_info表没有相关信息，无法更新");
            }
            // end
        } else if ("CREATE".equals(param.getUpdateId())) {

            // 插入cp_price_info表
            CpPriceInfo priceInfo = new CpPriceInfo();
            priceInfo.setTenantId(param.getTenantId());
            priceInfo.setPriceCode(aISysSequenceSvc.terrigerSysSequence("PRICE_CODE", 1).get(0));
            priceInfo.setPriceName(param.getPriceName());
            priceInfo.setCreateTime(DateUtil.getTimestamp(System.currentTimeMillis()));
            priceInfo.setComments(param.getComments());
            // ^^设置默认值
            priceInfo.setActiveTime(DateUtil.getTimestamp("20150101", DateUtil.YYYYMMDD));
            priceInfo.setInactiveTime(DateUtil.getTimestamp("20300101", DateUtil.YYYYMMDD));
            // ^^操作员和产品类型为空

            aCpPriceInfoMapper.insertSelective(priceInfo);
            // end
            // 目前只有一条数据
            StanderdPriceInfoUsage u = param.getUsageList().get(0);
            // for (StanderdPriceInfoUsage u : param.getUsageList()) {
            // 插入cp_price_detail表
            CpPriceDetail priceDetail = new CpPriceDetail();
            priceDetail.setPriceCode(priceInfo.getPriceCode());
            priceDetail.setServiceType(param.getServiceType());
            priceDetail
                    .setDetailCode(aISysSequenceSvc.terrigerSysSequence("DETAIL_CODE", 1).get(0));
            // ^^设置默认值
            priceDetail.setActiveTime(DateUtil.getTimestamp("20150101", DateUtil.YYYYMMDD));
            priceDetail.setInactiveTime(DateUtil.getTimestamp("20300101", DateUtil.YYYYMMDD));
            // ^^明细项名称为空，计费类型为空，说明为空

            aCpPriceDetailMapper.insertSelective(priceDetail);
            // end
            // 插入cp_unitprice_info表
            CpUnitpriceInfo unitpriceInfo = new CpUnitpriceInfo();
            unitpriceInfo.setUnitPriceCode(priceDetail.getDetailCode());
            unitpriceInfo.setFeeItemCode(
                    aISysSequenceSvc.terrigerSysSequence("FEE_ITEM_CODE", 1).get(0));
            unitpriceInfo
                    .setFactorCode(aISysSequenceSvc.terrigerSysSequence("FACTOR_CODE", 1).get(0));
            // ^^明细的名称为空

            aCpUnitpriceInfoMapper.insertSelective(unitpriceInfo);
            // end
            //插入cp_unitprice_item表
            CpUnitpriceItem unitpriceItem = new CpUnitpriceItem();
            unitpriceItem.setFeeItemCode(unitpriceInfo.getFeeItemCode());
            unitpriceItem.setPriceValue(param.getPrice());
            unitpriceItem.setUnitTypeValue(u.getAmount());
            unitpriceItem.setUnitType(u.getUnit());
            // ^^费用类型写死为1
            unitpriceItem.setFeeType(1);
            // ^^生失效时间默认
            unitpriceItem.setActiveTime(DateUtil.getTimestamp("20150101", DateUtil.YYYYMMDD));
            unitpriceItem.setInactiveTime(DateUtil.getTimestamp("20300101", DateUtil.YYYYMMDD));

            aCpUnitpriceItemMapper.insertSelective(unitpriceItem);

            // 插入cp_factor_info表
            CpFactorInfo factorInfo = new CpFactorInfo();
            factorInfo.setFactorCode(unitpriceInfo.getFactorCode());
            factorInfo.setTenantId(param.getTenantId());
            factorInfo.setFactorName("subServiceType");
            factorInfo.setFactorValue(u.getSubServiceType());
            aCpFactorInfoMapper.insertSelective(factorInfo);
            // factorInfo.setFactorName("priceType");
            // factorInfo.setFactorValue(param.getPriceType());
            // aCpFactorInfoMapper.insertSelective(factorInfo);
            // factorInfo.setFactorName("price");
            // factorInfo.setFactorValue(param.getPrice() + "");
            // aCpFactorInfoMapper.insertSelective(factorInfo);
            // *******************end*******************************
            // }
        } else if ("DELETE".equals(param.getUpdateId())) {
         // *******************删除cp_price_info表*******************
            CpPriceInfoCriteria priceInfoC = new CpPriceInfoCriteria();
            priceInfoC.createCriteria().andPriceCodeEqualTo(param.getStandardId());
            CpPriceInfo priceInfo = aCpPriceInfoMapper.selectByExample(priceInfoC).get(0);
            aCpPriceInfoMapper.deleteByExample(priceInfoC);
            // *************************end****************************
            // *******************删除cp_price_detail表*******************
            CpPriceDetailCriteria priceDetailC = new CpPriceDetailCriteria();
            priceDetailC.createCriteria().andPriceCodeEqualTo(priceInfo.getPriceCode());
            CpPriceDetail priceDetail = aCpPriceDetailMapper.selectByExample(priceDetailC).get(0);
            aCpPriceDetailMapper.deleteByExample(priceDetailC);
            // *************************end****************************
            // *******************删除cp_unitprice_info表*******************
            CpUnitpriceInfoCriteria unitpriceInfoC = new CpUnitpriceInfoCriteria();
            unitpriceInfoC.createCriteria().andUnitPriceCodeEqualTo(priceDetail.getPriceCode());
            CpUnitpriceInfo unitpriceInfo = aCpUnitpriceInfoMapper.selectByExample(unitpriceInfoC).get(0);
            aCpUnitpriceInfoMapper.deleteByExample(unitpriceInfoC);
            // *************************end****************************
            // ^^目前只有一条数据
//            StanderdPriceInfoUsage u = param.getUsageList().get(0);
            // *******************删除cp_unitprice_item表*******************
            CpUnitpriceItemCriteria unitpriceItemC = new CpUnitpriceItemCriteria();
            unitpriceItemC.createCriteria().andFeeItemCodeEqualTo(unitpriceInfo.getFeeItemCode());
            aCpUnitpriceItemMapper.deleteByExample(unitpriceItemC);
            // *************************end****************************
            // *******************删除cp_factor_info表*******************
            CpFactorInfoCriteria factorInfoC = new CpFactorInfoCriteria();
            factorInfoC.createCriteria().andFactorCodeEqualTo(unitpriceInfo.getFactorCode())
                    .andTenantIdEqualTo(param.getTenantId()).andFactorNameEqualTo("subServiceType");
            aCpFactorInfoMapper.deleteByExample(factorInfoC);
            // *************************end****************************
        }
    }

    @Override
    public void deleteData(StandardPriceInfoParams param) {
        //只更新状态字段：生效，待生效
        if ("UPDATE".equals(param.getUpdateId())) {
            
            //通过cp_price_info 得到detail_code
            CpPriceInfo priceInfo = new CpPriceInfo();

            CpPriceInfoCriteria priceInfoC = new CpPriceInfoCriteria();
            priceInfoC.createCriteria().andPriceCodeEqualTo(param.getStandardId());
            
            List<CpPriceInfo>priceInfoList = aCpPriceInfoMapper.selectByExample(priceInfoC);
            if (priceInfoList.size()==0) {
                throw new BusinessException("BaaS-000001", "CpPriceInfo表没有相关信息，无法更改状态");
            }
            priceInfo = priceInfoList.get(0);
            
            // 通过price_code得到cp_price_detail
            CpPriceDetail priceDetail = new CpPriceDetail();
            CpPriceDetailCriteria priceDetailC = new CpPriceDetailCriteria();
            priceDetailC.createCriteria().andPriceCodeEqualTo(priceInfo.getPriceCode());
 
            priceDetail = aCpPriceDetailMapper.selectByExample(priceDetailC).get(0);

            // 通过price_detail得到cp_unitprice_info
            CpUnitpriceInfo unitpriceInfo;
            CpUnitpriceInfoCriteria unitpriceInfoC = new CpUnitpriceInfoCriteria();
            unitpriceInfoC.createCriteria().andUnitPriceCodeEqualTo(priceDetail.getDetailCode());
            unitpriceInfo = aCpUnitpriceInfoMapper.selectByExample(unitpriceInfoC).get(0);
            //通过fee_item_code得到cp_unitprice_item

            CpUnitpriceItem unitpriceItem = new CpUnitpriceItem();
            //更新状态字段
            unitpriceItem.setActiveStatus(param.getStatus());
            CpUnitpriceItemCriteria unitpriceItemC = new CpUnitpriceItemCriteria();
            unitpriceItemC.createCriteria().andFeeItemCodeEqualTo(unitpriceInfo.getFeeItemCode());
            if (aCpUnitpriceItemMapper.updateByExampleSelective(unitpriceItem,
                    unitpriceItemC) < 1) {
                throw new BusinessException("BaaS-000001", "cp_unitprice_item表没有相关信息，无法更新");
            }
                
        } else if ("DELETE".equals(param.getUpdateId())) {
         // *******************删除cp_price_info表*******************
            CpPriceInfoCriteria priceInfoC = new CpPriceInfoCriteria();
            priceInfoC.createCriteria().andPriceCodeEqualTo(param.getStandardId());
            CpPriceInfo priceInfo = aCpPriceInfoMapper.selectByExample(priceInfoC).get(0);
            aCpPriceInfoMapper.deleteByExample(priceInfoC);
            // *************************end****************************
            // *******************删除cp_price_detail表*******************
            CpPriceDetailCriteria priceDetailC = new CpPriceDetailCriteria();
            priceDetailC.createCriteria().andPriceCodeEqualTo(priceInfo.getPriceCode());
            CpPriceDetail priceDetail = aCpPriceDetailMapper.selectByExample(priceDetailC).get(0);
            aCpPriceDetailMapper.deleteByExample(priceDetailC);
            // *************************end****************************
            // *******************删除cp_unitprice_info表*******************
            CpUnitpriceInfoCriteria unitpriceInfoC = new CpUnitpriceInfoCriteria();
            unitpriceInfoC.createCriteria().andUnitPriceCodeEqualTo(priceDetail.getDetailCode());
            CpUnitpriceInfo unitpriceInfo = aCpUnitpriceInfoMapper.selectByExample(unitpriceInfoC).get(0);
            aCpUnitpriceInfoMapper.deleteByExample(unitpriceInfoC);
            // *************************end****************************
            // ^^目前只有一条数据
//            StanderdPriceInfoUsage u = param.getUsageList().get(0);
            // *******************删除cp_unitprice_item表*******************
            CpUnitpriceItemCriteria unitpriceItemC = new CpUnitpriceItemCriteria();
            unitpriceItemC.createCriteria().andFeeItemCodeEqualTo(unitpriceInfo.getFeeItemCode());
            aCpUnitpriceItemMapper.deleteByExample(unitpriceItemC);
            // *************************end****************************
            // *******************删除cp_factor_info表*******************
            CpFactorInfoCriteria factorInfoC = new CpFactorInfoCriteria();
            factorInfoC.createCriteria().andFactorCodeEqualTo(unitpriceInfo.getFactorCode())
                    .andTenantIdEqualTo(param.getTenantId()).andFactorNameEqualTo("subServiceType");
            aCpFactorInfoMapper.deleteByExample(factorInfoC);
            // *************************end****************************
        }
    }

    @Override
    public void linkSubjectId(SubjectInput param) {
  
        //通过cp_price_info 得到detail_code
        CpPriceInfo priceInfo = new CpPriceInfo();
        CpPriceInfoCriteria priceInfoC = new CpPriceInfoCriteria();
        priceInfoC.createCriteria().andPriceCodeEqualTo(param.getStandardId());
        List<CpPriceInfo>priceInfoList = aCpPriceInfoMapper.selectByExample(priceInfoC);
        if (priceInfoList.size()==0) {
            throw new BusinessException("BaaS-000001", "CpPriceInfo表没有相关信息");
        }
        priceInfo = priceInfoList.get(0);
        
        // 通过price_code得到cp_price_detail
        CpPriceDetail priceDetail = new CpPriceDetail();
        CpPriceDetailCriteria priceDetailC = new CpPriceDetailCriteria();
        priceDetailC.createCriteria().andPriceCodeEqualTo(priceInfo.getPriceCode());
        priceDetail = aCpPriceDetailMapper.selectByExample(priceDetailC).get(0);

        // 通过price_detail得到cp_unitprice_info
        CpUnitpriceInfo unitpriceInfo;
        CpUnitpriceInfoCriteria unitpriceInfoC = new CpUnitpriceInfoCriteria();
        unitpriceInfoC.createCriteria().andUnitPriceCodeEqualTo(priceDetail.getDetailCode());
        unitpriceInfo = aCpUnitpriceInfoMapper.selectByExample(unitpriceInfoC).get(0);
        //通过fee_item_code得到cp_unitprice_item

        CpUnitpriceItem unitpriceItem = new CpUnitpriceItem();
        //更新状态字段
        unitpriceItem.setSubjectCode(param.getSubjectCode());
        CpUnitpriceItemCriteria unitpriceItemC = new CpUnitpriceItemCriteria();
        unitpriceItemC.createCriteria().andFeeItemCodeEqualTo(unitpriceInfo.getFeeItemCode());
        if (aCpUnitpriceItemMapper.updateByExampleSelective(unitpriceItem,
                unitpriceItemC) < 1) {
            throw new BusinessException("BaaS-000001", "cp_unitprice_item表没有相关信息，无法更新科目ID");
        }
        
        
    }


}
