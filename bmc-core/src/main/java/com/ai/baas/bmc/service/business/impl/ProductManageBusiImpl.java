package com.ai.baas.bmc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.marktableproduct.params.CpPackageInfoParamVo;
import com.ai.baas.bmc.api.marktableproduct.params.CpPriceDetailParamVo;
import com.ai.baas.bmc.api.marktableproduct.params.CpPriceInfoParamVo;
import com.ai.baas.bmc.api.marktableproduct.params.CpStepInfoParamVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProcductResponse;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamVo;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;
import com.ai.baas.bmc.service.atom.interfaces.ICpPackageInfoAtom;
import com.ai.baas.bmc.service.atom.interfaces.ICpPriceDetailAtom;
import com.ai.baas.bmc.service.atom.interfaces.ICpPriceInfoAtom;
import com.ai.baas.bmc.service.atom.interfaces.ICpStepInfoAtom;
import com.ai.baas.bmc.service.business.interfaces.IProductManageBusi;
import com.ai.paas.ipaas.util.StringUtil;
/**
 * (修改产品信息/删除产品信息) 类
 *
 * Date: 2016年4月11日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
@Service
@Transactional
public class ProductManageBusiImpl implements IProductManageBusi {

	@Autowired
	private ICpPriceInfoAtom cpPriceInfoAtom;
	@Autowired
	private ICpPriceDetailAtom cpPriceDetailAtom; 
	@Autowired
	private ICpPackageInfoAtom cpPackageInfoAtom;
	@Autowired
	private ICpStepInfoAtom cpStepInfoAtom; 
	
	public static final String CHARGE_TYPE_STEP = "STEP";
	public static final String CHARGE_TYPE_PACKAGE = "PACKAGE";
	
	@Override
	public void updateProduct(ProductParamVo vo) {
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setTenantId(vo.getCpPriceInfoParamVo().getTenantId());
		cpPriceInfo.setProductType(vo.getCpPriceInfoParamVo().getProductType());
		cpPriceInfo.setPriceName(vo.getCpPriceInfoParamVo().getPriceName());
		cpPriceInfo.setPriceInfoId(vo.getCpPriceInfoParamVo().getPriceInfoId());
		cpPriceInfo.setPriceCode(vo.getPriceCode());
		cpPriceInfo.setOperatorId(vo.getCpPriceInfoParamVo().getOperatorId());
		cpPriceInfo.setActiveTime(vo.getCpPriceInfoParamVo().getActiveTime());
		cpPriceInfo.setInactiveTime(vo.getCpPriceInfoParamVo().getInactiveTime());
		cpPriceInfo.setComments(vo.getCpPriceInfoParamVo().getComments());
		cpPriceInfo.setActiveStatus(vo.getCpPriceInfoParamVo().getActiveStatus());
		//
		this.cpPriceInfoAtom.updatePriceInfoByPriceCode(cpPriceInfo);
		//
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		cpPriceDetail.setActiveTime(vo.getCpPriceDetailParamVo().getActiveTime());
		cpPriceDetail.setChargeType(vo.getCpPriceDetailParamVo().getChargeType());
		cpPriceDetail.setComments(vo.getCpPriceDetailParamVo().getComments());
		cpPriceDetail.setDetailCode(vo.getCpPriceDetailParamVo().getDetailCode());
		cpPriceDetail.setDetailId(vo.getCpPriceDetailParamVo().getDetailId());
		cpPriceDetail.setDetailName(vo.getCpPriceDetailParamVo().getDetailName());
		cpPriceDetail.setInactiveTime(vo.getCpPriceDetailParamVo().getInactiveTime());
		cpPriceDetail.setPriceCode(vo.getCpPriceDetailParamVo().getPriceCode());
		cpPriceDetail.setServiceType(vo.getCpPriceDetailParamVo().getServiceType());
		//
		this.cpPriceDetailAtom.updatePriceDetailByPriceCode(cpPriceDetail);
		
	
		String chargeType = vo.getChargeType();
		//
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_STEP)){
			CpStepInfo cpStepInfo = new CpStepInfo();
			cpStepInfo.setDetailCode(new Long(cpPriceDetail.getDetailCode()));
			cpStepInfo.setExtCode(vo.getCpStepInfoParamVo().getExtCode());
			cpStepInfo.setFactorCode(vo.getCpStepInfoParamVo().getFactorCode());
			cpStepInfo.setPriceValue(vo.getCpStepInfoParamVo().getPriceValue());
			cpStepInfo.setSectionA(vo.getCpStepInfoParamVo().getSectionA());
			cpStepInfo.setSectionB(vo.getCpStepInfoParamVo().getSectionB());
			cpStepInfo.setSetpId(vo.getCpStepInfoParamVo().getSetpId());
			cpStepInfo.setStepSeq(vo.getCpStepInfoParamVo().getStepSeq());
			cpStepInfo.setTotalPriceValue(vo.getCpStepInfoParamVo().getTotalPriceValue());
			cpStepInfo.setUnitType(vo.getCpStepInfoParamVo().getUnitType());
			//
			this.cpStepInfoAtom.updateCpStepInfoByDetailCode(cpStepInfo);
		}
		
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_PACKAGE)){
			CpPackageInfo cpPackageInfo = new CpPackageInfo();
			cpPackageInfo.setAmount(vo.getCpPackageInfoParamVo().getAmount());
			cpPackageInfo.setDetailCode(cpPriceDetail.getDetailCode());
			cpPackageInfo.setExceedType(vo.getCpPackageInfoParamVo().getExceedType());
			cpPackageInfo.setExtCode(vo.getCpPackageInfoParamVo().getExtCode());
			cpPackageInfo.setFactorCode(vo.getCpPackageInfoParamVo().getFactorCode());
			cpPackageInfo.setPackageId(vo.getCpPackageInfoParamVo().getPackageId());
			cpPackageInfo.setPriceValue(vo.getCpPackageInfoParamVo().getPriceValue());
			cpPackageInfo.setTotalPriceValue(vo.getCpPackageInfoParamVo().getTotalPriceValue());
			cpPackageInfo.setUnitCode(vo.getCpPackageInfoParamVo().getUnitCode());
			cpPackageInfo.setUnitpriceCode(vo.getCpPackageInfoParamVo().getUnitpriceCode());
			cpPackageInfo.setUnitType(vo.getCpPackageInfoParamVo().getUnitType());
			//
			this.cpPackageInfoAtom.updateCpPackageInfoByDetailCode(cpPackageInfo);
			
		}
	}


	@Override
	public void deleteProduct(ProductParamKeyVo vo) {
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceCode(vo.getPriceCode());
		//
		this.cpPriceInfoAtom.deletePriceInfoByPriceCode(cpPriceInfo);
		//
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		cpPriceDetail.setPriceCode(vo.getPriceCode());
		//
		this.cpPriceDetailAtom.deletePriceDetailByPriceCode(cpPriceDetail);
		//
		CpPriceDetail cpPriceDetailDb = this.cpPriceDetailAtom.getCpPriceDetailByPriceCode(cpPriceDetail);
		//
		String chargeType = vo.getChargeType();
		//
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_STEP)){
			CpStepInfo cpStepInfo = new CpStepInfo();
			cpStepInfo.setDetailCode(new Long(cpPriceDetailDb.getDetailCode()));
			//
			this.cpStepInfoAtom.updateCpStepInfoByDetailCode(cpStepInfo);
		}
		//
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_PACKAGE)){
			CpPackageInfo cpPackageInfo = new CpPackageInfo();
			cpPackageInfo.setDetailCode(cpPriceDetailDb.getDetailCode());
			//
			this.cpPackageInfoAtom.updateCpPackageInfoByDetailCode(cpPackageInfo);
			
		}
	}


	@Override
	public ProductParamVo editProduct(ProductParamKeyVo vo) {
		ProductParamVo productParamVo = new ProductParamVo();
		//1.add priceCode
		productParamVo.setPriceCode(vo.getPriceCode());
		//2.add chargeType
		productParamVo.setChargeType(vo.getChargeType());
		//
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceCode(vo.getPriceCode());
		//
		CpPriceInfo cpPriceInfoNew = this.cpPriceInfoAtom.getCpPriceInfoByPriceCode(cpPriceInfo);
		//
		CpPriceInfoParamVo cpPriceInfoParamVo = new CpPriceInfoParamVo();
		if(null != cpPriceInfoNew){
			cpPriceInfoParamVo.setActiveStatus(cpPriceInfoNew.getActiveStatus());
			cpPriceInfoParamVo.setActiveTime(cpPriceInfoNew.getActiveTime());
			cpPriceInfoParamVo.setComments(cpPriceInfoNew.getComments());
			cpPriceInfoParamVo.setCreateTime(cpPriceInfoNew.getCreateTime());
			cpPriceInfoParamVo.setInactiveTime(cpPriceInfoNew.getInactiveTime());
			cpPriceInfoParamVo.setOperatorId(cpPriceInfoNew.getOperatorId());
			cpPriceInfoParamVo.setPriceCode(cpPriceInfoNew.getPriceCode());
			cpPriceInfoParamVo.setPriceInfoId(cpPriceInfoNew.getPriceInfoId());
			cpPriceInfoParamVo.setPriceName(cpPriceInfoNew.getPriceName());
			cpPriceInfoParamVo.setProductType(cpPriceInfoNew.getProductType());
			cpPriceInfoParamVo.setTenantId(cpPriceInfoNew.getTenantId());
		}
		//3.add cpPriceInfo
		productParamVo.setCpPriceInfoParamVo(cpPriceInfoParamVo);
		
		//
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		cpPriceDetail.setPriceCode(vo.getPriceCode());
		//
		CpPriceDetail cpPriceDetailNew = this.cpPriceDetailAtom.getCpPriceDetailByPriceCode(cpPriceDetail);
		//
		CpPriceDetailParamVo cpPriceDetailParamVo = new CpPriceDetailParamVo();
		if(null != cpPriceDetailNew){
			cpPriceDetailParamVo.setActiveTime(cpPriceDetailNew.getActiveTime());
			cpPriceDetailParamVo.setChargeType(cpPriceDetailNew.getChargeType());
			cpPriceDetailParamVo.setComments(cpPriceDetailNew.getComments());
			cpPriceDetailParamVo.setDetailCode(cpPriceDetailNew.getDetailCode());
			cpPriceDetailParamVo.setDetailId(cpPriceDetailNew.getDetailId());
			cpPriceDetailParamVo.setDetailName(cpPriceDetailNew.getDetailName());
			cpPriceDetailParamVo.setInactiveTime(cpPriceDetailNew.getInactiveTime());
			cpPriceDetailParamVo.setPriceCode(cpPriceDetailNew.getPriceCode());
			cpPriceDetailParamVo.setServiceType(cpPriceDetailNew.getServiceType());
			
		}
		//4.add cpPriceDetail
		productParamVo.setCpPriceDetailParamVo(cpPriceDetailParamVo);
		//
		String chargeType = vo.getChargeType();
		CpStepInfoParamVo cpStepInfoParamVo = new CpStepInfoParamVo();
		CpStepInfo cpStepInfoNew = null;
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_STEP)){
			CpStepInfo cpStepInfo = new CpStepInfo();
			cpStepInfo.setDetailCode(new Long(cpPriceDetailNew.getDetailCode()));
			//
			cpStepInfoNew = this.cpStepInfoAtom.getCpStepInfoByDetailCode(cpStepInfo);
			//
			if(null != cpStepInfoNew){
				cpStepInfoParamVo.setDetailCode(cpStepInfoNew.getDetailCode());
				cpStepInfoParamVo.setExtCode(cpStepInfoNew.getExtCode());
				cpStepInfoParamVo.setFactorCode(cpStepInfoNew.getFactorCode());
				cpStepInfoParamVo.setPriceValue(cpStepInfoNew.getPriceValue());
				cpStepInfoParamVo.setSectionA(cpStepInfoNew.getSectionA());
				cpStepInfoParamVo.setSectionB(cpStepInfoNew.getSectionB());
				cpStepInfoParamVo.setSetpId(cpStepInfoNew.getSetpId());
				cpStepInfoParamVo.setStepSeq(cpStepInfoNew.getStepSeq());
				cpStepInfoParamVo.setTotalPriceValue(cpStepInfoNew.getTotalPriceValue());
				cpStepInfoParamVo.setUnitType(cpStepInfoNew.getUnitType());
			}
		}
		//5.add cpStepInfo
		productParamVo.setCpStepInfoParamVo(cpStepInfoParamVo);
		//
		CpPackageInfoParamVo cpPackageInfoParamVo = new CpPackageInfoParamVo();
		CpPackageInfo cpPackageInfoNew = null;
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_PACKAGE)){
			CpPackageInfo cpPackageInfo = new CpPackageInfo();
			cpPackageInfo.setDetailCode(cpPriceDetailNew.getDetailCode());
			//
			cpPackageInfoNew = this.cpPackageInfoAtom.getCpPackageInfoByDetailCode(cpPackageInfo);
			if(null != cpPackageInfoNew){
				cpPackageInfoParamVo.setAmount(cpPackageInfoNew.getAmount());
				cpPackageInfoParamVo.setDetailCode(cpPackageInfoNew.getDetailCode());
				cpPackageInfoParamVo.setExceedType(cpPackageInfoNew.getExceedType());
				cpPackageInfoParamVo.setExtCode(cpPackageInfoNew.getExtCode());
				cpPackageInfoParamVo.setFactorCode(cpPackageInfoNew.getFactorCode());
				cpPackageInfoParamVo.setPackageId(cpPackageInfoNew.getPackageId());
				cpPackageInfoParamVo.setPriceValue(cpPackageInfoNew.getPriceValue());
				cpPackageInfoParamVo.setTotalPriceValue(cpPackageInfoNew.getTotalPriceValue());
				cpPackageInfoParamVo.setUnitCode(cpPackageInfoNew.getUnitCode());
				cpPackageInfoParamVo.setUnitpriceCode(cpPackageInfoNew.getUnitpriceCode());
				cpPackageInfoParamVo.setUnitType(cpPackageInfoNew.getUnitType());
			}
		}
		//add cpPackageInfo
		productParamVo.setCpPackageInfoParamVo(cpPackageInfoParamVo);
		//
		return productParamVo;
		
	}


	@Override
	@Transactional
	public ProcductResponse insertProduct(ProductParamVo vo) {
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setTenantId(vo.getCpPriceInfoParamVo().getTenantId());
		cpPriceInfo.setProductType(vo.getCpPriceInfoParamVo().getProductType());
		cpPriceInfo.setPriceName(vo.getCpPriceInfoParamVo().getPriceName());
		cpPriceInfo.setPriceInfoId(vo.getCpPriceInfoParamVo().getPriceInfoId());
		cpPriceInfo.setPriceCode(vo.getCpPriceInfoParamVo().getPriceCode());
		cpPriceInfo.setOperatorId(vo.getCpPriceInfoParamVo().getOperatorId());
		cpPriceInfo.setActiveTime(vo.getCpPriceInfoParamVo().getActiveTime());
		cpPriceInfo.setInactiveTime(vo.getCpPriceInfoParamVo().getInactiveTime());
		cpPriceInfo.setComments(vo.getCpPriceInfoParamVo().getComments());
		cpPriceInfo.setActiveStatus(vo.getCpPriceInfoParamVo().getActiveStatus());
		try{
			//1.add cpPriceInfo
			this.cpPriceInfoAtom.addCpPriceInfo(cpPriceInfo);
			//
			List<CpPriceDetailParamVo> cpPriceDetailParamVoList = new ArrayList<CpPriceDetailParamVo>();
			cpPriceDetailParamVoList = vo.getCpPriceDetailParamVoList();
			if(cpPriceDetailParamVoList.size()>0){
				CpPriceDetail cpPriceDetail = null;
				for(CpPriceDetailParamVo cpPriceDetailParamVo : cpPriceDetailParamVoList){
					cpPriceDetail = new CpPriceDetail();
					cpPriceDetail.setActiveTime(cpPriceDetailParamVo.getActiveTime());
					cpPriceDetail.setChargeType(cpPriceDetailParamVo.getChargeType());
					cpPriceDetail.setComments(cpPriceDetailParamVo.getComments());
					cpPriceDetail.setDetailCode(cpPriceDetailParamVo.getDetailCode());
					cpPriceDetail.setDetailId(cpPriceDetailParamVo.getDetailId());
					cpPriceDetail.setDetailName(cpPriceDetailParamVo.getDetailName());
					cpPriceDetail.setInactiveTime(cpPriceDetailParamVo.getInactiveTime());
					cpPriceDetail.setPriceCode(cpPriceDetailParamVo.getPriceCode());
					cpPriceDetail.setServiceType(cpPriceDetailParamVo.getServiceType());
					this.cpPriceDetailAtom.addCpPriceDetail(cpPriceDetail);
					//
					String chargeType = vo.getChargeType();
					
					if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_STEP)){
						CpStepInfo cpStepInfo = new CpStepInfo();
						cpStepInfo.setDetailCode(new Long(cpPriceDetail.getDetailCode()));
						cpStepInfo.setExtCode(cpPriceDetailParamVo.getCpStepInfoParamVo().getExtCode());
						cpStepInfo.setFactorCode(cpPriceDetailParamVo.getCpStepInfoParamVo().getFactorCode());
						cpStepInfo.setPriceValue(cpPriceDetailParamVo.getCpStepInfoParamVo().getPriceValue());
						cpStepInfo.setSectionA(cpPriceDetailParamVo.getCpStepInfoParamVo().getSectionA());
						cpStepInfo.setSectionB(cpPriceDetailParamVo.getCpStepInfoParamVo().getSectionB());
						cpStepInfo.setSetpId(cpPriceDetailParamVo.getCpStepInfoParamVo().getSetpId());
						cpStepInfo.setStepSeq(cpPriceDetailParamVo.getCpStepInfoParamVo().getStepSeq());
						cpStepInfo.setTotalPriceValue(cpPriceDetailParamVo.getCpStepInfoParamVo().getTotalPriceValue());
						cpStepInfo.setUnitType(cpPriceDetailParamVo.getCpStepInfoParamVo().getUnitType());
						//
						this.cpStepInfoAtom.addCpStepInfo(cpStepInfo);
					}
					if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_PACKAGE)){
						CpPackageInfo cpPackageInfo = new CpPackageInfo();
						cpPackageInfo.setAmount(cpPriceDetailParamVo.getCpPackageInfoParamVo().getAmount());
						cpPackageInfo.setDetailCode(cpPriceDetail.getDetailCode());
						cpPackageInfo.setExceedType(cpPriceDetailParamVo.getCpPackageInfoParamVo().getExceedType());
						cpPackageInfo.setExtCode(vo.getCpPackageInfoParamVo().getExtCode());
						cpPackageInfo.setFactorCode(cpPriceDetailParamVo.getCpPackageInfoParamVo().getFactorCode());
						cpPackageInfo.setPackageId(cpPriceDetailParamVo.getCpPackageInfoParamVo().getPackageId());
						cpPackageInfo.setPriceValue(cpPriceDetailParamVo.getCpPackageInfoParamVo().getPriceValue());
						cpPackageInfo.setTotalPriceValue(cpPriceDetailParamVo.getCpPackageInfoParamVo().getTotalPriceValue());
						cpPackageInfo.setUnitCode(cpPriceDetailParamVo.getCpPackageInfoParamVo().getUnitCode());
						cpPackageInfo.setUnitpriceCode(cpPriceDetailParamVo.getCpPackageInfoParamVo().getUnitpriceCode());
						cpPackageInfo.setUnitType(cpPriceDetailParamVo.getCpPackageInfoParamVo().getUnitType());
						//
						this.cpPackageInfoAtom.addCpPackageInfo(cpPackageInfo);
					}
				}
			}
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
