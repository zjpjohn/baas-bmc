package com.ai.baas.bmc.service.business.productInfo.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.dao.interfaces.CpCyclefeeInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpFactorInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpPackageInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpCyclefeeInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpCyclefeeInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetailCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.SmcPriceDetail;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpPriceInfoSvc;
import com.ai.baas.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;

import net.sf.json.JSONObject;
@Service
@Transactional
public class CpPriceInfoSvcImpl implements ICpPriceInfoSvc {
	private static final Log log = LogFactory.getLog(CpPriceInfoSvcImpl.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static String tenantId = null;
	IdshmSV dshmSV = DubboConsumerFactory.getService("IdshmSV", IdshmSV.class); 
	  
	@Override
	public String triggerCpPriceInfoSvc(CpPriceInfo record) {
		log.info("进入CpPriceInfoSvc.triggerCpPriceInfo方法,打印入参json:" + record);

		CpPriceInfoMapper cpPriceInfoMapper = sqlSessionTemplate.getMapper(CpPriceInfoMapper.class);
		CpPriceInfoCriteria cpPriceInfoCriteria = new CpPriceInfoCriteria();
		cpPriceInfoCriteria.createCriteria()
			//.andTenantIdEqualTo(record.getTenantId())
			.andPriceCodeEqualTo(record.getPriceCode());

		  //删除cp_price_info表
        List<CpPriceInfo> priceInfoList = cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria);
        if(priceInfoList.size() > 0){
            System.err.println("有重复数据,删除price_code为"+record.getPriceCode()+"的信息");
            cpPriceInfoMapper.deleteByExample(cpPriceInfoCriteria);
            delCpPriceInfoShm(priceInfoList);//删dshm
           
            for (CpPriceInfo r: priceInfoList){
                tenantId = r.getTenantId();
                delCpPriceDetailDB(r);

            }
        }
		cpPriceInfoMapper.insert(record);
		return "BMC-000000";
	}
	
        //删除cp_price_detail表
        private void delCpPriceDetailDB(CpPriceInfo cpPriceInfo){
            CpPriceDetailMapper cpPriceDetailMapper = sqlSessionTemplate.getMapper(CpPriceDetailMapper.class);
            CpPriceDetailCriteria cpPriceDetailCriteria = new CpPriceDetailCriteria();
          
            cpPriceDetailCriteria.createCriteria()
                    .andPriceCodeEqualTo(cpPriceInfo.getPriceCode());
         
            List<CpPriceDetail> priceDetailList = cpPriceDetailMapper.selectByExample(cpPriceDetailCriteria);
           
            if(priceDetailList.size() > 0){
                
                delCpPriceDetailShm(priceDetailList);
                cpPriceDetailMapper.deleteByExample(cpPriceDetailCriteria);
                
                for(CpPriceDetail r : priceDetailList){
                    delCpPackageInfoDB(r);  
                    delCpCyclefeeInfoDB(r);  
                }
            
            }
        }
        //删除cp_cyclefee_info表
        private void delCpCyclefeeInfoDB(CpPriceDetail cpPriceDetail) {
            CpCyclefeeInfoMapper cpCyclefeeInfoMapper = sqlSessionTemplate.getMapper(CpCyclefeeInfoMapper.class);
            CpCyclefeeInfoCriteria cpCyclefeeInfoCriteria = new CpCyclefeeInfoCriteria();
            cpCyclefeeInfoCriteria.createCriteria()
                    .andDetailCodeEqualTo(cpPriceDetail.getDetailCode());
            List<CpCyclefeeInfo> cyclefeeInfoList = cpCyclefeeInfoMapper.selectByExample(cpCyclefeeInfoCriteria);
            if(cyclefeeInfoList.size()>0){
                cpCyclefeeInfoMapper.deleteByExample(cpCyclefeeInfoCriteria);
                delCpCyclefeeInfoShm(cyclefeeInfoList);
            }
        }
    
        //删除cp_package_info表
        private void delCpPackageInfoDB(CpPriceDetail cpPriceDetail) {
            CpPackageInfoMapper cpPackageInfoMapper = sqlSessionTemplate.getMapper(CpPackageInfoMapper.class);
            CpPackageInfoCriteria cpPackageInfoCriteria = new CpPackageInfoCriteria();
          
            cpPackageInfoCriteria.createCriteria()
                    .andDetailCodeEqualTo(cpPriceDetail.getDetailCode());
            List<CpPackageInfo>packageInfoList = cpPackageInfoMapper.selectByExample(cpPackageInfoCriteria);
            if(packageInfoList.size()>0){
                cpPackageInfoMapper.deleteByExample(cpPackageInfoCriteria);
                delCpPackageInfoShm(packageInfoList);   
                for(CpPackageInfo cpPackageInfo : packageInfoList){
                    delCpFactorInfoDB(cpPackageInfo);
                    delCpExtInfoDB(cpPackageInfo);                   
                }
            }  
        }
        
        //删除cp_factor_info表
        private void delCpFactorInfoDB(CpPackageInfo cpPackageInfo) {
            CpFactorInfoMapper cpFactorInfoMapper = sqlSessionTemplate.getMapper(CpFactorInfoMapper.class);
            CpFactorInfoCriteria cpFactorInfoCriteria = new CpFactorInfoCriteria();
            cpFactorInfoCriteria.createCriteria()
                .andFactorCodeEqualTo(cpPackageInfo.getFactorCode());
            List<CpFactorInfo>factorInfoList = cpFactorInfoMapper.selectByExample(cpFactorInfoCriteria);
            if(factorInfoList.size()>0){
                cpFactorInfoMapper.deleteByExample(cpFactorInfoCriteria);
                delCpFactorInfoShm(factorInfoList);
            }
        }
        //删除cp_ext_info表
        private void delCpExtInfoDB(CpPackageInfo cpPackageInfo) {
            
        }

        
        
        //删除dshm, cp_price_info
        private void delCpPriceInfoShm(List<CpPriceInfo> priceInfoList) {
            JSONObject priceInfoObject = new JSONObject();
            for(CpPriceInfo aPriceInfo : priceInfoList ){
                priceInfoObject.clear();
                priceInfoObject.put("TENANT_ID", aPriceInfo.getTenantId()); 
                    
                //priceInfoObject.put("SYSTEM_ID", aPriceInfo.getSystemId()); 
                priceInfoObject.put("PRICE_CODE", aPriceInfo.getPriceCode()); 
                priceInfoObject.put("PRICE_NAME", aPriceInfo.getPriceName());
                
                priceInfoObject.put("ACTIVE_TIME", aPriceInfo.getActiveTime().toString().substring(0, 19)); 
                priceInfoObject.put("INACTIVE_TIME", aPriceInfo.getInactiveTime().toString().substring(0, 19));
                log.info("从dshm中删除cp_price_infol = [" + priceInfoObject.toString() + "]");
                dshmSV.initdel("cp_price_info", priceInfoObject.toString());
            }
            
        }
       //删除dshm, cp_price_detail
        private void delCpPriceDetailShm(List<CpPriceDetail> priceDetailList) {

            JSONObject priceDetailobject = new JSONObject();
            
            for (CpPriceDetail aPriceDetail : priceDetailList) {
                priceDetailobject.clear();
                priceDetailobject.put("TENANT_ID",tenantId);
                priceDetailobject.put("DETAIL_CODE", aPriceDetail.getDetailCode()); 
                priceDetailobject.put("PRICE_CODE", aPriceDetail.getPriceCode()); 
                priceDetailobject.put("CHARGE_TYPE", aPriceDetail.getChargeType()); 
                 
                priceDetailobject.put("ACTIVE_TIME", aPriceDetail.getActiveTime().toString().substring(0, 19)); 
                priceDetailobject.put("INACTIVE_TIME", aPriceDetail.getInactiveTime().toString().substring(0, 19));
                
                //删除dshm, 表记录
                log.info("从dshm中删除cp_price_detail = [" + priceDetailobject.toString() + "]");
                dshmSV.initdel("cp_price_detail", priceDetailobject.toString());
                
//              String activeTime = "";
//              String inActiveTime = "";  
//              DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");   
//              try {    
//                  activeTime = sdf.format(aPriceDetail.getActiveTime());
//                  inActiveTime = sdf.format(aPriceDetail.getInactiveTime());
//              } catch (Exception e) {
//                  log.info("Exception = [" + e + "]");
//              } 
              
//              priceDetailobject.put("ACTIVE_TIME", activeTime); 
//              priceDetailobject.put("INACTIVE_TIME", inActiveTime); 
            }
        }
            //删除dshm, cp_factor_info
        private void delCpFactorInfoShm(List<CpFactorInfo> factorInfoList) {
            JSONObject factorInfoObject = new JSONObject();

            for (CpFactorInfo aFactorInfo : factorInfoList) {               
                //对列表的节点对象逐个处理
                factorInfoObject.clear();
                factorInfoObject.put("TENANT_ID", tenantId);
                factorInfoObject.put("FACTOR_NAME", aFactorInfo.getFactorName());  
                factorInfoObject.put("FACTOR_VALUE", aFactorInfo.getFactorValue()); 
                factorInfoObject.put("FACTOR_CODE", aFactorInfo.getFactorCode());
                factorInfoObject.put("SYSTEM_ID", aFactorInfo.getSystemId());
                factorInfoObject.put("TENANT_ID", aFactorInfo.getTenantId());
     
                //删除
                log.info("向内存cp_factor_info中 删除 = [" + factorInfoObject.toString() + "]");
                dshmSV.initdel("cp_factor_info", factorInfoObject.toString());  
            }
        }
        
        //删除dshm, cp_cyclefee_info
        private void delCpCyclefeeInfoShm(List<CpCyclefeeInfo> cyclefeeInfoList) {
            JSONObject cyclefeeInfoObject = new JSONObject();

            for (CpCyclefeeInfo aCyclefeeInfo : cyclefeeInfoList) {               
                //对列表的节点对象逐个处理
                cyclefeeInfoObject.clear();
                cyclefeeInfoObject.put("TENANT_ID", tenantId);
                cyclefeeInfoObject.put("CYCLE_FEE", aCyclefeeInfo.getCycleFee());  
                cyclefeeInfoObject.put("CYCLE_FEE_TYPE", aCyclefeeInfo.getCycleFeeTpye()); 
                cyclefeeInfoObject.put("DETAIL_CODE", aCyclefeeInfo.getDetailCode());
                
                log.info("向内存cp_cyclefee_info中 删除 = [" + cyclefeeInfoObject.toString() + "]");
                dshmSV.initdel("cp_cyclefee_info", cyclefeeInfoObject.toString());  
           }
            
        }
        //删除dshm,cp_package_info
        private void delCpPackageInfoShm(List<CpPackageInfo> packageInfoList) {
            JSONObject packageInfoObject = new JSONObject();

            for (CpPackageInfo aPackageInfo : packageInfoList) {               
                //对列表的节点对象逐个处理
                packageInfoObject.clear();
                packageInfoObject.put("TENANT_ID", tenantId);
                packageInfoObject.put("DETAIL_CODE", aPackageInfo.getDetailCode());  
                packageInfoObject.put("AMOUNT", aPackageInfo.getAmount()); 
                packageInfoObject.put("UNIT_CODE", aPackageInfo.getUnitCode());
                packageInfoObject.put("UNIT_TYPE", aPackageInfo.getUnitType());
                packageInfoObject.put("FACTOR_CODE", aPackageInfo.getFactorCode());
                packageInfoObject.put("EXCEED_TYPE", aPackageInfo.getExceedType());
                packageInfoObject.put("UNIT_PRICE_CODE", aPackageInfo.getUnitpriceCode());
                packageInfoObject.put("EXT_CODE", aPackageInfo.getExtCode());
             
                log.info("向内存cp_package_info中 删除 = [" + packageInfoObject.toString() + "]");
                dshmSV.initdel("cp_package_info", packageInfoObject.toString());  
           }
        }
}
