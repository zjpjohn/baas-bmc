package com.ai.opt.baas.bmc.test.api.marktableproduct.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IQueryProductSV;
import com.ai.baas.bmc.api.marktableproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryByIdListVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryVO;
import com.ai.opt.base.vo.PageInfo;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class QueryProductSvTest {
	@Autowired
	private IQueryProductSV queryProductSv;
	//@Test
	public void testPageSearch(){
		ProductQueryVO vo = new ProductQueryVO();
		
		vo.setPageNo(1);
		vo.setPageSize(27);
//		vo.setActiveDate(Timestamp.valueOf("2016-04-13 11:48:54"));
//		vo.setInvalidDate(Timestamp.valueOf("2016-04-13 11:48:54"));
//		vo.setTenantId("11111533");
//		vo.setServiceType("1");
		//vo.setBillingType("PACKAGE");
		vo.setTenantId("test");
		//vo.setProductId("0000000312");
		vo.setProductName("a");
		PageInfo<ProductInfo> pageInfo = this.queryProductSv.getProductInfo(vo);
		System.out.println("-----param:"+JSON.toJSONString(vo));
		System.out.println("-----result:"+JSON.toJSONString(pageInfo));
	}
	@Test
	public void testSearchByProductIdList(){
		ProductQueryByIdListVO vo = new ProductQueryByIdListVO();
		vo.setTenantId("baas-test");
		
		List<String> productIdList = new ArrayList<String>();
		productIdList.add("147");
		productIdList.add("148");
		//
		vo.setProductIdList(productIdList);
		
		PageInfo<ProductInfo> pageInfo = this.queryProductSv.getProductInfoByProductIdList(vo);
		System.out.println("-----result:"+JSON.toJSONString(pageInfo));
	}
}
