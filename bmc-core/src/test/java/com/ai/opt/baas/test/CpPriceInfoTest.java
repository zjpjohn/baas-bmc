package com.ai.opt.baas.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.service.business.interfaces.ICpPriceInfoBusi;
import com.ai.baas.bmc.util.BmcSeqUtil;
import com.ai.opt.sdk.util.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class CpPriceInfoTest {
	@Autowired
	protected ApplicationContext ctx;

	public <T> T getBean(Class<T> type) {
		return ctx.getBean(type);
	}

	public Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
	@Autowired
	ICpPriceInfoBusi iCpPriceInfoBusi;
	@Test
	public void add(){
		CpPriceInfo info=new CpPriceInfo();
		info.setTenantId("BYD");
		info.setActiveStatus("not");
		info.setActiveTime(DateUtil.getSysDate());
		info.setComments("测试数据");
		info.setCreateTime(DateUtil.getSysDate());
		info.setInactiveTime(DateUtil.getSysDate());
		info.setOperatorId("123oper");
		info.setPriceCode(BmcSeqUtil.getPriceCode());
		info.setPriceInfoId(BmcSeqUtil.getPriceInfoId());
		info.setPriceName("满赠优惠");
		info.setProductType("PRESENT");
		iCpPriceInfoBusi.addCpPriceInfo(info);
	}
}
