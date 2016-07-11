package com.ai.baas.bmc.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.RequestHeader;
import com.ai.opt.sdk.constants.ExceptCodeConstants;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.fastjson.JSON;

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
        if ("test1".equals(service_id)) {
            return "ECS-INSTANCE";
        } else if ("test2".equals(service_id)) {
            return "ECS-DISK";
        }
        return null;
    }

    public static String getChargeTypeByPriceType(String serviceId) {
        return null;
    }

    /**
     * 将属性名转换成表的列名 userId -> user_id
     * 
     * @param name
     * @return
     * @author mayt
     * @ApiDocMethod
     */
    static String switchParam(String name) {

        if (name.matches("[a-z]+[A-Z][a-z]+([A-Z][a-z]+)*")) {

            Pattern pattern = Pattern.compile("[A-Z]");

            Matcher matcher = pattern.matcher(name);

            while (matcher.find()) {

                String old = matcher.group();
                String ne = matcher.group().toLowerCase();

                name = name.replaceAll(old, "_" + ne);

            }

        }
        return name;
    }

    public static Map<String, String> assebleDshmData(Object bo) {
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) JSON.parse(JSON.toJSONString(bo));
        Map<String, String> maps = new HashMap<String, String>();
        for (Entry<String, String> s : map.entrySet()) {
            maps.put(switchParam(s.getKey()), s.getValue());
        }
        return maps;
    }

}
