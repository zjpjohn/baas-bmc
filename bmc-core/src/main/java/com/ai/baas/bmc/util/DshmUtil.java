package com.ai.baas.bmc.util;

import java.io.IOException;
import java.util.Properties;

import com.ai.baas.bmc.context.Constants;
import com.ai.runner.center.dshm.api.dshmservice.interfaces.IdshmreadSV;
public class DshmUtil {
    private static IdshmreadSV dshmread;
    
    private static Properties prop;
    
//    @Autowired
//    @Qualifier("IdshmSV")
//    private IdshmSV aIdshmSV;
    
    private static DshmUtil instantiation;
    
//    @PostConstruct
//    private void init(){
//        System.err.println(aIdshmSV);
//    }
    
    public synchronized static IdshmreadSV getDshmread() {
        if(prop == null){
            prop = new Properties();
            try {
                prop.load(DshmUtil.class.getClassLoader().getResourceAsStream("context/config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
                LoggerUtil.log.error(e);
            }
        }
        try {
            dshmread = (IdshmreadSV) ServiceRegiter.registerService(prop.getProperty("dshm.ip"), prop.getProperty("dshm.port"),
                    Constants.ShmServiceCode.SHM_SERVICE_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.log.error(e);
        }
        return dshmread;
    }
    
//    public static IdshmSV getIdshmSV(){
////        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/consumer/dubbo-consumer.xml");
////        context.registerShutdownHook();
////        context.start();
////        IdshmSV aIdshmSV = context.getBean(IdshmSV.class);
////        IdshmSV aIdshmSV = DubboConsumerFactory.getService("IdshmSV", IdshmSV.class);
//        return instantiation.aIdshmSV;
//    }
}
