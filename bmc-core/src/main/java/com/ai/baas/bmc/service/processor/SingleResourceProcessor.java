package com.ai.baas.bmc.service.processor;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.mds.MDSClientFactory;
import com.ai.paas.ipaas.mds.IMessageSender;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Random;

public class SingleResourceProcessor implements IDeductProcessor {
	private static Properties mdsConfig;
	private static IMessageSender sender;
	public SingleResourceProcessor() throws IOException{
		if (mdsConfig == null) {
            mdsConfig = new Properties();
		}
		InputStream inputStream=SingleResourceProcessor.class.getResourceAsStream("/mds.properties");
		if(inputStream==null){
			throw new SystemException("mds.properties Cannot be find");
		}
		mdsConfig.load(inputStream);
		sender=MDSClientFactory.getSenderClient(mdsConfig.getProperty("resource.mds.topic"));
	}
	@Override
	public void sendToMds(Map<String, String> data) throws Exception {
		Map<String, String> senderData= new HashMap<String, String>();
		Random random=new Random();
		senderData.put("event_id", data.get("sn"));
		senderData.put("business_id", "");
		senderData.put("tenant_id", data.get("tenant_id"));
		senderData.put("acct_id", data.get("acct_id"));
		senderData.put("subs_id", data.get("subs_id"));
		BigDecimal upStream = new BigDecimal(data.get("gprs_up"));
		BigDecimal downStream = new BigDecimal(data.get("gprs_down"));
		BigDecimal initNum= new BigDecimal(0);
		BigDecimal invupStream=initNum.subtract(upStream);
		BigDecimal invdownStream=initNum.subtract(downStream);
		senderData.put("amount",invupStream.add(invdownStream).setScale(0, BigDecimal.ROUND_UP).toPlainString() );
		senderData.put("amount_type","DATA");
		//将Map形式转化成json串
		Gson jsonConverter = new Gson();
		sender.send(jsonConverter.toJson(senderData),random.nextInt(2)%2);
		
	}

}
