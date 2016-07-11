package com.ai.baas.bmc.service.business.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.client.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.marktableproduct.params.ProductActiveVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductDelVO;
import com.ai.baas.bmc.api.marktableproduct.params.ProductParamKeyVo;
import com.ai.baas.bmc.api.marktableproduct.params.ProductVO;
import com.ai.baas.bmc.api.marktableproduct.params.ServiceVO;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.context.TableCon;
import com.ai.baas.bmc.context.TableCon.ConTradeSeqLog;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;
import com.ai.baas.bmc.service.atom.interfaces.ICpPackageInfoAtom;
import com.ai.baas.bmc.service.atom.interfaces.ICpPriceDetailAtom;
import com.ai.baas.bmc.service.atom.interfaces.ICpPriceInfoAtom;
import com.ai.baas.bmc.service.atom.interfaces.ICpStepInfoAtom;
import com.ai.baas.bmc.service.business.interfaces.IProductManageBusi;
import com.ai.baas.bmc.service.business.interfaces.ISysSequenceSvc;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.alibaba.fastjson.JSON;

import net.sf.json.JSONObject;

/**
 * (修改产品信息/删除产品信息) 类
 *
 * Date: 2016年4月11日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhangzd
 */
@Service
@Transactional
public class ProductManageBusiImpl implements IProductManageBusi {
	private static final Logger log = LogManager
			.getLogger(ProductManageBusiImpl.class);
	
	@Autowired
	private ISysSequenceSvc aISysSequenceSvc;
	@Autowired
	private ICpPriceInfoAtom cpPriceInfoAtom;
	@Autowired
	private ICpPriceDetailAtom cpPriceDetailAtom;
	@Autowired
	private ICpPackageInfoAtom cpPackageInfoAtom;
	@Autowired
	private ICpStepInfoAtom cpStepInfoAtom;

	public static final String CHARGE_TYPE_STEP = "step_group_type";
	public static final String CHARGE_TYPE_PACKAGE = "standard_group_type";
	public static final String STATUS_ACTIVE = "ACTIVE";
	public static final String STATUS_INACTIVE = "INACTIVE";
	/**
	 * 修改产品信息
	 */
	@Override
	public void updateProduct(ProductVO vo) {
		JSONObject priceinfobject = new JSONObject();
		String priceCode = aISysSequenceSvc.terrigerSysSequence("PRICE_CODE", 1).get(0);
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		
		cpPriceInfo.setPriceCode(vo.getProductId());
		priceinfobject.put("PRICE_CODE", vo.getProductId());
		
		cpPriceInfo.setActiveTime(vo.getActiveDate());
		priceinfobject.put("ACTIVE_TIME", vo.getActiveDate());

		cpPriceInfo.setInactiveTime(vo.getInvalidDate());
		priceinfobject.put("INACTIVE_TIME", vo.getInvalidDate());

		cpPriceInfo.setTenantId(vo.getTenantId());
		priceinfobject.put("TENANT_ID", vo.getTenantId());

		cpPriceInfo.setPriceName(vo.getProductName());
		priceinfobject.put("PRICE_NAME", vo.getProductName());
		
		cpPriceInfo.setActiveStatus(vo.getActiveDateTag());
		priceinfobject.put("ACTIVE_STATUS", vo.getActiveDateTag());
		
		try {
			this.cpPriceInfoAtom.updatePriceInfoByPriceCode(cpPriceInfo);
			log.info("修改cpPriceInfo信息完毕！！！");
			// 插入共享内存
			//DshmUtil.getIdshmSV().initLoader("cp_price_info", JSON.toJSONString(priceinfobject), 0);
			long stepSeq = 0;
			//序列生成DETAIL_CODE
			CpPriceDetail cpPriceDetail = new CpPriceDetail();
			//
			cpPriceDetail.setPriceCode(vo.getProductId());
			CpPriceDetail detailDb = this.cpPriceDetailAtom.getCpPriceDetailByPriceCode(cpPriceDetail);//aISysSequenceSvc.terrigerSysSequence("DETAIL_CODE", 1).get(0);
			String detailCode = detailDb.getDetailCode();
			log.info("序列生成DETAIL_CODE:"+detailCode);
			
			this.toUpdateCpPriceDetail(vo.getProductId(), vo, detailCode);
			for (ServiceVO s : vo.getMajorProductAmount()) {
				
				// 阶梯类型
				if (vo.getBillingType().equalsIgnoreCase(CHARGE_TYPE_STEP)) {
					
					stepSeq++;
					this.toUpdateCpStepInfo(detailCode, s, stepSeq, vo);
				} 
				// 标准类型
				if(vo.getBillingType().equalsIgnoreCase(CHARGE_TYPE_PACKAGE)){
					
					this.toUpdateCpPackageInfo(detailCode, s, vo);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(ProductDelVO vo) {
		String billingType = vo.getBillingType();
		String productId = vo.getProductId();
		
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceCode(productId);
		//
		this.cpPriceInfoAtom.deletePriceInfoByPriceCode(cpPriceInfo);
		//
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		cpPriceDetail.setPriceCode(productId);
		//
		cpPriceDetail = this.cpPriceDetailAtom.getCpPriceDetailByPriceCode(cpPriceDetail);
		//
		this.cpPriceDetailAtom.deletePriceDetailByPriceCode(cpPriceDetail);
		//
		if((CHARGE_TYPE_STEP).equalsIgnoreCase(billingType)){
			CpStepInfo cpStepInfo = new CpStepInfo();
			cpStepInfo.setDetailCode(new Long(cpPriceDetail.getDetailCode()));
			//
			this.cpStepInfoAtom.deleteCpStepInfoByDetailCode(cpStepInfo);
		}
		if((CHARGE_TYPE_PACKAGE).equalsIgnoreCase(billingType)){
			CpPackageInfo cpPackageInfo = new CpPackageInfo();
			cpPackageInfo.setDetailCode(cpPriceDetail.getDetailCode());
			//
			this.cpPackageInfoAtom.updateCpPackageInfoByDetailCode(cpPackageInfo);
		}

	}
	/**
	 * 编辑信息 根据productId和billingType
	 */
	@Override
	public ProductVO editProduct(ProductParamKeyVo vo) {
		String billingType = vo.getBillingType();
		String productId = vo.getProductId();
		ProductVO productVo = new ProductVO();
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceCode(vo.getProductId());
		//
		cpPriceInfo = this.cpPriceInfoAtom.getCpPriceInfoByPriceCode(cpPriceInfo);
		//
		productVo.setActiveDate(cpPriceInfo.getActiveTime());
		//productVo.setActiveDateTag();
		productVo.setBillingType(billingType);
		productVo.setInvalidDate(cpPriceInfo.getInactiveTime());
		//productVo.setIsPriceEqual(isPriceEqual);
		productVo.setProductId(productId);
		productVo.setProductName(cpPriceInfo.getPriceName());
		//productVo.setStandardPriceType();
		productVo.setTenantId(cpPriceInfo.getTenantId());
		
		//
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		cpPriceDetail.setPriceCode(vo.getProductId());
		//
		cpPriceDetail = this.cpPriceDetailAtom.getCpPriceDetailByPriceCode(cpPriceDetail);
		//
		List<ServiceVO> serviceVOList = new ArrayList<ServiceVO>();
		ServiceVO serviceVo = null;
		//
		if((CHARGE_TYPE_STEP).equalsIgnoreCase(billingType)){
			CpStepInfo cpStepInfo = new CpStepInfo();
			cpStepInfo.setDetailCode(new Long(cpPriceDetail.getDetailCode()));
			//
			List<CpStepInfo> cpStepInfoList = this.cpStepInfoAtom.getCpStepInfoByDetailCode(cpStepInfo);
			
			for(CpStepInfo cpStepInfoNew : cpStepInfoList){
				serviceVo = new ServiceVO();
				serviceVo.setServiceId(cpStepInfoNew.getSetpId().toString());
				serviceVo.setPrice(new BigDecimal(cpStepInfoNew.getPriceValue()));
				serviceVo.setAmountStart(cpStepInfoNew.getSectionA());
				serviceVo.setAmountEnd(cpStepInfoNew.getSectionB());
				serviceVo.setUnit(cpStepInfoNew.getUnitType());
				serviceVo.setServiceTypeDetail(cpStepInfoNew.getFactorCode().toString());
				serviceVo.setServiceType(cpStepInfoNew.getServiceType());
				//
				serviceVOList.add(serviceVo);
			}
			if(!CollectionUtil.isEmpty(cpStepInfoList)){
				productVo.setTotalPrice(new BigDecimal(cpStepInfoList.get(0).getTotalPriceValue()));
				productVo.setIsPriceEqual(cpStepInfoList.get(0).getIsPriceEqual());
			}
			
		}
		if((CHARGE_TYPE_PACKAGE).equalsIgnoreCase(billingType)){
			CpPackageInfo cpPackageInfo = new CpPackageInfo();
			cpPackageInfo.setDetailCode(cpPriceDetail.getDetailCode());
			//
			List<CpPackageInfo> cpPackageInfoList = this.cpPackageInfoAtom.getCpPackageInfoByDetailCode(cpPackageInfo);
			
			for(CpPackageInfo cpPackageInfoNew : cpPackageInfoList){
				serviceVo = new ServiceVO();
				serviceVo.setServiceId(cpPackageInfoNew.getPackageId().toString());
				serviceVo.setAmountEnd(cpPackageInfoNew.getAmount());
				serviceVo.setUnit(cpPackageInfoNew.getUnitType());
				serviceVo.setPrice(new BigDecimal(cpPackageInfoNew.getPriceValue()));
				serviceVo.setServiceTypeDetail(cpPackageInfoNew.getFactorCode());
				serviceVo.setServiceType(cpPackageInfoNew.getServiceType());
				serviceVo.setUnit(cpPackageInfoNew.getUnitCode());
				//
				serviceVOList.add(serviceVo);
			}
			if(!CollectionUtil.isEmpty(cpPackageInfoList)){
				productVo.setTotalPrice(new BigDecimal(cpPackageInfoList.get(0).getTotalPriceValue()));
			}
		}
		productVo.setMajorProductAmount(serviceVOList);
		
		//
		return productVo;

	}

	// ---------------------------------************-------------------------------------
	// ---------------------------------************-------------------------------------
	// ---------------------------------************-------------------------------------
	/**
	 * 判断序列号是否存在
	 * 
	 * @param vo
	 * @return
	 * @throws IOException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public String hasSeq(ProductVO vo) throws IOException {
		String flag = "noexit";
		try {
			String rowkey = vo.getTenantId() + Context.SPLIT + Context.AddProduct + Context.SPLIT + vo.getTradeSeq();
			Table table = MyHbaseUtil.getTable(TableCon.TRADE_SEQ_LOG);
			System.out.println("-------hasSeq:" + table + "--->" + rowkey);
			if (MyHbaseUtil.hasExists(table, rowkey)) {
				flag = "exit";
				return flag;
			}
			MyHbaseUtil.addData(table, rowkey, CellTemp.inst(ConTradeSeqLog.TENANT_ID, vo.getTenantId()),
					CellTemp.inst(ConTradeSeqLog.INTERFACE_CODE, Context.AddProduct),
					CellTemp.inst(ConTradeSeqLog.TRADE_SEQ, vo.getTradeSeq()),
					CellTemp.inst(ConTradeSeqLog.RECEIVE_TIME, DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS)),
					CellTemp.inst(ConTradeSeqLog.MSG_CONTENT, MyJsonUtil.toJson(vo)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	/**
	 * 添加产品信息
	 */
	@Override
	public void addProduct(ProductVO vo) {
		JSONObject priceinfobject = new JSONObject();
		String priceCode = aISysSequenceSvc.terrigerSysSequence("PRICE_CODE", 1).get(0);
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setActiveTime(vo.getActiveDate());
		priceinfobject.put("ACTIVE_TIME", vo.getActiveDate());

		cpPriceInfo.setCreateTime(DateUtil.getTimestamp(System.currentTimeMillis()));
		priceinfobject.put("CREATE_TIME", DateUtil.getTimestamp(System.currentTimeMillis()));

		cpPriceInfo.setInactiveTime(vo.getInvalidDate());
		priceinfobject.put("INACTIVE_TIME", vo.getInvalidDate());

		cpPriceInfo.setTenantId(vo.getTenantId());
		priceinfobject.put("TENANT_ID", vo.getTenantId());

		cpPriceInfo.setPriceCode(priceCode);
		priceinfobject.put("PRICE_CODE", priceCode);

		cpPriceInfo.setPriceName(vo.getProductName());
		priceinfobject.put("PRICE_NAME", vo.getProductName());
		
		//如果失效日期大于当前系统日期 那么为有效状态 ACTIVE：有效 ；INACTIVE：失效
//		if(vo.getInvalidDate().compareTo(DateUtil.getSysDate()) > 0){
//			cpPriceInfo.setActiveStatus("1");
//			priceinfobject.put("ACTIVE_STATUS", 1);
//		}else{
			cpPriceInfo.setActiveStatus(STATUS_INACTIVE);
			priceinfobject.put("ACTIVE_STATUS", STATUS_INACTIVE);
//		}
		
		
		try {
			this.cpPriceInfoAtom.addCpPriceInfo(cpPriceInfo);
			log.info("添加cpPriceInfo信息完毕！！！");
			// 插入共享内存
			DshmUtil.getIdshmSV().initLoader("cp_price_info", priceinfobject.toString(), 1);
			long stepSeq = 0;
			//序列生成DETAIL_CODE
			String detailCode = aISysSequenceSvc.terrigerSysSequence("DETAIL_CODE", 1).get(0);
			log.info("序列生成DETAIL_CODE:"+detailCode);
			this.toAddCpPriceDetail(priceCode, vo, detailCode);
			for (ServiceVO s : vo.getMajorProductAmount()) {
				
				// 阶梯类型
				if (vo.getBillingType().equalsIgnoreCase(CHARGE_TYPE_STEP)) {
					
					stepSeq++;
					this.toAddCpStepInfo(detailCode, s, stepSeq, vo);
				} 
				// 标准类型
				if(vo.getBillingType().equalsIgnoreCase(CHARGE_TYPE_PACKAGE)){
					
					this.toAddCpPackageInfo(detailCode, s, vo);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("error",e.getMessage());
		}

	}
	/**
	 * 添加价格详单表
	 * @param priceCode
	 * @param vo
	 * @param detailCode
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	private void toAddCpPriceDetail(String priceCode, ProductVO vo, String detailCode) {
		JSONObject detailobject = new JSONObject();
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		cpPriceDetail.setActiveTime(vo.getActiveDate());
		detailobject.put("ACTIVE_TIME", vo.getActiveDate());

		cpPriceDetail.setChargeType(vo.getBillingType());
		detailobject.put("CHARGE_TYPE", vo.getBillingType());

		cpPriceDetail.setDetailCode(detailCode);
		detailobject.put("DETAIL_CODE", detailCode);

		cpPriceDetail.setInactiveTime(vo.getInvalidDate());
		detailobject.put("INACTIVE_TIME", vo.getInvalidDate());

		cpPriceDetail.setDetailName(vo.getProductName());
		detailobject.put("DETAIL_NAME", vo.getProductName());

		cpPriceDetail.setPriceCode(priceCode);
		detailobject.put("PRICE_CODE", priceCode);

		// cpPriceDetail.setServiceType(s.getServiceType());
		// detailobject.put("SERVICE_TYPE", s.getServiceType());

		this.cpPriceDetailAtom.addCpPriceDetail(cpPriceDetail);
		DshmUtil.getIdshmSV().initLoader("cp_price_detail", detailobject.toString(), 1);
	}
	/**
	 * 添加阶梯组合表信息
	 * @param detailCode
	 * @param serviceVO
	 * @param stepSeq
	 * @param vo
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	private void toAddCpStepInfo(String detailCode, ServiceVO serviceVO, long stepSeq, ProductVO vo) {
		CpStepInfo cpStepInfo = new CpStepInfo();
		JSONObject stepobject = new JSONObject();
		cpStepInfo.setDetailCode(Long.valueOf(detailCode));
		stepobject.put("DETAIL_CODE", detailCode);
		// cpStepInfo.setExtCode(extCode);
		// cpStepInfo.setFactorCode(factorCode);
		cpStepInfo.setPriceValue(serviceVO.getPrice().doubleValue());
		stepobject.put("PRICE_VALUE", serviceVO.getPrice());

		cpStepInfo.setSectionA(serviceVO.getAmountStart());
		stepobject.put("SECTION_A", serviceVO.getAmountStart());

		cpStepInfo.setSectionB(serviceVO.getAmountEnd());
		stepobject.put("SECTION_B", serviceVO.getAmountEnd());

		cpStepInfo.setTotalPriceValue(vo.getTotalPrice().doubleValue());
		stepobject.put("TOTAL_PRICE_VALUE", vo.getTotalPrice());

		cpStepInfo.setStepSeq(stepSeq);
		stepobject.put("STEP_SEQ", Long.toString(stepSeq));

		cpStepInfo.setUnitType(serviceVO.getUnit());
		stepobject.put("UNIT_TYPE", serviceVO.getUnit());

		cpStepInfo.setServiceType(serviceVO.getServiceType());
		stepobject.put("SERVICE_TYPE", serviceVO.getServiceType());
		
		cpStepInfo.setFactorCode(serviceVO.getServiceTypeDetail());
		stepobject.put("FACTOR_CODE", serviceVO.getServiceTypeDetail());
		
		cpStepInfo.setIsPriceEqual(vo.getIsPriceEqual());
		stepobject.put("IS_PRICE_EQUAL", vo.getIsPriceEqual());
		
		this.cpStepInfoAtom.addCpStepInfo(cpStepInfo);
		DshmUtil.getIdshmSV().initLoader("cp_step_info", stepobject.toString(), 1);
	}

	/**
	 * 添加标准组合表信息
	 * @param detailCode
	 * @param serviceVO
	 * @param vo
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	private void toAddCpPackageInfo(String detailCode, ServiceVO serviceVO, ProductVO vo) {
		CpPackageInfo cpPackageInfo = new CpPackageInfo();
		JSONObject packageobject = new JSONObject();

		cpPackageInfo.setAmount(serviceVO.getAmountEnd());
		packageobject.put("AMOUNT", serviceVO.getAmountEnd());

		cpPackageInfo.setDetailCode(detailCode);
		packageobject.put("DETAIL_CODE", detailCode);

		cpPackageInfo.setUnitType(serviceVO.getUnit());
		packageobject.put("UNIT_TYPE", serviceVO.getUnit());

		cpPackageInfo.setPriceValue(0.0);//(serviceVO.getPrice().doubleValue());
		packageobject.put("PRICE_VALUE", "0.0");

		cpPackageInfo.setTotalPriceValue(vo.getTotalPrice().doubleValue());
		packageobject.put("TOTAL_PRICE_VALUE", vo.getTotalPrice());

		cpPackageInfo.setFactorCode(serviceVO.getServiceTypeDetail());
		packageobject.put("FACTOR_CODE", serviceVO.getServiceTypeDetail());

		cpPackageInfo.setServiceType(serviceVO.getServiceType());
		packageobject.put("SERVICE_TYPE", serviceVO.getServiceType());
		
		cpPackageInfo.setUnitCode(serviceVO.getUnit());
		packageobject.put("UNIT_CODE", serviceVO.getUnit());
		
		cpPackageInfo.setFactorCode(serviceVO.getServiceTypeDetail());
		packageobject.put("FACTOR_CODE", serviceVO.getServiceTypeDetail());
		
		this.cpPackageInfoAtom.addCpPackageInfo(cpPackageInfo);
		DshmUtil.getIdshmSV().initLoader("cp_package_info", packageobject.toString(), 1);
	}
	
	//-------------------------修改相关表信息-----------------------------
	
	/**
	 * 修改价格详单表
	 * @param priceCode
	 * @param vo
	 * @param detailCode
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	private void toUpdateCpPriceDetail(String priceCode, ProductVO vo, String detailCode) {
		JSONObject detailobject = new JSONObject();
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		cpPriceDetail.setActiveTime(vo.getActiveDate());
		detailobject.put("ACTIVE_TIME", vo.getActiveDate());

		cpPriceDetail.setChargeType(vo.getBillingType());
		detailobject.put("CHARGE_TYPE", vo.getBillingType());

		cpPriceDetail.setDetailCode(detailCode);
		detailobject.put("DETAIL_CODE", detailCode);

		cpPriceDetail.setInactiveTime(vo.getInvalidDate());
		detailobject.put("INACTIVE_TIME", vo.getInvalidDate());

		cpPriceDetail.setDetailName(vo.getProductName());
		detailobject.put("DETAIL_NAME", vo.getProductName());

		cpPriceDetail.setPriceCode(priceCode);
		detailobject.put("PRICE_CODE", priceCode);

		// cpPriceDetail.setServiceType(s.getServiceType());
		// detailobject.put("SERVICE_TYPE", s.getServiceType());

		this.cpPriceDetailAtom.updatePriceDetailByPriceCode(cpPriceDetail);
		//DshmUtil.getIdshmSV().initLoader("cp_price_detail", detailobject.toString(), 0);
	}
	/**
	 * 修改阶梯组合表信息
	 * @param detailCode
	 * @param serviceVO
	 * @param stepSeq
	 * @param vo
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	private void toUpdateCpStepInfo(String detailCode, ServiceVO serviceVO, long stepSeq, ProductVO vo) {
		CpStepInfo cpStepInfo = new CpStepInfo();
		JSONObject stepobject = new JSONObject();
		cpStepInfo.setSetpId(new Long(serviceVO.getServiceId()));
		stepobject.put("STEP_ID", serviceVO.getServiceId());
		
		cpStepInfo.setDetailCode(Long.valueOf(detailCode));
		stepobject.put("DETAIL_CODE", detailCode);
		// cpStepInfo.setExtCode(extCode);
		// cpStepInfo.setFactorCode(factorCode);
		cpStepInfo.setPriceValue(serviceVO.getPrice().doubleValue());
		stepobject.put("PRICE_VALUE", serviceVO.getPrice());

		cpStepInfo.setSectionA(serviceVO.getAmountStart());
		stepobject.put("SECTION_A", serviceVO.getAmountStart());

		cpStepInfo.setSectionB(serviceVO.getAmountEnd());
		stepobject.put("SECTION_B", serviceVO.getAmountEnd());

		cpStepInfo.setTotalPriceValue(vo.getTotalPrice().doubleValue());
		stepobject.put("TOTAL_PRICE_VALUE", vo.getTotalPrice());

		cpStepInfo.setStepSeq(stepSeq);
		stepobject.put("STEP_SEQ", Long.toString(stepSeq));

		cpStepInfo.setUnitType(serviceVO.getUnit());
		stepobject.put("UNIT_TYPE", serviceVO.getUnit());

		cpStepInfo.setFactorCode(serviceVO.getServiceTypeDetail());
		stepobject.put("FACTOR_CODE", serviceVO.getServiceTypeDetail());

		cpStepInfo.setServiceType(serviceVO.getServiceType());
		stepobject.put("SERVICE_TYPE", serviceVO.getServiceType());
		
		if(StringUtil.isBlank(vo.getIsPriceEqual())){
			cpStepInfo.setIsPriceEqual("0");
			stepobject.put("IS_PRICE_EQUAL", "0");
		}else{
			cpStepInfo.setIsPriceEqual(vo.getIsPriceEqual());
			stepobject.put("IS_PRICE_EQUAL", vo.getIsPriceEqual());
		}
		
		//this.cpStepInfoAtom.updateCpStepInfoByDetailCode(cpStepInfo);
		if(StringUtil.isBlank(serviceVO.getServiceId())){
			this.cpStepInfoAtom.addCpStepInfo(cpStepInfo);
			DshmUtil.getIdshmSV().initLoader("cp_step_info", JSON.toJSONString(stepobject), 1);
		}else{
			this.cpStepInfoAtom.updateCpStepInfoByPrimaryKey(cpStepInfo);
			DshmUtil.getIdshmSV().initLoader("cp_step_info", JSON.toJSONString(stepobject), 0);
		}
	}

	/**
	 * 修改标准组合表信息
	 * @param detailCode
	 * @param serviceVO
	 * @param vo
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	private void toUpdateCpPackageInfo(String detailCode, ServiceVO serviceVO, ProductVO vo) {
		CpPackageInfo cpPackageInfo = new CpPackageInfo();
		JSONObject packageobject = new JSONObject();

		cpPackageInfo.setPackageId(new Long(serviceVO.getServiceId()));
		packageobject.put("PACKAGE_ID", serviceVO.getServiceId());
		
		cpPackageInfo.setAmount(serviceVO.getAmountEnd());
		packageobject.put("AMOUNT", serviceVO.getAmountEnd());

		cpPackageInfo.setDetailCode(detailCode);
		packageobject.put("DETAIL_CODE", detailCode);

		cpPackageInfo.setUnitType(serviceVO.getUnit());
		packageobject.put("UNIT_TYPE", serviceVO.getUnit());

		cpPackageInfo.setPriceValue(0.0);//(serviceVO.getPrice().doubleValue());
		packageobject.put("PRICE_VALUE", 0.0);//serviceVO.getPrice());

		cpPackageInfo.setTotalPriceValue(vo.getTotalPrice().doubleValue());
		packageobject.put("TOTAL_PRICE_VALUE", vo.getTotalPrice());

		cpPackageInfo.setFactorCode(serviceVO.getServiceTypeDetail());
		packageobject.put("FACTOR_CODE", serviceVO.getServiceTypeDetail());

		cpPackageInfo.setServiceType(serviceVO.getServiceType());
		packageobject.put("SERVICE_TYPE", serviceVO.getServiceType());
		
		cpPackageInfo.setUnitCode(serviceVO.getUnit());
		packageobject.put("UNIT_CODE", serviceVO.getUnit());
		//
		if(StringUtil.isBlank(serviceVO.getServiceId())){
			this.cpPackageInfoAtom.addCpPackageInfo(cpPackageInfo);
			DshmUtil.getIdshmSV().initLoader("cp_package_info", JSON.toJSONString(packageobject), 1);
		}else{
			this.cpPackageInfoAtom.updateCpPackageInfoByPrimaryKey(cpPackageInfo);
			DshmUtil.getIdshmSV().initLoader("cp_package_info", JSON.toJSONString(packageobject), 0);
		}
	}

	@Override
	public void updateProductStatus(ProductActiveVO vo) {
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setTenantId(vo.getTenantId());
		cpPriceInfo.setPriceCode(vo.getProductId());
		cpPriceInfo.setActiveStatus(vo.getStatus());
		//
		this.cpPriceInfoAtom.updateProductStatus(cpPriceInfo);
		
	}
}
