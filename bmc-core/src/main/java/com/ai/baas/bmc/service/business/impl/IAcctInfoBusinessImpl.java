package com.ai.baas.bmc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.acctinfo.params.AcctInfoParams;
import com.ai.baas.bmc.api.acctinfo.params.AcctQueryRequest;
import com.ai.baas.bmc.api.acctinfo.params.ResponseMessage;
import com.ai.baas.bmc.dao.interfaces.BlAcctInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBlAcctInfoAtomSV;
import com.ai.baas.bmc.service.business.interfaces.IAcctInfoBusiness;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.StringUtil;

@Service
@Transactional
public class IAcctInfoBusinessImpl implements IAcctInfoBusiness{
	private static final Logger log = LogManager.getLogger(IAcctInfoBusinessImpl.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	IBlAcctInfoAtomSV iBlAcctInfoAtomSV;
	@Override
	public ResponseMessage getAcctInfo(AcctQueryRequest acctQueryRequest){
		ResponseMessage responseMessage=new ResponseMessage();

		

			if(StringUtil.isBlank(acctQueryRequest.getTenantId())){
				responseMessage.setResponseHeader(new ResponseHeader(false, "000001", "租户ID为空，查询失败"));
				return responseMessage;
			}

			PageInfo<BlAcctInfo>  acctInfoList=iBlAcctInfoAtomSV.queryBlAcctinfoPageInfo(acctQueryRequest);
//			if(acctInfoList.size()==0){
//				responseMessage.setResponseHeader(new ResponseHeader(false, "000001", "bl_acct_info表中未找到数据"));
//				return responseMessage;
//			}
			if(acctInfoList!=null){
				PageInfo<AcctInfoParams> acctInfoParamsPageInfo = new PageInfo<AcctInfoParams>();
				List<AcctInfoParams> acctInfoParamsList= new ArrayList<AcctInfoParams>();
				for(BlAcctInfo blAcctInfo:acctInfoList.getResult()){
					AcctInfoParams acctInfoParams = new AcctInfoParams();
					acctInfoParams.setAcctID(blAcctInfo.getAcctId());
					acctInfoParams.setAcctName(blAcctInfo.getAcctName());
					acctInfoParams.setAcctType(blAcctInfo.getAcctName());
					acctInfoParams.setComments(blAcctInfo.getComments());
					acctInfoParams.setCreatTime(StringUtil.toString(blAcctInfo.getCreateTime()));
					acctInfoParams.setCustID(blAcctInfo.getOwnerId());
					acctInfoParams.setOwnerType(blAcctInfo.getOwnerType());
					acctInfoParams.setTenantId(blAcctInfo.getTenantId());
					
					acctInfoParamsList.add(acctInfoParams);
				}
				acctInfoParamsPageInfo.setResult(acctInfoParamsList);
				acctInfoParamsPageInfo.setCount(acctInfoList.getCount());
				acctInfoParamsPageInfo.setPageCount(acctInfoList.getPageCount());
				acctInfoParamsPageInfo.setPageNo(acctInfoList.getPageNo());
				acctInfoParamsPageInfo.setPageSize(acctInfoList.getPageSize());
				responseMessage.setAcctInfoParamsList(acctInfoParamsPageInfo);	
			}
			
			ResponseHeader header = new ResponseHeader();
			header.setIsSuccess(true);
			header.setResultCode("000000");
			responseMessage.setResponseHeader(header);
			
		return responseMessage;
	}
}
