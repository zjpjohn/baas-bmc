package com.ai.opt.baas.bmc.test.api.pricemaking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.pricemaking.interfaces.IPricemakingSV;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfoZX;
import com.ai.baas.bmc.api.pricemaking.params.PricemakingResponseZX;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContextTest/dubbo-consumer-context.xml" })
public class PricemakingSVDubboTest {
    @Autowired
    protected ApplicationContext ctx;

    @Test
    public void queryPriceMakingZX() {
        IPricemakingSV sv = (IPricemakingSV) ctx.getBean("iPriceMakingSV");
        PriceElementInfoZX request = new PriceElementInfoZX();
        PricemakingResponseZX responseMessage = sv.queryPricemakingZX(request);
        System.out.println(JSON.toJSONString(responseMessage));
    }
}
