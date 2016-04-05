package com.ai.baas.bmc.util;

import com.ai.baas.bmc.constants.BmcConstants.SEQ;
import com.ai.opt.sdk.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.StringUtil;

/**
 * BMC seq 工具类
 *
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public final class BmcSeqUtil {

    private BmcSeqUtil() {
    
    }
    /**
     * 获取priceCode
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static String getPriceCode() {
        Long seq = SeqUtil.getNewId(SEQ.PRICE_CODE_SEQ);
        return StringUtil.toString(seq);
    }
    /**
     * 获取cpPiceId
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static Long getPriceInfoId(){
    	return SeqUtil.getNewId(SEQ.PRICE_INFO_ID_SEQ);
    }
    /**
     * 获取detailCode
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static String getDetailCode() {
        Long seq = SeqUtil.getNewId(SEQ.DETAIL_CODE_SEQ);
        return StringUtil.toString(seq);
    }
    /**
     * 获取detailId
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
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static Long getPresentId(){
    	return SeqUtil.getNewId(SEQ.PRESENT_ID_SEQ);
    }
    /**
     * 获取presentCode
     * @return
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     */
    public static String getPresentCode(){
    	 Long seq = SeqUtil.getNewId(SEQ.PRESENT_CODE_SEQ);
         return StringUtil.toString(seq);
    }
    
}
