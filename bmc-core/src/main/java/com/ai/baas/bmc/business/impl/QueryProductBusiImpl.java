package com.ai.baas.bmc.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.marktableproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryByIdListVO;
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
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.esotericsoftware.minlog.Log;

@Service
@Transactional
public class QueryProductBusiImpl implements IQueryProductBusi {
	private static final Logger log = LogManager
			.getLogger(QueryProductBusiImpl.class);
	
	@Autowired
	private CpPriceInfoMapper cpPriceInfoMapper;
	@Autowired
	private CpPriceDetailMapper cpPriceDetailMapper;
	@Autowired
	private CpStepInfoMapper cpStepInfoMapper;
	@Autowired
	private CpPackageInfoMapper cpPackageInfoMapper;
	
	public static final String CHARGE_TYPE_STEP = "step_group_type";
	public static final String CHARGE_TYPE_PACKAGE = "standard_group_type";
	@Override
	public PageInfo<ProductInfo> Product(ProductQueryVO vo) {
		PageInfo<ProductInfo> productInfoPageInfo =new PageInfo<ProductInfo>();
	        
		try {
			
			CpPriceInfoCriteria cpPriceInfoCriteria = new CpPriceInfoCriteria();
			CpPriceInfoCriteria.Criteria criteriaCpPriceInfo= cpPriceInfoCriteria.createCriteria();
			criteriaCpPriceInfo.andTenantIdEqualTo(vo.getTenantId());
			 
			 if(null != vo.getActiveDate() && null != vo.getInvalidDate()){
				 criteriaCpPriceInfo.andActiveTimeBetween(vo.getActiveDate(), vo.getInvalidDate());
			 }else{
				 if (null != vo.getActiveDate()) {
					 criteriaCpPriceInfo.andActiveTimeGreaterThanOrEqualTo(vo.getActiveDate());
				 }
				 if (null != vo.getInvalidDate()) {
					 criteriaCpPriceInfo.andActiveTimeLessThanOrEqualTo(vo.getInvalidDate());
				 }
			 }
			 
			 
			 if(!StringUtil.isBlank(vo.getProductId())){
				 criteriaCpPriceInfo.andPriceCodeEqualTo(vo.getProductId());
			 }
			 if(!StringUtil.isBlank(vo.getProductName())){
				 criteriaCpPriceInfo.andPriceNameLike("%"+vo.getProductName()+"%");
			 }
			 if (vo.getPageNo() != null && vo.getPageSize() != null) {
				 //cpPriceInfoCriteria.setLimitStart((vo.getPageNo() - 1) * vo.getPageSize());
				 //cpPriceInfoCriteria.setLimitEnd(vo.getPageSize());
		     }
			 
			 PageInfo<CpPriceInfo> pageInfo = new PageInfo<CpPriceInfo>();
			 
			 
			 pageInfo.setResult(cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria));
	         pageInfo.setCount(cpPriceInfoMapper.countByExample(cpPriceInfoCriteria));
	         pageInfo.setPageNo(vo.getPageNo());
	         pageInfo.setPageSize(vo.getPageSize());
		        
	        
	         //
	         List<ProductInfo> productInfoList = new ArrayList<ProductInfo>();
	         log.info("cpPriceInfoList.size------->>>"+pageInfo.getResult().size());
	         ProductInfo productInfo = null;
			 for(CpPriceInfo c : pageInfo.getResult()){
				 productInfo = new ProductInfo();
				 //
				 productInfo.setActiveDate(c.getActiveTime());
				 productInfo.setInvalidDate(c.getInactiveTime());
				 productInfo.setProductId(c.getPriceCode());
				 productInfo.setProductName(c.getPriceName());
				 productInfo.setStatus(c.getActiveStatus());
				 productInfo.setTenantId(c.getTenantId());
				 //
				 List<ServiceVO> usageList = new ArrayList<ServiceVO>();
				 ServiceVO serv = null;
				 
				 CpPriceDetailCriteria cpPriceDetailCriteria = new CpPriceDetailCriteria();
				 CpPriceDetailCriteria.Criteria criteriaCpPriceDetail = cpPriceDetailCriteria.createCriteria();
				 
				 if(!StringUtil.isBlank(vo.getBillingType())){
					 criteriaCpPriceDetail.andChargeTypeEqualTo(vo.getBillingType());
				 }
				 //
				 criteriaCpPriceDetail.andPriceCodeEqualTo(c.getPriceCode());
				 //
				 List<CpPriceDetail> cpPriceDetail = cpPriceDetailMapper.selectByExample(cpPriceDetailCriteria);
				 CpPriceDetail cpPriceDetailNew = new CpPriceDetail();
				 if(!CollectionUtil.isEmpty(cpPriceDetail)){
					 System.out.println("打印信息 cpPriceDetail.size()："+cpPriceDetail.size());
					 cpPriceDetailNew = cpPriceDetail.get(0);
				 }
				 //
				 String detailCode = cpPriceDetailNew.getDetailCode();
				 if(!StringUtil.isBlank(detailCode)){
					 if(null != vo.getBillingType() && vo.getBillingType().equalsIgnoreCase(CHARGE_TYPE_STEP)){
						 //stepInfo
						 this.stepMethod(detailCode, serv, usageList, vo, productInfo, cpPriceDetailNew);
					 
					 } else if(null != vo.getBillingType() && vo.getBillingType().equalsIgnoreCase(CHARGE_TYPE_PACKAGE)){
						//packageInfo
						this.packageMethod(detailCode, serv, usageList, vo, productInfo, cpPriceDetailNew);
						
					 }else if(null == vo.getBillingType()){
						
						this.stepMethod(detailCode, serv, usageList, vo, productInfo, cpPriceDetailNew);
						this.packageMethod(detailCode, serv, usageList, vo, productInfo, cpPriceDetailNew);
					 
					 }
				}
						 
				 productInfo.setUsageList(usageList);
				 productInfoList.add(productInfo);
				 //如果billingType 是 阶梯类型  只查阶梯类型不为空的数据
				 if(null != vo.getBillingType() && vo.getBillingType().equalsIgnoreCase(CHARGE_TYPE_STEP)){
					 
					 if(StringUtil.isBlank(productInfo.getBillingType()) || CHARGE_TYPE_PACKAGE.equalsIgnoreCase(productInfo.getBillingType())){
						 productInfoList.remove(productInfo);
					 }
				 //如果billingType 是 基本类型 只查基本类型不为空的数据
				 }else if(null != vo.getBillingType() && vo.getBillingType().equalsIgnoreCase(CHARGE_TYPE_PACKAGE)){
					 
					 if(StringUtil.isBlank(productInfo.getBillingType()) || CHARGE_TYPE_STEP.equalsIgnoreCase(productInfo.getBillingType())){
						 productInfoList.remove(productInfo);
					 }
				 }
				
			 }
			 List<ProductInfo> productInfoListNew = new ArrayList<ProductInfo>();
			 //
			 int startRowIndex = 0;
			 if(pageInfo.getStartRowIndex()>productInfoList.size()){
				 productInfoListNew = new ArrayList<ProductInfo>();
			 }else if(pageInfo.getEndRowIndex()>productInfoList.size()){
				 productInfoListNew = productInfoList.subList(pageInfo.getStartRowIndex(),productInfoList.size());
			 }else if(pageInfo.getEndRowIndex()<productInfoList.size()){
				 productInfoListNew = productInfoList.subList(pageInfo.getStartRowIndex(),pageInfo.getEndRowIndex());
			 }
			 //
			 productInfoPageInfo.setResult(productInfoListNew);
	         productInfoPageInfo.setCount(productInfoList.size());
	         productInfoPageInfo.setPageNo(pageInfo.getPageNo());
	         productInfoPageInfo.setPageSize(pageInfo.getPageSize());
//			 ResponseHeader responseHeader = new ResponseHeader(true, ErrorCode.SUCCESS, "成功");
//			 product.setResponseHeader(responseHeader);

		} catch (Exception e) {
			e.printStackTrace();
			ResponseHeader responseHeader = new ResponseHeader(false, ErrorCode.FALSE, "失败");
//			 product.setResponseHeader(responseHeader);
			 //pro_list.add(product);
			 //return pro_list;
		}
		 
		return productInfoPageInfo;
		
	}
	
	private void stepMethod(String detailCode,ServiceVO serv,List<ServiceVO> usageList,ProductQueryVO vo,ProductInfo productInfo,CpPriceDetail cpPriceDetailNew){
		//阶梯组合
		 CpStepInfoCriteria cpStepInfoCriteria = new CpStepInfoCriteria();
		 CpStepInfoCriteria.Criteria criteriaCpStepInfo = cpStepInfoCriteria.createCriteria();
		 
		 criteriaCpStepInfo.andDetailCodeEqualTo(detailCode);
		 if(null != new Double(vo.getPriceStart()) && new Double(vo.getPriceStart()) != 0.0 && null != new Double(vo.getPriceEnd()) && new Double(vo.getPriceEnd()) != 0.0 ){
			 criteriaCpStepInfo.andTotalPriceValueNotBetween(vo.getPriceStart(), vo.getPriceEnd());
		 }
		 if(!StringUtil.isBlank(vo.getServiceType())){
			 criteriaCpStepInfo.andServiceTypeEqualTo(vo.getServiceType());
		 }
		 
		 
		 List<CpStepInfo> cpStepInfo =cpStepInfoMapper.selectByExample(cpStepInfoCriteria);
		 for(CpStepInfo s : cpStepInfo){
			 serv = new ServiceVO();
			 serv.setAmountStart(s.getSectionA());
			 serv.setAmountEnd(s.getSectionB());
			 serv.setPrice(new java.math.BigDecimal(s.getPriceValue()));
			 serv.setServiceTypeDetail(s.getFactorCode().toString());
			 serv.setUnit(s.getUnitType());
			 serv.setServiceType(s.getServiceType());
			 
			 usageList.add(serv);	        
		 }
		 if(!CollectionUtil.isEmpty(cpStepInfo)){
			 productInfo.setBillingType(cpPriceDetailNew.getChargeType()); 
		 }
	}
	
	private void packageMethod(String detailCode,ServiceVO serv,List<ServiceVO> usageList,ProductQueryVO vo,ProductInfo productInfo,CpPriceDetail cpPriceDetailNew){
		//标准组合
		 CpPackageInfoCriteria cpPackageInfoCriteria =new CpPackageInfoCriteria();
		 CpPackageInfoCriteria.Criteria criteriaCpPackageInfo = cpPackageInfoCriteria.createCriteria();
		 
		 criteriaCpPackageInfo.andDetailCodeEqualTo(detailCode);
		 if(null != new Double(vo.getPriceStart()) && new Double(vo.getPriceStart()) != 0.0 && null != new Double(vo.getPriceEnd()) && new Double(vo.getPriceEnd()) != 0.0 ){
			 criteriaCpPackageInfo.andTotalPriceValueBetween(vo.getPriceStart(), vo.getPriceEnd());
		 }
		 if(!StringUtil.isBlank(vo.getServiceType())){
			 criteriaCpPackageInfo.andServiceTypeEqualTo(vo.getServiceType());
		 }
		 List<CpPackageInfo> packageInfo = cpPackageInfoMapper.selectByExample(cpPackageInfoCriteria);
		 System.out.println("packageInfoList.Size:"+packageInfo.size());
		 for(CpPackageInfo p : packageInfo){
			 serv = new ServiceVO();
			 serv.setAmountStart(0);
			 serv.setAmountEnd(p.getAmount());
			 serv.setPrice(new java.math.BigDecimal(p.getPriceValue()));
			 serv.setServiceTypeDetail(p.getFactorCode());
			 serv.setUnit(p.getUnitType());
			 serv.setServiceType(p.getServiceType());
			 usageList.add(serv);
		 }
		 if(!CollectionUtil.isEmpty(packageInfo)){
			 productInfo.setBillingType(cpPriceDetailNew.getChargeType()); 
			 productInfo.setTotalPrice(new BigDecimal(packageInfo.get(0).getTotalPriceValue()));
		 }
	}

	@Override
	public PageInfo<ProductInfo> getProductInfoByProductIdList(ProductQueryByIdListVO vo) {
		PageInfo<ProductInfo> productInfoPageInfo =new PageInfo<ProductInfo>();
        
		try {
			
			CpPriceInfoCriteria cpPriceInfoCriteria = new CpPriceInfoCriteria();
			CpPriceInfoCriteria.Criteria criteriaCpPriceInfo= cpPriceInfoCriteria.createCriteria();
			criteriaCpPriceInfo.andTenantIdEqualTo(vo.getTenantId());
			criteriaCpPriceInfo.andPriceCodeIn(vo.getProductIdList());
			 
			 PageInfo<CpPriceInfo> pageInfo = new PageInfo<CpPriceInfo>();
			 
			 
			 pageInfo.setResult(cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria));
	         pageInfo.setCount(cpPriceInfoMapper.countByExample(cpPriceInfoCriteria));
		        
	        Log.info("size--------->>>"+pageInfo.getResult().size());
	         //
	         List<ProductInfo> productInfoList = new ArrayList<ProductInfo>();
	         
	         ProductInfo productInfo = null;
			 for(CpPriceInfo c : pageInfo.getResult()){
				 productInfo = new ProductInfo();
				 //
				 productInfo.setActiveDate(c.getActiveTime());
				 productInfo.setInvalidDate(c.getInactiveTime());
				 productInfo.setProductId(c.getPriceCode());
				 productInfo.setProductName(c.getPriceName());
				 productInfo.setStatus(c.getActiveStatus());
				 productInfo.setTenantId(c.getTenantId());
				 //
				 List<ServiceVO> usageList = new ArrayList<ServiceVO>();
				 ServiceVO serv = null;
				 
				 CpPriceDetailCriteria cpPriceDetailCriteria = new CpPriceDetailCriteria();
				 CpPriceDetailCriteria.Criteria criteriaCpPriceDetail = cpPriceDetailCriteria.createCriteria();
				 
				 //
				 criteriaCpPriceDetail.andPriceCodeEqualTo(c.getPriceCode());
				 //
				 List<CpPriceDetail> cpPriceDetail = cpPriceDetailMapper.selectByExample(cpPriceDetailCriteria);
				 CpPriceDetail cpPriceDetailNew = new CpPriceDetail();
				 if(!CollectionUtil.isEmpty(cpPriceDetail)){
					 System.out.println("打印信息 cpPriceDetail.size()："+cpPriceDetail.size());
					 cpPriceDetailNew = cpPriceDetail.get(0);
				 }
				 //
				 String detailCode = cpPriceDetailNew.getDetailCode();
				 if(!StringUtil.isBlank(detailCode)){
				 	ProductQueryVO productQueryVO = new ProductQueryVO();
				 	
				 	//
					this.stepMethod(detailCode, serv, usageList, productQueryVO, productInfo, cpPriceDetailNew);
					this.packageMethod(detailCode, serv, usageList, productQueryVO, productInfo, cpPriceDetailNew);
					 
				}
						 
				 productInfo.setUsageList(usageList);
				 productInfoList.add(productInfo);
				
				
			 }
			 Log.info("productInfoList.size----->>>"+productInfoList.size());
//			 List<ProductInfo> productInfoListNew = new ArrayList<ProductInfo>();
//			 //
//			 if(pageInfo.getStartRowIndex()>productInfoList.size()){
//				 productInfoListNew = new ArrayList<ProductInfo>();
//			 }else if(pageInfo.getEndRowIndex()>productInfoList.size()){
//				 productInfoListNew = productInfoList.subList(pageInfo.getStartRowIndex(),productInfoList.size());
//			 }
			 //
			 productInfoPageInfo.setResult(productInfoList);
	         productInfoPageInfo.setCount(productInfoList.size());
	         productInfoPageInfo.setPageNo(1);
	         productInfoPageInfo.setPageSize(productInfoList.size()==0?1:productInfoList.size());

		} catch (Exception e) {
			e.printStackTrace();
			ResponseHeader responseHeader = new ResponseHeader(false, ErrorCode.FALSE, "失败");
		}
		 
		return productInfoPageInfo;
		
	}

}
