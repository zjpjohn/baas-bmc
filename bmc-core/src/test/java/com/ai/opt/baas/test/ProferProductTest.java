package com.ai.opt.baas.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IProferProductManageSV;
import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IQueryProferProductSV;
import com.ai.baas.bmc.api.proferentialprocuct.params.ActiveProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.FullPresent;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedAccountVO;
import com.ai.opt.sdk.util.DateUtil;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ProferProductTest {
	@Autowired
	protected ApplicationContext ctx;

	public <T> T getBean(Class<T> type) {
		return ctx.getBean(type);
	}

	public Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
	@Autowired
	IProferProductManageSV iProferProductManageSV;
	@Autowired
	IQueryProferProductSV iQueryProferProductSV;
	//测试满赠添加
	@Test
	public void testAddZengsong(){
		
		ProferProductVO vo=new ProferProductVO();
		vo.setActiveDate(DateUtil.getSysDate());
		vo.setComments("这是个测试产品");
		vo.setInvalidDate(DateUtil.getSysDate());
		vo.setOperatorId("BYD001");
		List<FullPresent> list=new ArrayList<FullPresent>();
		//赠送业务
		FullPresent fp=new FullPresent();
		fp.setGiftActiveDate(DateUtil.getSysDate());
		fp.setGiftInvalidDate(DateUtil.getSysDate());
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		fp.setGiftProList(list1);
		fp.setGiftType("SERVICETYPE");
		list.add(fp);
		//赠送现金
		FullPresent fp1=new FullPresent();
		fp1.setGiftActiveDate(DateUtil.getSysDate());
		fp1.setGiftInvalidDate(DateUtil.getSysDate());
		fp1.setGiftProList(list1);
		fp1.setGiftType("CASH");
		fp1.setGitfAmount(10.1);
		list.add(fp1);
		//赠送虚拟货币
		FullPresent fp2=new FullPresent();
		fp2.setGiftActiveDate(DateUtil.getSysDate());
		fp2.setGiftInvalidDate(DateUtil.getSysDate());
		fp2.setGiftProList(list1);
		fp2.setGiftType("COIN");
		fp2.setGitfAmount(11);
		list.add(fp2);
		
		vo.setPresentList(list);
		
	//	vo.setPriceCode(priceCode);
		vo.setProductList(list1);
		
		vo.setProductType("PRESENT");
		vo.setProgramName("满赠活动");
		vo.setRuleAmount(180);
		vo.setRuleUnit("YUAN");
		vo.setTenantId("BYD");
		vo.setTradeSeq("11111111111111111111111111111111111");
		System.out.println(JSON.toJSONString(vo));
		iProferProductManageSV.addProferProduct(vo);
	}
	
	
	
	    //测试满减添加
		@Test
		public void testAddManjian(){
			
			ProferProductVO vo=new ProferProductVO();
			vo.setActiveDate(DateUtil.getSysDate());
			vo.setComments("这是个满减活动的测试产品");
			vo.setInvalidDate(DateUtil.getSysDate());
			vo.setOperatorId("BYD001");
			List<FullPresent> list=new ArrayList<FullPresent>();
			
			
			List<Integer> list1=new ArrayList<Integer>();
			list1.add(1);
			list1.add(2);
			list1.add(3);
			
			vo.setPresentList(list);
			
			vo.setProductList(list1);
			
			vo.setProductType("REDUCE");
			vo.setProgramName("满减活动");
			vo.setRuleAmount(180);
			vo.setRuleUnit("YUAN");
			vo.setTenantId("BYD");
			vo.setTradeSeq("manjian11111111111111");
			vo.setReduceAmount(10);
			System.out.println(JSON.toJSONString(vo));
			iProferProductManageSV.addDiscontProduct(vo);
		}
	
	
	
	//测试满减
	@Test
	public void testAddmanjian(){
		//测试满赠添加
		ProferProductVO vo=new ProferProductVO();
		vo.setActiveDate(DateUtil.getSysDate());
		vo.setComments("这是个测试产品");
		vo.setInvalidDate(DateUtil.getSysDate());
		vo.setOperatorId("BYD001");
	
		//产品列表
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		vo.setProductList(list1);
		
		
		vo.setProductType("PRESENT");
		vo.setProgramName("满减活动");
		vo.setRuleAmount(180);
		vo.setRuleUnit("YUAN");
		vo.setTenantId("BYD");
		vo.setTradeSeq("11111111111111111111111111111111111");
		vo.setReduceAmount(10);
		System.out.println(JSON.toJSONString(vo));
		iProferProductManageSV.addDiscontProduct(vo);
	}
	@Test
	public void updateStatus(){
		
		ActiveProductVO vo=new ActiveProductVO();
		vo.setProductId(21L);
		vo.setStatus("ACTIVE1");
		vo.setTenantId("BYD");
		vo.setTradeSeq("BYD2016040812312321321");
		System.out.println("---->"+JSON.toJSONString(vo));
		iProferProductManageSV.updateProferProductStatus(vo);
	}
	//修改满赠类型的
	@Test
	public void updateProferProduct1(){
		//测试满赠添加
				ProferProductVO vo=new ProferProductVO();
				vo.setProductId(301L);
				vo.setActiveDate(DateUtil.getSysDate());
				vo.setComments("这是个测试产品修改");
				vo.setInvalidDate(DateUtil.getSysDate());
				vo.setOperatorId("BYD");
				vo.setPriceCode("0000000162");
				List<FullPresent> list=new ArrayList<FullPresent>();
				//赠送业务
				FullPresent fp=new FullPresent();
				fp.setGiftActiveDate(DateUtil.getSysDate());
				fp.setGiftInvalidDate(DateUtil.getSysDate());
				List<Integer> list1=new ArrayList<Integer>();
				list1.add(4);
				list1.add(5);
				list1.add(6);
				fp.setGiftProList(list1);
				fp.setGiftType("SERVICETYPE");
				list.add(fp);
				//赠送现金
//				FullPresent fp1=new FullPresent();
//				fp1.setGiftActiveDate(DateUtil.getSysDate());
//				fp1.setGiftInvalidDate(DateUtil.getSysDate());
//				fp1.setGiftProList(list1);
//				fp1.setGiftType("CASH");
//				fp1.setGitfAmount(10.1);
//				list.add(fp1);
				//赠送虚拟货币
				FullPresent fp2=new FullPresent();
				fp2.setGiftActiveDate(DateUtil.getSysDate());
				fp2.setGiftInvalidDate(DateUtil.getSysDate());
				fp2.setGiftProList(list1);
				fp2.setGiftType("COIN");
				fp2.setGitfAmount(12);
				list.add(fp2);
				
				vo.setPresentList(list);
				
			//	vo.setPriceCode(priceCode);
				vo.setProductList(list1);
				
				vo.setProductType("PRESENT");
				vo.setProgramName("满赠活动");
				vo.setRuleAmount(180);
				vo.setRuleUnit("YUAN");
				vo.setTenantId("BYD");
				vo.setTradeSeq("BYD1234111111111111");
				System.out.println(JSON.toJSONString(vo));
				iProferProductManageSV.updateProferProduct(vo);
	}
	//修改满减
	@Test
	public void updateProferProduct2(){
		//测试满赠添加
				ProferProductVO vo=new ProferProductVO();
				vo.setProductId(401L);
				vo.setActiveDate(DateUtil.getSysDate());
				vo.setComments("这是个测试产品修改");
				vo.setInvalidDate(DateUtil.getSysDate());
				vo.setOperatorId("BYD");
				vo.setPriceCode("0000000202");
			
				
				List<Integer> list1=new ArrayList<Integer>();
				list1.add(4);
				list1.add(5);
				list1.add(6);
			
		
				vo.setProductList(list1);
				
				vo.setProductType("REDUCE");
				vo.setProgramName("满减活动");
				vo.setRuleAmount(180);
				vo.setRuleUnit("YUAN");
				vo.setTenantId("BYD");
				vo.setTradeSeq("BYD1234111111111111");
				vo.setReduceAmount(11.0);
				vo.setReduceId(52L);
				System.out.println(JSON.toJSONString(vo));
				iProferProductManageSV.updateProferProduct(vo);
	}
	//查询分页
	@Test
	public void testPage(){
		ProductQueryVO vo=new ProductQueryVO();
		vo.setTenantId("BYD");
		vo.setPageNo(2);
		vo.setPageSize(10);
		System.out.println(JSON.toJSONString(iQueryProferProductSV.getProductInfo(vo)));
	}
	
	//测试关联费用科目-满减
	@Test
	public void testRelatedAccount1(){
		RelatedAccountVO vo=new RelatedAccountVO();
		vo.setAccountType("xiangdankemu");
		vo.setChargeType("REDUCE");
		vo.setProductId(543L);
		List<Long> list=new ArrayList<Long>();
		list.add(1L);
		list.add(2L);
		list.add(3L);
		vo.setRelAccounts(list);
		
		List<Long> list1=new ArrayList<Long>();
		list1.add(163L);
		
		vo.setFullIds(list1);
		vo.setTenantId("BYD");
		vo.setTradeSeq("xuliehao123");
		
		iProferProductManageSV.relatedAccout(vo);
	}
	
}
