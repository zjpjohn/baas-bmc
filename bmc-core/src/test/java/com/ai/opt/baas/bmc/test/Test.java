package com.ai.opt.baas.bmc.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.ai.baas.bmc.api.queryidinfo.interfaces.IQueryIdInfoSV;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.alibaba.fastjson.JSON;

public class Test {

    public static void main(String[] args) {
        String ss = "DataDisk.1.Size";
        System.out.println(JSON.toJSONString(ss.split(".")));
    }

}
