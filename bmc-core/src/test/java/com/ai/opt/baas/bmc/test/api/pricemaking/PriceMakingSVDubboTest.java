package com.ai.opt.baas.bmc.test.api.pricemaking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.pricemaking.interfaces.IPriceMakingSV;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfoZX;
import com.ai.baas.bmc.api.pricemaking.params.ResponseMessage;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContextTest/dubbo-consumer-context.xml" })
public class PriceMakingSVDubboTest {
    @Autowired
    protected ApplicationContext ctx;

    @Test
    public void queryPriceMakingZX() {
        IPriceMakingSV sv = (IPriceMakingSV) ctx.getBean("iPriceMakingSV");
        PriceElementInfoZX request = new PriceElementInfoZX();
        ResponseMessage responseMessage = sv.queryPriceMakingZX(request);
        System.out.println(JSON.toJSONString(responseMessage));
    }
}
