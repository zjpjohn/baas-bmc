package com.ai.baas.bmc.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;

public class MyJsonUtil {
    private static Gson gson = new Gson();

    /**
     * 将json转换成实体类
     */
    public static <T> T toBean(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T toBean(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    /**
     * 将实体类装换成json
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * 判断数据是否符合json格式
     */
    public static boolean isJson(String json) {
        try {
            gson.fromJson(json, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
