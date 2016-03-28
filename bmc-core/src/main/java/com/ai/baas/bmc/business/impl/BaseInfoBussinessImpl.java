package com.ai.baas.bmc.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.baseInfo.params.BaseCode;
import com.ai.baas.bmc.api.baseInfo.params.BaseCodeInfo;
import com.ai.baas.bmc.api.baseInfo.params.QueryInfoParams;
import com.ai.baas.bmc.business.interfaces.IBaseInfoBussiness;
import com.ai.baas.bmc.dao.interfaces.BmcBasedataCodeMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcBasedataCode;
import com.ai.baas.bmc.dao.mapper.bo.BmcBasedataCodeCriteria;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
@Service
@Transactional
public class BaseInfoBussinessImpl implements IBaseInfoBussiness{
	 @Autowired
	 private BmcBasedataCodeMapper bmcBasedataCodeMapper;
	@Override
	public BaseCodeInfo getBaseInfo(QueryInfoParams param) {
		
		BmcBasedataCodeCriteria sql=new BmcBasedataCodeCriteria();
		BmcBasedataCodeCriteria.Criteria Criteria=sql.or();
		Criteria.andTenantIdEqualTo(param.getTenantId()).andParamTypeEqualTo(param.getParamType());
		List<BmcBasedataCode> list=bmcBasedataCodeMapper.selectByExample(sql);
		List<BaseCode> baseCodeList=new ArrayList<BaseCode>();
		if(!CollectionUtil.isEmpty(list)){
			for(BmcBasedataCode bmcBaseCode :list){
				BaseCode baseCode=new BaseCode();
				BeanUtils.copyProperties(baseCode,bmcBaseCode);
				baseCodeList.add(baseCode);
			}
		
		}
		BaseCodeInfo baseCodeInfo=new BaseCodeInfo();
		baseCodeInfo.setTradeSeq(param.getTradeSeq());
		baseCodeInfo.setTenantId(param.getTenantId());
		baseCodeInfo.setParamType(param.getParamType());
		baseCodeInfo.setParamList(baseCodeList);
		return baseCodeInfo;
	}

}
