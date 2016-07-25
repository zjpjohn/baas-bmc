package com.ai.baas.bmc.constants;

/**
 * BMC常量类
 * 
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author gaogang
 */
public final class BmcConstants {
    public final static class ResultCode {
        private ResultCode() {
        }

        public static final String SUCCESS_CODE = "000000";

        public static final String FAIL_CODE = "000001";
    }

    public static final class BlAcctInfo {

        public static final class OwnerType {

            public static final String CUST = "CUST";

            public static final String USER = "USER";
        }
    }

    public static final class CpPriceInfo {

        public static final class ActiveStatus {

            public static final String ACTIVE = "ACTIVE";

            public static final String INACTIVE = "INACTIVE";

            public static final String DEL = "DEL";
        }

    }

    public static final class CpPriceDetail {

        public static final class ChargeType {

            public static final String CUNIT = "CUNIT";

            public static final String PACKAGE = "PACKAGE";

            public static final String STEP = "STEP";

            public static final String UNIT = "UNIT";
        }

    }

    public static final class BlCustinfo {

        public static final class State {

            /**
             * 正常
             */
            public static final String NORMAL = "Normal";

            /**
             * 未返档
             */
            public static final String NODOC = "NoDoc";

            /**
             * 注册
             */
            public static final String REGISTER = "Register";

            /**
             * 欠费
             */
            public static final String OWEFEE = "OweFee";

            /**
             * 冻结
             */
            public static final String FREEZE = "Freeze";

        }

    }

    public static final class ZxServiceId {

        public static final String ECS = "576206bb6ae6ca04e145958d";

        public static final String RDS = "5762107c6ae6ca04e14595b8";

        public static final String CS = "57721abd2fa45f06e1c013d2";

        public static final String KVS = "5785e232b9aa1e3769039c19";

        public static final String ONS = "57721e052fa45f06e1c013da";

        public static final String OSS = "57721cb62fa45f06e1c013d6";

    }

    public static final class CpPricemakingFactor {

        public static final class FactorName {

            public static final String REGION_ID = "RegionId";

            public static final String INSTANCE_TYPE = "InstanceType";

            public static final String INSTANCE_CHARGE_TYPE = "InstanceChargeType";

            public static final String PERIOD = "Period";

            public static final String SYSTEM_DISK_CATEGORY = "SystemDisk.Category";

            public static final String SYSTEM_DISK_SIZE = "SystemDisk.Size";

            public static final String INTERNET_CHARGE_TYPE = "InternetChargeType";

            public static final String INTERNET_MAX_BANDWIDTH_OUT = "InternetMaxBandwidthOut";

        }

        public static final class PriceProductType {

            public static final String ECS_INSTANCE = "ECS-INSTANCE";

            public static final String ECS_SYSTEM_DISK = "ECS-SYSTEM-DISK";

            public static final String ECS_DATA_DISK = "ECS-DATA-DISK";

            public static final String ECS_BANDWITH = "ECS-BANDWITH";

            public static final String KVS = "KVS";

            public static final String RDS = "RDS";

        }

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

        public static final String REDUCE_CODE_SEQ = "CP_FULL_REDUCE$REDUCE_CODE$SEQ";

        public static final String REDUCE_ID_SEQ = "CP_FULL_REDUCE$REDUCE_ID$SEQ";

        public static final String BL_CUSTINFO$CUST_ID$SEQ = "BL_CUSTINFO$CUST_ID$SEQ";

        public static final String BL_ACCT_INFO$ACCT_ID$SEQ = "BL_ACCT_INFO$ACCT_ID$SEQ";

        public static final String BL_USERINFO$SUBS_ID$SEQ = "BL_USERINFO$SUBS_ID$SEQ";

        public static final String BL_SUBSCOMM_EXT$EXT_ID$SEQ = "BL_SUBSCOMM_EXT$EXT_ID$SEQ";

        public static final String BL_SUBS_COMM$SUBS_PRODUCT_ID$SEQ = "BL_SUBS_COMM$SUBS_PRODUCT_ID$SEQ";

    }

    public static final class TenantId {
        private TenantId() {
        }

        public static final String PUB = "PUB";

        public static final String ZX = "test";
    }

    public static final class CacheNS {
        private CacheNS() {

        }

        public static final String CACHENS_PROFERENTIALPRODUCT = "com.ai.baas.bmc.proferentialprocuct";
    }

    public static class CpPricemakingRule {
        public static class PriceType {
            public static final String PER_MONTH = "PER_MONTH";

            public static final String PER_HOUR = "PER_HOUR";

            public static final String PER_UNIT1G = "PER_UNIT1G";
        }

        public static class RuleCode {
            public static final String CONST = "CONST";

            public static final String EXPR = "EXPR";
        }
    }
}
