package com.ai.baas.bmc.api.proferentialprocuct.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IProferProductManageSV;
import com.ai.baas.bmc.api.proferentialprocuct.params.ActiveProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.FullPresent;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedAccountVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.productDelVO;
import com.ai.baas.bmc.business.interfaces.ICpFullPresentBusi;
import com.ai.baas.bmc.business.interfaces.ICpFullReduceBusi;
import com.ai.baas.bmc.business.interfaces.ICpPriceDetailBusi;
import com.ai.baas.bmc.business.interfaces.ICpPriceInfoBusi;
import com.ai.baas.bmc.constants.BmcConstants.ResultCode;
import com.ai.baas.bmc.constants.ExceptCodeConstant;
import com.ai.baas.bmc.dao.mapper.bo.CpFullPresent;
import com.ai.baas.bmc.dao.mapper.bo.CpFullReduce;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.util.BmcSeqUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

@Service(validation = "true")
@Component
public class ProferProductManageSV implements IProferProductManageSV {

	@Autowired
	private ICpPriceInfoBusi cpPriceInfoBusi;
	@Autowired
	private ICpPriceDetailBusi cpPriceDetailBusi;
	@Autowired
	private ICpFullPresentBusi cpFullPresentBusi;
	@Autowired
	private ICpFullReduceBusi cpFullReduceBusi;

	/**
	 * 满赠添加
	 */
	@Override
	public ProductResponse addProferProduct(ProferProductVO vo) throws BusinessException, SystemException {
		/**
		 * 插入资费信息表 cp_price_info
		 */
		String priceCode = BmcSeqUtil.getPriceCode();
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceInfoId(BmcSeqUtil.getPriceInfoId());
		cpPriceInfo.setPriceCode(priceCode);
		cpPriceInfo.setCreateTime(DateUtil.getSysDate());
		cpPriceInfo.setActiveTime(vo.getActiveDate());
		cpPriceInfo.setComments(vo.getComments());
		cpPriceInfo.setOperatorId(vo.getOperatorId());
		cpPriceInfo.setInactiveTime(vo.getInvalidDate());
		cpPriceInfo.setPriceName(vo.getProgramName());
		// cpPriceInfo.setProductType(vo.getProductType()); 暂时不启用
		cpPriceInfo.setChargeType(vo.getProductType());
		cpPriceInfo.setTenantId(vo.getTenantId());
		cpPriceInfo.setActiveStatus("INOPERATIVE"); // inoperative 待生效
		// TODO 有返回值，后期注意处理
		cpPriceInfoBusi.addCpPriceInfo(cpPriceInfo);

		/**
		 * 插入资费计划明细表 cp_price_detail
		 */
		CpPriceDetail detail = new CpPriceDetail();
		detail.setPriceCode(priceCode);
		// detail.setActiveTime(vo.getActiveDate());
		String billType = vo.getProductType();
		detail.setChargeType(billType);
		detail.setComments(vo.getComments());
		String detailCode = BmcSeqUtil.getDetailCode();
		detail.setDetailCode(detailCode);
		detail.setDetailId(BmcSeqUtil.getDetailId());
		// 冗余字段，暂时不填
		// detail.setDetailName(vo.getProgramName());
		// detail.setInactiveTime(vo.getInvalidDate());
		detail.setPriceCode(priceCode);
		// 冗余字段，暂时不填
		// detail.setServiceType(vo.getProductType());

		detail.setActiveTime(DateUtil.getTimestamp("2015-1-1"));
		detail.setInactiveTime(DateUtil.getTimestamp("2030-1-1"));
		detail.setServiceType(vo.getProductType());

		cpPriceDetailBusi.addCpPriceDetail(detail);

		/**
		 * 插入满赠的详细表
		 */

		for (FullPresent p : vo.getPresentList()) {
			CpFullPresent present = new CpFullPresent();
			present.setPresentType(p.getGiftType());
			present.setActiveTime(p.getGiftActiveDate());
			present.setDetailCode(detailCode);
			present.setInactiveTime(p.getGiftInvalidDate());
			String presentCode = BmcSeqUtil.getPresentCode();
			present.setPresentCode(presentCode);
			present.setPresentId(BmcSeqUtil.getPresentId());
			present.setProductGiftIds(JSON.toJSONString(p.getGiftProList()));
			present.setProductIds(JSON.toJSONString(vo.getProductList()));
			present.setReachAmount(vo.getRuleAmount());
			present.setPresentAmount(p.getGitfAmount());
			present.setUnit(vo.getRuleUnit());
			present.setActiveCycle(p.getActiveCycle());
			present.setActiveFlag(p.getActiveFlag());
			cpFullPresentBusi.addFullPresent(present);
		}
		ProductResponse response = new ProductResponse();
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
		response.setResponseHeader(responseHeader);

		return response;
	}

	@Override
	public ProductResponse addDiscontProduct(ProferProductVO vo) throws BusinessException, SystemException {
		/**
		 * 插入资费信息表 cp_price_info
		 */
		String priceCode = BmcSeqUtil.getPriceCode();
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceInfoId(BmcSeqUtil.getPriceInfoId());
		cpPriceInfo.setPriceCode(priceCode);
		cpPriceInfo.setCreateTime(DateUtil.getSysDate());
		cpPriceInfo.setActiveTime(vo.getActiveDate());
		cpPriceInfo.setComments(vo.getComments());
		cpPriceInfo.setOperatorId(vo.getOperatorId());
		cpPriceInfo.setInactiveTime(vo.getInvalidDate());
		cpPriceInfo.setPriceName(vo.getProgramName());
		//cpPriceInfo.setProductType(vo.getProductType());
		cpPriceInfo.setChargeType(vo.getProductType());
		cpPriceInfo.setTenantId(vo.getTenantId());
		cpPriceInfo.setActiveStatus("INOPERATIVE"); // inoperative 待生效
		// TODO 有返回值，后期注意处理
		cpPriceInfoBusi.addCpPriceInfo(cpPriceInfo);

		/**
		 * 插入资费计划明细表 cp_price_detail
		 */
		CpPriceDetail detail = new CpPriceDetail();
		detail.setPriceCode(priceCode);
		// detail.setActiveTime(vo.getActiveDate());
		String billType = vo.getProductType();
		detail.setChargeType(billType);
		detail.setComments(vo.getComments());
		String detailCode = BmcSeqUtil.getDetailCode();
		detail.setDetailCode(detailCode);
		detail.setDetailId(BmcSeqUtil.getDetailId());
		// 设置缺省值
		detail.setActiveTime(DateUtil.getTimestamp("2015-1-1"));
		detail.setInactiveTime(DateUtil.getTimestamp("2030-1-1"));
		detail.setServiceType(vo.getProductType());
		// 冗余字段，暂时不填
		// detail.setDetailName(vo.getProgramName());
		// detail.setInactiveTime(vo.getInvalidDate());
		detail.setPriceCode(priceCode);
		// 冗余字段，暂时不填
		// detail.setServiceType(vo.getProductType());
		cpPriceDetailBusi.addCpPriceDetail(detail);

		/**
		 * 插入满减的详细表
		 */
		CpFullReduce reduce = new CpFullReduce();

		reduce.setActiveTime(vo.getActiveDate());
		reduce.setDetailCode(detailCode);
		reduce.setInactiveTime(vo.getInvalidDate());
		reduce.setProductIds(JSON.toJSONString(vo.getProductList()));
		reduce.setReachAmount(vo.getRuleAmount());
		reduce.setReduceAmount(vo.getReduceAmount());
		reduce.setReduceCode(BmcSeqUtil.getReduceCode());
		reduce.setReduceId(BmcSeqUtil.getReduceId());
		reduce.setUnit(vo.getRuleUnit());
		cpFullReduceBusi.add(reduce);

		ProductResponse response = new ProductResponse();
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
		response.setResponseHeader(responseHeader);

		return response;
	}

	@Override
	public BaseResponse updateProferProductStatus(ActiveProductVO vo) throws BusinessException, SystemException {
		if (StringUtil.isBlank(vo.getTenantId())) {
			throw new BusinessException("88888888", "[租户Id]不能为空");
		}
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceInfoId(vo.getProductId());
		cpPriceInfo.setActiveStatus(vo.getStatus()); // 设置状态
		cpPriceInfo.setTenantId(vo.getTenantId());
		int count = cpPriceInfoBusi.delCpRpriceInfo(cpPriceInfo);
		// 整理返回对象
		ResponseHeader responseHeader = new ResponseHeader();
		if (count > 0) {
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ResultCode.SUCCESS_CODE);
			responseHeader.setResultMessage("数据更新成功");
		} else {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ResultCode.FAIL_CODE);
			responseHeader.setResultMessage("数据更新不成功");
		}
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;

	}

	@Override
	public BaseResponse delProferProduct(productDelVO vo) throws BusinessException, SystemException {
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceInfoId(vo.getProductId());
		cpPriceInfo.setTenantId(vo.getTenantId());
		cpPriceInfo.setActiveStatus("DEL"); // 设置状态为删除
		int count = cpPriceInfoBusi.delCpRpriceInfo(cpPriceInfo);
		ResponseHeader responseHeader = new ResponseHeader();
		if (count > 0) {
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ResultCode.SUCCESS_CODE);
			responseHeader.setResultMessage("数据更新成功");
		} else {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ResultCode.FAIL_CODE);
			responseHeader.setResultMessage("数据更新不成功");
		}
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;
	}

	@Override
	public BaseResponse updateProferProduct(ProferProductVO vo) throws BusinessException, SystemException {

		
		/**
		 * 更新资费信息表 cp_price_info
		 */
		// String priceCode = BmcSeqUtil.getPriceCode();
		CpPriceInfo cpPriceInfo = new CpPriceInfo();
		cpPriceInfo.setPriceInfoId(vo.getProductId()); // 获得PriceId
		cpPriceInfo.setTenantId(vo.getTenantId()); // 得到租户
		// cpPriceInfo.setPriceCode(priceCode);
		// cpPriceInfo.setCreateTime(DateUtil.getSysDate());
		cpPriceInfo.setActiveTime(vo.getActiveDate());
		cpPriceInfo.setComments(vo.getComments());
		cpPriceInfo.setOperatorId(vo.getOperatorId());
		cpPriceInfo.setInactiveTime(vo.getInvalidDate());
		cpPriceInfo.setPriceName(vo.getProgramName());
		cpPriceInfo.setPriceInfoId(vo.getProductId());
		// cpPriceInfo.setProductType(vo.getProductType()); 暂时不填写
		
		cpPriceInfoBusi.updatePriceInfo(cpPriceInfo);
		/**
		 * 更新资费计划明细表 cp_price_detail
		 */
		// CpPriceDetail detail = new CpPriceDetail();
		CpPriceDetail detail = cpPriceDetailBusi.getCpPriceDetail(vo.getPriceCode());

		detail.setDetailName(vo.getProgramName());

		cpPriceDetailBusi.updatePriceDetail(detail);
		String chargeType = detail.getChargeType();
		String detailCode = detail.getDetailCode();
		if ("PRESENT".equals(chargeType)) {// 满赠
			// 由于数量不好对应所以进行先删后增
			cpFullPresentBusi.deleteFullPresent(detailCode);
			List<FullPresent> fList = vo.getPresentList();
			for (FullPresent p : fList) {
				CpFullPresent cfp = new CpFullPresent();
				cfp.setPresentType(p.getGiftType());
				cfp.setActiveTime(p.getGiftActiveDate());
				cfp.setDetailCode(detailCode);
				cfp.setInactiveTime(p.getGiftInvalidDate());
				String presentCode = BmcSeqUtil.getPresentCode();
				cfp.setPresentCode(presentCode);
				cfp.setPresentId(BmcSeqUtil.getPresentId());
				cfp.setProductGiftIds(JSON.toJSONString(p.getGiftProList()));
				cfp.setReachAmount(vo.getRuleAmount());
				cfp.setProductIds(JSON.toJSONString(vo.getProductList()));
				cfp.setPresentAmount(p.getGitfAmount());
				cfp.setUnit(vo.getRuleUnit());
				cpFullPresentBusi.addFullPresent(cfp);
			}
		}
		if ("REDUCE".equals(chargeType)) {// 满减

			CpFullReduce reduce = new CpFullReduce();
			reduce.setActiveTime(vo.getActiveDate());
			// reduce.setDetailCode(detailCode);
			reduce.setInactiveTime(vo.getInvalidDate());
			reduce.setProductIds(JSON.toJSONString(vo.getProductList()));
			reduce.setReachAmount(vo.getRuleAmount());
			reduce.setReduceAmount(vo.getReduceAmount());
			reduce.setReduceCode(BmcSeqUtil.getReduceCode());
			reduce.setReduceId(BmcSeqUtil.getReduceId());
			reduce.setUnit(vo.getRuleUnit());
			reduce.setReduceId(vo.getReduceId());
			cpFullReduceBusi.updateFullReduce(reduce);
		}
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;
	}

	@Override
	public BaseResponse relatedAccout(RelatedAccountVO vo) throws BusinessException, SystemException {
		int  count=0;
		// 满赠
		if ("PRESENT".equals(vo.getChargeType())) {
			List<Long> pIds = vo.getFullIds();
			for (Long id : pIds) {
				CpFullPresent p = cpFullPresentBusi.getFullPresent(id);

				p.setAccountType(vo.getAccountType());
				p.setRelatedAccount(JSON.toJSONString(vo.getRelAccounts()));
				count=cpFullPresentBusi.updateFullPresent(p);
			}

		}
		// 满减
		if ("REDUCE".equals(vo.getChargeType())) {
			Long rId = vo.getFullIds().get(0);
			CpFullReduce r = cpFullReduceBusi.getFullReduce(rId);
			if (r != null) {
			

				CpFullReduce cfr = new CpFullReduce();
				cfr.setRelatedAccount(JSON.toJSONString(vo.getFullIds()));
				cfr.setAccountType(vo.getAccountType());
				cfr.setReduceId(r.getReduceId());
				count=cpFullReduceBusi.updateFullReduce(cfr);
			}

		}
		ResponseHeader responseHeader = new ResponseHeader();
		if (count > 0) {
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ResultCode.SUCCESS_CODE);
			responseHeader.setResultMessage("关联成功");
		} else {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ResultCode.FAIL_CODE);
			responseHeader.setResultMessage("关联失败");
		}
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;
	}

}
