package com.ai.baas.bmc.business.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.hadoop.hbase.client.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.marktableproduct.params.ProductVO;
import com.ai.baas.bmc.api.marktableproduct.params.ServiceVO;
import com.ai.baas.bmc.business.interfaces.IProductManageBusiness;
import com.ai.baas.bmc.business.interfaces.ISysSequenceSvc;
import com.ai.baas.bmc.context.Context;
import com.ai.baas.bmc.context.TableCon;
import com.ai.baas.bmc.context.TableCon.ConTradeSeqLog;
import com.ai.baas.bmc.dao.interfaces.CpPackageInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;
import com.ai.baas.bmc.dao.interfaces.CpStepInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPackageInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpStepInfo;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.baas.bmc.util.MyHbaseUtil.CellTemp;
import com.ai.baas.bmc.util.MyJsonUtil;
import com.ai.opt.sdk.util.DateUtil;

@Service
@Transactional
public class IProductManageBusinessImpl implements IProductManageBusiness {
	@Autowired
	private CpPriceInfoMapper cpPriceInfoMapper;
	@Autowired
	private ISysSequenceSvc aISysSequenceSvc;
	@Autowired
	private CpPriceDetailMapper cpPriceDetailMapper;
	@Autowired
	private CpStepInfoMapper cpStepInfoMapper;
	@Autowired
	private CpPackageInfoMapper cpPackageInfoMapper;

	@Override
	public String hasSeq(ProductVO vo) throws IOException {
		String flag = "noexit";
		try{
		String rowkey = vo.getTenantId() + Context.SPLIT
				+ Context.AddProduct + Context.SPLIT + vo.getTradeSeq();
		Table table = MyHbaseUtil.getTable(TableCon.TRADE_SEQ_LOG);
		System.out.println("-------hasSeq:"+table+"--->"+rowkey);
		if (MyHbaseUtil.hasExists(table, rowkey)) {
			flag="exit";
			return flag;
		}
		MyHbaseUtil.addData(table,rowkey,
						CellTemp.inst(ConTradeSeqLog.TENANT_ID,
								vo.getTenantId()),
						CellTemp.inst(ConTradeSeqLog.INTERFACE_CODE,
								Context.AddProduct),
						CellTemp.inst(ConTradeSeqLog.TRADE_SEQ,
								vo.getTradeSeq()),
						CellTemp.inst(ConTradeSeqLog.RECEIVE_TIME,
								DateUtil.getDateString(DateUtil.YYYYMMDDHHMMSS)),
						CellTemp.inst(ConTradeSeqLog.MSG_CONTENT,
								MyJsonUtil.toJson(vo)));
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public void addproduct(ProductVO vo) {

		JSONObject priceinfobject = new JSONObject();
		String priceCode = aISysSequenceSvc
				.terrigerSysSequence("PRICE_CODE", 1).get(0);
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setActiveTime(vo.getActiveDate());
		priceinfobject.put("ACTIVE_TIME", vo.getActiveDate());

		cpPriceInfo.setCreateTime(DateUtil.getTimestamp(System
				.currentTimeMillis()));
		priceinfobject.put("CREATE_TIME",
				DateUtil.getTimestamp(System.currentTimeMillis()));

		cpPriceInfo.setInactiveTime(vo.getInvalidDate());
		priceinfobject.put("INACTIVE_TIME", vo.getInvalidDate());

		cpPriceInfo.setTenantId(vo.getTenantId());
		priceinfobject.put("TENANT_ID", vo.getTenantId());

		cpPriceInfo.setPriceCode(priceCode);
		priceinfobject.put("PRICE_CODE", priceCode);

		cpPriceInfo.setPriceName(vo.getProductName());
		priceinfobject.put("PRICE_NAME", vo.getProductName());
		try{
			cpPriceInfoMapper.insert(cpPriceInfo);
			//插入共享内存
			DshmUtil.getIdshmSV().initLoader("cp_price_info",
					priceinfobject.toString(), 0);
			long stepSeq = 0;
			String detailCode = aISysSequenceSvc.terrigerSysSequence(
					"DETAIL_CODE", 1).get(0);
			//CpPriceDetail(priceCode, vo, s, detailCode);
			for (ServiceVO s : vo.getMajorProductAmount()) {
				//序列生成DETAIL_CODE
				
				if (vo.getBillingType().equals("STEP")) {
					//阶梯类型
					stepSeq++;
					CpStepInfo(detailCode, s, stepSeq, vo);
				} else {
					//标准类型
					CpPackageInfo(detailCode, s, vo);
	
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("---------------添加成功！！！！");
	}
//CpPriceDetail
	private void CpPriceDetail(String priceCode, ProductVO vo, ServiceVO s,
			String detailCode) {
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

		cpPriceDetail.setServiceType(s.getServiceType());
		detailobject.put("SERVICE_TYPE", s.getServiceType());

		cpPriceDetailMapper.insert(cpPriceDetail);
		DshmUtil.getIdshmSV().initLoader("cp_price_detail",
				detailobject.toString(), 0);
	}
//CpStepInfo
	private void CpStepInfo(String detailCode, ServiceVO serviceVO,
			long stepSeq, ProductVO vo) {
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
		
		cpStepInfo.setFactorCode(Long.valueOf(serviceVO.getServiceTypeDetail()));
		stepobject.put("FACTOR_CODE", serviceVO.getServiceTypeDetail());
		
		cpStepInfoMapper.insert(cpStepInfo);
		DshmUtil.getIdshmSV().initLoader("cp_step_info", stepobject.toString(),0);
	}
//CpPackageInfo
	private void CpPackageInfo(String detailCode, ServiceVO serviceVO,
			ProductVO vo) {
		CpPackageInfo cpPackageInfo = new CpPackageInfo();
		JSONObject packageobject = new JSONObject();

		cpPackageInfo.setAmount(serviceVO.getAmountEnd());
		packageobject.put("AMOUNT",serviceVO.getAmountEnd());

		cpPackageInfo.setDetailCode(detailCode);
		packageobject.put("DETAIL_CODE", detailCode);

		cpPackageInfo.setUnitType(serviceVO.getUnit());
		packageobject.put("UNIT_TYPE", serviceVO.getUnit());

		cpPackageInfo.setPriceValue(serviceVO.getPrice().doubleValue());
		packageobject.put("PRICE_VALUE", serviceVO.getPrice());

		cpPackageInfo.setTotalPriceValue(vo.getTotalPrice().doubleValue());
		packageobject.put("TOTAL_PRICE_VALUE", vo.getTotalPrice());
		
		cpPackageInfo.setFactorCode(serviceVO.getServiceTypeDetail());
		packageobject.put("FACTOR_CODE", serviceVO.getServiceTypeDetail());

		cpPackageInfoMapper.insert(cpPackageInfo);
		DshmUtil.getIdshmSV().initLoader("cp_package_info",packageobject.toString(), 0);
	}

}
