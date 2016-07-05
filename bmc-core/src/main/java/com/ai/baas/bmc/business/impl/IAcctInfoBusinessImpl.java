package com.ai.baas.bmc.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.acctInfo.params.AcctInfoParams;
import com.ai.baas.bmc.api.acctInfo.params.AcctQueryRequest;
import com.ai.baas.bmc.api.acctInfo.params.ResponseMessage;
import com.ai.baas.bmc.business.interfaces.IAcctInfoBusiness;
import com.ai.baas.bmc.dao.interfaces.BlAcctInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfoCriteria;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;

@Service
@Transactional
public class IAcctInfoBusinessImpl implements IAcctInfoBusiness{
	private static final Logger log = LogManager.getLogger(IAcctInfoBusinessImpl.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public ResponseMessage getAcctInfo(AcctQueryRequest acctQueryRequest){
		ResponseMessage responseMessage=new ResponseMessage();
        List<AcctInfoParams> acctInfoParamsList = new ArrayList<AcctInfoParams>( );		
		
		BlAcctInfoMapper blAcctInfoMapper=sqlSessionTemplate.getMapper(BlAcctInfoMapper.class);
		

			if(StringUtil.isBlank(acctQueryRequest.getTenantId())){
				responseMessage.setResponseHeader(new ResponseHeader(false, "000001", "租户ID为空，查询失败"));
				return responseMessage;
			}
			BlAcctInfoCriteria blAcctInfoCriteria=new BlAcctInfoCriteria();
			BlAcctInfoCriteria.Criteria criteria=blAcctInfoCriteria.createCriteria();
			criteria.andTenantIdEqualTo(acctQueryRequest.getTenantId());

			List<BlAcctInfo>  acctInfoList=blAcctInfoMapper.selectByExample(blAcctInfoCriteria);
			if(acctInfoList.size()==0){
				responseMessage.setResponseHeader(new ResponseHeader(false, "000001", "bl_acct_info表中未找到数据"));
				return responseMessage;
			}
			log.debug("获得"+acctInfoList.size()+"条账户信息");
			
			AcctInfoParams acctInfoParams=new AcctInfoParams();
			for(BlAcctInfo blAcctInfo:acctInfoList){
				acctInfoParams.setAcctID(blAcctInfo.getAcctId());
				acctInfoParams.setAcctName(blAcctInfo.getAcctName());
				acctInfoParams.setCustID(blAcctInfo.getOwnerId());
				acctInfoParams.setTenantId(blAcctInfo.getTenantId());
				acctInfoParams.setAcctType(blAcctInfo.getAcctType());
				acctInfoParams.setComments(blAcctInfo.getComments());
				acctInfoParams.setCreatTime(StringUtil.toString(blAcctInfo.getCreateTime()));
				acctInfoParams.setOwnerType(blAcctInfo.getOwnerType());
				acctInfoParamsList.add(acctInfoParams);
			}
		PageInfo<AcctInfoParams> resultPage=new PageInfo<AcctInfoParams>();
		
		List<AcctInfoParams> acctInfoParamsSubList = new ArrayList<AcctInfoParams>();
		int sum = acctInfoParamsList.size();
		
        //内存分页
        if(acctQueryRequest.getPageSize()!=null&&acctQueryRequest.getPageNo()!=null){

            int pageSize=acctQueryRequest.getPageSize();
            int pageNo=acctQueryRequest.getPageNo(); 
            int fromIndex = (pageNo-1)*pageSize;
            int toIndex = pageNo*pageSize;
            if(acctInfoParamsList.size()<toIndex){
            	acctInfoParamsSubList = acctInfoParamsList.subList(fromIndex,acctInfoParamsList.size());
            }else{
            	acctInfoParamsSubList = acctInfoParamsList.subList(fromIndex,toIndex);
            } 
        }else {
            //不分页
            acctInfoParamsSubList = acctInfoParamsList;
        }    
		
		//分页信息
		resultPage.setCount(sum);
		if(acctQueryRequest.getPageSize()!=null&&acctQueryRequest.getPageNo()!=null){
            resultPage.setPageSize(acctQueryRequest.getPageSize());
            resultPage.setPageNo(acctQueryRequest.getPageNo());
        }
        else{
        	//不分页
            resultPage.setPageSize(sum);
            resultPage.setPageNo(1);
        }
		
		resultPage.setResult(acctInfoParamsSubList);
		responseMessage.setTenantId(acctQueryRequest.getTenantId());
		responseMessage.setAcctInfoParamsList(resultPage);
		responseMessage.setReturnCode("BMC-000000");	
		return responseMessage;
	}
}
