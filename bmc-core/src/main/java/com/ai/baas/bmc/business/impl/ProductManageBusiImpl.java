package com.ai.baas.bmc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.marketbleproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marketbleproduct.params.ProductParamVo;
import com.ai.baas.bmc.business.interfaces.ICpPackageInfoBusi;
import com.ai.baas.bmc.business.interfaces.ICpPriceDetailBusi;
import com.ai.baas.bmc.business.interfaces.ICpPriceInfoBusi;
import com.ai.baas.bmc.business.interfaces.ICpStepInfoBusi;
import com.ai.baas.bmc.business.interfaces.IProductManageBusi;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;
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
	private ICpPriceInfoBusi cpPriceInfoBusi;
	@Autowired
	private ICpPriceDetailBusi cpPriceDetailBusi; 
	@Autowired
	private ICpPackageInfoBusi cpPackageInfoBusi;
	@Autowired
	private ICpStepInfoBusi cpStepInfoBusi; 
	
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
		this.cpPriceInfoBusi.updatePriceInfoByPriceCode(cpPriceInfo);
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
		this.cpPriceDetailBusi.updatePriceDetailByPriceCode(cpPriceDetail);
		
	
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
			this.cpStepInfoBusi.updateCpStepInfoByDetailCode(cpStepInfo);
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
			this.cpPackageInfoBusi.updateCpPackageInfoByDetailCode(cpPackageInfo);
			
		}
	}


	@Override
	public void deleteProduct(ProductParamKeyVo vo) {
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceCode(vo.getPriceCode());
		//
		this.cpPriceInfoBusi.deletePriceInfoByPriceCode(cpPriceInfo);
		//
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		cpPriceDetail.setPriceCode(vo.getPriceCode());
		//
		this.cpPriceDetailBusi.deletePriceDetailByPriceCode(cpPriceDetail);
		//
		CpPriceDetail cpPriceDetailDb = this.cpPriceDetailBusi.getCpPriceDetailByPriceCode(cpPriceDetail);
		//
		String chargeType = vo.getChargeType();
		//
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_STEP)){
			CpStepInfo cpStepInfo = new CpStepInfo();
			cpStepInfo.setDetailCode(new Long(cpPriceDetailDb.getDetailCode()));
			//
			this.cpStepInfoBusi.updateCpStepInfoByDetailCode(cpStepInfo);
		}
		//
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_PACKAGE)){
			CpPackageInfo cpPackageInfo = new CpPackageInfo();
			cpPackageInfo.setDetailCode(cpPriceDetailDb.getDetailCode());
			//
			this.cpPackageInfoBusi.updateCpPackageInfoByDetailCode(cpPackageInfo);
			
		}
	}


	@Override
	public ProductParamVo editProduct(ProductParamKeyVo vo) {
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceCode(vo.getPriceCode());
		//
		CpPriceInfo cpPriceInfoNew = this.cpPriceInfoBusi.getCpPriceInfoByPriceCode(cpPriceInfo);
		//
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		cpPriceDetail.setPriceCode(vo.getPriceCode());
		//
		CpPriceDetail cpPriceDetailNew = this.cpPriceDetailBusi.getCpPriceDetailByPriceCode(cpPriceDetail);
		
		String chargeType = vo.getChargeType(); 
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_STEP)){
			CpStepInfo cpStepInfo = new CpStepInfo();
			cpStepInfo.setDetailCode(new Long(cpPriceDetailNew.getDetailCode()));
			//
			this.cpStepInfoBusi.getCpStepInfoByDetailCode(cpStepInfo);
		}
		//
		if(!StringUtil.isBlank(chargeType) && chargeType.equals(CHARGE_TYPE_PACKAGE)){
			CpPackageInfo cpPackageInfo = new CpPackageInfo();
			cpPackageInfo.setDetailCode(cpPriceDetailNew.getDetailCode());
			//
			this.cpPackageInfoBusi.getCpPackageInfoByDetailCode(cpPackageInfo);
		}
		return null;
	}

}
