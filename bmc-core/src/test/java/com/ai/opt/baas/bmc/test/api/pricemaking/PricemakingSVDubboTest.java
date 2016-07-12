package com.ai.opt.baas.bmc.test.api.pricemaking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.pricemaking.interfaces.IPricemakingSV;
import com.ai.baas.bmc.api.pricemaking.params.ElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.OrderTypeInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfoZX;
import com.ai.baas.bmc.api.pricemaking.params.PricemakingResponseZX;
import com.ai.baas.bmc.api.pricemaking.params.ResponseMessage;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContextTest/dubbo-consumer-context.xml" })
public class PricemakingSVDubboTest {
    @Autowired
    protected ApplicationContext ctx;

    @Test
    public void queryPriceMaking() {
        List<ElementInfo> elementInfoList = new ArrayList<ElementInfo>();
        ElementInfo elementInfo = new ElementInfo();
        elementInfo.setName("AERA_ID");
        elementInfo.setValue("HuaBei1");
        elementInfoList.add(elementInfo);
        elementInfo = new ElementInfo();
        elementInfo.setName("CPU_MEM");
        elementInfo.setValue("2C4G");
        elementInfoList.add(elementInfo);
        elementInfo = new ElementInfo();
        elementInfo.setName("IO_OPTI");
        elementInfo.setValue("YES");
        elementInfoList.add(elementInfo);
        elementInfo = new ElementInfo();
        elementInfo.setName("OS");
        elementInfo.setValue("win");
        elementInfoList.add(elementInfo);
        elementInfo = new ElementInfo();
        elementInfo.setName("SERIAL_ID");
        elementInfo.setValue("1");
        elementInfoList.add(elementInfo);

        List<OrderTypeInfo> orderTypeList = new ArrayList<OrderTypeInfo>();
        OrderTypeInfo orderTypeInfo = new OrderTypeInfo();
        orderTypeInfo.setListId("1");
        orderTypeInfo.setPriceType("ECS-INSTANCE");
        orderTypeInfo.setElementInfoList(elementInfoList);
        orderTypeList.add(orderTypeInfo);
        orderTypeInfo = new OrderTypeInfo();
        orderTypeInfo.setListId("2");
        orderTypeInfo.setPriceType("ECS-DISK");
        List<ElementInfo> elementInfoList2 = new ArrayList<ElementInfo>();
        ElementInfo elementInfo2 = new ElementInfo();
        elementInfo2.setName("AERA_ID");
        elementInfo2.setValue("HuaNan1");
        elementInfoList2.add(elementInfo2);
        elementInfo2 = new ElementInfo();
        elementInfo2.setName("DISK_TYPE");
        elementInfo2.setValue("SSD");
        elementInfoList2.add(elementInfo2);
        elementInfo2 = new ElementInfo();
        elementInfo2.setName("USE_TYPE");
        elementInfo2.setValue("SYSTEM");
        elementInfoList2.add(elementInfo2);
        elementInfo2 = new ElementInfo();
        elementInfo2.setName("AMOUNT");
        elementInfo2.setValue("50");
        elementInfoList2.add(elementInfo2);
        orderTypeInfo.setElementInfoList(elementInfoList2);
        orderTypeList.add(orderTypeInfo);

        PriceElementInfo request = new PriceElementInfo();
        request.setTradeSeq("1");
        request.setTenantId("test");
        request.setOrderTypeList(orderTypeList);

        IPricemakingSV sv = DubboConsumerFactory.getService(IPricemakingSV.class);
        ResponseMessage responseMessage = sv.queryPricemaking(request);
        System.out.println(JSON.toJSONString(responseMessage));
    }
}
