package com.ai.opt.baas.bmc.test;

import java.lang.reflect.Field;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class Test {

    public static void main(String[] args) {
        String a = "{\"a\":\"1\",\"b\":\"2\"}";
        Map object = (Map) JSON.parse(a);
        for (Field f : object.getClass().getFields()) {
            System.out.println(f.getName());
            // System.out.println(f.get);
        }
    }

}
