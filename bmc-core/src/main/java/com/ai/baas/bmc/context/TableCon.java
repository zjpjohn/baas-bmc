package com.ai.baas.bmc.context;
/**
 * 和表相关的字段
 * Date: 2016年3月24日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public final class TableCon {
    /**
     * hbase的交易流水日志表表名
     */
    public static final String TRADE_SEQ_LOG = "BMC_TRADE_SEQ_LOG";
    /**
     * 客户信息表表名
     */
    public static final String BL_CUSTINFO = "bl_custinfo";
    /**
     * 用户信息表表名
     */
    public static final String BL_USERINFO = "bl_userinfo";
    /**
     * 产品订购信息表表名
     */
    public static final String BL_SUBS_COMM = "bl_subs_comm";
    /**
     * 账户信息表表名
     */
    public static final String BL_ACCT_INFO = "bl_acct_info";
    /**
     * TRADE_SEQ_LOG对应的数据结构名称
     */
    public class ConTradeSeqLog{
        public static final String TENANT_ID = "TENANT_ID";
        public static final String INTERFACE_CODE = "INTERFACE_CODE";
        public static final String TRADE_SEQ = "TRADE_SEQ";
        public static final String RECEIVE_TIME = "RECEIVE_TIME";
        public static final String MSG_CONTENT = "MSG_CONTENT";
    }
    /**
     * BL_CUSTINFO对应的表结构名称
     */
    public class ConBlCustinfo{
        public static final String EXT_CUST_ID = "ext_cust_id";
        public static final String CUST_ID = "cust_id";
    }
    /**
     * BL_USERINFO对应的表结构名称
     */
    public class ConBlUserinfo{
        public static final String TENANT_ID = "tenant_id";
        public static final String CUST_ID = "cust_id";
        public static final String SUBS_ID = "subs_id";
        public static final String ACCT_ID = "acct_id";
        public static final String SERVICE_ID = "service_id";
        public static final String DEAL_TIME = "deal_time";
        public static final String PROVINCE_CODE = "province_code";
        public static final String CITY_CODE = "city_code";
        public static final String CHL_ID = "chl_id";
        public static final String DEV_ID = "dev_id";
        public static final String ACTIVE_TIME = "active_time";
        public static final String INACTIVE_TIME = "inactive_time";
        public static final String REMARK = "remark";
        public static final String SERV_TYPE = "serv_type";
        public static final String USER_TYPE = "user_type";
        public static final String USER_STATE = "user_state";
    }
    /**
     * BL_SUBS_COMM对应的表结构名称
     */
    public class ConBlSubsComm{
        public static final String SUBS_ID = "subs_id";
        public static final String PRODUCT_ID = "product_id";
        public static final String SUBS_PRODUCT_ID = "subs_product_id";
        public static final String RES_BONUS_FLAG = "res_bonus_flag";
        public static final String ACTIVE_TIME = "active_time";
        public static final String INACTIVE_TIME = "inactive_time";
        public static final String TENANT_ID = "tenant_id";
        public static final String CUST_ID = "cust_id";
    }
    
    /**
     * BL_ACCT_INFO对应的表的结构名称
     */
    public class ConBlAcctInfo{
        public static final String TENANT_ID = "tenant_id";
        public static final String ACCT_ID = "acct_id";
        public static final String OWNER_TYPE = "owner_type";
        public static final String OWNER_ID = "owner_id";
        public static final String ACCT_NAME = "acct_name";
        public static final String ACCT_TYPE = "acct_type";
        public static final String CREATE_TIME = "create_time";
        public static final String COMMENTS = "comments";
    }
    
}
