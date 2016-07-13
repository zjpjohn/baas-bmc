package com.ai.opt.baas.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.drmanager.interfaces.IDrQuery;
import com.ai.baas.bmc.api.drmanager.parameters.DrQueryInputObject;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/context/core-context.xml"})
public class DrqueryTest {
	 @Autowired
	    protected ApplicationContext ctx;

	    public <T> T getBean(Class<T> type) {
	        return ctx.getBean(type);
	    }

	    public Object getBean(String beanName) {
	        return ctx.getBean(beanName);
	    }
	    
	   @Autowired
	   IDrQuery iDrQuery;
	   @Test
	   public void test(){
		  
		   DrQueryInputObject drObject=new DrQueryInputObject();
		   drObject.setApnCode("APN1");
		   drObject.setBeginDate("20160601000000");
		   drObject.setCustId("10007");
		   drObject.setEndDate("20160621235959");
		   drObject.setMsgSeq("1605271713450045565");
		   drObject.setPagecountNum("5");
		   drObject.setPageNum("1");
		   drObject.setServiceNum("iccid10007");
		   drObject.setServiceType("GPRS");
		   drObject.setSubsId("s10007");
		   drObject.setSystemId("111");
		   drObject.setTenantId("VIV-BYD");
		   System.out.println(JSON.toJSONString(iDrQuery.drQueryObj(drObject)));
	   }
	    
}
