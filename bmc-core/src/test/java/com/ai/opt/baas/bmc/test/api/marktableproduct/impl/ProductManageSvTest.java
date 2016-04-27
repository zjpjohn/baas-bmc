package com.ai.opt.baas.bmc.test.api.marktableproduct.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IProductManageSV;
import com.ai.baas.bmc.api.marktableproduct.params.ProductActiveVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductDelVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductRelatedRequest;
import com.ai.baas.bmc.api.marktableproduct.params.ProductVO;
import com.ai.baas.bmc.api.marktableproduct.params.ServiceVO;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.sdk.util.DateUtil;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ProductManageSvTest {

	@Autowired
	private IProductManageSV productManageSV; 
	
	//@Test
	public void testAAA(){
//		if(true){
//			System.out.println("111111111");
//		}
		if(false){
			System.out.println("2222222222");
		}
		System.out.println("aaaaaaaaaaaaaaa");
	}
	
	
	
	//@Test
	public void addProduct(){
		ProductVO productVO = new ProductVO();
		productVO.setActiveDate(DateUtil.getSysDate());
		//productVO.setActiveDateTag("1");
		productVO.setBillingType("STEP_GROUP_TYPE");
		productVO.setInvalidDate(DateUtil.getSysDate());
		productVO.setIsPriceEqual("1");
		productVO.setProductId("111115");
		productVO.setProductName("超级产品BBBcccaCCCCCDDD");
		productVO.setStandardPriceType("bbb");
		productVO.setTenantId("111115132");
		productVO.setTotalPrice(new BigDecimal(100.1));
		productVO.setTradeSeq("aaaaa12211131213");
		//
		List<ServiceVO> serviceVoList = new ArrayList<ServiceVO>();
		
		ServiceVO serviceVO = new ServiceVO();
		serviceVO.setAmountEnd(100.1);
		serviceVO.setAmountStart(11.1);
		serviceVO.setCycleAmount(11);
		serviceVO.setCycleId("1111");
		serviceVO.setCycleType("111");
		serviceVO.setPrice(new BigDecimal(11));
		serviceVO.setServiceType("1111");
		serviceVO.setServiceTypeDetail("1111");
		serviceVO.setUnit("元");
		//
		serviceVoList.add(serviceVO);
		
		productVO.setMajorProductAmount(serviceVoList);;
		String jsonObj = JSON.toJSONString(productVO);
		BaseResponse response = this.productManageSV.addProduct(productVO);
		String jsonObj2 = JSON.toJSONString(response);
		
		System.out.println("-------------********------------------>>>>params:"+jsonObj);
		System.out.println("-------------********------------------>>>>response:"+jsonObj2);
	
	}
	//@Test
	public void deleteProduct(){
		ProductDelVO vo = new ProductDelVO();
		vo.setProductId("price_code_001");
		vo.setBillingType("STEP");
		this.productManageSV.delProduct(vo);
	}
	
	@Test
	public void editProduct(){
		ProductParamKeyVo vo = new ProductParamKeyVo();
		vo.setProductId("0000001403");
		vo.setBillingType("STEP_GROUP_TYPE");
		
		ProductVO productVo = this.productManageSV.editProduct(vo);
		String jsonObj = JSON.toJSONString(vo);
		String jsonObj2 = JSON.toJSONString(productVo);
		System.out.println("-------------********------------------>>>>params:"+jsonObj);
		System.out.println("-------------********------------------>>>>response:"+jsonObj2);
	}
	//@Test
	public void updateProductStatus(){
		ProductActiveVO vo = new ProductActiveVO();
		vo.setTenantId("111115222");
		vo.setProductId("67");
		vo.setStatus("10");
		//
		BaseResponse response = this.productManageSV.updateProductStatus(vo);
		String jsonObj = JSON.toJSONString(vo);
		String jsonObj2 = JSON.toJSONString(response);
		System.out.println("-------------********------------------>>>>params:"+jsonObj);
		System.out.println("-------------********------------------>>>>response:"+jsonObj2);
	
	}
	//@Test
	public void updateProduct(){
		
		ProductVO vo = new ProductVO();
		vo.setActiveDate(DateUtil.getSysDate());
		vo.setActiveDateTag("ACTIVE");
		vo.setBillingType("standard_group_type");
		vo.setInvalidDate(DateUtil.getSysDate());
		vo.setIsPriceEqual("0");
		//vo.setProductId("169");
		//vo.setProductName("标准组合测试2333444");
		//vo.setTenantId("7BAF6267AE2F421FA8D1E305EE35C4BA");
		vo.setTotalPrice(new BigDecimal(201));
		try{
			this.productManageSV.updateProduct(vo);
		}catch(BusinessException e){
			System.out.println("----------->>>:"+e.getErrorCode()+e.getErrorMessage());
			
		}
		System.out.println("----------->>>:update success");
	}
	@Test
	public void updateProductRelated(){
		ProductRelatedRequest request = new ProductRelatedRequest();
		request.setBillingType("STEP_GROUP_TYPE");
		request.setProductId("0000001031");
		request.setTenantId("111115132");
		request.setSubjectCode("SUPER");
		
		this.productManageSV.updateProductRelated(request);
	}
}
