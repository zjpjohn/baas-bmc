package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.acctinfo.interfaces.IAcctInfoSV;
import com.ai.baas.bmc.api.acctinfo.params.AcctInfoParams;
import com.ai.baas.bmc.api.acctinfo.params.AcctQueryRequest;
import com.ai.baas.bmc.api.acctinfo.params.ResponseMessage;
import com.ai.opt.base.vo.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class GetAcctInfoTest {
	@Autowired
	IAcctInfoSV iAcctInfoSV;
	@Test
    public void test(){
		PageInfo<AcctInfoParams> resultPage=new PageInfo<AcctInfoParams>();
		AcctQueryRequest acctQueryRequest=new AcctQueryRequest();
//		List a=new ArrayList();
//		String b="39";
//		String c="11";
//		a.add(b);
//		a.add(c);
//		acctQueryRequest.setCustIDs(a);
		acctQueryRequest.setPageNo(2);
		acctQueryRequest.setPageSize(20);
		acctQueryRequest.setTenantId("VIV-BYD");
		ResponseMessage responseMessage=iAcctInfoSV.getAcctInfo(acctQueryRequest);
		System.out.println("param="+com.alibaba.fastjson.JSON.toJSONString(acctQueryRequest));
        System.out.println("responseMessage="+com.alibaba.fastjson.JSON.toJSONString(responseMessage));

	}

}
