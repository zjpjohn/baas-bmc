package com.ai.opt.baas.failbill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.failedbillmaintain.interfaces.IFailedBillMaintainSV;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillCriteria;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillPagerResponse;
import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class FailBillTest {
	 @Autowired
	    IFailedBillMaintainSV failedBillMaintainSV;
	 
	 @Test
	    public void queryTest2(){
	    	FailedBillCriteria queryInfo = new FailedBillCriteria();
	    	queryInfo.setTenantId("TR");
	    	queryInfo.setServiceType("VOICE");
//	    	queryInfo.setErrorCode();
	    	FailedBillPagerResponse list = failedBillMaintainSV.queryFailedBills(queryInfo);
	    	System.out.println("标准资费查询出参:"+JSON.toJSONString(list));
	    }
}
