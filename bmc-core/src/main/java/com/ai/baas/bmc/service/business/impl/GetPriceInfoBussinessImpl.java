package com.ai.baas.bmc.service.business.impl;

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
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfoCriteria.Criteria;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItem;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItemCriteria;
import com.ai.baas.bmc.service.business.interfaces.IGetPriceInfoBussiness;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
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
        //StandardList standards = new StandardList();
        //UsageList usages =new UsageList();
        List<StandardList> standardList = new ArrayList<StandardList>( );
        
        //基于StandardId 和 PriceName 模糊查询
        CpPriceDetailMapper cpPriceDetailMapper = sqlSessionTemplate.getMapper(CpPriceDetailMapper.class);
        
        CpUnitpriceInfoMapper cpUnitpriceInfoMapper = sqlSessionTemplate.getMapper(CpUnitpriceInfoMapper.class);
        
        CpUnitpriceItemMapper cpUnitpriceItemMapper = sqlSessionTemplate.getMapper(CpUnitpriceItemMapper.class);
        
        CpFactorInfoMapper cpFactorInfoMapper = sqlSessionTemplate.getMapper(CpFactorInfoMapper.class);
        
        CpPriceInfoMapper  cpPriceInfoMapper = sqlSessionTemplate.getMapper(CpPriceInfoMapper.class); 
        CpPriceInfoCriteria cpPriceInfoCriteria=new CpPriceInfoCriteria();
        
        //判断是否需要分页   ,因为数据库结构问题，暂时通过内存分页
        
//        if(record.getPageSize()!=null&&record.getPageNo()!=null){
//            //pageSize
//            int pageSize=record.getPageSize();        
//            //pageNo
//            int pageNo=record.getPageNo();
//            cpPriceInfoCriteria.setLimitStart((pageNo-1)*pageSize);
//            cpPriceInfoCriteria.setLimitEnd(pageSize);            
//        }        
        
        String code = null;
        String name = null;
        
        code = record.getStandardId();
        name = record.getPriceName();
        
        CpPriceInfoCriteria.Criteria criteria=cpPriceInfoCriteria.or();
        if(!StringUtil.isBlank(code)){
            //code = "%"+record.getStandardId()+"%";
            criteria.andPriceCodeLike("%"+code+"%");
        }
        if(!StringUtil.isBlank(name)){
            //name = "%"+record.getPriceName()+"%";
            criteria.andPriceNameLike("%"+name+"%");         
        }

        if(StringUtil.isBlank(record.getTenantId())){
            responseMessage.setResponseHeader(new ResponseHeader(false, "000001", "租户ID为空，查询失败"));
            return responseMessage;
        }
        //租户ID也需要作为查询条件
        criteria.andTenantIdEqualTo(record.getTenantId());
        
        List<CpPriceInfo>  cpPriceInfoList=cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria);
        PageInfo<StandardList> resultPage=new PageInfo<StandardList>();
//        resultPage.setCount(cpPriceInfoList.size());
//        
//        if(record.getPageSize()!=null&&record.getPageNo()!=null){
//            resultPage.setPageSize(record.getPageSize());
//            resultPage.setPageNo(record.getPageNo());
//        }
//        else{
//            resultPage.setPageSize(cpPriceInfoList.size());
//            resultPage.setPageNo(1);
//        }
        
        System.out.println("获得"+cpPriceInfoList.size()+"条资费信息");
        if(cpPriceInfoList.size() == 0){
            responseMessage.setResponseHeader(new ResponseHeader(false, "000001", "cp_price_info表中未找到数据"));
            return responseMessage;
        }
       
        for(CpPriceInfo cpPriceInfo : cpPriceInfoList){
            List<UsageList> usageList = new ArrayList<UsageList>();
           //查询CpPriceDetail
           price_code = cpPriceInfo.getPriceCode();
           System.out.println("price_code"+price_code);
           CpPriceDetailCriteria cpPriceDetailCriteria = new CpPriceDetailCriteria();
           
           CpPriceDetailCriteria.Criteria cpPriceDetailC=cpPriceDetailCriteria.or();
           cpPriceDetailC.andPriceCodeEqualTo(price_code);
           //////TEMP
          //业务类型作为查询条件
           if(!StringUtil.isBlank(record.getServiceType())){
               cpPriceDetailC.andServiceTypeEqualTo(record.getServiceType());
             }
           
           List<CpPriceDetail> cpPriceDetailList = cpPriceDetailMapper.selectByExample(cpPriceDetailCriteria);
           //CpPriceDetail判空
           if(cpPriceDetailList.size()==0){
               System.out.println("price_code:"+price_code+"在CpPriceDetail表中没有对应的数据");
               continue;
           }

           CpPriceDetail cpPriceDetail = cpPriceDetailList.get(0);
           //查询CpUnitpriceInfo    获得factor_code fee_item_code
           detail_code = cpPriceDetail.getDetailCode();
           CpUnitpriceInfoCriteria cpUnitpriceInfoCriteria = new CpUnitpriceInfoCriteria();
           
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
           CpUnitpriceItemCriteria cpUnitpriceItemCriteria = new CpUnitpriceItemCriteria();
           CpUnitpriceItemCriteria.Criteria  cpUnitpriceItemC = cpUnitpriceItemCriteria.or();
           //增加生效状态做为查询条件
           if(!StringUtil.isBlank(record.getPriceState())){
               cpUnitpriceItemC.andActiveStatusEqualTo(record.getPriceState());
           }
           cpUnitpriceItemC.andFeeItemCodeEqualTo(fee_item_code);
           List<CpUnitpriceItem> cpUnitpriceItemList =  cpUnitpriceItemMapper.selectByExample(cpUnitpriceItemCriteria);
           if(cpUnitpriceItemList.size()==0){
               System.out.println("fee_item_code:"+fee_item_code+"在CpUnitpriceItem表中没有对应的数据");
               continue;
           }
           CpUnitpriceItem cpUnitpriceItem = cpUnitpriceItemList.get(0);
           //查询CpFactorInfo
           factor_code = cpUnitpriceInfo.getFactorCode();
           CpFactorInfoCriteria cpFactorInfoCriteria = new CpFactorInfoCriteria();
           cpFactorInfoCriteria.createCriteria()
            .andFactorCodeEqualTo(factor_code)
            .andFactorNameEqualTo("subServiceType");
           
           List<CpFactorInfo>cpFactorInfoList = cpFactorInfoMapper.selectByExample(cpFactorInfoCriteria) ;
           if(cpFactorInfoList.size()==0){
               System.out.println("factor_code:"+factor_code+"在CpFactorInfo表中没有对应的数据");
               continue;
           }
           
           CpFactorInfo cpFactorInfo = cpFactorInfoList.get(0);
           if(!StringUtil.isBlank(record.getSubServiceType())&&!cpFactorInfo.getFactorValue().equals(record.getSubServiceType())){
               System.out.println("业务类型细分不匹配");
               continue;
           }
           responseMessage.setTradeSeq(record.getTradeSeq());//TradeSeq 交易流水
           responseMessage.setTenantId(cpPriceInfo.getTenantId());//TenantId 租户ID
           StandardList standards = new StandardList();
           standards.setPriceName(cpPriceInfo.getPriceName());//PriceName 资费名称
           standards.setComments(cpPriceInfo.getComments());//Comments 资费描述
           standards.setStandardId(cpPriceInfo.getPriceCode());//StandardId 资费ID
           standards.setServiceType(cpPriceDetail.getServiceType());//ServiceType 业务类型
           standards.setPrice(cpUnitpriceItem.getPriceValue());//Price 价格
           
           standards.setStatus(cpUnitpriceItem.getActiveStatus());//新增状态
           
           UsageList usages =new UsageList();
           usages.setAmount(cpUnitpriceItem.getUnitTypeValue());//使用量
           usages.setSubServiceType(cpFactorInfo.getFactorValue());//SubServiceType 业务类型细分
           usages.setUnit(cpUnitpriceItem.getUnitType());//Unit 单位
           usageList.add(usages);   
           standards.setUsageList(usageList);
           standardList.add(standards);  
           
           //CpUnitpriceItem
           //目前list.size() = 1
        }// end for
        int sum = standardList.size();
        List<StandardList> standardSubList = new ArrayList<StandardList>();
        //内存分页
        if(record.getPageSize()!=null&&record.getPageNo()!=null){

            int pageSize=record.getPageSize();
            int pageNo=record.getPageNo(); 
            int fromIndex = (pageNo-1)*pageSize;
            int toIndex = pageNo*pageSize;
            
            if(standardList.size()<toIndex){
                standardSubList = standardList.subList(fromIndex,standardList.size());
            }else{
                standardSubList = standardList.subList(fromIndex,toIndex);
            } 
        }else {
            System.out.println("不分页");
            standardSubList = standardList;
        }
        //分页信息
        resultPage.setCount(sum);
        if(record.getPageSize()!=null&&record.getPageNo()!=null){
            resultPage.setPageSize(record.getPageSize());
            resultPage.setPageNo(record.getPageNo());
        }
        else{
            resultPage.setPageSize(sum);
            resultPage.setPageNo(1);
        }
        
        resultPage.setResult(standardSubList);
        responseMessage.setStandardList(resultPage);
        responseMessage.setReturnCode("BMC-000000");
        return responseMessage;
    }

    
    
    
    
}
