package com.ai.baas.bmc.business.impl;

import com.ai.baas.bmc.api.marktableproduct.params.ProductInfo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryByIdListVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductQueryVO;
import com.ai.baas.bmc.api.marktableproduct.params.ServiceVO;
import com.ai.baas.bmc.business.interfaces.IQueryProductBusi;
import com.ai.baas.bmc.dao.interfaces.CpPackageInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpStepInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.*;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.esotericsoftware.minlog.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
			cpPriceInfoCriteria.setOrderByClause("PRICE_CODE DESC");
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
			 if(!StringUtil.isBlank(vo.getActiveStatus())){
				 criteriaCpPriceInfo.andActiveStatusEqualTo(vo.getActiveStatus());
			 }

			 PageInfo<CpPriceInfo> pageInfo = new PageInfo<CpPriceInfo>();
			 pageInfo.setResult(cpPriceInfoMapper.selectByExample(cpPriceInfoCriteria));
	         pageInfo.setCount(cpPriceInfoMapper.countByExample(cpPriceInfoCriteria));
	         pageInfo.setPageNo(vo.getPageNo());
	         pageInfo.setPageSize(vo.getPageSize());
		        
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
						 this.stepMethod(detailCode, usageList, vo, productInfo, cpPriceDetailNew);
					 } else if(null != vo.getBillingType() && vo.getBillingType().equalsIgnoreCase(CHARGE_TYPE_PACKAGE)){
						this.packageMethod(detailCode, usageList, vo, productInfo, cpPriceDetailNew);
						
					 }else if(null == vo.getBillingType()){
						this.stepMethod(detailCode, usageList, vo, productInfo, cpPriceDetailNew);
						this.packageMethod(detailCode, usageList, vo, productInfo, cpPriceDetailNew);
					 }

					 productInfo.setUsageList(usageList);
					 productInfoList.add(productInfo);
				 }
			 }

			 List<ProductInfo> productInfoListNew = new ArrayList<ProductInfo>();
			 if(pageInfo.getStartRowIndex()>productInfoList.size()){
				 productInfoListNew = new ArrayList<ProductInfo>();
			 }else if(pageInfo.getEndRowIndex()>productInfoList.size()){
				 productInfoListNew = productInfoList.subList(pageInfo.getStartRowIndex(),productInfoList.size());
			 }else if(pageInfo.getEndRowIndex()<=productInfoList.size()){
				 productInfoListNew = productInfoList.subList(pageInfo.getStartRowIndex(),pageInfo.getEndRowIndex());
			 }
			 productInfoPageInfo.setResult(productInfoListNew);
	         productInfoPageInfo.setCount(productInfoList.size());
	         productInfoPageInfo.setPageNo(pageInfo.getPageNo());
	         productInfoPageInfo.setPageSize(pageInfo.getPageSize());
		} catch (Exception e) {
			log.error("可销售产品查询异常",e);
			throw new BusinessException("可销售产品查询异常",e.getMessage());
		}
		 
		return productInfoPageInfo;
		
	}
	
	private void stepMethod(String detailCode,List<ServiceVO> usageList,ProductQueryVO vo,ProductInfo productInfo,CpPriceDetail cpPriceDetailNew){
		//阶梯组合
		 CpStepInfoCriteria cpStepInfoCriteria = new CpStepInfoCriteria();
		 CpStepInfoCriteria.Criteria criteriaCpStepInfo = cpStepInfoCriteria.createCriteria();
		 
		 criteriaCpStepInfo.andDetailCodeEqualTo(detailCode);

		 if(!StringUtil.isBlank(vo.getServiceType())){
			 criteriaCpStepInfo.andServiceTypeEqualTo(vo.getServiceType());
		 }
		 
		 
		 List<CpStepInfo> cpStepInfo =cpStepInfoMapper.selectByExample(cpStepInfoCriteria);
		 if(!CollectionUtil.isEmpty(cpStepInfo)){
			 CpStepInfo stepInfo = cpStepInfo.get(0);

			 productInfo.setPricingType(stepInfo.getIsTotalPrice());

			 CpStepInfoCriteria cpStepInfoCriteriaNew = new CpStepInfoCriteria();
			 CpStepInfoCriteria.Criteria criteriaCpStepInfoNew = cpStepInfoCriteriaNew.createCriteria();
			 criteriaCpStepInfoNew.andDetailCodeEqualTo(stepInfo.getDetailCode());
			 List<CpStepInfo> cpStepInfoNew =cpStepInfoMapper.selectByExample(cpStepInfoCriteriaNew);
			 
			 for(CpStepInfo s : cpStepInfoNew){
				 ServiceVO serv = new ServiceVO();
				 serv.setAmountStart(s.getSectionA());
				 serv.setAmountEnd(s.getSectionB());
				 serv.setPrice(new java.math.BigDecimal(s.getPriceValue()/1000));
				 serv.setServiceTypeDetail(s.getFactorCode());
				 serv.setUnit(s.getUnitType());
				 serv.setServiceType(s.getServiceType());
				 
				 usageList.add(serv);	        
			 }
			 if(!CollectionUtil.isEmpty(cpStepInfoNew)){
				 productInfo.setBillingType(cpPriceDetailNew.getChargeType()); 
			 }
		 }
		 
	}
	
	private void packageMethod(String detailCode,List<ServiceVO> usageList,ProductQueryVO vo,ProductInfo productInfo,CpPriceDetail cpPriceDetailNew){
		//标准组合
		 CpPackageInfoCriteria cpPackageInfoCriteria =new CpPackageInfoCriteria();
		 CpPackageInfoCriteria.Criteria criteriaCpPackageInfo = cpPackageInfoCriteria.createCriteria();
		 
		 criteriaCpPackageInfo.andDetailCodeEqualTo(detailCode);
		 
		 if(!StringUtil.isBlank(vo.getServiceType())){
			 criteriaCpPackageInfo.andServiceTypeEqualTo(vo.getServiceType());
		 }
		 List<CpPackageInfo> packageInfo = cpPackageInfoMapper.selectByExample(cpPackageInfoCriteria);
		 System.out.println("packageInfoList.Size:"+packageInfo.size());
		 //
		 if(!CollectionUtil.isEmpty(packageInfo)){
			 CpPackageInfo info = packageInfo.get(0);

			 productInfo.setPricingType(info.getIsTotalPrice());

			 CpPackageInfoCriteria cpPackageInfoCriteriaNew =new CpPackageInfoCriteria();
			 CpPackageInfoCriteria.Criteria criteriaCpPackageInfoNew = cpPackageInfoCriteriaNew.createCriteria();
			 
			 criteriaCpPackageInfoNew.andDetailCodeEqualTo(info.getDetailCode());
			 
			 List<CpPackageInfo> packageInfoNew = cpPackageInfoMapper.selectByExample(cpPackageInfoCriteriaNew);

			 for(CpPackageInfo p : packageInfoNew){
				 ServiceVO serv = new ServiceVO();
				 serv.setAmountStart(0);
				 serv.setAmountEnd(p.getAmount());
				 if(null != p.getPriceValue()){
					 serv.setPrice(new java.math.BigDecimal(p.getPriceValue()/1000));
				 }
				 serv.setServiceTypeDetail(p.getFactorCode());
				 serv.setUnit(p.getUnitType());
				 serv.setServiceType(p.getServiceType());
				 usageList.add(serv);
			 }

			 if(!CollectionUtil.isEmpty(packageInfoNew)){
				 productInfo.setBillingType(cpPriceDetailNew.getChargeType()); 
				 productInfo.setTotalPrice(new BigDecimal(packageInfoNew.get(0).getTotalPriceValue()/1000));
			 }
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
	         
			 for(CpPriceInfo c : pageInfo.getResult()){
				 ProductInfo productInfo = new ProductInfo();
				 //
				 productInfo.setActiveDate(c.getActiveTime());
				 productInfo.setInvalidDate(c.getInactiveTime());
				 productInfo.setProductId(c.getPriceCode());
				 productInfo.setProductName(c.getPriceName());
				 productInfo.setStatus(c.getActiveStatus());
				 productInfo.setTenantId(c.getTenantId());
				 //
				 List<ServiceVO> usageList = new ArrayList<ServiceVO>();

				 CpPriceDetailCriteria cpPriceDetailCriteria = new CpPriceDetailCriteria();
				 CpPriceDetailCriteria.Criteria criteriaCpPriceDetail = cpPriceDetailCriteria.createCriteria();
				 
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
					this.stepMethod(detailCode, usageList, productQueryVO, productInfo, cpPriceDetailNew);
					this.packageMethod(detailCode, usageList, productQueryVO, productInfo, cpPriceDetailNew);
					productInfo.setUsageList(usageList);
					productInfoList.add(productInfo);
				 }

			 }
			 Log.info("productInfoList.size----->>>"+productInfoList.size());
			 productInfoPageInfo.setResult(productInfoList);
	         productInfoPageInfo.setCount(productInfoList.size());
	         productInfoPageInfo.setPageNo(1);
	         productInfoPageInfo.setPageSize(productInfoList.size()==0?1:productInfoList.size());

		} catch (Exception e) {
			log.error("getProductInfoByProductIdList-可销售产品查询异常",e);
			throw new BusinessException("可销售产品查询异常",e.getMessage());
		}
		 
		return productInfoPageInfo;
		
	}

}
