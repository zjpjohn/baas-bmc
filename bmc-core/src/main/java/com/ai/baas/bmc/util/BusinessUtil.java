package com.ai.baas.bmc.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.RequestHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;

/**
 * 业务校验工具类<br>
 * Date: 2015年8月12日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author mayt
 */
public final class BusinessUtil {

    private BusinessUtil() {
    }

    /**
     * 报文头校验<br>
     * 
     * @param requestHeader
     * @author mayt
     * @throws BusinessException
     * 
     */
    public static void checkRequestHeader(RequestHeader requestHeader) throws BusinessException {
        if (requestHeader == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "[请求报文头为空]");
        }
        if (StringUtil.isBlank(requestHeader.getApplyChlId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "[报文头渠道ID为空]");
        }
        if (StringUtil.isBlank(requestHeader.getSystemId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "[报文头系统ID为空]");
        }
        if (requestHeader.getOperId() == null || requestHeader.getOperId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "[报文头操作员ID为空]");
        }
    }

    /**
     * 租户信息校验<br>
     * 
     * @param baseInfo
     * @author rui
     * @throws BusinessException
     * @ApiDocMethod
     */
    public static void checkBaseInfo(BaseInfo baseInfo) throws BusinessException {
        if (null == baseInfo) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "[请求报文]为空");
        }
        if (StringUtil.isBlank(baseInfo.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "[租户ID]为空");
        }
    }

    public static String getPriceTypeByServiceId(String service_id) {
        return null;
    }

    public static String getChargeTypeByPriceType(String serviceId) {
        return null;
    }

}
