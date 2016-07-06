package com.ai.baas.bmc.util;

import com.ai.baas.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.ai.baas.dshm.client.CacheFactoryUtil;
import com.ai.baas.dshm.client.impl.CacheBLMapper;
import com.ai.baas.dshm.client.impl.DshmClient;
import com.ai.baas.dshm.client.interfaces.IDshmClient;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;

public class DshmUtil {
    private static DshmUtil instance;

    //dubbo服务
    private IdshmSV idshmSV;

    private IDshmClient client;
    //原生cache
    private ICacheClient cacheClient;


    private DshmUtil() {
        idshmSV = DubboConsumerFactory.getService(IdshmSV.class);
        client = new DshmClient();
        cacheClient = CacheFactoryUtil.getCacheClient(CacheBLMapper.CACHE_BL_CAL_PARAM);
    }

    private static DshmUtil getInstance() {
        if (instance == null) {
            instance = new DshmUtil();
        }
        return instance;
    }

    public static IdshmSV getIdshmSV() {
        return getInstance().idshmSV;
    }
    
    public static IDshmClient getClient(){
        return getInstance().client;
    }
    
    public static ICacheClient getCacheClient(){
        return getInstance().cacheClient;
    }
}
