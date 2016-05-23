package com.ai.baas.bmc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.custInfo.params.CustInfo;
import com.ai.baas.bmc.api.custInfo.params.CustInfoResponse;
import com.ai.baas.bmc.api.custInfo.params.QueryCustInfoRequest;
import com.ai.baas.bmc.api.custInfo.params.UserInfoRequest;
import com.ai.baas.bmc.constants.ExceptCodeConstant;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;
import com.ai.baas.bmc.service.atom.interfaces.IBlCustInfoAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IBlUserInfoAtomSV;
import com.ai.baas.bmc.service.business.interfaces.ICustInfoQueryBusiSV;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
@Service
@Transactional
public class CustInfoQueryBusiImpl implements ICustInfoQueryBusiSV {

	@Autowired
	private IBlCustInfoAtomSV iBlCustInfoAtomSV;
	@Autowired
	private IBlUserInfoAtomSV iBlUserInfoAtomSV;
	@Override
	public CustInfoResponse getCustInfos(QueryCustInfoRequest param) {
		String tenantId=param.getTenantId();
		String tradeSeq=param.getTradeSeq();
		List<BlCustinfo> custinfoList=iBlCustInfoAtomSV.getCustInfos(param);
		CustInfoResponse response=new CustInfoResponse();
		List<CustInfo> pageList=new ArrayList<CustInfo>();
		PageInfo<CustInfo> pageInfo =new PageInfo<CustInfo>();
		if(!CollectionUtil.isEmpty(custinfoList)){
			for(BlCustinfo ci:custinfoList){
				
				String custId =ci.getCustId();
				String custName=ci.getCustName();
				String custGrade=ci.getCustGrade();
				
				UserInfoRequest rq=new UserInfoRequest();
				rq.setTenantId(tenantId);
				rq.setCustId(custId);
				rq.setServiceId(param.getServiceId());
				rq.setPageSize(param.getPageSize());
				rq.setPageNo(param.getPageNo());
				int pageCount=iBlUserInfoAtomSV.getUserInfoCount(rq);
				//查询userInfo
				List<BlUserinfo> userInfoList=iBlUserInfoAtomSV.getUserInfo(rq);
				
				pageInfo.setCount(pageCount);
				//pageInfo.setPageCount(pageCount);
				
				
				for(BlUserinfo bu:userInfoList){
					CustInfo  custInfo=new CustInfo();
					custInfo.setServiceId(bu.getServiceId());
					custInfo.setCustGrade(custGrade);
					custInfo.setCustName(custName);
					custInfo.setTenantId(tenantId);
					custInfo.setTradeSeq(tradeSeq);
					custInfo.setCustId(bu.getCustId());
					custInfo.setSubsId(bu.getSubsId());
					pageList.add(custInfo);
				}
			
			}	
		}else{
			pageInfo.setCount(0);
		}
		
		pageInfo.setPageNo(param.getPageNo());
		pageInfo.setPageSize(param.getPageSize());
		pageInfo.setResult(pageList);
		response.setPageInfo(pageInfo);
		ResponseHeader rh=new ResponseHeader(true, ExceptCodeConstant.SUCCESS, "成功");
		response.setResponseHeader(rh);
		return response;
	}

}
