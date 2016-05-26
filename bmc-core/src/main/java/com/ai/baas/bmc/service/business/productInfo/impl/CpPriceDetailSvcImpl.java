package com.ai.baas.bmc.service.business.productInfo.impl;
 
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.dao.interfaces.CpFactorInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpPackageInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.interfaces.CpUnitpriceInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpUnitpriceItemMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetailCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItem;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItemCriteria;
import com.ai.baas.bmc.service.business.productInfo.interfaces.ICpPriceDetailSvc;
import com.ai.baas.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;

@Service
@Transactional
public class CpPriceDetailSvcImpl implements ICpPriceDetailSvc {
	private static final Log log = LogFactory.getLog(CpPriceDetailSvcImpl.class);
	
    IdshmSV dshmSV = DubboConsumerFactory.getService("IdshmSV", IdshmSV.class); 
    String systemId = "";
    String tenantId = "";
    
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public String insertCpPriceDetail(CpPriceDetail record){
	    System.out.println("进入CpPriceDetailSvc.insertCpPriceDetail方法,打印入参json:" + record);
        log.info("进入CpPriceDetailSvc.insertCpPriceDetail方法,打印入参json:" + record);

        CpPriceDetailMapper cpPriceDetailMapper = sqlSessionTemplate.getMapper(CpPriceDetailMapper.class);
        cpPriceDetailMapper.insert(record);
	    return "BMC-000001";
	}
	
	

	/**
	 * 把关联的记录全部删除
	 */
	@Override
	public String triggerCpPriceDetail(CpPriceDetail record, String aSystemId, String aTenantId) {
		log.info("进入CpPriceDetailSvc.triggerCpPriceDetaiSvc方法,打印入参json:" + record.toString());

		//后面的内存表删除记录需要使用
		systemId = aSystemId;
		tenantId = aTenantId;
		
		CpPriceDetailMapper cpPriceDetailMapper = sqlSessionTemplate.getMapper(CpPriceDetailMapper.class);
		CpPriceDetailCriteria cpPriceDetailCriteria = new CpPriceDetailCriteria();
		cpPriceDetailCriteria.createCriteria()
	            .andPriceCodeEqualTo(record.getPriceCode())
	            .andChargeTypeEqualTo(record.getChargeType())
	            .andActiveTimeEqualTo(record.getActiveTime());

		//先查询满足条件的记录是否已经有了
		List<CpPriceDetail> priceDetailList = cpPriceDetailMapper.selectByExample(cpPriceDetailCriteria);
		if(priceDetailList.size() > 0){
		    //有记录，则把相关的记录都删除
	        cpPriceDetailMapper.deleteByExample(cpPriceDetailCriteria);
	        delCpPriceDetailShm(priceDetailList);//price_code是hash key，根据这个就可以全部删除 PriceDetail 

	        for (CpPriceDetail r : priceDetailList) {	            
	            //遍历 PriceDetail 列表，逐个删除明细信息 UnitpriceInfo 表
	            delCpUnitpriceInfoDB(r);
	        }
		}

		cpPriceDetailMapper.insert(record);

		return "BMC-000000";
	}

	/**删除 CpPriceDetail 内存表记录
	 * 
	 * @param record
	 * @author ygz
	 * @ApiDocMethod
	 */
	private void delCpPriceDetailShm(List<CpPriceDetail> priceDetailList) {

        JSONObject priceDetailobject = new JSONObject();
        
        for (CpPriceDetail aPriceDetail : priceDetailList) {
            priceDetailobject.clear();
            
            priceDetailobject.put("DETAIL_CODE", aPriceDetail.getDetailCode()); 
            priceDetailobject.put("PRICE_CODE", aPriceDetail.getPriceCode()); 
            priceDetailobject.put("CHARGE_TYPE", aPriceDetail.getChargeType()); 
             
            String activeTime = "";
            String inActiveTime = "";  
            DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");   
            try {    
                activeTime = sdf.format(aPriceDetail.getActiveTime());
                inActiveTime = sdf.format(aPriceDetail.getInactiveTime());
            } catch (Exception e) {
                log.info("Exception = [" + e + "]");
            } 
            
            priceDetailobject.put("ACTIVE_TIME", activeTime); 
            priceDetailobject.put("INACTIVE_TIME", inActiveTime); 
            priceDetailobject.put("SYSTEM_ID", this.systemId);
            priceDetailobject.put("TENANT_ID", this.tenantId);
            
            //删除dshm, 表记录
            log.info("*********从dshm中cp_price_detail删除 = [" + priceDetailobject.toString() + "]");
            System.out.println("**********从dshm中cp_price_detail删除 = [" + priceDetailobject.toString() + "]");
            dshmSV.initdel("cp_price_detail", priceDetailobject.toString()); 
            
        }

    }


    /**根据CpPriceDetail.detail_code, 删除 CP_UNITPRICE_INFO
	 * 
	 * @param r
	 * @author ygz
	 * @ApiDocMethod
	 */
    private void delCpUnitpriceInfoDB(CpPriceDetail detailRecord) {
        CpUnitpriceInfoMapper cpUnitpriceInfoMapper = sqlSessionTemplate.getMapper(CpUnitpriceInfoMapper.class);
        CpUnitpriceInfoCriteria cpUnitpriceInfoCriteria = new CpUnitpriceInfoCriteria();
        cpUnitpriceInfoCriteria.createCriteria().andUnitPriceCodeEqualTo( detailRecord.getDetailCode() );
        
        List<CpUnitpriceInfo> cpUnitpriceInfoList = cpUnitpriceInfoMapper.selectByExample(cpUnitpriceInfoCriteria);
        if(cpUnitpriceInfoList.size() > 0){
            //删除 cpUnitpriceInfo 表, 一个detail code只有一个unit price info 表记录
            cpUnitpriceInfoMapper.deleteByExample(cpUnitpriceInfoCriteria);
            delCpUnitpriceInfoShm(cpUnitpriceInfoList.get(0));
            
            //根据 CP_UNITPRICE_INFO.FACTOR_CODE 删除 CP_factor_INFO
            CpFactorInfoMapper cpFactorInfoMapper = sqlSessionTemplate.getMapper(CpFactorInfoMapper.class);
            CpFactorInfoCriteria cpFactorInfoCriteria = new CpFactorInfoCriteria();
            cpFactorInfoCriteria.createCriteria().andFactorCodeEqualTo(cpUnitpriceInfoList.get(0).getFactorCode().toString());
            
            //获取全部的参考因素列表
            List<CpFactorInfo> factorInfoList = cpFactorInfoMapper.selectByExample(cpFactorInfoCriteria);
            delCpFactorInfoShm(factorInfoList);//把列表里面所有的内存记录都删除
                        
            //删除factor info 表的记录
            cpFactorInfoMapper.deleteByExample(cpFactorInfoCriteria);

            //根据CP_UNITPRICE_INFO.FEE_ITEM_CODE 删除 CP_UNITPRICE_ITEM
            CpUnitpriceItemMapper cpUnitpriceItemMapper = sqlSessionTemplate.getMapper(CpUnitpriceItemMapper.class);
            CpUnitpriceItemCriteria cpUnitpriceItemCriteria = new CpUnitpriceItemCriteria();
            cpUnitpriceItemCriteria.createCriteria().andFeeItemCodeEqualTo(cpUnitpriceInfoList.get(0).getFeeItemCode());
            
            //根据列表逐个删除 CpUnitpriceItem 内存表记录
            List<CpUnitpriceItem> cpUnitpriceItemList = cpUnitpriceItemMapper.selectByExample(cpUnitpriceItemCriteria);
            delCpUnitpriceItemShm(cpUnitpriceItemList);
             
//          if(cpUnitpriceItemList.size() > 0){
//              for(CpUnitpriceItem item : cpUnitpriceItemList){
//                  //根据CP_UNITPRICE_ITEM.ITEM_EXT_CODE 删除 CP_EXT_INFO
//                  CpExtInfoMapper cpExtInfoMapper = sqlSessionTemplate.getMapper(CpExtInfoMapper.class);
//                  CpExtInfoCriteria cpExtInfoCriteria = new CpExtInfoCriteria();
//                  cpExtInfoCriteria.createCriteria().andExtCodeEqualTo(item.getFeeItemCode().toString());
//
//                  cpExtInfoMapper.deleteByExample(cpExtInfoCriteria);
//              }
//          }
             
            //删除 CpUnitpriceItem  数据库表记录
            cpUnitpriceItemMapper.deleteByExample(cpUnitpriceItemCriteria);
        } 

    }

    /**删除UnitpriceItem 内存表记录
     * 
     * @param cpUnitpriceItemList
     * @author ygz
     * @ApiDocMethod
     */
    private void delCpUnitpriceItemShm(List<CpUnitpriceItem> cpUnitpriceItemList) {
        JSONObject unitpriceItemObject = new JSONObject(); //cpUnitpriceItem

        for (CpUnitpriceItem aUnitpriceItem : cpUnitpriceItemList) {
            unitpriceItemObject.clear();

            unitpriceItemObject.put("FEE_TYPE", aUnitpriceItem.getFeeType());
            unitpriceItemObject.put("PRICE_VALUE", aUnitpriceItem.getPriceValue());  
            unitpriceItemObject.put("SUBJECT_CODE", aUnitpriceItem.getSubjectCode());
            unitpriceItemObject.put("UNIT_TYPE", aUnitpriceItem.getUnitType());
            
            String activeTime = "";
            String inActiveTime = "";  
            DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");   
            try {    
                activeTime = sdf.format(aUnitpriceItem.getActiveTime());
                inActiveTime = sdf.format(aUnitpriceItem.getInactiveTime());
            } catch (Exception e) {
                log.info("Exception = [" + e + "]");
            } 
            
            unitpriceItemObject.put("ACTIVE_TIME", activeTime);  
            unitpriceItemObject.put("INACTIVE_TIME",inActiveTime);   
            unitpriceItemObject.put("ITEM_EXT_CODE",  aUnitpriceItem.getItemExtCode()); 
            unitpriceItemObject.put("FEE_ITEM_CODE", aUnitpriceItem.getFeeItemCode());
            unitpriceItemObject.put("SYSTEM_ID", this.systemId);
            unitpriceItemObject.put("TENANT_ID", this.tenantId);

            //先删除
            log.info("向内存cp_unitprice_item 删除 = [" + unitpriceItemObject.toString() + "]"); 
            dshmSV.initdel("cp_unitprice_item", unitpriceItemObject.toString()); 
        }
    }

    /**删除  CpFactorInfo 内存表的记录
     * 
     * @param factorInfoList
     * @author ygz
     * @ApiDocMethod
     */
    private void delCpFactorInfoShm(List<CpFactorInfo> factorInfoList) {
        JSONObject factorInfoObject = new JSONObject();

        for (CpFactorInfo aFactorInfo : factorInfoList) {               
            //对列表的节点对象逐个处理
            factorInfoObject.clear();
              
            factorInfoObject.put("FACTOR_NAME", aFactorInfo.getFactorName());  
            factorInfoObject.put("FACTOR_VALUE", aFactorInfo.getFactorValue()); 
            factorInfoObject.put("FACTOR_CODE", aFactorInfo.getFactorCode());
            factorInfoObject.put("SYSTEM_ID", this.systemId);
            factorInfoObject.put("TENANT_ID", this.tenantId);
            
            //删除
            log.info("向内存cp_factor_info中 删除 = [" + factorInfoObject.toString() + "]");
            dshmSV.initdel("cp_factor_info", factorInfoObject.toString());  
        }
    }

    /**删除CpUnitpriceInfo内存表记录
     * 
     * @param cpUnitpriceInfo
     * @author ygz
     * @ApiDocMethod
     */
    private void delCpUnitpriceInfoShm(CpUnitpriceInfo cpUnitpriceInfo) {

        JSONObject unitpriceInfoObject = new JSONObject();
         
        unitpriceInfoObject.put("UNITPRICE_CODE", cpUnitpriceInfo.getUnitPriceCode());
        unitpriceInfoObject.put("FACTOR_CODE", cpUnitpriceInfo.getFactorCode());
        unitpriceInfoObject.put("FEE_ITEM_CODE", cpUnitpriceInfo.getFeeItemCode() );
 
        unitpriceInfoObject.put("SYSTEM_ID", this.systemId);
        unitpriceInfoObject.put("TENANT_ID", this.tenantId); 

        //删除共享内存记录
        log.info("向内存cp_unitprice_info中删除 = [" + unitpriceInfoObject.toString() + "]"); 
        dshmSV.initdel("cp_unitprice_info", unitpriceInfoObject);
    }


    public static void main(String [] args){
//        String sDate = "20151228120023"; 
//        
//        Date dDate = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        try {
//            dDate = sdf.parse(sDate);
//            Timestamp st = new Timestamp(dDate.getTime());
//            System.out.println("st = [" + st + "]");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } 
        
        Timestamp ts = new Timestamp(System.currentTimeMillis());   
        String tsStr = "";   
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
        try {
            tsStr = sdf.format(ts);   
            System.out.println(tsStr);    
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
    }
    
}
