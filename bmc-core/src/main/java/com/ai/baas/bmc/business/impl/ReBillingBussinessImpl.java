 package com.ai.baas.bmc.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.baas.bmc.business.interfaces.IReBillingBussiness;
import com.ai.baas.bmc.constants.BmcConstants;
import com.ai.baas.bmc.service.business.interfaces.IGetReProcessClassSV;
import com.ai.baas.bmc.service.business.interfaces.IGetRowKey;
import com.ai.baas.bmc.service.processor.GetDataDetail;
import com.ai.baas.bmc.service.processor.SplitRowkey;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ReBillingBussinessImpl implements IReBillingBussiness {
	@Autowired
    private IGetRowKey getRowKey;
	@Autowired
	private IGetReProcessClassSV reBillingProcess;
	@Override
    public long reBilling(ReBillingParam param) throws BusinessException, SystemException {
    	
    	String serviceId=param.getServiceId();
    	String tenantId=param.getTenantId();
    	String acct=param.getBillMonth();
    	String serviceType=param.getBusiType();
    	StringBuilder rowKeyPart=new StringBuilder();
    	List<Map<String, String>> results=new ArrayList();
    	String rowKey;
        rowKey=getRowKey.getRowKey(param);
    	// 此时需要根据subsId、tenantId 从userinfo表中读取service_id的信息；
    	SplitRowkey getRowKey=new SplitRowkey();
    	results=getRowKey.getSubsInfo(tenantId, serviceId);
    	List<Map<String, String>> rowKeyDatas=new ArrayList<Map<String,String>>();
    	if(null==results||results.isEmpty()){
    		LoggerUtil.log.error("该租户下的用户在缓存中查询不到.......");
    		return -1;
    	}else{
    		rowKeyDatas=getRowKey.getKeyData(rowKey, results);
    	}
    	if(rowKeyDatas.size()==0){
    		LoggerUtil.log.error("该租户下的用户在rowkey取不到数据.......");
    		return -1;
    	}else{
    		int num=0;
    		for(Map<String, String> rowKeyData:rowKeyDatas){
    			for(Entry<String, String> data: rowKeyData.entrySet()){
    				if("service_type".equals(data.getKey())&&num==0)
    					rowKeyPart.append(serviceType).append(BmcConstants.SEQ.ROWKEY_SPLIT);

	    			if(""!=data.getValue()&&null!=data.getValue()){
	    				rowKeyPart.append(data.getValue()).append(BmcConstants.SEQ.ROWKEY_SPLIT);
	    			}else{
	    				num++;
	    				break;		
	    			}
    			}
    		}
    	}
    	//开始进行rowkey的模糊匹配
    	StringBuilder tableName=new StringBuilder();
    	tableName.append(tenantId).append(BmcConstants.SEQ.BMC_BAK_HTABLE_SPLIT).append(serviceType)
    	.append(BmcConstants.SEQ.BMC_BAK_HTABLE_SPLIT).append("DR").append(BmcConstants.SEQ.BMC_BAK_HTABLE_SPLIT)
    	.append(acct);
    	Map<String, Object> datas=MyHbaseUtil.resGetData(tableName.toString(), rowKeyPart.deleteCharAt(rowKeyPart.length()-1).toString());
    	GetDataDetail dataDetail=new GetDataDetail(tenantId,serviceType,acct,reBillingProcess);
    	//Map<String, Object> datas=dataDetail.resultToMap(resultScan);
    	try{
	    	boolean ifsuc=dataDetail.sendToHbase(datas);
	    	if(ifsuc)
	    		return 0;
	    	else 
	    		return -1;
    	}catch(Exception e){
    		e.printStackTrace();
    		return -1;
	    }
        //return 0;
    }
}
