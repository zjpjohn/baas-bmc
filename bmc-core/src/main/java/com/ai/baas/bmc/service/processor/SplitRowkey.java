package com.ai.baas.bmc.service.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.LoggerUtil;
import com.ai.baas.dshm.client.interfaces.IDshmClient;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import java.util.Map.Entry;

public class SplitRowkey {
	private DshmUtil instance=null;
	private IDshmClient client;
    private ICacheClient cacheClient; 
	public List<Map<String,String>> getSubsInfo(String tenantId,String serviceId){
		cacheClient=instance.getCacheClient();
		Map<String,String> params = new TreeMap<String,String>();
		params.put("service_id", serviceId);
		params.put("tenant_id", tenantId);
		List<Map<String, String>> results=client.list("bl_userinfo")
				.where(params) 
				.executeQuery(cacheClient);
//		List<Map<String, String>> results=new ArrayList<Map<String,String>>();
//		Map<String, String> result=new HashMap<String, String>();
//		result.put("subs_id", "s2681");
//		result.put("cust_id", "2681");
//		result.put("acct_id", "2681");
//		result.put("service_id", "iccid2681");
//		results.add(result);
		return results;
	}
	
	public List<Map<String, String>> getKeyData(String rowKey,List<Map<String, String>> results ){
		String[] keyDatas=StringUtils.splitPreserveAllTokens(rowKey, ":");
		List<Map<String, String>> rowKeyData=new ArrayList<Map<String,String>>();
		for(Map<String,String> result:results){
			for(String keyData:keyDatas){
				Map<String, String> row=new HashMap<String,String>();
				String key;
				key=result.get(keyData);
				System.out.println("the param name is "+keyData+"  the value is "+key);
				row.put(keyData, key);
				rowKeyData.add(row);
			}
		}
//		for(java.util.Map.Entry<String, String> entry:rowKeyData.entrySet()){
//			System.out.println("the map test name is "+entry.getKey()+"  the value is "+entry.getValue());
//		}
		return rowKeyData;
	}
	

}
