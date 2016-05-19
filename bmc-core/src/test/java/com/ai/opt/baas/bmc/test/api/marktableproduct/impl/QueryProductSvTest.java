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
import com.ai.baas.bmc.api.marktableproduct.params.ProductRelatedRequest;
import com.ai.baas.bmc.api.marktableproduct.params.ProductRelatedResponse;
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
		vo.setPageSize(6);
//		vo.setActiveDate(Timestamp.valueOf("2016-04-13 11:48:54"));
		vo.setInvalidDate(Timestamp.valueOf("2016-04-23 11:48:54"));
//		vo.setTenantId("11111533");
		vo.setServiceType("VOICE");
		//vo.setBillingType("STEP_GROUP_TYPE");
		//vo.setTenantId("7BAF6267AE2F421FA8D1E305EE35C4BA");
		vo.setTenantId("7BAF6267AE2F421FA8D1E305EE35C4BA");
		vo.setActiveDate(Timestamp.valueOf("2016-04-19 00:00:00"));
		//vo.setPriceEnd(0);
		//vo.setPriceStart(0);
		//vo.setProductId("0000000312");
		//vo.setProductName("a");
		PageInfo<ProductInfo> pageInfo = this.queryProductSv.getProductInfo(vo);
		System.out.println("-----param:"+JSON.toJSONString(vo));
		System.out.println("-----result:"+JSON.toJSONString(pageInfo));
	}
	@Test
	public void testSearchByProductIdList(){
		ProductQueryByIdListVO vo = new ProductQueryByIdListVO();
		vo.setTenantId("7BAF6267AE2F421FA8D1E305EE35C4BA");
		
		List<String> productIdList = new ArrayList<String>();
		productIdList.add("1002");
		//productIdList.add("359");
	//	productIdList.add("360");
		//
		vo.setProductIdList(productIdList);
		System.out.println("-----param:"+JSON.toJSONString(vo));
		PageInfo<ProductInfo> pageInfo = this.queryProductSv.getProductInfoByProductIdList(vo);
		System.out.println("-----result:"+JSON.toJSONString(pageInfo));
	}
	@Test
	public void getProductRelated(){
		ProductRelatedRequest request = new ProductRelatedRequest();
		request.setBillingType("STEP_GROUP_TYPE");
		request.setProductId("0000001031");
		request.setTenantId("111115132");
		
		ProductRelatedResponse response = this.queryProductSv.getProductRelated(request);
		System.out.println("---->>>:"+JSON.toJSONString(response));
	}

	@Test
	public void testActivePageSearch(){
		ProductQueryVO vo = new ProductQueryVO();

		vo.setPageNo(1);
		vo.setPageSize(6);
		vo.setTenantId("7BAF6267AE2F421FA8D1E305EE35C4BA");
		vo.setBillingType("STANDARD_GROUP_TYPE");
		vo.setServiceType("VOICE");
		PageInfo<ProductInfo> pageInfo = this.queryProductSv.getActiveProductInfo(vo);
		System.out.println("-----param:"+JSON.toJSONString(vo));
		System.out.println("-----result:"+JSON.toJSONString(pageInfo));
	}
}
