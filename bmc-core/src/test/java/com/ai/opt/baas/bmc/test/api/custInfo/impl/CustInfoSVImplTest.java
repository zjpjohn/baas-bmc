package com.ai.opt.baas.bmc.test.api.custInfo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.custInfo.interfaces.ICustInfoSV;
import com.ai.baas.bmc.api.custInfo.params.CustInfoParams;
import com.ai.baas.bmc.api.custInfo.params.ExtInfo;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class CustInfoSVImplTest {

	@Autowired
	private ICustInfoSV custInfoSv;
	private static final Log log = LogFactory.getLog(CustInfoSVImplTest.class);
	//@Test
	public void testAddCustInfo(){
		CustInfoParams custInfo = new CustInfoParams();
		custInfo.setCityCode("010");
		custInfo.setContactNo("111");
		custInfo.setCustAddress("北京");
		custInfo.setCustGrade("A");
		custInfo.setCustName("习近平");
		custInfo.setCustType("P");
		custInfo.setEmail("xijinping@asiainfo.com");
		custInfo.setExtCustId("1111");
		custInfo.setProvinceCode("010");
		custInfo.setRemark("高级客户11111111");
		custInfo.setState("1");
		custInfo.setStateChgTime("20160415172529");
		custInfo.setTenantId("11111");
		custInfo.setTenantPwd("1111");
		custInfo.setTradeSeq("800115");
		//
		List<ExtInfo> extInfoList = new ArrayList<ExtInfo>();
		ExtInfo extInfo = new ExtInfo();
		extInfo.setExtName("1115");
		extInfo.setExtValue("2223211");
		extInfo.setUpdateFlag("U");
		extInfoList.add(extInfo);
		
		custInfo.setExtInfoList(extInfoList);
		log.info("-----------json param:"+JSON.toJSONString(custInfo));
		String resultCode = this.custInfoSv.custNotify(custInfo);
		log.info("-----------json str:"+JSON.toJSONString(resultCode));
		
		
		Map<String, String> params = new TreeMap<String, String>();
        params.put("EXT_CUST_ID", custInfo.getExtCustId());
        params.put("TENANT_ID", custInfo.getTenantId());
        
        List<Map<String, String>> result = DshmUtil.getClient().list("bl_custinfo").where(params)
                .executeQuery(DshmUtil.getCacheClient());
        log.info("----------result size:"+result.size());
        log.info("----------result json:"+MyJsonUtil.toJson(result));
        
        
	}
	//@Test
	public void testDelCustInfoDhms(){
		Map<String, String> params = new TreeMap<String, String>();
        params.put("EXT_CUST_ID", "1111");
        params.put("TENANT_ID", "11111");
        DshmUtil.getIdshmSV().initdel("bl_custinfo",MyJsonUtil.toJson(params));
        
        List<Map<String, String>> result = DshmUtil.getClient().list("bl_custinfo").where(params)
                .executeQuery(DshmUtil.getCacheClient());
        log.info("----------result size:"+result.size());
        log.info("----------result json:"+MyJsonUtil.toJson(result));
	}
	@Test
	public void testCustInfoExt(){
		Map<String, String> params = new TreeMap<String, String>();
        params.put("CUST_ID", "25");
        params.put("EXT_NAME", "1115");
        
        List<Map<String, String>> result = DshmUtil.getClient().list("bl_custinfo_ext").where(params)
                .executeQuery(DshmUtil.getCacheClient());
        log.info("----------result size:"+result.size());
        log.info("----------result json:"+MyJsonUtil.toJson(result));
	}
}
