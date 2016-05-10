package com.ai.opt.baas.config;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ai.opt.sdk.components.ccs.CCSClientFactory;
import com.ai.opt.sdk.constants.SDKConstants;
import com.ai.paas.ipaas.ccs.IConfigClient;
import com.ai.paas.ipaas.ccs.constants.ConfigException;

public class CCSTest {

    private IConfigClient client;

    @Before
    public void initData() {
        this.client = CCSClientFactory.getDefaultConfigClient();
    }

    @Ignore
    @Test
    public void testGetConfig() throws Exception {
        client.add("/test", "test");
        assertEquals("test", client.get("/test"));
        System.out.println("aaaaaa");
    }

    @Test
    public void addServiceIdPwdMap() throws ConfigException {
    	String cachesnsConfig = "{\"MCS001\":\"" + "123456"     
    			+ "\",\"MCS002\":\"" + "123456"
    			+ "\",\"MDS001\":\"" + "123456"
    			+ "\",\"DSS001\":\"" + "123456"
    			+ "\"}";
        
        // paas serviceid password 映射配置
        if (!client.exists(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH))
            client.add(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH,
                    cachesnsConfig);
        else {
            client.modify(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH,
                    cachesnsConfig);
        }
    }
    //@Ignore
    @Test
    public void addMcsConfig() throws ConfigException {
        // 缓存服务主机
        String mcs002 = "MCS002";
        // 缓存空间
        String cachesnsConfig = "{\"com.ai.runner.center.dshm.cache.calparam\":\"" + mcs002+ "\"}";
        
        

        // 缓存空间配置
        if (!client.exists(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH))
            client.add(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH,
                    cachesnsConfig);
        else {
            client.modify(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH,
                    cachesnsConfig);
        }
    }
    //@Ignore
    @Test
    public void readMcsConfig() throws ConfigException {
    	
    	String cachesns=client.get(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH);
    	
    	System.out.println("cachesns:"+cachesns);
    	
    }

    @Test
    public void addMdsConfig() throws ConfigException {
        // 
        String mds001 = "MDS003";
        // 空间
        String mdssnsConfig = "{\"baas-bmc-topic\":\"" + mds001+ "\"}";

        // MDS空间配置
        if (!client.exists(SDKConstants.PAAS_MDSNS_MDS_MAPPED_PATH))
            client.add(SDKConstants.PAAS_MDSNS_MDS_MAPPED_PATH,
                    mdssnsConfig);
        else {
            client.modify(SDKConstants.PAAS_MDSNS_MDS_MAPPED_PATH,
                    mdssnsConfig);
        }
        
     // 
        String mdsRealTopic = "ECBCA29571714183B23A630E2311DD66_MDS003_195839411";
        // 空间
        String mdstopicConfig = "{\"MDS003\":\"" + mdsRealTopic
                + "\"}";

        // MDS空间配置
        if (!client.exists(SDKConstants.PAAS_MDS_TOPIC_MAPPED_PATH))
            client.add(SDKConstants.PAAS_MDS_TOPIC_MAPPED_PATH,
            		mdstopicConfig);
        else {
            client.modify(SDKConstants.PAAS_MDS_TOPIC_MAPPED_PATH,
            		mdstopicConfig);
        }
        
    }
    
    @Test
    public void addDssConfig() throws ConfigException {
        // 缓存服务主机
        String dssId = "DSS001";
        // 缓存空间
        String dssnsConfig = "{\"baas-bmc-dss\":\"" + dssId
                + "\",\"baas-amc-dss\":\"" + dssId
                + "\",\"baas-omc-dss\":\"" + dssId
                + "\",\"baas-smc-dss\":\"" + dssId + "\"}";
        
        

        // 缓存空间配置
        if (!client.exists(SDKConstants.PAAS_DSSNS_DSS_MAPPED_PATH))
            client.add(SDKConstants.PAAS_DSSNS_DSS_MAPPED_PATH,
                    dssnsConfig);
        else {
            client.modify(SDKConstants.PAAS_DSSNS_DSS_MAPPED_PATH,
                    dssnsConfig);
        }
    }

    /**
     * DBS配置
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

}