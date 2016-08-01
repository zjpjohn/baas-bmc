package com.ai.baas.bmc.util;

import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ai.baas.bmc.api.marktableproduct.params.ProcductResponse;
import com.ai.baas.bmc.context.ErrorCode;
import com.ai.opt.base.vo.ResponseHeader;

public class InCheckUtil {
    private static final Logger LOGGER = LogManager.getLogger(InCheckUtil.class);
    /**
     * String和Integer类型的校验
     * canBeNull为true是可以为空，lenth是最大长度，enums是取值范围，不填是没有取值范围
     */
    public static ProcductResponse check(Object o, String name, boolean canBeNull, int lenth,
            String... enums) {
    	ProcductResponse response = new ProcductResponse();
        if (o == null || "".equals(o.toString())) {
            if (canBeNull) {
            	ResponseHeader responseHeader = new ResponseHeader(true, ErrorCode.SUCCESS, "成功");
            	response.setResponseHeader(responseHeader);
            	return response;
            }
            ResponseHeader responseHeader = new ResponseHeader(false,ErrorCode.NULL, name + "不能为空");
        	response.setResponseHeader(responseHeader);
        	return response;
        }
        if(lenth==0){
        	ResponseHeader responseHeader = new ResponseHeader(true, ErrorCode.SUCCESS, "成功");
        	response.setResponseHeader(responseHeader);
        	return response;
        }
        if (o.toString().length() > lenth) {
        	 ResponseHeader responseHeader = new ResponseHeader(false,ErrorCode.OVER_LENTH, ErrorCode.OVER_LENTH);
         	response.setResponseHeader(responseHeader);
         	return response;
        }

        if (enums == null || enums.length == 0) {
        	ResponseHeader responseHeader = new ResponseHeader(true, ErrorCode.SUCCESS, "成功");
        	response.setResponseHeader(responseHeader);
        	return response;
        }

        String result =  name + "取值范围";
        for (String e : enums) {
            if (e.equals(o.toString())) {
            	ResponseHeader responseHeader = new ResponseHeader(true, ErrorCode.SUCCESS, "成功");
            	response.setResponseHeader(responseHeader);
            	return response;
            }
            result += e + ",";
        }
        ResponseHeader responseHeader = new ResponseHeader(false,ErrorCode.UNKNOWN,result);
     	response.setResponseHeader(responseHeader);
     	return response;
    }
    /**
     * 校验时间格式
     */
    public static boolean check(String time ,String pattern){
        if(time == null || "".equals(time)){
            return true;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            LOGGER.info(sdf.parse(time));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
