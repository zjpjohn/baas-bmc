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
        public static final String EXT_CUST_ID = "EXT_CUST_ID";
        public static final String CUST_ID = "CUST_ID";
    }
    /**
     * BL_USERINFO对应的表结构名称
     */
    public class ConBlUserinfo{
        public static final String CUST_ID = "CUST_ID";
        public static final String SUBS_ID = "SUBS_ID";
        public static final String ACCT_ID = "ACCT_ID";
    }
    /**
     * BL_SUBS_COMM对应的表结构名称
     */
    public class ConBlSubsComm{
        public static final String SUBS_PRODUCT_ID = "SUBS_PRODUCT_ID";
    }
    
}
