package com.ai.baas.bmc.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.mapred.RecordReader;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.ResponseMessage;
import com.ai.baas.bmc.api.priceinfo.params.StandardList;
import com.ai.baas.bmc.api.priceinfo.params.UsageList;
import com.ai.baas.bmc.business.interfaces.IGetPriceInfoBussiness;
import com.ai.baas.bmc.dao.interfaces.CpFactorInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfo2Mapper;
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
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.StringUtil;
@Service
@Transactional
public class GetPriceInfoBussinessImpl  implements IGetPriceInfoBussiness{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    private static String price_code = null;
    private static String detail_code = null;
    private static String factor_code = null;
    private static String fee_item_code = null;
    
    @Override
    public ResponseMessage getPriceInfo(QueryInfoParams record) {

        ResponseMessage responseMessage = new ResponseMessage();
        StandardList standards = new StandardList();
        UsageList usages =new UsageList();
        List<StandardList> standardList = new ArrayList<StandardList>( );
        List<UsageList> usageList = new ArrayList<>();
        
        
        //基于StandardId 和 PriceName 模糊查询
        CpPriceDetailMapper cpPriceDetailMapper = sqlSessionTemplate.getMapper(CpPriceDetailMapper.class);
        CpPriceDetailCriteria cpPriceDetailCriteria = new CpPriceDetailCriteria();
        CpUnitpriceInfoMapper cpUnitpriceInfoMapper = sqlSessionTemplate.getMapper(CpUnitpriceInfoMapper.class);
        CpUnitpriceInfoCriteria cpUnitpriceInfoCriteria = new CpUnitpriceInfoCriteria();
        CpUnitpriceItemMapper cpUnitpriceItemMapper = sqlSessionTemplate.getMapper(CpUnitpriceItemMapper.class);
        CpUnitpriceItemCriteria cpUnitpriceItemCriteria = new CpUnitpriceItemCriteria();
        CpFactorInfoMapper cpFactorInfoMapper = sqlSessionTemplate.getMapper(CpFactorInfoMapper.class);
        CpFactorInfoCriteria cpFactorInfoCriteria = new CpFactorInfoCriteria();
        CpPriceInfoMapper  cpPriceInfoMapper = sqlSessionTemplate.getMapper(CpPriceInfoMapper.class);
        
        CpPriceInfoCriteria cpPriceInfoCriteria=new CpPriceInfoCriteria();
        //判断是否需要分页
        if(record.getPageSize()!=null&&record.getPageNo()!=null){
            //pageSize
            int pageSize=record.getPageSize();        
            //pageNo
            int pageNo=record.getPageNo();
            cpPriceInfoCriteria.setLimitStart((pageNo-1)*pageSize);
            cpPriceInfoCriteria.setLimitEnd(pageSize);            
        }        
        String code = null;
        String name = null;
        code = record.getStandardId();
        name = record.getPriceName();
        if(!StringUtil.isBlank(code)){
            cpPriceInfoCriteria.or().andPriceCodeLike(code);
        }
        if(!StringUtil.isBlank(name)){
            cpPriceInfoCriteria.or().andPriceNameLike(name);
        }
        List<CpPriceInfo>  cpPriceInfoList=cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria);
        PageInfo<StandardList> resultPage=new PageInfo<StandardList>();
        resultPage.setCount(cpPriceInfoList.size());
        if(record.getPageSize()!=null&&record.getPageNo()!=null){
            resultPage.setPageSize(record.getPageSize());
            resultPage.setPageNo(record.getPageNo());
        }
        else{
            resultPage.setPageSize(cpPriceInfoList.size());
            resultPage.setPageNo(1);
        }
        
        System.out.println("获得"+cpPriceInfoList.size()+"条资费信息");
        if(cpPriceInfoList.size() == 0)return null;
       
        for(CpPriceInfo cpPriceInfo : cpPriceInfoList){
          
           //查询CpPriceDetail
           price_code = cpPriceInfo.getPriceCode();
           System.out.println("price_code"+price_code);
           cpPriceDetailCriteria.createCriteria()
             .andPriceCodeEqualTo(price_code);
           List<CpPriceDetail> cpPriceDetailList = cpPriceDetailMapper.selectByExample(cpPriceDetailCriteria);
           //CpPriceDetail判空
           if(cpPriceDetailList.size()==0){
               System.out.println("price_code:"+price_code+"在CpPriceDetail表中没有对应的数据");
               continue;
           }
           CpPriceDetail cpPriceDetail = cpPriceDetailList.get(0);
           //查询CpUnitpriceInfo    获得factor_code fee_item_code
           detail_code = cpPriceDetail.getDetailCode();
           cpUnitpriceInfoCriteria.createCriteria()
             .andUnitPriceCodeEqualTo(detail_code);
           //判空
           List<CpUnitpriceInfo> cpUnitpriceInfoList = cpUnitpriceInfoMapper.selectByExample(cpUnitpriceInfoCriteria);
           if(cpUnitpriceInfoList.size()==0){
               System.out.println("detail_code:"+detail_code+"在CpUnitpriceInfo表中没有对应的数据");
               continue;
           }
           CpUnitpriceInfo cpUnitpriceInfo = cpUnitpriceInfoList.get(0);
           //查询CpUnitpriceItem
           fee_item_code = cpUnitpriceInfo.getFeeItemCode();
           cpUnitpriceItemCriteria.createCriteria()
             .andFeeItemCodeEqualTo(fee_item_code);
           List<CpUnitpriceItem> cpUnitpriceItemList =  cpUnitpriceItemMapper.selectByExample(cpUnitpriceItemCriteria);
           if(cpUnitpriceItemList.size()==0){
               System.out.println("fee_item_code:"+fee_item_code+"在CpUnitpriceItem表中没有对应的数据");
               continue;
           }
           CpUnitpriceItem cpUnitpriceItem = cpUnitpriceItemList.get(0);
           //查询CpFactorInfo
           factor_code = cpUnitpriceInfo.getFactorCode();
           cpFactorInfoCriteria.createCriteria()
            .andFactorCodeEqualTo(factor_code)
            .andFactorNameEqualTo("subServiceType");
           
           List<CpFactorInfo>cpFactorInfoList = cpFactorInfoMapper.selectByExample(cpFactorInfoCriteria) ;
           if(cpFactorInfoList.size()==0){
               System.out.println("factor_code:"+factor_code+"在CpFactorInfo表中没有对应的数据");
               continue;
           }
           CpFactorInfo cpFactorInfo = cpFactorInfoList.get(0);
           
           responseMessage.setTradeSeq(record.getTradeSeq());//TradeSeq 交易流水
           responseMessage.setTenantId(cpPriceInfo.getTenantId());//TenantId 租户ID
           standards.setPriceName(cpPriceInfo.getPriceName());//PriceName 资费名称
           standards.setComments(cpPriceInfo.getComments());//Comments 资费描述
           standards.setStandardId(cpPriceInfo.getPriceCode());//StandardId 资费ID
           standards.setServiceType(cpPriceDetail.getServiceType());//ServiceType 业务类型
           standards.setPrice(cpUnitpriceItem.getPriceValue());//Price 价格
           usages.setAmount(cpUnitpriceItem.getUnitTypeValue());//使用量
           usages.setSubServiceType(cpFactorInfo.getFactorValue());//SubServiceType 业务类型细分
           usages.setUnit(cpUnitpriceItem.getUnitType());//Unit 单位
           usageList.add(usages);   
           standards.setUsageList(usageList);
           standardList.add(standards);  
           
           //CpUnitpriceItem
           //目前list.size() = 1
        }
        resultPage.setResult(standardList);
        responseMessage.setStandardList(resultPage);
        responseMessage.setReturnCode("BMC-000000");
        return responseMessage;
    }

    
    
    
    
}
