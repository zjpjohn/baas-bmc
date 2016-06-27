package com.ai.opt.baas.bmc.test.api.initdata.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.initbasedata.interfaces.IInitBaseSV;
import com.ai.baas.bmc.api.initbasedata.params.InitBaseParam;
import com.ai.opt.base.vo.BaseResponse;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class IinitdataSVTest {
	@Autowired
	private IInitBaseSV initbase;
	
	@Test
	public void initData(){
		InitBaseParam baseParam=new InitBaseParam();
		baseParam.setServiceId("1345756");
		baseParam.setExtCustId("134377");
		baseParam.setTenantId("ZX");
		BaseResponse baseRes=initbase.InitBaseData(baseParam);
		System.out.println(JSON.toJSONString(baseRes));
		
	}
	
	
}
