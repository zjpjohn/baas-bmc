package com.ai.baas.bmc.util;

import com.ai.baas.bmc.constants.BmcConstants.SEQ;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;

/**
 * BMC seq 工具类
 * 
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author gaogang
 */
public final class BmcSeqUtil {

    private BmcSeqUtil() {

    }

    /**
     * 获取priceCode
     * 
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static String getPriceCode() {
        return SeqUtil.getNewId(SEQ.PRICE_CODE_SEQ, 10);
    }

    /**
     * 获取cpPiceId
     * 
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static Long getPriceInfoId() {
        return SeqUtil.getNewId(SEQ.PRICE_INFO_ID_SEQ);
    }

    /**
     * 获取detailCode
     * 
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static String getDetailCode() {
        return SeqUtil.getNewId(SEQ.DETAIL_CODE_SEQ, 10);
    }

    /**
     * 获取detailId
     * 
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static Long getDetailId() {
        return SeqUtil.getNewId(SEQ.DETAIL_ID_SEQ);
    }

    /**
     * 获取presentId
     * 
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static Long getPresentId() {
        return SeqUtil.getNewId(SEQ.PRESENT_ID_SEQ);
    }

    /**
     * 获取presentCode
     * 
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static String getPresentCode() {
        return SeqUtil.getNewId(SEQ.PRESENT_CODE_SEQ, 10);
    }

    public static Long getReduceId() {
        return SeqUtil.getNewId(SEQ.REDUCE_ID_SEQ);
    }

    public static String getReduceCode() {
        return SeqUtil.getNewId(SEQ.REDUCE_CODE_SEQ, 10);
    }

    public static String getCustId() {
        return SeqUtil.getNewId(SEQ.BL_CUSTINFO$CUST_ID$SEQ, 10);
    }

    public static String getAcctId() {
        return SeqUtil.getNewId(SEQ.BL_ACCT_INFO$ACCT_ID$SEQ, 10);
    }

    public static String getSubsId() {
        return SeqUtil.getNewId(SEQ.BL_USERINFO$SUBS_ID$SEQ, 10);
    }

}
