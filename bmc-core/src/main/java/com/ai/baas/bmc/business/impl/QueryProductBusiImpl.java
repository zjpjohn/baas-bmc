package com.ai.baas.bmc.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.marktableproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryVO;
import com.ai.baas.bmc.api.marktableproduct.params.ServiceVO;
import com.ai.baas.bmc.business.interfaces.IQueryProductBusi;
import com.ai.baas.bmc.context.ErrorCode;
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
import com.ai.opt.base.vo.ResponseHeader;

@Service
@Transactional
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
	public List<ProductInfo> Product(ProductQueryVO vo) {
		List<ProductInfo> pro_list =new ArrayList<ProductInfo>();
		List<ProductInfo> list =new ArrayList<ProductInfo>();
		ProductInfo product = new ProductInfo();
	        
		try {
			product.setProductId(vo.getProductId());
			product.setActiveDate(vo.getActiveDate());
			product.setInvalidDate(vo.getInvalidDate());
			product.setBillingType(vo.getBillingType());
			product.setProcuctName(vo.getProductName());
			product.setTenantId( vo.getTenantId());
			product.setTradeSeq(vo.getTenantPwd());
			
			 CpPriceInfoCriteria cpPriceInfoCriteria = new CpPriceInfoCriteria();
			cpPriceInfoCriteria.createCriteria()
					 .andActiveTimeEqualTo(vo.getActiveDate())
					 .andInactiveTimeEqualTo(vo.getInvalidDate())
					 .andTenantIdEqualTo(vo.getTenantId());
//			totalCount += cpPriceInfoMapper.countByExample(cpPriceInfoCriteria);
			 List<CpPriceInfo> cpPriceInfo = cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria);
			 for(CpPriceInfo c:cpPriceInfo){
				 List<ServiceVO> usageList = new ArrayList<ServiceVO>();
				 ServiceVO serv = new ServiceVO();
				 product.setStatus(c.getActiveStatus());
//				 String priceCode = c.getPriceCode();
				 
				 CpPriceDetailCriteria cpPriceDetailCriteria = new CpPriceDetailCriteria();
				 cpPriceDetailCriteria.createCriteria().andActiveTimeEqualTo(vo.getActiveDate())
				 .andServiceTypeEqualTo( vo.getServiceType())
				 .andChargeTypeEqualTo(vo.getBillingType());
				 
//				 totalCount += cpPriceDetailMapper.countByExample(cpPriceDetailCriteria);
				 List<CpPriceDetail> cpPriceDetail = cpPriceDetailMapper.selectByExample(cpPriceDetailCriteria);
				 for(CpPriceDetail d:cpPriceDetail){
					 String detailCode = d.getDetailCode();
					 serv.setServiceType(d.getServiceType());
					
					 if(vo.getBillingType().equals("STEP")){
						 //阶梯组合
						 CpStepInfoCriteria cpStepInfoCriteria = new CpStepInfoCriteria();
						 cpStepInfoCriteria.createCriteria().andDetailCodeEqualTo(Long.valueOf(detailCode)).andTotalPriceValueNotBetween(vo.getPriceStart(), vo.getPriceEnd());
						 
//						 totalCount += cpStepInfoMapper.countByExample(cpStepInfoCriteria);
						 List<CpStepInfo> cpStepInfo =cpStepInfoMapper.selectByExample(cpStepInfoCriteria);
						 for(CpStepInfo s:cpStepInfo){
							 serv.setAmountStart(s.getSectionA());
							 serv.setAmountEnd(s.getSectionB());
							 serv.setPrice(new java.math.BigDecimal(s.getPriceValue()));
							 serv.setServiceTypeDetail(s.getFactorCode().toString());
							 serv.setUnit(s.getUnitType());
								        
						 }
						 
					 }else{
						 //标准组合
						 CpPackageInfoCriteria cpPackageInfoCriteria =new CpPackageInfoCriteria();
						 cpPackageInfoCriteria.createCriteria().andDetailCodeEqualTo(detailCode).andTotalPriceValueBetween(vo.getPriceStart(), vo.getPriceEnd());
//						 totalCount += cpPackageInfoMapper.countByExample(cpPackageInfoCriteria);
						 List<CpPackageInfo> packageInfo = cpPackageInfoMapper.selectByExample(cpPackageInfoCriteria);
						 for(CpPackageInfo p:packageInfo){
					
							 serv.setAmountStart(0);
							 serv.setAmountEnd(p.getAmount());
							 serv.setPrice(new java.math.BigDecimal(p.getPriceValue()));
							 serv.setServiceTypeDetail(p.getFactorCode());
							 serv.setUnit(p.getUnitType());
							 
						 }
					 }
						 
					 
				 }
				 
				 usageList.add(serv);
				 product.setUsageList(usageList);
			 }
			 ResponseHeader responseHeader = new ResponseHeader(true, ErrorCode.SUCCESS, "成功");
			 product.setResponseHeader(responseHeader);

		} catch (Exception e) {
			e.printStackTrace();
			ResponseHeader responseHeader = new ResponseHeader(false, ErrorCode.FALSE, "失败");
			 product.setResponseHeader(responseHeader);
			 pro_list.add(product);
			 return pro_list;
		}
		Integer pageNum = vo.getPageNo();
		Integer pagecountNum = vo.getPageSize();
		int startIndex =0;
		int endIndex=0;
		 startIndex = (pageNum - 1) * pagecountNum;
		 endIndex = (pageNum - 1) * pagecountNum + pagecountNum;
		 list.add(product);
		 if(startIndex<pro_list.size()){
	        	//输出页超出总条数
	        	return pro_list;
	        }
		 //偏移量
	        int offsetBL = 0;
	        int end_flag=0;
	        
				for(ProductInfo p:list){
					if (offsetBL < startIndex) {
						// 循环直到,到当前页的第一条记录
						offsetBL++;
						continue;
					}
					
					pro_list.add(p);
					if (offsetBL == endIndex) {
						// 到达当前页的最后一条，退出循环
						end_flag=1;
						break;
					}
				}
					
			return pro_list;
		

		
//		pro_list.add(product);
//		return pro_list;
	}


}
