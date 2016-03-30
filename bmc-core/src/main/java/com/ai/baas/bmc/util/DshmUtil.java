package com.ai.baas.bmc.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.baas.bmc.context.Constants;
import com.ai.baas.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.ai.runner.center.dshm.api.dshmservice.interfaces.IdshmreadSV;

public class DshmUtil {
    private static IdshmreadSV dshmread;

    private static Properties prop;

    private static DshmUtil instance;

    private IdshmSV aIdshmSV;

    private ClassPathXmlApplicationContext context;

    private DshmUtil() {
        context = new ClassPathXmlApplicationContext("dubbo/consumer/dubbo-consumer.xml");
        context.registerShutdownHook();
        context.start();
        aIdshmSV = context.getBean(IdshmSV.class);
    }

    private static DshmUtil getInstance() {
        if (instance == null) {
            return new DshmUtil();
        }
        return instance;
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
        return getInstance().aIdshmSV;
    }
}
