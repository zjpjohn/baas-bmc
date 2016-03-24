package com.ai.baas.bmc.util;

import java.text.SimpleDateFormat;

import com.ai.baas.bmc.context.ErrorCode;

public class CheckUtil {
    /**
     * String和Integer类型的校验
     * canBeNull为true是可以为空，lenth是最大长度，enums是取值范围，不填是没有取值范围
     */
    public static String check(Object o, String name, boolean canBeNull, int lenth,
            String... enums) {
        if (o == null || "".equals(o.toString())) {
            if (canBeNull) {
                return ErrorCode.SUCCESS;
            }
            return ErrorCode.NULL + name + "不能为空";
        }

        if (o.toString().length() > lenth) {
            return ErrorCode.OVER_LENTH + name + "不能超过" + lenth + "位";
        }

        if (enums == null || enums.length == 0) {
            return ErrorCode.SUCCESS;
        }

        String result = ErrorCode.UNKNOWN + name + "取值范围";
        for (String e : enums) {
            if (e.equals(o.toString())) {
                return ErrorCode.SUCCESS;
            }
            result += e + ",";
        }
        return result;
    }
    /**
     * 校验时间格式
     */
    public static boolean check(String time ,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            System.out.println(sdf.parse(time));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
