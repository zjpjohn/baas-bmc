package com.ai.opt.baas.bmc.test.api.pricemaking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfoZX;
import com.ai.baas.bmc.api.pricemaking.params.ShoppingList;
import com.ai.opt.sdk.dubbo.util.HttpClientUtil;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class PricemakingSVRestTest {
    @Autowired
    protected ApplicationContext ctx;

    @Test
    public void queryPricemakingZX() {
        // ECS-INSTANCE
        String parameters1 = "{\"InstanceChargeType\":\"PostPaid\",\"InstanceType\":\"ecs.n1.tiny\",\"RegionId\":\"cn-hangzhou\",\"DataDisk.1.Category\":\"cloud\",\"SystemDisk.Category\":\"cloud\", \"InternetMaxBandwidthOut\":\"12\", \"InternetChargeType\":\"PayByTraffic\", \"DataDisk.1.Size\":\"13\", \"SystemDisk.Size\":\"14\"}";

        ShoppingList shoppingList1 = new ShoppingList();
        shoppingList1.setList_id("1");
        shoppingList1.setService_id("576206bb6ae6ca04e145958d");
        shoppingList1.setParameters(parameters1);

        // ECS-DISK
        // String parameters2 =
        // "{\"AERA_ID\":\"HuaNan1\", \"DISK_TYPE\":\"SSD\", \"USE_TYPE\":\"SYSTEM\", \"AMOUNT\":\"50\"}";
        //
        // ShoppingList shoppingList2 = new ShoppingList();
        // shoppingList2.setList_id("2");
        // shoppingList2.setService_id("test2");
        // shoppingList2.setParameters(parameters2);

        List<ShoppingList> shopping_lists = new ArrayList<ShoppingList>();
        shopping_lists.add(shoppingList1);
//        shopping_lists.add(shoppingList2);

        PriceElementInfoZX request = new PriceElementInfoZX();
        request.setShopping_lists(shopping_lists);

        String s = HttpClientUtil.sendPost(
                "http://127.0.0.1:10884/baas-bmc/pricemaking/queryPricemakingZX",
                JSON.toJSONString(request));
        System.out.println("定价查询接口返回结果: " + s);
        System.out.println("success");
    }

}
