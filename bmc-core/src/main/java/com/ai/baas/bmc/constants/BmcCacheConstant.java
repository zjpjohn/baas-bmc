package com.ai.baas.bmc.constants;

public class BmcCacheConstant {
    public static class Dshm {
        public static class FieldName {
            public static final String TENANT_ID = "TENANT_ID";
            public static final String PRICE_PRODUCT_TYPE = "PRICE_PRODUCT_TYPE";
            public static final String PRICE_PRODUCT_ID = "PRICE_PRODUCT_ID";
            public static final String FACTOR_NAME = "FACTOR_NAME";
            public static final String FACTOR_VALUE = "FACTOR_VALUE";
            public static final String EXT_CUST_ID = "EXT_CUST_ID";
            public static final String ACTIVE_TIME = "ACTIVE_TIME";
            public static final String INACTIVE_TIME = "INACTIVE_TIME";
            public static final String CUST_ID = "CUST_ID";
        }

        public static class TableName {
            public static final String CP_PRICEMAKING_FACTOR = "cp_pricemaking_factor";
            public static final String BL_CUSTINFO = "bl_custinfo";
            public static final String BL_USERINFO = "bl_userinfo";
            public static final String BL_ACCT_INFO = "bl_acct_info";
            public static final String BL_SUBS_COMM = "bl_subs_comm";
            public static final String BL_SUBSCOMM_EXT = "bl_subscomm_ext";
        }
        public static class OptType {
            public static final int INSERT = 1;

            public static final int UPDATE = 0;
        }
    }

}
