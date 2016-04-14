package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.baas.bmc.api.priceinfo.params.QueryInfoParams;
import com.ai.baas.bmc.api.priceinfo.params.ResponseMessage;
import com.ai.baas.bmc.api.priceinfo.params.StandardList;
import com.ai.baas.bmc.api.priceinfo.params.UsageList;
import com.ai.baas.bmc.business.interfaces.ISysSequenceSvc;
import com.ai.opt.base.vo.PageInfo;
import com.alibaba.dubbo.common.json.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class GetPriceInfoTest {
    @Autowired
    IPriceInfoSV iPriceInfoSV;
    
    @Test
    public void test(){
        PageInfo<StandardList> resultPage=new PageInfo<StandardList>();; 
        QueryInfoParams queryInfoParams = new QueryInfoParams();
        queryInfoParams.setTenantId("test");
        queryInfoParams.setTradeSeq("123456693");
        queryInfoParams.setStandardId("3");
        queryInfoParams.setPriceName("");
        System.err.println("queryInfoParams："+queryInfoParams.getPriceName()+"kkk");
//        queryInfoParams.setServiceType(null);
//        queryInfoParams.setPriceState(null);
//        queryInfoParams.setPageNo(null);
//        queryInfoParams.setPageSize(null);

        ResponseMessage responseMessage = iPriceInfoSV.getPriceInfo(queryInfoParams);
        System.out.println(responseMessage.toString());
//        List<StandardList> result= responseMessage.getStandardList().getResult();
//        StandardList standardList = result.get(0);
        System.out.println("param="+com.alibaba.fastjson.JSON.toJSONString(queryInfoParams));
        System.out.println("responseMessage="+com.alibaba.fastjson.JSON.toJSONString(responseMessage));

       
    }
}
    
