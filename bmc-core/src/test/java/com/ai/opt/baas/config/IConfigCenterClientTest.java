package com.ai.opt.baas.config;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ai.opt.sdk.components.ccs.CCSClientFactory;
import com.ai.opt.sdk.constants.SDKConstants;
import com.ai.paas.ipaas.ccs.IConfigClient;
import com.ai.paas.ipaas.ccs.constants.ConfigException;

public class IConfigCenterClientTest {

    private IConfigClient client;

    @Before
    public void initData() {
        this.client = CCSClientFactory.getDefaultConfigClient();
    }

    @Test
    public void testGetConfig() throws Exception {
        client.add("/test", "test");
        assertEquals("test", client.get("/test"));
        System.out.println("aaaaaa");
    }

    @Test
    public void addMcsConfig() throws ConfigException {
        // 缓存服务主机
        String MCS001 = "MCS001";
        // 缓存空间
        String cachesnsConfig = "{\"com.ai.baas.bmc.proferentialprocuct\":\"" + MCS001
                + "\",\"com.ai.runner.center.dshm.cache.calparam\":\"" + MCS001
                + "\", \"com.ai.baas.bmc.api.baseInfo\":\"" + MCS001 + "\"}";

        StringBuilder bu = new StringBuilder();
        bu.append("{");
        bu.append("  \"MCS001\":");
        bu.append("  {                                      ");
        bu.append("		  \"mcs.host\":\"10.1.130.84:16379\",     ");
        bu.append("	  	\"mcs.maxtotal\":\"200\",            ");
        bu.append("		  \"mcs.maxIdle\":\"10\",              ");
        bu.append("		  \"mcs.minIdle\":\"5\",               ");
        bu.append("		  \"mcs.testOnBorrow\":\"true\",       ");
        bu.append("		  \"mcs.password\":\"\"          ");
        bu.append("  }                                     ");
        bu.append("}                                        ");

        // 缓存服务主机和密码设置
        if (!client.exists(SDKConstants.SDK_MODE_PAAS_MCS_REDIS_MAPPED_PATH)) {
            client.add(SDKConstants.SDK_MODE_PAAS_MCS_REDIS_MAPPED_PATH, bu.toString());
        } else {
            client.modify(SDKConstants.SDK_MODE_PAAS_MCS_REDIS_MAPPED_PATH, bu.toString());
        }

        // 缓存空间配置
        if (!client.exists(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH))
            client.add(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH, cachesnsConfig);
        else {
            client.modify(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH, cachesnsConfig);
        }
    }

    @Ignore
    @Test
    public void readMcsConfig() throws ConfigException {

        String cachesns = client.get(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH);
        String redisconf = client.get(SDKConstants.SDK_MODE_PAAS_MCS_REDIS_MAPPED_PATH);

        System.out.println("cachesns:" + cachesns);
        System.out.println("redisconf:" + redisconf);

    }

    /**
     * DBS配置
     * 
     * @throws ConfigException
     */
    @Test
    public void addDbConfInfo() throws ConfigException {
        System.out.println("DBConf config ... start");
        StringBuilder sb = new StringBuilder();

        sb.append("{																																																				");
        sb.append("		\"opt-bmc-db\":                                                                                   ");
        sb.append("		{                                                                                                     ");
        sb.append("			\"driverClassName\":\"com.mysql.jdbc.Driver\",                                                          ");
        sb.append("			\"jdbcUrl\":\"jdbc:mysql://10.1.235.245:31306/dev_baas_bmc1?useUnicode=true&characterEncoding=UTF-8\",   ");
        sb.append("			\"username\":\"bmcusr01\",                                                                         ");
        sb.append("			\"password\":\"bmcusr01_123\",                                                                         ");

        sb.append("			\"autoCommit\":\"true\",                                                                                ");
        sb.append("			\"connectionTimeout\":\"30000\",                                                                        ");
        sb.append("			\"idleTimeout\":\"600000\",                                                                             ");
        sb.append("			\"maxLifetime\":\"1800000\",                                                                            ");
        sb.append("			\"maximumPoolSize\":\"10\"                                                                              ");
        sb.append("		}                                                                                                     ");
        sb.append("}                                                                                                        ");

        if (!client.exists(SDKConstants.DB_CONF_PATH)) {
            client.add(SDKConstants.DB_CONF_PATH, sb.toString());
        } else {
            client.modify(SDKConstants.DB_CONF_PATH, sb.toString());
        }

        System.out.println("DBConf config ... end");
    }

    @Test
    public void queryDbConfInfo() throws ConfigException {
        System.out.println("DBConf config ... start");
        StringBuilder sb = new StringBuilder();
        String dbconf = client.get(SDKConstants.DB_CONF_PATH);

        System.out.println("DBConf config:" + dbconf);
    }

}