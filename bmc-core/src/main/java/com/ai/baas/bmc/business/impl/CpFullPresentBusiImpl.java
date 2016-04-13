package com.ai.baas.bmc.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.business.interfaces.ICpFullPresentBusi;
import com.ai.baas.bmc.dao.interfaces.CpFullPresentMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpFullPresent;
import com.ai.baas.bmc.dao.mapper.bo.CpFullPresentCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpFullPresentCriteria.Criteria;
import com.ai.opt.sdk.util.CollectionUtil;

@Service
@Transactional
public class CpFullPresentBusiImpl implements ICpFullPresentBusi {

	//TODO 需要统一检查如果需要使用缓存的需要使用缓存进行处理，统一排查
	@Autowired
	private CpFullPresentMapper cpFullPresentMapper;

	@Override
	public Integer addFullPresent(CpFullPresent present) {

		return cpFullPresentMapper.insert(present);
	}

	@Override
	public CpFullPresent getFullPresent(String detailCode) {
		CpFullPresentCriteria example = new CpFullPresentCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andDetailCodeEqualTo(detailCode);
		List<CpFullPresent> list=cpFullPresentMapper.selectByExample(example);
		if(!CollectionUtil.isEmpty(list)){
			return  list.get(0);
		}
		return  null;
	}

	@Override
	public List<CpFullPresent> getFullPresents(String detailCode) {
		CpFullPresentCriteria example = new CpFullPresentCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andDetailCodeEqualTo(detailCode);
		return cpFullPresentMapper.selectByExample(example);
	}

	@Override
	public CpFullPresent getFullPresent(Long presentId) {
		CpFullPresentCriteria example = new CpFullPresentCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andPresentIdEqualTo(presentId);
		return cpFullPresentMapper.selectByExample(example).get(0);
	}

	@Override
	public Integer updateFullPresent(CpFullPresent present) {
		CpFullPresentCriteria example = new CpFullPresentCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andPresentIdEqualTo(present.getPresentId());
		return cpFullPresentMapper.updateByExampleSelective(present, example);

	}

	@Override
	public Integer deleteFullPresent(String detailCode) {
		CpFullPresentCriteria example = new CpFullPresentCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andDetailCodeEqualTo(detailCode);
		return cpFullPresentMapper.deleteByExample(example);
	}

}
