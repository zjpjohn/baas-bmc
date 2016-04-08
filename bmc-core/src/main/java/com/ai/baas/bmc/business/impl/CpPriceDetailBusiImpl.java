package com.ai.baas.bmc.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.business.interfaces.ICpPriceDetailBusi;
import com.ai.baas.bmc.dao.interfaces.CpPriceDetailMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetailCriteria;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.opt.sdk.util.CollectionUtil;
import com.alibaba.fastjson.JSON;
@Service
@Transactional
public class CpPriceDetailBusiImpl implements ICpPriceDetailBusi {

	@Autowired
	private CpPriceDetailMapper cpPriceDetailMapper;
	@Override
	public Long addCpPriceDetail(CpPriceDetail info) {
		//TODO 还需要刷到缓存当中去
		int id=cpPriceDetailMapper.insert(info);
		if(id>0){
			DshmUtil.getIdshmSV().initLoader("cp_price_detail",JSON.toJSONString(info),1);	
		}
		return info.getDetailId();
	}
	@Override
	public List<CpPriceDetail> getCpPriceDetail(CpPriceDetail detail) {
		// TODO Auto-generated method stub 看一下方法是什么样的
		
		
		return null;
	}
	@Override
	public CpPriceDetail getCpPriceDetail(String priceCode) {
		CpPriceDetailCriteria sql=new CpPriceDetailCriteria();	
		CpPriceDetailCriteria.Criteria criteria =sql.createCriteria();
		criteria.andPriceCodeEqualTo(priceCode);
		List<CpPriceDetail> list=cpPriceDetailMapper.selectByExample(sql);
		if(!CollectionUtil.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void updatePriceDetail(CpPriceDetail info) {
		
		CpPriceDetailCriteria sql=new CpPriceDetailCriteria();	
		CpPriceDetailCriteria.Criteria criteria =sql.createCriteria();
		criteria.andDetailIdEqualTo(info.getDetailId());
		cpPriceDetailMapper.updateByExampleSelective(info, sql);
	}
	

}
