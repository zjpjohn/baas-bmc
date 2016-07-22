package com.ai.opt.baas.bmc.test.api.iCurrMonthUsgQueryImplTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.currmonthusgquery.interfaces.ICurrMonthUsgQuery;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryReq;
import com.ai.baas.bmc.api.currmonthusgquery.parameters.CurrMonthUsgQueryResp;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class CurrMonthUsgQueryImplTest {
	@Autowired ICurrMonthUsgQuery iCurrMonthUsgQuery;
	@Test
	public void testCurrMonthUsgQuery() {
		CurrMonthUsgQueryReq req = new CurrMonthUsgQueryReq();
		req.setApnCode("ALL");
		req.setBeginMonth("201604");
		req.setCustId("1234");
		req.setEndMonth("201604");
		req.setMsgSeq("002");
		req.setServiceNum("23456");
		req.setSubsId("222");
		req.setTenantId("viv-runner-viv-byd");
		req.setTenantPwd("123");
		CurrMonthUsgQueryResp currMonthUsgQuery = iCurrMonthUsgQuery.currMonthUsgQuery(req);
		System.out.println("11111111111");
		System.out.println(currMonthUsgQuery.getMonthList().get(0));
	}

}
