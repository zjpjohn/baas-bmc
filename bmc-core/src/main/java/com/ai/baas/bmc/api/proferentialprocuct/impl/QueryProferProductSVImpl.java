package com.ai.baas.bmc.api.proferentialprocuct.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IQueryProferProductSV;
import com.ai.baas.bmc.api.proferentialprocuct.params.FullPresent;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryParam;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductInfo;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProferProductResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedResponse;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.SingleProductInfo;
import com.ai.baas.bmc.business.interfaces.ICpFullPresentBusi;
import com.ai.baas.bmc.business.interfaces.ICpFullReduceBusi;
import com.ai.baas.bmc.business.interfaces.ICpPriceDetailBusi;
import com.ai.baas.bmc.business.interfaces.ICpPriceInfoBusi;
import com.ai.baas.bmc.constants.ExceptCodeConstant;
import com.ai.baas.bmc.dao.mapper.bo.CpFullPresent;
import com.ai.baas.bmc.dao.mapper.bo.CpFullReduce;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

@Service(validation = "true")
@Component
public class QueryProferProductSVImpl implements IQueryProferProductSV {

	@Autowired
	private ICpPriceInfoBusi iCpPriceInfoBusi;
	@Autowired
	private ICpPriceDetailBusi iCpPriceDetailBusi;
	@Autowired
	private ICpFullPresentBusi iCpFullPresentBusi;
	@Autowired
	private ICpFullReduceBusi iCpFullReduceBusi;

	@Override
	public ProferProductResponse getProductInfo(ProductQueryVO vo) throws BusinessException, SystemException {
		List<CpPriceInfo> priceInfoList = iCpPriceInfoBusi.getCpPriceInfo(vo);

		PageInfo<ProferProductInfo> page = new PageInfo<ProferProductInfo>();
		page.setCount(iCpPriceInfoBusi.getCpPriceInfoCount(vo)); // 得到总条数
		page.setPageNo(vo.getPageNo());
		page.setPageSize(vo.getPageSize());
		List<ProferProductInfo> list = new ArrayList<ProferProductInfo>();
		ProferProductInfo productInfo = null;
		for (CpPriceInfo info : priceInfoList) {
			productInfo = new ProferProductInfo();
			productInfo.setActiveDate(info.getActiveTime());
			productInfo.setInvalidDate(info.getInactiveTime());
			productInfo.setProductId(info.getPriceInfoId());
			productInfo.setProductName(info.getPriceName());
			// productInfo.setRule(info.get); 规则应该由后边表的数据拼写而成
			productInfo.setStatus(info.getActiveStatus());
			productInfo.setTenantId(info.getTenantId());
			productInfo.setTradeSeq(vo.getTradeSeq());
			CpPriceDetail detail = iCpPriceDetailBusi.getCpPriceDetail(info.getPriceCode());
			if(detail!=null){
				productInfo.setProferType(detail.getChargeType());
				String detailCode = detail.getDetailCode();
				String chargeType = detail.getChargeType();

				if (chargeType.equals("PRESENT")) { // 如果类型是满赠
					// 赠表可能有多个记录
					// CpFullPresent present=
					// iCpFullPresentBusi.getFullPresent(detailCode);
					List<CpFullPresent> presentList = iCpFullPresentBusi.getFullPresents(detailCode);
					if(!CollectionUtil.isEmpty(presentList)){
						StringBuffer sb = new StringBuffer();
						for (CpFullPresent present : presentList) {
							sb.append("满");
							sb.append(present.getReachAmount());
							sb.append("赠送");
							String presentType = present.getPresentType();
							if (presentType.equals("SERVICETYPE")) {
								sb.append("赠送业务");
							} else if ("CASH".equals(presentType)) {
								sb.append(present.getPresentAmount());
								sb.append("元");
							} else if ("VIRTURECOIN".equals(presentType)) {
								sb.append(present.getPresentAmount());
								sb.append("个虚拟货币");
							}
							sb.append(";");
						}
						String rule = sb.toString();
						if(rule.length()>1){
							productInfo.setRule(rule.substring(0, rule.length() - 1));
						}
					}
					
					
				} else if (chargeType.equals("REDUCE")) { // 如果是满减
					CpFullReduce cpFullReduce = iCpFullReduceBusi.getFullReduce(detailCode);
					if(cpFullReduce!=null){
						StringBuffer sb = new StringBuffer();
						sb.append("满");
						sb.append(cpFullReduce.getReachAmount());
						sb.append(cpFullReduce.getUnit());
						sb.append("减");
						sb.append(cpFullReduce.getReduceAmount());
						sb.append("元");
						productInfo.setRule(sb.toString());
					}
					
				} else {
					productInfo.setRule("");
				}
			}
			
			list.add(productInfo);
		}
		page.setResult(list);
		ProferProductResponse responses=new ProferProductResponse();
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
		responses.setPageInfo(page);
		responses.setResponseHeader(responseHeader);
		return responses;
	}

	@Override
	public SingleProductInfo getProductById(ProductQueryParam param) throws BusinessException, SystemException {
		// 查询资费信息表
		CpPriceInfo priceInfo = iCpPriceInfoBusi.getCpPriceInfo(param);
		SingleProductInfo singlePro = new SingleProductInfo();
		singlePro.setActiveDate(priceInfo.getActiveTime());

		singlePro.setComments(priceInfo.getComments());

		//

		singlePro.setInvalidDate(priceInfo.getInactiveTime());
		singlePro.setOperatorId(priceInfo.getOperatorId());
		singlePro.setProductId(priceInfo.getPriceInfoId());

		// singlePro.setProductType(productType);
		singlePro.setProgramName(priceInfo.getPriceName());
		singlePro.setTenantId(priceInfo.getTenantId());
		// 查询detail表
		CpPriceDetail detail = iCpPriceDetailBusi.getCpPriceDetail(priceInfo.getPriceCode());
		singlePro.setProductType(detail.getChargeType()); // 获取优惠类型

		// 根据类型查询相对应的横表
		if ("PRESENT".equals(detail.getChargeType())) { // 查询满赠表
			List<FullPresent> list = new ArrayList<FullPresent>();
			List<CpFullPresent> presentList = iCpFullPresentBusi.getFullPresents(detail.getDetailCode());
			for (CpFullPresent present : presentList) {
				FullPresent fp = new FullPresent();
				fp.setGiftActiveDate(present.getActiveTime());
				fp.setGiftInvalidDate(present.getInactiveTime());

				fp.setGiftProList(JSON.parseArray(present.getProductGiftIds(), Long.class));
				fp.setGiftType(present.getPresentType());
				fp.setGitfAmount(present.getPresentAmount());
				fp.setActiveCycle(present.getActiveCycle());
				fp.setActiveFlag(present.getActiveFlag());
				singlePro.setRuleAmount(present.getReachAmount());
				singlePro.setRuleUnit(present.getUnit());
				list.add(fp);

			}
			singlePro.setPresentList(list);

		} else if ("REDUCE".equals(detail.getChargeType())) {
			CpFullReduce reduce = iCpFullReduceBusi.getFullReduce(detail.getDetailCode());
			singlePro.setRuleAmount(reduce.getReachAmount());
			singlePro.setReduceAmount(reduce.getReduceAmount());
			singlePro.setRuleUnit(reduce.getUnit());
			singlePro.setProductList(JSON.parseArray(reduce.getProductIds(), Integer.class));

		}
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
		singlePro.setResponseHeader(responseHeader);
		return singlePro;
	}

	@Override
	public RelatedResponse getRelatedAccount(RelatedVO vo) {
		CpPriceInfo price = iCpPriceInfoBusi.getCpPriceInfo(vo);

		CpPriceDetail detail = iCpPriceDetailBusi.getCpPriceDetail(price.getPriceCode());
		String chargeType=detail.getChargeType();
		List<String> accList=null;
		List<Long> ids=new ArrayList<Long>();
		// 如果是满赠，则查询满赠
		if ("PRESENT".equals(chargeType)) {
			List<CpFullPresent> pList = iCpFullPresentBusi.getFullPresents(detail.getDetailCode());
			for(CpFullPresent p:pList){
				ids.add(p.getPresentId());
			}
			if (!CollectionUtil.isEmpty(pList)) {
				accList = JSON.parseArray(pList.get(0).getRelatedAccount(), String.class);
			}

		}

		// 如果是满减，则查询满减
		if ("REDUCE".equals(chargeType)) {
			CpFullReduce reduce = iCpFullReduceBusi.getFullReduce(detail.getDetailCode());
			if(null!=reduce){
				accList=JSON.parseArray(reduce.getRelatedAccount(),String.class);	
			}
			ids.add(reduce.getReduceId());
		}
		RelatedResponse response=new  RelatedResponse();
		ResponseHeader responseHeader = new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
		response.setAccounts(accList);
		response.setResponseHeader(responseHeader);
		response.setProductId(vo.getProductId());
		response.setTradeSeq(vo.getTradeSeq());
		response.setTenantId(vo.getTenantId());
		response.setChargeType(chargeType);
		response.setIds(ids);
		return response;
	}

}
