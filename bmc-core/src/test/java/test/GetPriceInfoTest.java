package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.ResponseMessage;
import com.ai.baas.bmc.api.priceinfo.params.StandardList;
import com.ai.baas.bmc.api.priceinfo.params.UsageList;
import com.ai.baas.bmc.business.interfaces.ISysSequenceSvc;
import com.ai.opt.base.vo.PageInfo;
import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class GetPriceInfoTest {
    @Autowired
    IPriceInfoSV iPriceInfoSV;
    
    @Test
    public void test(){
        PageInfo<StandardList> resultPage=new PageInfo<StandardList>();
        QueryInfoParams queryInfoParams = new QueryInfoParams();
        queryInfoParams.setTenantId("baas-test");
        queryInfoParams.setTradeSeq("123456dfdf12322asd2693");
        queryInfoParams.setStandardId("1");
        queryInfoParams.setPriceName("");
        queryInfoParams.setPageNo(1);
        queryInfoParams.setPageSize(20);
        queryInfoParams.setServiceType("");
        queryInfoParams.setSubServiceType("");
//        queryInfoParams.setPriceState(null);
        System.err.println("queryInfoParams："+queryInfoParams.getPriceName()+"kkk");
       
        
        //queryInfoParams =  JSONObject.parseObject("{\"serviceType\":\"\",\"tenantPwd\":\"\",\"pageNo\":1,\"priceState\":\"\",\"standardId\":\"\",\"tenantId\":\"7BAF6267AE2F421FA8D1E305EE35C4BA\",\"pageSize\":20,\"priceName\":\"\",\"tradeSeq\":\"test201604181518035501\"}", QueryInfoParams.class);
        ResponseMessage responseMessage = iPriceInfoSV.getPriceInfo(queryInfoParams);
//        List<StandardList> result= responseMessage.getStandardList().getResult();
//        StandardList standardList = result.get(0);
        System.out.println("param="+com.alibaba.fastjson.JSON.toJSONString(queryInfoParams));
        System.out.println("1");
        System.out.println("responseMessage="+com.alibaba.fastjson.JSON.toJSONString(responseMessage));
       System.out.println("2");

       
    }
}
    
