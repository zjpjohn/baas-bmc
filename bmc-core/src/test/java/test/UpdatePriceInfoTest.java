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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class UpdatePriceInfoTest {
    @Autowired
    IPriceInfoSV aIPriceInfoSV;
    
    @Test
    public void test(){
        StandardPriceInfoParams param = new StandardPriceInfoParams();
        param.setTenantId("test");
        param.setTradeSeq("11266666");
        param.setPriceName("testPriceName");
        param.setServiceType("testServiceType");
        param.setUsageList(new ArrayList<StanderdPriceInfoUsage>());
        StanderdPriceInfoUsage usage = new StanderdPriceInfoUsage();
        usage.setAmount(111);
        usage.setSubServiceType("testServiceType");
        usage.setUnit("分钟");
        param.getUsageList().add(usage);
        param.setPrice(4.5);
        param.setUpdateId("CREATE");
        param.setComments("本机自测用");
        System.out.println(aIPriceInfoSV.updatePriceInfo(param));
    }
}
