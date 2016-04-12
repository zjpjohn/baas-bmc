package com.ai.opt.baas.bmc.test.api.marktableproduct.impl;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IQueryProductSV;
import com.ai.baas.bmc.api.marktableproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryVO;
import com.ai.opt.base.vo.PageInfo;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class QueryProductSvTest {
	@Autowired
	private IQueryProductSV queryProductSv;
	@Test
	public void testPageSearch(){
		ProductQueryVO vo = new ProductQueryVO();
		vo.setPageNo(1);
		vo.setPageSize(3);
		vo.setActiveDate(Timestamp.valueOf("2016-04-08 15:28:34"));
		vo.setInvalidDate(Timestamp.valueOf("2016-04-08 15:28:34"));
		vo.setTenantId("BYD");
		vo.setServiceType("1");
		vo.setBillingType("STEP");
		PageInfo<ProductInfo> pageInfo = this.queryProductSv.getProductInfo(vo);
		System.out.println("-----result:"+JSON.toJSONString(pageInfo));
	}
}
