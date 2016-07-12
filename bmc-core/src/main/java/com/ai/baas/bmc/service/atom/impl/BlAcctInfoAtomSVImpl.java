package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ai.baas.bmc.api.acctinfo.params.AcctQueryRequest;
import com.ai.baas.bmc.constants.BmcCacheConstant;
import com.ai.baas.bmc.dao.interfaces.BlAcctInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBlAcctInfoAtomSV;
import com.ai.baas.bmc.util.BusinessUtil;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.alibaba.fastjson.JSON;

@Service
public class BlAcctInfoAtomSVImpl implements IBlAcctInfoAtomSV {
	@Autowired
	private BlAcctInfoMapper blAcctInfoMapper;
    @Override
    public void addDshmData(BlAcctInfo blAcctInfo) {
        DshmUtil.getIdshmSV().initLoader(BmcCacheConstant.Dshm.TableName.BL_ACCT_INFO,
                JSON.toJSONString(BusinessUtil.assebleDshmData(blAcctInfo)),
                BmcCacheConstant.Dshm.OptType.INSERT);
    }
    @Override
    public List<BlAcctInfo> queryBlAcctinfo(AcctQueryRequest acctQueryRequest){
    	BlAcctInfoCriteria blAcctInfoCriteria=new BlAcctInfoCriteria();
		BlAcctInfoCriteria.Criteria criteria=blAcctInfoCriteria.createCriteria();
		criteria.andTenantIdEqualTo(acctQueryRequest.getTenantId());
		if(!StringUtil.isBlank(acctQueryRequest.getCustID())){
			criteria.andOwnerIdEqualTo(acctQueryRequest.getCustID());
		}
		List<BlAcctInfo>  acctInfoList=blAcctInfoMapper.selectByExample(blAcctInfoCriteria);
		 if (CollectionUtil.isEmpty(acctInfoList)) {
	            return null;
	        } else{
	        	return acctInfoList;
	        }
    	
    }
}
