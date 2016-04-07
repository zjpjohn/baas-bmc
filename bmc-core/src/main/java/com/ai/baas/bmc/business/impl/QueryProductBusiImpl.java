package com.ai.baas.bmc.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.baas.bmc.api.marketbleproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductQueryVO;
import com.ai.baas.bmc.api.marketbleproduct.params.ServiceVO;
import com.ai.baas.bmc.business.interfaces.IQueryProductBusi;
import com.ai.baas.bmc.dao.interfaces.CpPackageInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpStepInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetailCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfoCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfoCriteria;

public class QueryProductBusiImpl implements IQueryProductBusi {
	@Autowired
	private CpPriceInfoMapper cpPriceInfoMapper;
	@Autowired
	private CpPriceDetailMapper cpPriceDetailMapper;
	@Autowired
	private CpStepInfoMapper cpStepInfoMapper;
	@Autowired
	private CpPackageInfoMapper cpPackageInfoMapper;
	
	@Override
	public ProductInfo Product(ProductQueryVO vo) {
		ProductInfo product = new ProductInfo();
	        
		try {
//			product.setProductId(vo.getProductId());
//			product.setActiveDate(vo.getActiveDate());
//			product.setInvalidDate(vo.getInvalidDate());
//			product.setBillingType(vo.getBillingType());
//			product.setProcuctName(vo.getProductName());
//			product.setTenantId( vo.getTenantId());
//			product.setTradeSeq(vo.getTenantPwd());
//			product.setResponseHeader(responseHeader);
//			product.setStatus(status);
			
			Integer pageNum = vo.getPageNo();
			Integer pagecountNum = vo.getPageSize();
			int startIndex =0;
			int endIndex=0;
			 startIndex = (pageNum - 1) * pagecountNum;
			 endIndex = (pageNum - 1) * pagecountNum + pagecountNum;
			 
			 int totalCount = 0;
			 List<ServiceVO> usageList = new ArrayList<ServiceVO>();
			 product.setUsageList(usageList);//置一个空列表
			 
			 String serviceType = "";
			 String serviceTypeDetail = "";
			 String amountStart = "";
			 String amountEnd = "";
			 String price= "";
			
			 CpPriceInfoCriteria cpPriceInfoCriteria = new CpPriceInfoCriteria();
			cpPriceInfoCriteria.createCriteria()
					 .andActiveTimeEqualTo(vo.getActiveDate())
					 .andInactiveTimeEqualTo(vo.getInvalidDate())
					 .andTenantIdEqualTo(vo.getTenantId());
			totalCount += cpPriceInfoMapper.countByExample(cpPriceInfoCriteria);
			 List<CpPriceInfo> cpPriceInfo = cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria);
			 for(CpPriceInfo c:cpPriceInfo){
				 String priceCode = c.getPriceCode();
				 
				 CpPriceDetailCriteria cpPriceDetailCriteria = new CpPriceDetailCriteria();
				 cpPriceDetailCriteria.createCriteria().andActiveTimeEqualTo(vo.getActiveDate())
				 .andServiceTypeEqualTo( vo.getServiceType())
				 .andChargeTypeEqualTo(vo.getBillingType());
				 
				 totalCount += cpPriceDetailMapper.countByExample(cpPriceDetailCriteria);
				 List<CpPriceDetail> cpPriceDetail = cpPriceDetailMapper.selectByExample(cpPriceDetailCriteria);
				 for(CpPriceDetail d:cpPriceDetail){
					 String detailCode = d.getDetailCode();
					 if(vo.getBillingType().equals("")){
						 //阶梯类型 
						 CpStepInfoCriteria cpStepInfoCriteria = new CpStepInfoCriteria();
						 cpStepInfoCriteria.createCriteria().andDetailCodeEqualTo(Long.valueOf(detailCode)).andTotalPriceValueNotBetween(vo.getPriceStart(), vo.getPriceEnd());
						 
						 totalCount += cpStepInfoMapper.countByExample(cpStepInfoCriteria);
						 List<CpStepInfo> cpStepInfo =cpStepInfoMapper.selectByExample(cpStepInfoCriteria);
						 
//						 for(CpStepInfo s:cpStepInfo){
////							 usageList.add("serviceType", element);
////							 usageList.add("serviceTypeDetail", element);
////							 usageList.add("amountStart", s.getSectionA());
////							 usageList.add("amountEnd", s.getSectionB());
////							 usageList.add("price", s.getPriceValue());
////				                      
//								 s.getSectionA();       
//								 s.getSectionB();       
//								 s.getTotalPriceValue();
//								 s.getUnitType();       
//						 }
						 
					 }else{
						 CpPackageInfoCriteria cpPackageInfoCriteria =new CpPackageInfoCriteria();
						 cpPackageInfoCriteria.createCriteria().andDetailCodeEqualTo(detailCode).andTotalPriceValueBetween(vo.getPriceStart(), vo.getPriceEnd());
						 totalCount += cpPackageInfoMapper.countByExample(cpPackageInfoCriteria);
						 List<CpPackageInfo> packageInfo = cpPackageInfoMapper.selectByExample(cpPackageInfoCriteria);
//						 for(CpPackageInfo p:packageInfo){
//							 usageList.add("", element);
//							 usageList.add("", element);
//							 usageList.add("", element);
//							 usageList.add("", element);
//							 p.getPriceValue();
//							 p.getTotalPriceValue();
//							 p.getUnitType();
//							 p.getAmount();
//						 }
					 }
						 
					 
				 }
				 
			 }
			 if(startIndex > (totalCount)){
					//输出页超出总条数
					return product;
				}else{
				// 保存billList的偏移量
				int offsetBL = 0;
	            int end_flag=0;
	            
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
