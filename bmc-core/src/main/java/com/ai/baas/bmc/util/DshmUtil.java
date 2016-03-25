package com.ai.baas.bmc.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.baas.bmc.context.Constants;
import com.ai.runner.center.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.ai.runner.center.dshm.api.dshmservice.interfaces.IdshmreadSV;

public class DshmUtil {
    private static IdshmreadSV dshmread;

    private static Properties prop;

    private static IdshmSV aIdshmSV = null;

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "dubbo/consumer/dubbo-consumer.xml");

    static {
    }

    public synchronized static IdshmreadSV getDshmread() {
        if (prop == null) {
            prop = new Properties();
            try {
                prop.load(DshmUtil.class.getClassLoader()
                        .getResourceAsStream("context/config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
                LoggerUtil.log.error(e);
            }
        }
        try {
            dshmread = (IdshmreadSV) ServiceRegiter.registerService(prop.getProperty("dshm.ip"),
                    prop.getProperty("dshm.port"), Constants.ShmServiceCode.SHM_SERVICE_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.log.error(e);
        }
        return dshmread;
    }

    public static IdshmSV getIdshmSV() {
        // ClassPathXmlApplicationContext context = new
        // ClassPathXmlApplicationContext("dubbo/consumer/dubbo-consumer.xml");
        // context.registerShutdownHook();
        // context.start();
        // IdshmSV aIdshmSV = context.getBean(IdshmSV.class);
        // IdshmSV aIdshmSV = DubboConsumerFactory.getService("IdshmSV", IdshmSV.class);
        return aIdshmSV;
    }
}
