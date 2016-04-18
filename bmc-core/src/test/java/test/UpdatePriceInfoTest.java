package test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.StanderdPriceInfoUsage;
import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UpdatePriceInfoTest {
    @Autowired
    IPriceInfoSV aIPriceInfoSV;
    
    @Test
    public void test(){
        StandardPriceInfoParams param = new StandardPriceInfoParams();
//        param.setTenantId("test");
//        param.setTradeSeq("11266666");
//        param.setPriceName("testPriceName");
//        param.setServiceType("testServiceType");
//        param.setUsageList(new ArrayList<StanderdPriceInfoUsage>());
//        StanderdPriceInfoUsage usage = new StanderdPriceInfoUsage();
//        usage.setAmount(111);
//        usage.setSubServiceType("testServiceType");
//        usage.setUnit("分钟");
//        param.getUsageList().add(usage);
//        param.setPrice(4.5);
//        param.setUpdateId("CREATE");
//        param.setComments("本机自测用");
        param =  JSONObject.parseObject(
                "{\"serviceType\":\"VOICE\",\"comments\":\"\",\"tenantPwd\":\"\",\"cycleId\":\"\",\"priceType\":\"\",\"standardId\":\"163\",\"cycleAmount\":0,\"cycleType\":\"\",\"updateId\":\"UPDATE\",\"price\":123,\"tenantId\":\"7BAF6267AE2F421FA8D1E305EE35C4BA\",\"priceName\":\"test02\",\"tradeSeq\":\"7BAF6267AE2F421FA8D1E305EE35C4BA2016041815213185734d95453-fb20-4a12-a395-8cbda644a262\",\"status\":\"NOTEFFECT\",\"usageList\":[{\"amount\":1,\"subServiceType\":\"CALL_OUT\",\"unit\":\"MIN\"}]}"
                , StandardPriceInfoParams.class);
        System.out.println("param="+com.alibaba.fastjson.JSON.toJSONString(param));
        System.out.println(aIPriceInfoSV.updatePriceInfo(param));
    }
}
