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
import com.ai.baas.bmc.api.pricemaking.params.ShoppingList;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.dubbo.util.HttpClientUtil;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContextTest/dubbo-consumer-context.xml" })
public class PricemakingSVDubboTest {
    @Autowired
    protected ApplicationContext ctx;

    @Test
    public void queryPricemakingZX() {

        List<ShoppingList> shopping_lists = new ArrayList<ShoppingList>();
        // ECS-INSTANCE
        String parameters1 = "{\"InstanceChargeType\":\"PostPaid\",\"InstanceType\":\"ecs.n1.tiny\",\"RegionId\":\"cn-hangzhou\",\"DataDisk.1.Category\":\"cloud\",\"SystemDisk.Category\":\"cloud\", \"InternetMaxBandwidthOut\":\"12\", \"InternetChargeType\":\"PayByTraffic\", \"DataDisk.1.Size\":\"13\", \"SystemDisk.Size\":\"14\"}";

        ShoppingList shoppingList1 = new ShoppingList();
        shoppingList1.setList_id("1");
        shoppingList1.setService_id("576206bb6ae6ca04e145958d");
//        shoppingList1.setParameters(parameters1);

        shopping_lists.add(shoppingList1);
        // RDS
        String parameters2 = "{\"RegionId\":\"cn-hangzhou\", \"Engine\":\"SQLServer\", \"DBInstanceClass\":\"rds.mysql.t1.small\", \"DBInstanceStorage\":\"50\", \"DBInstanceNetType\":\"Internet\", \"PayType\":\"Postpaid\", \"UsedTime\":\"2\"}";

        ShoppingList shoppingList2 = new ShoppingList();
        shoppingList2.setList_id("2");
        shoppingList2.setService_id("5762107c6ae6ca04e14595b8");
//        shoppingList2.setParameters(parameters2);

        shopping_lists.add(shoppingList2);

        PriceElementInfoZX request = new PriceElementInfoZX();
        request.setShopping_lists(shopping_lists);
        System.out.println(JSON.toJSONString(request));
        System.out.println("success");

    }

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

        IPricemakingSV sv = (IPricemakingSV) ctx.getBean(IPricemakingSV.class);
        ResponseMessage responseMessage = sv.queryPricemaking(request);
        System.out.println(JSON.toJSONString(responseMessage));
    }
}
