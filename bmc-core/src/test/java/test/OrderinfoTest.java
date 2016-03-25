package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class OrderinfoTest {
    
    @Test
    public void test(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/consumer/dubbo-consumer.xml");
//        context.registerShutdownHook();
//        context.start();
//        IdshmSV a = context.getBean(IdshmSV.class);
//        System.out.println(a);
//        DshmUtil.getIdshmSV();
    }
}
