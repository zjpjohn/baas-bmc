package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.orderinfo.interfaces.IOrderInfoSV;
import com.ai.baas.bmc.api.orderinfo.params.OrderExt;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.api.orderinfo.params.Product;
import com.ai.baas.bmc.api.orderinfo.params.ProductExt;
import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.baas.bmc.service.business.interfaces.ISysSequenceSvc;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class OrderinfoTest {
    @Autowired
    IOrderInfoSV aIOrderInfoSV;
    @Autowired
    ISysSequenceSvc aISysSequenceSvc;
    
    @Test
    public void test(){
        
        System.setProperty("hadoop.home.dir","D:/hadoop/hadoop-2.4.1" );
        
        OrderInfoParams a = new OrderInfoParams();
        
//        OrderExt o = new OrderExt();
//        Product p = new Product();
//        ProductExt pe = new ProductExt();
//        List<OrderExt> orderExtList = new ArrayList<>();
//        List<Product> productList = new ArrayList<>();
//        List<ProductExt> productExtInfoList = new ArrayList<>();
//        a.setTenantId("VIV-BYD");        
//        a.setExtCustId("122301");//外部客户ID
//        a.setServiceId("77777777777777");
//        a.setTradeSeq("99913299343123991231111");
//
//        a.setUsetype("Test");
//        a.setState("Normal");
//        
//        a.setOrderTime("20130320111111");
//        a.setProvinceCode("07777");
//        a.setCityCode("012345");
//        a.setChlId("Normal");
//        a.setDevId("test");
//        a.setActiveTime("20130320111111");
//        a.setInactiveTime("20160320111111");
//        a.setRemark("666666");
//            o.setExtName("test-BAAS");
//            o.setExtValue("test-BAAS");
//            o.setUpdateFlag("N");
//            orderExtList.add(o);
//            a.setOrderExtInfo(orderExtList);
//            
//            p.setProductId("test3");
//            p.setProductNumber(1);
//            p.setResBonusFlag("Y");
//            p.setActiveTime("20150406235959");
//            p.setInactiveTime("20200406235959");
//                pe.setExtName("扩展信息");
//                pe.setExtValue("没用");
//                pe.setUpdateFlag("N");
//                productExtInfoList.add(pe);
//             p.setProductExtInfoList(productExtInfoList);
//             productList.add(p);
//         a.setProductList(productList);

         a =  JSONObject.parseObject(
                 "{\"tradeSeq\" : \"vi3333111\",  \"tenantId\":\"VIV-BYD\",  \"extCustId\" : \"test22\",  \"usetype\" : \"Normal\",  \"state\" : \"Test\",  \"serviceId\" : \"GRO20160406235959\",  \"orderTime\" : \"20160406085959\",  \"provinceCode\" : \"123456\",  \"cityCode\" : \"013CC1\",  \"chlId\" : \"GRO20160406235959099999512345678\",  \"devId\" : \"GRO20160406235959099999512345678\",  \"activeTime\" : \"20160406235959\",  \"inactiveTime\" : \"20190406235959\",  \"remark\" : \"test22\" ,                                                                  \"orderExtInfo\" : [       {       \"extName\" : \"remind_num\",       \"extValue\" : \"18501956112\",        \"updateFlag\" : \"U\"        }      ],  \"productList\" : [       {       \"productId\" :\"test22\",       \"productNumber\" : 1,       \"resBonusFlag\"  : \"Y\",       \"activeTime\" : \"20150410235959\",       \"inactiveTime\":\"20200411235959\",        \"productExtInfoList\" : [         {         \"extName\" :\"test22\",         \"extValue\" : \"GRO20160406235959099999512345678GRO20160406235959099999512345678\",             \"updateFlag\" : \"N\"         }       ]             }    ] } "
                 , OrderInfoParams.class);
         
        System.out.println(JSON.toJSONString(aIOrderInfoSV.orderInfo(a)));

        System.err.println(JSON.toJSONString(a));
        System.err.println("end");
    }
    
//    @Test
//    public void aa(){
//        System.err.println(aISysSequenceSvc.terrigerSysSequence(ConBlUserinfo.SUBS_ID, 1).get(0));
//    }
}
