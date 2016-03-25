package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.orderinfo.interfaces.IOrderInfoSV;
import com.ai.baas.bmc.api.orderinfo.params.OrderInfoParams;
import com.ai.baas.bmc.business.interfaces.ISysSequenceSvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class OrderinfoTest {
    @Autowired
    IOrderInfoSV aIOrderInfoSV;
    @Autowired
    ISysSequenceSvc aISysSequenceSvc;
    
    @Test
    public void test(){
        OrderInfoParams a = new OrderInfoParams();
        a.setTenantId("byd");
        a.setTradeSeq("123456693");
        a.setExtCustId("11");
        a.setUsetype("Test");
        a.setState("Normal");
        a.setServiceId("222");
        a.setOrderTime("20130320111111");
        a.setProvinceCode("123456");
        a.setCityCode("012345");
        a.setActiveTime("20130320111111");
        a.setInactiveTime("20160320111111");
        System.out.println(aIOrderInfoSV.orderInfo(a));
        System.err.println("end");
    }
    
//    @Test
//    public void aa(){
//        System.err.println(aISysSequenceSvc.terrigerSysSequence(ConBlUserinfo.SUBS_ID, 1).get(0));
//    }
}
