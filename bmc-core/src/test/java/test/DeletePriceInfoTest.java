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
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class DeletePriceInfoTest {
    @Autowired
    IPriceInfoSV aIPriceInfoSV;
    
    @Test
    public void test(){
        StandardPriceInfoParams param = new StandardPriceInfoParams();
        param.setTenantId("test");
        param.setTradeSeq("1111");
        param.setStandardId("7");
        param.setUpdateId("DELETE");
        param.setStatus("EFFECT");
        System.err.println(JSON.toJSONString(param));
        System.err.println(JSON.toJSONString(aIPriceInfoSV.deletePriceInfo(param)));
    }
}
