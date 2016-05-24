package com.ai.baas.bmc.constants;
/**
 * BMC常量类
 *
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public final class BmcConstants {
	public final static class ResultCode{
    	private ResultCode(){}
    	
    	public static final String SUCCESS_CODE = "000000";
    	
    	public static final String FAIL_CODE = "000001";
    }
    private BmcConstants() {

    }

        public final static class SEQ {
            private SEQ() {
            }
            public static final String PRICE_INFO_ID_SEQ = "CP_PRICE_INFO$PRICE_INFO_ID$SEQ";
            public static final String PRICE_CODE_SEQ = "CP_PRICE_INFO$PRICE_CODE$SEQ";
            public static final String DETAIL_ID_SEQ = "CP_PRICE_DETAIL$DETAIL_ID$SEQ";
            public static final String DETAIL_CODE_SEQ = "CP_PRICE_DETAIL$DETAIL_CODE$SEQ";
            public static final String PRESENT_ID_SEQ = "CP_FULL_PRESENT$PRESENT_ID$SEQ";
            public static final String PRESENT_CODE_SEQ = "CP_FULL_PRESENT$PRESENT_CODE$SEQ";
            public static final String RECORD_FMT_ID_SEQ = "BMC_RECORD_FMT$ID$SEQ";

            
            public static final String REDUCE_CODE_SEQ = "CP_FULL_REDUCE$REDUCE_CODE$SEQ";
            public static final String REDUCE_ID_SEQ = "CP_FULL_REDUCE$REDUCE_ID$SEQ";

        }

        public static final class TenantId {
            private TenantId() {
            }
            public static final String PUB = "PUB";
        }

        public static final class CacheNS{
        	private CacheNS(){
        		
        	}
        	public static final String CACHENS_PROFERENTIALPRODUCT="com.ai.baas.bmc.proferentialprocuct";
        }
        public static final class ProferName{
        	private ProferName(){}
        	/**
        	 * 满赠类型
        	 */
        	public static final String DR_OFFER="dr_offer";
        	/**
        	 * 满赠类型
        	 */
        	public static final String DR_MINUS="dr_minus";
        	/**
        	 * 赠送业务
        	 */
        	public static final String SERVICE_OFFER="service_offer";
        	/**
        	 * 生效
        	 */
        	public static final String ACTIVE="ACTIVE";
        	/**
        	 * 失效
        	 */
        	public static final String INACTIVE="INACTIVE";
        	/**
        	 * 失效状态
        	 */
        	public static final String DEL="DEL";
        }
        
        public static final class MDSNS{
        	//注意参考原来的配置文件的信息，只不过现在要统一进行修改，修改了其中的内容
        	public static final String BMC_KAFKA_TOPIC="baas-bmc-topic"; 
        }

        public static final class CUST{
        	public static final String NORMAL="Normal"; 
        }
}
