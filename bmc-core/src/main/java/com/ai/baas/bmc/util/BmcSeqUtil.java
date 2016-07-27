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
        return String.valueOf(SeqUtil.getNewId(SEQ.PRICE_CODE_SEQ));
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
        return String.valueOf(SeqUtil.getNewId(SEQ.DETAIL_CODE_SEQ));
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
        return String.valueOf(SeqUtil.getNewId(SEQ.BL_CUSTINFO$CUST_ID$SEQ));
    }

    public static String getAcctId() {
        return String.valueOf(SeqUtil.getNewId(SEQ.BL_ACCT_INFO$ACCT_ID$SEQ));
    }

    public static String getSubsId() {
        return String.valueOf(SeqUtil.getNewId(SEQ.BL_USERINFO$SUBS_ID$SEQ));
    }

    public static Integer getSubscommExtId() {
        return SeqUtil.getNewId(SEQ.BL_SUBSCOMM_EXT$EXT_ID$SEQ).intValue();
    }

    public static String getSubsProductId() {
        return String.valueOf(SeqUtil.getNewId(SEQ.BL_SUBS_COMM$SUBS_PRODUCT_ID$SEQ));
    }

}
