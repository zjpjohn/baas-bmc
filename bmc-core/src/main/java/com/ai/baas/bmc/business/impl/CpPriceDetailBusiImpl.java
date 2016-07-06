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
	/**
	 * 通过priceCode修改信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Override
	public void updatePriceDetailByPriceCode(CpPriceDetail info) {
		CpPriceDetailCriteria sql=new CpPriceDetailCriteria();	
		CpPriceDetailCriteria.Criteria criteria =sql.createCriteria();
		criteria.andPriceCodeEqualTo(info.getPriceCode());
		//
		this.cpPriceDetailMapper.updateByExampleSelective(info, sql);
	}
	/**
	 * 通过priceCode删除信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Override
	public void deletePriceDetailByPriceCode(CpPriceDetail info) {
		CpPriceDetailCriteria sql=new CpPriceDetailCriteria();	
		CpPriceDetailCriteria.Criteria criteria =sql.createCriteria();
		criteria.andPriceCodeEqualTo(info.getPriceCode());
		//
		this.cpPriceDetailMapper.deleteByExample(sql);
	}
	/**
	 * 根据priceCode查询信息
	 * @param info
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Override
	public CpPriceDetail getCpPriceDetailByPriceCode(CpPriceDetail info) {
		CpPriceDetailCriteria sql=new CpPriceDetailCriteria();	
		CpPriceDetailCriteria.Criteria criteria =sql.createCriteria();
		criteria.andPriceCodeEqualTo(info.getPriceCode());
		//
		List<CpPriceDetail> cpPriceDetailList = this.cpPriceDetailMapper.selectByExample(sql);
		CpPriceDetail cpPriceDetail = new CpPriceDetail();
		if(null != cpPriceDetailList){
			cpPriceDetail = cpPriceDetailList.get(0);
		}
		return cpPriceDetail;
	}
	

}
