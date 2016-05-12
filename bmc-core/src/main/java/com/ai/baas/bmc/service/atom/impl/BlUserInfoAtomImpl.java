package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.custInfo.params.UserInfoRequest;
import com.ai.baas.bmc.dao.interfaces.BlUserinfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBlUserInfoAtomSV;
@Component
public class BlUserInfoAtomImpl implements IBlUserInfoAtomSV {
	
	@Autowired
	private BlUserinfoMapper blUserinfoMapper;
	@Override
	public int getUserInfoCount(UserInfoRequest param) {
		BlUserinfoCriteria sql=new BlUserinfoCriteria();
		BlUserinfoCriteria.Criteria creteria=sql.createCriteria();
		creteria.andTenantIdEqualTo(param.getTenantId());
		creteria.andCustIdEqualTo(param.getCustId());
		if(!StringUtils.isEmpty(param.getServiceId())){
			creteria.andServiceIdEqualTo(param.getServiceId());
		}
		
		return blUserinfoMapper.countByExample(sql);
	}
	@Override
	public List<BlUserinfo> getUserInfo(UserInfoRequest param) {
		BlUserinfoCriteria sql=new BlUserinfoCriteria();
		BlUserinfoCriteria.Criteria creteria=sql.createCriteria();
		creteria.andTenantIdEqualTo(param.getTenantId());
		creteria.andCustIdEqualTo(param.getCustId());
		if(!StringUtils.isEmpty(param.getServiceId())){
			creteria.andServiceIdEqualTo(param.getServiceId());
		}
		if(param.getPageSize()!=null&&param.getPageNo()!=null){
			sql.setLimitStart((param.getPageNo()-1)*param.getPageSize());
			sql.setLimitEnd(param.getPageSize());
		}
		return blUserinfoMapper.selectByExample(sql);
	}

}
