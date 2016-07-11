package com.ai.opt.baas.bmc.test.api.pricemaking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.pricemaking.params.ElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.OrderTypeInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfo;
import com.ai.baas.bmc.api.pricemaking.params.PriceElementInfoZX;
import com.ai.baas.bmc.api.pricemaking.params.PriceInfo;
import com.ai.baas.bmc.api.pricemaking.params.ShoppingList;
import com.ai.baas.bmc.service.business.interfaces.IPricemakingBusiSV;
import com.ai.opt.sdk.dubbo.util.HttpClientUtil;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class PricemakingSVRestTest {
    @Autowired
    protected ApplicationContext ctx;

    @Test
    public void queryPricemakingZX() {
        String parameters="{\"AERA_ID\":\"HuaBei1\",\"CPU_MEM\":\"2C4G\",\"IO_OPTI\":\"YES\",\"OS\":\"win\",\"SERIAL_ID\":\"1\"}";
        ShoppingList shoppingList=new ShoppingList();
        shoppingList.setList_id("1");
        shoppingList.setService_id("");
        shoppingList.setParameters(parameters);
        PriceElementInfoZX request=new PriceElementInfoZX();
        List<ShoppingList> shopping_lists=new ArrayList<ShoppingList>();
        request.setShopping_lists(shopping_lists);
        
//        elementInfo2.setName("AERA_ID");
//        elementInfo2.setValue("HuaNan1");
//        elementInfoList2.add(elementInfo2);
//        elementInfo2=new ElementInfo();
//        elementInfo2.setName("DISK_TYPE");
//        elementInfo2.setValue("SSD");
//        elementInfoList2.add(elementInfo2);
//        elementInfo2=new ElementInfo();
//        elementInfo2.setName("USE_TYPE");
//        elementInfo2.setValue("SYSTEM");
//        elementInfoList2.add(elementInfo2);
//        elementInfo2=new ElementInfo();
//        elementInfo2.setName("AMOUNT");
//        elementInfo2.setValue("50");
//        elementInfoList2.add(elementInfo2);
//        orderTypeInfo.setElementInfoList(elementInfoList2);
//        orderTypeList.add(orderTypeInfo);

HttpClientUtil.
        System.out.println(JSON.toJSONString(infos));
    }

}
