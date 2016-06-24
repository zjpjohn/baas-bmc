package com.ai.opt.baas.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
//	    @Test
//	  public  void test(){
//	    	QueryInfoParams query=new QueryInfoParams();
//	    	query.setParamType("DATA_TEST_URL");
//	    	query.setTenantId("PUB");
//	    	query.setTradeSeq("BYD160323090000130123456789");
//	    	System.out.println("11111"+JSON.toJSON(query));
//	    	BaseCodeInfo bi=iBaseInfoSV.getBaseInfo(query);
//	    	System.out.println("22222"+JSON.toJSON(bi));
//	    }
	    
//	    @Test
//		  public  void testChild(){
//	    	 QueryChildCodeRequest query=new QueryChildCodeRequest();
//		    	//query.setTenantId(tenantId);
//		    	query.setTenantId("7BAF6267AE2F421FA8D1E305EE35C4BA");
//		    	query.setTradeSeq("BYD160323090000130123456789");
//		    	query.setParentCode("5");
//		    	System.out.println("33333"+JSON.toJSON(query));
//		    	//BaseCodeInfo bi=iBaseInfoSV.getBaseInfo(query);
//		    	//System.out.println(JSON.toJSON(bi));
//		    	ChildeCodeResponse res=iBaseInfoSV.getChildCode(query);
//		    	System.out.println(JSON.toJSONString(res));
//		    }
	@Test
	public void testJson(){
		//JSONObject jsonObject=new JSONObject();
		Map<String, String> userMap=new HashMap<String,String>();
				String json="{\"users\": [{\"user_id\": \"6ba76566-0251-4e1a-a188-64e1b2d26be2\",\"employee_id\": \"009528\",\"name\": \"张三\",\"mail\": \"someone@citic.com\",\"cell\": \"13600000000\",\"org_id\": \"52dbb3e5-ec31-4989-be82-705123c45eef\",\"roles\": [{\"role_id\": \"3\"}],\"services\": [{\"service_id\": \"cffe8d3c-7628-4378-a07f-a7bf6c3871a0\"},{\"service_id\": \"b1305db4-c5e3-4413-80fa-b0273536d0b5\"}],\"operating_services\": [{\"service_id\": \"b2b73f3b-0aa0-4000-9c8e-1449a0d3cf87\"}, {\"service_id\": \"fd634834-59a1-416d-a124-f74fb99069d9\"}]}]}";
				JSONObject jsonObject= JSONObject.fromObject((Object)json);
				  String value=null;
				  for(Object firstV:jsonObject.keySet()){
					  
					  value=String.valueOf(jsonObject.get(firstV));
					 // System.out.println("the key is "+firstV+"   the firstValueis "+jsonObject.get(firstV));
				  }
//				  while(it.hasNext()){
//					  String key=String.valueOf(it.next());
//					  value=jsonObject.getString(key);
//					  //System.out.println("the key is "+key+"   the value is "+value);
//				  }
		       JSONObject jsonDetail=JSONObject.fromObject((Object)value.substring(1, value.length()-1));
		       System.out.println("the jsonDetail is "+jsonDetail);
		      for(Object k:jsonDetail.keySet()){
		    	  System.out.println("the value is "+jsonDetail.get(k));
		    	  userMap.put(String.valueOf(k), String.valueOf(jsonDetail.get(k)));
		      }

		//System.out.println("the value of the user context is "+userContext);
		//String users = jsonArray.getString("users"); 
//		for(int i=0;i<jsonArray.size();i++){
//			System.out.println("the value is "+jsonArray.getString(i));
//		}
		
	}
}
