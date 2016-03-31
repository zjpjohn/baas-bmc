package com.ai.baas.bmc.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.baas.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.ai.baas.dshm.client.CacheFactoryUtil;
import com.ai.baas.dshm.client.impl.CacheBLMapper;
import com.ai.baas.dshm.client.impl.DshmClient;
import com.ai.baas.dshm.client.interfaces.IDshmClient;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;

public class DshmUtil {
    private static DshmUtil instance;

    private IdshmSV aIdshmSV;

    private IDshmClient client;

    private ICacheClient cacheClient;

    private ClassPathXmlApplicationContext context;

    private DshmUtil() {
        context = new ClassPathXmlApplicationContext("dubbo/consumer/dubbo-consumer.xml");
        context.registerShutdownHook();
        context.start();
        aIdshmSV = context.getBean(IdshmSV.class);
        client = new DshmClient();
        cacheClient = CacheFactoryUtil.getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
    }

    private static DshmUtil getInstance() {
        if (instance == null) {
            return new DshmUtil();
        }
        return instance;
    }

    public static IdshmSV getIdshmSV() {
        return getInstance().aIdshmSV;
    }
    
    public static IDshmClient getClient(){
        return getInstance().client;
    }
    
    public static ICacheClient getCacheClient(){
        return getInstance().cacheClient;
    }
}
