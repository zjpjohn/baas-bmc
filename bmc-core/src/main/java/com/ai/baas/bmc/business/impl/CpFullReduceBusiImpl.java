package com.ai.baas.bmc.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.business.interfaces.ICpFullReduceBusi;
import com.ai.baas.bmc.dao.interfaces.CpFullReduceMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpFullReduce;
import com.ai.baas.bmc.dao.mapper.bo.CpFullReduceCriteria;
import com.ai.opt.sdk.util.CollectionUtil;

@Service
@Transactional
public class CpFullReduceBusiImpl implements ICpFullReduceBusi {
	@Autowired
	private CpFullReduceMapper cpFullReduceMapper;

	@Override
	public Integer add(CpFullReduce present) {
		// 需要添加到缓存中一份
		return cpFullReduceMapper.insert(present);
	}

	@Override
	public CpFullReduce getFullReduce(String detailCode) {
		CpFullReduceCriteria sql = new CpFullReduceCriteria();
		CpFullReduceCriteria.Criteria criteria = sql.createCriteria();
		criteria.andDetailCodeEqualTo(detailCode);
		List<CpFullReduce> list = cpFullReduceMapper.selectByExample(sql);
		if (!CollectionUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer updateFullReduce(CpFullReduce present) {
		CpFullReduceCriteria sql = new CpFullReduceCriteria();
		CpFullReduceCriteria.Criteria criteria = sql.createCriteria();
		criteria.andReduceIdEqualTo(present.getReduceId());
		return cpFullReduceMapper.updateByExampleSelective(present, sql);

	}

	@Override
	public CpFullReduce getFullReduce(Long id) {
		CpFullReduceCriteria sql = new CpFullReduceCriteria();
		CpFullReduceCriteria.Criteria criteria = sql.createCriteria();
		criteria.andReduceIdEqualTo(id);
		List<CpFullReduce> list=cpFullReduceMapper.selectByExample(sql);
		if(!CollectionUtil.isEmpty(list)){
			return list.get(0);
		}
		
		
		return null;
	}

}
