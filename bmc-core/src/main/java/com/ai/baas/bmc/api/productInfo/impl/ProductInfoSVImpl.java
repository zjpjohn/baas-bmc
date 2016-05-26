package com.ai.baas.bmc.api.productInfo.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.productInfo.interfaces.IProductInfoSV;
import com.ai.baas.bmc.api.productInfo.params.FactorCodeListParams;
import com.ai.baas.bmc.api.productInfo.params.PackgeListParams;
import com.ai.baas.bmc.api.productInfo.params.ProductInfoParams;
import com.ai.baas.bmc.business.interfaces.ISysSequenceSvc;
import com.ai.baas.bmc.dao.mapper.bo.CpCyclefeeInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpCyclefeeInfoSvc;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpExtInfoSvc;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpFactorInfoSvc;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpPackageInfoSvc;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpPriceDetailSvc;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpPriceInfoSvc;
import com.ai.baas.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.baas.bmc.service.business.productInfo.impl.CpPriceInfoSvcImpl;
import com.alibaba.dubbo.config.annotation.Service;

import net.sf.json.JSONObject;

@Service
@Component
public class ProductInfoSVImpl implements IProductInfoSV{
    
    private static final Logger log = LogManager.getLogger(ProductInfoSVImpl.class);
    @Autowired
    private ICpPriceInfoSvc iCpPriceInfoSvc;
    @Autowired
    private ICpPriceDetailSvc iCpPriceDetailSvc;
    @Autowired
    private ICpPackageInfoSvc iCpPackageInfosvc;
    @Autowired
    private ICpFactorInfoSvc iCpFactorInfoSvc;
    @Autowired
    private ICpCyclefeeInfoSvc iCpCyclefeeInfoSvc;
    
    @Autowired
    private ISysSequenceSvc iSysSequenceSvc;
    
    private static String fCode = null;
    private static String eCode = null;
//    private static String uCode = null;
    private static String dCode = null;
    private String resultCode;
    
    private static final int DSHM_OPERATION_INSERT = 1 ;

    @Override
    public String productNotify(String product) throws BusinessException,SystemException {
        return null;
    }

    @Override
    public String productNotify(ProductInfoParams product) throws BusinessException,SystemException{
       
        log.info("ProductInfoSVImpl.productNotify ProductId = ["+product.getProductId()+"]TenancyId=]"+product.getTenantId()+"]");
        IdshmSV dshmSV =DubboConsumerFactory.getService("IdshmSV", IdshmSV.class);
        log.info("调用内存接口IdshmSV");
        
        CpPriceInfo cpPriceInfo = new CpPriceInfo();
        JSONObject priceInfoObject = new JSONObject();
        
        CpPriceDetail cpPriceDetail = new CpPriceDetail();
        JSONObject priceDetailObject = new JSONObject();
        
        CpPackageInfo cpPackageInfo = new CpPackageInfo();
        JSONObject packageInfoObject = new JSONObject();
        
        CpCyclefeeInfo cpCyclefeeInfo = new CpCyclefeeInfo();
        JSONObject cyclefeeInfoObject = new JSONObject();
        
        CpFactorInfo cpFactorInfo = new CpFactorInfo();
        JSONObject factorInfoObject = new JSONObject();
        
        
      //检查是否为空
        check_parameters(product);
        
        /*
         * cp_price_info
         */
        log.info("向cp_price_info中插入 TENANT_ID = [ "+product.getTenantId()+"]"
                +"ACTIVE_TIME =["+product.getActiveTime()+"]"
                +"INACTIVE_TIME = ["+product.getInactiveTime()+"]"
                +"SYSTEM_ID = ["+product.getSystemId()+"]"
                +"PRICE_CODE = ["+product.getProductId()+"]");
        System.out.println("向cp_price_info中插入 TENANT_ID = [ "+product.getTenantId()+"]"
                +"ACTIVE_TIME =["+product.getActiveTime()+"]"
                +"INACTIVE_TIME = ["+product.getInactiveTime()+"]"
                +"SYSTEM_ID = ["+product.getSystemId()+"]"
                +"PRICE_CODE = ["+product.getProductId()+"]");
        setCpPriceInfo(product, cpPriceInfo,priceInfoObject);
        resultCode = iCpPriceInfoSvc.triggerCpPriceInfoSvc(cpPriceInfo);
       
        dshmSV.initLoader("cp_price_info", priceInfoObject.toString(),DSHM_OPERATION_INSERT);
        
        /*
         * cp_price_detail
         */

        List<PackgeListParams>packgeList = product.getPackgeList(); //拼写错误
        for(PackgeListParams p : packgeList){
            
            if(!p.getUnitType().equals("STREAM"))break;//****暂时只取流量的
            
            List<String> detailCode = iSysSequenceSvc.terrigerSysSequence("DetailCode",1);
            dCode = detailCode.get(0);
            
            log.info("向cp_price_detail中插入TENANT_ID = [ "+product.getTenantId()+"]"
                    +"ACTIVE_TIME =["+product.getActiveTime()+"]"
                    +"INACTIVE_TIME = ["+product.getInactiveTime()+"]"
                    +"CHAREGE_TYPE=[DPACKAGE]"
                    +"PRICE_CODE = ["+product.getProductId()+"]"
                    +"DETAIL_CODE=["+dCode+"]"
                    );        
            setCpPriceDetail(product,cpPriceDetail,priceDetailObject,p);
            resultCode = iCpPriceDetailSvc.insertCpPriceDetail(cpPriceDetail);
            dshmSV.initLoader("cp_price_detail", priceDetailObject.toString(),DSHM_OPERATION_INSERT);      
            
            /*
             * cp_cyclefee_info
             */
            log.info("向cp_cyclefee_info中插入DETAIL_CODE = [ "+dCode+"]"
                    +"CYCLE_FEE = ["+product.getCycleFee()+"]"
                    +"CYCLE_FEE_TYPE = ["+product.getCycleFeeTpye()+"]"
                    );
            setCpCyclefeeInfo(product,cpCyclefeeInfo,cyclefeeInfoObject);
            resultCode = iCpCyclefeeInfoSvc.terrigerCpCyclefeeInfo(cpCyclefeeInfo);
            dshmSV.initLoader("cp_cyclefee_info", cyclefeeInfoObject.toString(),DSHM_OPERATION_INSERT);     
               
            /*
             * cp_package_info
             */

            List<String> factorCode = iSysSequenceSvc.terrigerSysSequence("FactorCode",1);
            fCode = factorCode.get(0);
            
            List<String> extCode = iSysSequenceSvc.terrigerSysSequence("ExtCode",1);
            eCode = extCode.get(0);
            
//            if(p.getExceedType().equals("D")){
//                List<String> unitPriceCode = iSysSequenceSvc.terrigerSysSequence("UnitPriceCode",1);
//                uCode = unitPriceCode.get(0);
//                
//            }
            
            log.info("向cp_package_info中插入"
                    +"DETAIL_CODE = [ "+dCode+"]"
                    +"AMOUNT =["+p.getAmount()+"]"
                    +"UNIT_CODE = ["+p.getUnitCode()+"]"
                    +"UNIT_TYPE=["+p.getUnitType()+"]"//暂时取流量
                    +"FACTOR_CODE = ["+fCode+"]"
                    +"EXCEED_TYPE=["+p.getExceedType()+"]"
                    +"EXT_CODE=["+eCode+"]"
                    );       

            setCpPackageInfo(product,p,cpPackageInfo,packageInfoObject);
            resultCode = iCpPackageInfosvc.insertCpPackageInfo(cpPackageInfo);
            dshmSV.initLoader("cp_package_info", packageInfoObject.toString(),DSHM_OPERATION_INSERT);     
               
            /*
             * cp_factor_info      
             */
            
            if(p. getFactorCode()!=null){          
                List<FactorCodeListParams> factorList = p.getFactorCode(); //拼写错误
                for(FactorCodeListParams f : factorList){
                    log.info("向cp_factor_info中插入"
                            +"FACTOR_NAME = [ "+f.getFactorName()+"]"
                            +"FACTOR_VALUE =["+f.getFactorValue()+"]"
                            +"FACTOR_CODE = ["+fCode+"]"
                            +"SYSTEM_ID = [ "+product.getSystemId()+"]"
                            +"TENANT_ID = ["+product.getTenantId()+"]");
                    setCpFactorInfo(product,f,cpFactorInfo,factorInfoObject);
                    resultCode = iCpFactorInfoSvc.InsertCpFactorInfo(cpFactorInfo);
                    dshmSV.initLoader("cp_factor_info", factorInfoObject.toString(),DSHM_OPERATION_INSERT);  
                }
            }
            
            
        }
        if(cpPriceDetail.getChargeType()== null)throw new  BusinessException("CTP-3008", "CHAREGE_TYPE不能为空");
       

        return resultCode;  
    }
    
    
    private static void setCpFactorInfo(ProductInfoParams product, FactorCodeListParams f, CpFactorInfo cpFactorInfo,JSONObject factorInfoObject  ){
       //SystemId
        cpFactorInfo.setSystemId(product.getSystemId());
        factorInfoObject.put("SYSTEM_ID", product.getSystemId());
        //TenantId
        cpFactorInfo.setTenantId(product.getTenantId());
        factorInfoObject.put("TENANT_ID",product.getTenantId());
        //FactorName
        cpFactorInfo.setFactorName(f.getFactorName());
        factorInfoObject.put("FACTOR_NAME",f.getFactorName());
        //FactorValue
        cpFactorInfo.setFactorValue(f.getFactorValue());
        factorInfoObject.put("FACTOR_VALUE",f.getFactorValue());
        //FactorCode
        cpFactorInfo.setFactorCode(fCode);
        factorInfoObject.put("FACTOR_CODE",fCode);
        //FactorOwner
//        cpFactorInfo.setFactorOwner("Owner");
//        factorInfoObject.put("FACTOR_OWNER","Owner");
        
    }
 
    private static void setCpCyclefeeInfo(ProductInfoParams product, CpCyclefeeInfo cpCyclefeeInfo,JSONObject cyclefeeInfoObject) {
        
        //DetailCode
        cpCyclefeeInfo.setDetailCode(dCode);
        cyclefeeInfoObject.put("DETAIL_CODE", dCode);
        //CycleFee
        cpCyclefeeInfo.setCycleFee(product.getCycleFee());
        cyclefeeInfoObject.put("CYCLE_FEE", product.getCycleFee());
        //CycleFeeType
        cpCyclefeeInfo.setCycleFeeTpye(product.getCycleFeeTpye());
        cyclefeeInfoObject.put("CYCLE_FEE_TPYE", product.getCycleFeeTpye());
        //TenantId
        cyclefeeInfoObject.put("TENANT_ID", product.getTenantId());
        
    }

    private static void setCpPackageInfo(ProductInfoParams product, PackgeListParams p ,CpPackageInfo cpPackageInfo, JSONObject packageInfoObject) {
   
        //Amount
        cpPackageInfo.setAmount(p.getAmount().doubleValue());
        packageInfoObject.put("AMOUNT", p.getAmount());
       //DetailCode
        cpPackageInfo.setDetailCode(dCode);
        packageInfoObject.put("DETAIL_CODE", dCode);
        //UnitCode
        cpPackageInfo.setUnitCode(p.getUnitCode());
        packageInfoObject.put("UNIT_CODE", p.getUnitCode());
        //UnitType
        cpPackageInfo.setUnitType(p.getUnitType());
        packageInfoObject.put("UNIT_TYPE", p.getUnitType());
        //FactorCode
        cpPackageInfo.setFactorCode(fCode);
        packageInfoObject.put("FACTOR_CODE", fCode);
        //ExceedType
        cpPackageInfo.setExceedType(p.getExceedType());
        packageInfoObject.put("EXCEED_TYPE",p.getExceedType());
        //UnitPriceCode
//        if(p.getExceedType().equals("D")){
//        cpPackageInfo.setUnitpriceCode(uCode);
//        packageInfoObject.put("UNIT_PRICE_CODE", uCode);
//        }
        //ExtCode
        cpPackageInfo.setExtCode(eCode);
        packageInfoObject.put("EXT_CODE",eCode);
        //TenantId
        packageInfoObject.put("TENANT_ID", product.getTenantId());
    
    
    }

    private static void setCpPriceDetail(ProductInfoParams product, CpPriceDetail cpPriceDetail, JSONObject priceDetailObject,PackgeListParams p) {
      //ActiveTime  InactiveTime
        
//        Date dDate = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//
//        try{  dDate = sdf.parse(product.getActiveTime());
//            Timestamp st = new Timestamp(dDate.getTime());
//            System.out.println("st = [" + st + "]");
//            cpPriceDetail.setActiveTime(st);
//            priceDetailObject.put("ACTIVE_TIME", st);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } 
//  
//        try{  dDate = sdf.parse(product.getInactiveTime());
//           Timestamp st = new Timestamp(dDate.getTime());
//           System.out.println("st = [" + st + "]");
//           cpPriceDetail.setInactiveTime(st);
//           priceDetailObject.put("INACTIVE_TIME", st);
//       } catch (ParseException e) {
//           e.printStackTrace();
//       } 
        
        Date dDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        try{  dDate = sdf.parse(product.getActiveTime());
            Timestamp st = new Timestamp(dDate.getTime());
            System.out.println("st = [" + st + "]");
            cpPriceDetail.setActiveTime(st);
            priceDetailObject.put("ACTIVE_TIME", st.toString().substring(0,19));
            } catch (ParseException e) {
                e.printStackTrace();
            } 
  
        try{  dDate = sdf.parse(product.getInactiveTime());
               Timestamp st = new Timestamp(dDate.getTime());
               System.out.println("st = [" + st + "]");
               cpPriceDetail.setInactiveTime(st);
               priceDetailObject.put("INACTIVE_TIME", st.toString().substring(0,19));
       } catch (ParseException e) {
           e.printStackTrace();
       } 
      //PriceCode
        cpPriceDetail.setPriceCode(product.getProductId());
        priceDetailObject.put("PRICE_CODE", product.getProductId());
       //DetailCode
        cpPriceDetail.setDetailCode(dCode);
        priceDetailObject.put("DETAIL_CODE", dCode);
        //ChargeType
        cpPriceDetail.setChargeType("DPACKAGE");
        priceDetailObject.put("CHARGE_TYPE", "DPACKAGE");
        //TenantId
        priceDetailObject.put("TENANT_ID", product.getTenantId());
    }

    private static void setCpPriceInfo(ProductInfoParams product,CpPriceInfo cpPriceInfo,JSONObject object){
      //SystemId
//        cpPriceInfo.setSystemId(product.getSystemId());
//        object.put("SYSTEM_ID",product.getSystemId());

        //TenantId
        cpPriceInfo.setTenantId(product.getTenantId());
        object.put("TENANT_ID", product.getTenantId());
        //PriceCode
        cpPriceInfo.setPriceCode(product.getProductId());
        object.put("PRICE_CODE", product.getProductId());
        //ProductType
        cpPriceInfo.setProductType(product.getProductType());
        object.put("PRODUCT_TYPE", product.getProductType());
        

        //ActiveTime  InactiveTime
        Date dDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        try{  dDate = sdf.parse(product.getActiveTime());
            Timestamp st = new Timestamp(dDate.getTime());
            System.out.println("st = [" + st + "]");
            cpPriceInfo.setActiveTime(st);
            object.put("ACTIVE_TIME", st.toString().substring(0,19));
            } catch (ParseException e) {
                e.printStackTrace();
            } 
  
        try{  dDate = sdf.parse(product.getInactiveTime());
               Timestamp st = new Timestamp(dDate.getTime());
               System.out.println("st = [" + st + "]");
           cpPriceInfo.setInactiveTime(st);
           object.put("INACTIVE_TIME", st.toString().substring(0,19));
       } catch (ParseException e) {
           e.printStackTrace();
       } 

    }
    
    
    private void check_parameters(ProductInfoParams product) {
        //TenantId
        if(!StringUtil.isBlank(product.getTenantId())){
            if(product.getTenantId().length()<=32){
           
            }else{
                throw new  BusinessException("CTP-3012", "TENANT_ID超长");
            }
        }else{
            throw new  BusinessException("CTP-3001", "TENANT_ID不能为空");
        }
        //ActiveTime
        if (!StringUtil.isBlank(product.getActiveTime())) {
            if (product.getActiveTime().length() <= 14) {
   
            } else {
                throw new BusinessException("CTP-2002", "ACTIVE_TIME超长");
            }
        } else {
            throw new BusinessException("CTP-2002", "ACTIVE_TIME不能为空");
        }
      //InactiveTime
       if (!StringUtil.isBlank(product.getInactiveTime())) {
           if (product.getInactiveTime().length() <= 14) {

           } else {
               throw new BusinessException("CTP-2002", "INACTIVE_TIME超长");
           }
       } else {
           throw new BusinessException("CTP-2002", "INACTIVE_TIME不能为空");
       }
       //SystemId
       if(!StringUtil.isBlank(product.getSystemId())){
           if(product.getSystemId().length()<=32){
         
           }else{
               throw new  BusinessException("CTP-3009", "SYSTEM_ID超长");
           }
       }else{
           throw new  BusinessException("CTP-3004", "SYSTEM_ID不能为空");
       }
        //ProductId
       if(!StringUtil.isBlank(product.getProductId())){
           if(product.getProductId().length() <= 32){
               
           }else{
               throw new  BusinessException("CTP-3010", "PRODUCT_ID超长");
           }   
       }else{
           throw new  BusinessException("CTP-3005", "PRODUCT_ID不能为空");
       }
        //CycleFeeTpye
       if(!StringUtil.isBlank(product.getCycleFeeTpye())){ //***拼写***
           if(product.getCycleFeeTpye().equals("MONTH")||product.getCycleFeeTpye().equals("YEAR")||product.getCycleFeeTpye().equals("DAY")){
     
           }else{
               throw new  BusinessException("CTP-3011", "CYCLE_FEE_TPYE只能填写：MONTH,YEAR,DAY");
           }
       }
       //BillingType
       if(!StringUtil.isBlank(product.getBillingType())){
           if(product.getBillingType().equals("HALF")||product.getBillingType().equals("FULL")||product.getBillingType().equals("OUTP")||product.getBillingType().equals("PDAY")){

           }else{
               throw new BusinessException("CTP-3011", "BillingType="+product.getBillingType()+", BILLING_TYPE只能填写:HALF,FULL,OUTP,PDAY");
           }
       }
       //DisType
       if(!StringUtil.isBlank(product.getDisType())){
           if(product.getDisType().equals("RET")||product.getDisType().equals("DIS")){
               
           }else{
               throw new BusinessException("CTP-3011", "DisType="+product.getDisType()+", DisType只能填写:RET,DIS");
           }
       }
       //DisValueType
       if(!StringUtil.isBlank(product.getDisValueType())){
           if(product.getDisValueType().equals("USGP")||product.getDisValueType().equals("FIX")){
               
           }else{
               throw new BusinessException("CTP-3011", "DisValueType="+product.getDisValueType()+", DisValueType只能填写:USGP,FIX");
           }
       }
       
       List<PackgeListParams> packgeList = product.getPackgeList();
       
       for (PackgeListParams p :packgeList){
           //Amount
           if (p.getAmount() != null) {
            
           }else{
               throw new  BusinessException("CTP-3008", "Amount不能为空");
           }
           //UnitCode
           if(!StringUtil.isBlank(p.getUnitCode())){
               if(p.getUnitCode().equals("MB")||p.getUnitCode().equals("KB")||p.getUnitCode().equals("S")||p.getUnitCode().equals("60S")||p.getUnitCode().equals("TIME")||p.getUnitCode().equals("ITME")){
                
               }else{
                   throw new  BusinessException("CTP-3013", "UNIT_CODE只能取值：MB：MB;KB：KB;S：秒;60S：60秒;TIME：次;ITEM：条");
               }
           }else{
               throw new  BusinessException("CTP-3006", "UNIT_CODE不能为空");
           }
           //UnitType
           if(!StringUtil.isBlank(p.getUnitType())){
               if(p.getUnitType().equals("STREAM")||p.getUnitType().equals("DURATION")||p.getUnitType().equals("TIMES")||p.getUnitType().equals("ITEMS")){

               }else{
                   throw new  BusinessException("CTP-3014", "UNIT_TYPE只能取值：STREAM-流量;DURATION-时长;TIMES-次数;ITEMS-条数");
               }
           }else{
               throw new  BusinessException("CTP-3007", "UNIT_TYPE不能为空");
           }
           //ExceedType
           if(!StringUtil.isBlank(p.getExceedType())){
               if(p.getExceedType().equals("D")||p.getExceedType().equals("T")){

               }else{
                   throw new  BusinessException("CTP-3015", "EXCEED_TYPE只能取值：D：单价；T：透支");
               }
           }
           //ResClearFlag
           if(!StringUtil.isBlank(p.getResClearFlag())){
                   if(p.getResClearFlag().equals("Y")||p.getResClearFlag().equals("N")){
                       
                   }else{
                       throw new  BusinessException("CTP-3015", "ResClearFlag只能取值：Y , N");
                   }
           }
           //ResBounsFlag
           if(!StringUtil.isBlank(p.getResBonusFlag())){
                   if(p.getResBonusFlag().equals("Y")||p.getResBonusFlag().equals("N")){
                       
                   }else{
                       throw new  BusinessException("CTP-3015", "ResBounsFlag只能取值：Y , N");
                   }
           }
           //DefineFlag
           if(!StringUtil.isBlank(p.getDefineFlag())){
                   if(p.getDefineFlag().equals("Y")||p.getDefineFlag().equals("N")){
                       
                   }else{
                       throw new  BusinessException("CTP-3015", "DefineFlag只能取值：Y , N");
                   }    
           }
       }
    }
    
    
}
