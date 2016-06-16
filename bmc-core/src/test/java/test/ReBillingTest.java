package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.ResponseMessage;
import com.ai.baas.bmc.api.priceinfo.params.StandardList;
import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.baas.bmc.business.interfaces.IReBillingBussiness;
import com.ai.opt.base.vo.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ReBillingTest {
	 @Autowired
	 IReBillingBussiness rebillingImpl;
	    
	    @Test
	    public void test(){
	       // PageInfo<StandardList> resultPage=new PageInfo<StandardList>();
	        ReBillingParam queryInfoParams = new ReBillingParam();
	        queryInfoParams.setBillMonth("201606");
	        queryInfoParams.setBusiType("GPRS");
	        queryInfoParams.setSubsId("s2681");
	        queryInfoParams.setTenantId("VIV-BYD");
//	        queryInfoParams.setPriceState(null);
	       // System.err.println("queryInfoParams："+queryInfoParams.getPriceName()+"kkk");
	       
	        
	        //queryInfoParams =  JSONObject.parseObject("{\"serviceType\":\"\",\"tenantPwd\":\"\",\"pageNo\":1,\"priceState\":\"\",\"standardId\":\"\",\"tenantId\":\"7BAF6267AE2F421FA8D1E305EE35C4BA\",\"pageSize\":20,\"priceName\":\"\",\"tradeSeq\":\"test201604181518035501\"}", QueryInfoParams.class);
	        long result = rebillingImpl.reBilling(queryInfoParams);
//	        List<StandardList> result= responseMessage.getStandardList().getResult();
//	        StandardList standardList = result.get(0);
	        System.out.println("param="+com.alibaba.fastjson.JSON.toJSONString(queryInfoParams));
	        System.out.println("1");
	        //System.out.println("responseMessage="+com.alibaba.fastjson.JSON.toJSONString(responseMessage));
	       System.out.println("2");

	       
	    }

}
