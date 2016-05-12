package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.custInfo.params.QueryCustInfoRequest;
import com.ai.baas.bmc.dao.interfaces.BlCustinfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBlCustInfoAtomSV;
import com.ai.opt.sdk.util.StringUtil;
/**
 * 客户信息查询原子服务
 *
 * Date: 2016年5月12日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
@Component
public class IBlCustInfoAtomImpl implements IBlCustInfoAtomSV {

	@Autowired
	private BlCustinfoMapper blCustinfoMapper;
	@Override
	public List<BlCustinfo> getCustInfos(QueryCustInfoRequest param) {
		BlCustinfoCriteria sql =new BlCustinfoCriteria();
		BlCustinfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andTenantIdEqualTo(param.getTenantId());
		if(!StringUtil.isBlank(param.getCustGrade())){
			criteria.andCustGradeEqualTo(param.getCustGrade());
		}
		if(!StringUtil.isBlank(param.getCustName())){
			criteria.andCustNameLike("%"+param.getCustName()+"%");
		}
		if(!StringUtil.isBlank(param.getIdNumber())){
			criteria.andIdNumberEqualTo(param.getIdNumber());
		}
		if(param.getPageNo()!=null&&param.getPageSize()!=null){
			sql.setLimitStart((param.getPageNo()-1)*param.getPageSize());
			sql.setLimitEnd(param.getPageSize());
		}
		
		return blCustinfoMapper.selectByExample(sql);
	}
	@Override
	public int getCustInfoCount(QueryCustInfoRequest param) {
		BlCustinfoCriteria sql =new BlCustinfoCriteria();
		BlCustinfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andTenantIdEqualTo(param.getTenantId());
		if(!StringUtil.isBlank(param.getCustGrade())){
			criteria.andCustGradeEqualTo(param.getCustGrade());
		}
		if(!StringUtil.isBlank(param.getCustName())){
			criteria.andCustNameLike("%"+param.getCustName()+"%");
		}
		if(!StringUtil.isBlank(param.getIdNumber())){
			criteria.andIdNumberEqualTo(param.getIdNumber());
		}
		
		return blCustinfoMapper.countByExample(sql);
	}
	

}
