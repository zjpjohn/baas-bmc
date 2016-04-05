package com.ai.baas.bmc.constants;
/**
 * BMC常量类
 *
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public final class BmcConstants {

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
            
            
            public static final String REDUCE_CODE_SEQ = "CP_FULL_REDUCE$REDUCE_CODE$SEQ";
            public static final String REDUCE_ID_SEQ = "CP_FULL_REDUCE$REDUCE_ID$SEQ";

        }

        public static final class TenantId {
            private TenantId() {
            }
            public static final String ALL = "all";
        }

        public static final class CacheNS{
        	private CacheNS(){
        		
        	}
        	public static final String CACHENS_PROFERENTIALPRODUCT="com.ai.baas.bmc.proferentialprocuct";
        }

}
