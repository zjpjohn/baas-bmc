package com.ai.opt.baas.bmc.test.api.orderinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.business.interfaces.IOrderinfoBusiSV;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class OrderInfoSVTest {
    @Autowired
    protected ApplicationContext ctx;

    @Test
    public void orderInfo() {
        IOrderinfoBusiSV sv = ctx.getBean(IOrderinfoBusiSV.class);
        OrderInfoParams request=new OrderInfoParams();
        request.setTenantId("test");
        request.setTradeSeq("1");
        sv.writeData(request);
    }
}
