package com.ai.opt.baas.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.baseInfo.interfaces.IBaseInfoSV;
import com.ai.baas.bmc.api.baseInfo.params.BaseCodeInfo;
import com.ai.baas.bmc.api.baseInfo.params.ChildeCodeResponse;
import com.ai.baas.bmc.api.baseInfo.params.QueryChildCodeRequest;
import com.ai.baas.bmc.api.baseInfo.params.QueryInfoParams;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/context/core-context.xml"})
public class BaseInfoTest {
	    @Autowired
	    protected ApplicationContext ctx;

	    public <T> T getBean(Class<T> type) {
	        return ctx.getBean(type);
	    }

	    public Object getBean(String beanName) {
	        return ctx.getBean(beanName);
	    }
	    @Autowired
	    IBaseInfoSV iBaseInfoSV;
	    @Test
	  public  void test(){
	    	QueryInfoParams query=new QueryInfoParams();
	    	query.setParamType("SERVICE_TYPE");
	    	query.setTenantId("PUB");
	    	query.setTradeSeq("BYD160323090000130123456789");
	    	System.out.println(JSON.toJSON(query));
	    	BaseCodeInfo bi=iBaseInfoSV.getBaseInfo(query);
	    	System.out.println(JSON.toJSON(bi));
	    }
	    
	    @Test
		  public  void testChild(){
	    	 QueryChildCodeRequest query=new QueryChildCodeRequest();
		    	//query.setTenantId(tenantId);
		    	query.setTenantId("7BAF6267AE2F421FA8D1E305EE35C4BA");
		    	query.setTradeSeq("BYD160323090000130123456789");
		    	query.setParentCode("5");
		    	System.out.println(JSON.toJSON(query));
		    	//BaseCodeInfo bi=iBaseInfoSV.getBaseInfo(query);
		    	//System.out.println(JSON.toJSON(bi));
		    	ChildeCodeResponse res=iBaseInfoSV.getChildCode(query);
		    	System.out.println(JSON.toJSONString(res));
		    }
	
}
