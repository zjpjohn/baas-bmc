package com.ai.baas.bmc.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryParam;
import com.ai.baas.bmc.api.proferentialprocuct.params.ProductQueryVO;
import com.ai.baas.bmc.api.proferentialprocuct.params.RelatedVO;
import com.ai.baas.bmc.business.interfaces.ICpPriceInfoBusi;
import com.ai.baas.bmc.dao.interfaces.CpPriceInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfoCriteria;
@Service
@Transactional
public class CpPriceInfoBusiImpl implements ICpPriceInfoBusi {
	@Autowired
	private CpPriceInfoMapper cpPriceInfoMapper;

	@Override
	public Integer addCpPriceInfo(CpPriceInfo info) {
		//TODO 向缓存中添加一份
		Integer cpPriceInfoId=cpPriceInfoMapper.insert(info);
		
		return cpPriceInfoId;
	}
	
	

	@Override
	public void delCpRpriceInfo(CpPriceInfo info) {
		//TODO 还需要在缓存中进行删除
		CpPriceInfoCriteria example=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria = example.or();
		criteria.andTenantIdEqualTo(info.getTenantId()).andPriceInfoIdEqualTo(info.getPriceInfoId());
		cpPriceInfoMapper.updateByExample(info, example);

	}



	/**
	 * 获取资费信息表
	 */
	@Override
	public List<CpPriceInfo> getCpPriceInfo(ProductQueryVO vo) {
		//TODO 需要改成想缓存中获取
		
		
		CpPriceInfoCriteria example=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria = example.or();
		criteria.andTenantIdEqualTo(vo.getTenantId());
		criteria.andActiveStatusNotEqualTo("DEL");
		if(vo.getActiveDate()!=null){
			criteria.andActiveTimeEqualTo(vo.getActiveDate());
		}
		if(vo.getInvalidDate()!=null){
			criteria.andInactiveTimeEqualTo(vo.getInvalidDate());
		}
		if(vo.getProductName()!=null){
			criteria.andPriceNameEqualTo(vo.getProductName());
		}
		if(vo.getProferType()!=null){
			criteria.andProductTypeEqualTo(vo.getProferType());
		}
		if(vo.getPageNo()!=null&&vo.getPageSize()!=null){
			example.setLimitStart((vo.getPageNo()-1)*vo.getPageSize());
			example.setLimitEnd(vo.getPageSize());
		}
		
		
		return cpPriceInfoMapper.selectByExample(example);
	}



	@Override
	public CpPriceInfo getCpPriceInfo(ProductQueryParam param) {
		CpPriceInfoCriteria sql=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andTenantIdEqualTo(param.getTenantId());
		criteria.andPriceInfoIdEqualTo(param.getProductId());
		return cpPriceInfoMapper.selectByExample(sql).get(0);
	}



	@Override
	public CpPriceInfo getCpPriceInfo(RelatedVO vo) {
		CpPriceInfoCriteria sql=new CpPriceInfoCriteria();
		CpPriceInfoCriteria.Criteria criteria=sql.createCriteria();
		criteria.andTenantIdEqualTo(vo.getTenantId());
		criteria.andPriceInfoIdEqualTo(vo.getProductId());
		
		return cpPriceInfoMapper.selectByExample(sql).get(0);
	}
}

