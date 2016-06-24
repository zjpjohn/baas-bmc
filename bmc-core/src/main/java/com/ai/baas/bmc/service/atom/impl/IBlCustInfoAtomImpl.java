package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.custInfo.params.QueryCustInfoRequest;
import com.ai.baas.bmc.api.initbasedata.params.InitBaseParam;
import com.ai.baas.bmc.constants.BmcConstants;
import com.ai.baas.bmc.dao.interfaces.BlCustinfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfoCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBlCustInfoAtomSV;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.opt.sdk.util.DateUtil;
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
		criteria.andStateEqualTo(BmcConstants.CUST.NORMAL);
		if(!StringUtil.isBlank(param.getCustGrade())){
			criteria.andCustGradeEqualTo(param.getCustGrade());
		}
		if(!StringUtil.isBlank(param.getCustName())){
			criteria.andCustNameLike("%"+param.getCustName()+"%");
		}
		if(!StringUtil.isBlank(param.getIdNumber())){
			criteria.andIdNumberEqualTo(param.getIdNumber());
		}
		/*if(param.getPageNo()!=null&&param.getPageSize()!=null){
			sql.setLimitStart((param.getPageNo()-1)*param.getPageSize());
			sql.setLimitEnd(param.getPageSize());
		}*/
		
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
	@Override
	public int custInfoInsert(InitBaseParam param) {
		BlCustinfo custInfo=new BlCustinfo();
		custInfo.setCustId(param.getCustId());
		custInfo.setCustType("G");
		custInfo.setExtCustId(param.getExtCustId());
		custInfo.setState("NORMAL");
		custInfo.setStateChgTime(DateUtil.getSysDate());
		custInfo.setTenantId(param.getTenantId());
		if(blCustinfoMapper.insert(custInfo)!=0){
			//开始向缓存中刷新
			JSONObject json=new JSONObject();
			json.put("tenant_id", custInfo.getTenantId());
			json.put("cust_id", custInfo.getCustId());
			json.put("cust_name", custInfo.getCustName());
			json.put("ext_cust_id", custInfo.getExtCustId());
			json.put("cust_type", custInfo.getCustType());
			json.put("cust_grade", custInfo.getCustGrade());
			json.put("province_code", custInfo.getProvinceCode());
			json.put("city_code", custInfo.getCityCode());
			json.put("state", custInfo.getState());
			json.put("state_chg_time", custInfo.getStateChgTime().toString());
			json.put("remark", custInfo.getRemark());
			json.put("contact_no", custInfo.getContactNo());
			json.put("email", custInfo.getEmail());
			json.put("cust_address", custInfo.getCustAddress());
			json.put("id_number", custInfo.getIdNumber());
			return DshmUtil.getIdshmSV().initLoader("bl_custinfo", json.toString(),1);
		}
		return 0;
	}
	

}
