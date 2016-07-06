package test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.baas.bmc.api.priceinfo.params.StandardPriceInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.StanderdPriceInfoUsage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Value;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class DeletePriceInfoTest {
    @Autowired
    IPriceInfoSV aIPriceInfoSV;
    
    @Test
    public void test(){
        StandardPriceInfoParams param = new StandardPriceInfoParams();
//        param.setTenantId("test");
//        param.setTradeSeq("1111");
//        param.setStandardId("7");
//        param.setUpdateId("DELETE");
//        param.setStatus("EFFECT");
        param =  JSONObject.parseObject(
                "{\"serviceType\":\"\",\"comments\":\"\",\"tenantPwd\":\"\",\"cycleId\":\"\",\"priceType\":\"\",\"standardId\":\"163\",\"cycleAmount\":0,\"cycleType\":\"\",\"updateId\":\"DELETE\",\"price\":0,\"tenantId\":\"7BAF6267AE2F421FA8D1E305EE35C4BA\",\"priceName\":\"\",\"tradeSeq\":\"7BAF6267AE2F421FA8D1E305EE35C4BA2016041817420116473bdadde-5233-4da1-afde-51327fab8fa4\",\"status\":\"\",\"usageList\":[]}"
                , StandardPriceInfoParams.class);
        System.err.println(JSON.toJSONString(param));
        System.err.println(JSON.toJSONString(aIPriceInfoSV.deletePriceInfo(param)));
        
        //抵扣测试
//        String value = "999999";
//        System.out.println("fff   the resdeduct amount is "+Double.parseDouble(value)/1024);
//        System.out.println("value  "+value);
//        double total=Double.valueOf(value)/1024;
//        System.out.println("total  "+total);
//        BigDecimal feeDec = new BigDecimal(total);
//        Double feeD =  feeDec.setScale(0, RoundingMode.DOWN).doubleValue();
//        System.out.println("feeD :"+feeD);
//        System.out.println("feeD.longValue() :"+feeD.longValue());
    }
}
