package com.ai.opt.baas.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.custInfo.interfaces.ICustInfoQuerySV;
import com.ai.baas.bmc.api.custInfo.params.QueryCustInfoRequest;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class CustInfoQueryTest {
	@Autowired
	protected ApplicationContext ctx;

	public <T> T getBean(Class<T> type) {
		return ctx.getBean(type);
	}

	public Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
	@Autowired
	private ICustInfoQuerySV iCustInfoQuerySV;
	@Test
	public void testCustInfoQuery(){
		QueryCustInfoRequest request=new QueryCustInfoRequest();
		
		request.setCustGrade("A");
		request.setCustName(null);
		request.setIdNumber("41148119921213337X");
		request.setTenantId("VIV-BYD");
		request.setPageNo(1);
		request.setPageSize(10);
		request.setTradeSeq("123123213");
		System.out.println("------------------>"+JSON.toJSONString(iCustInfoQuerySV.getCustInfos(request)));
		
	}
}
