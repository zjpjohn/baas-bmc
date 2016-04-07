package com.ai.baas.bmc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.business.interfaces.ICpFullReduceBusi;
import com.ai.baas.bmc.dao.interfaces.CpFullReduceMapper;
import com.ai.baas.bmc.dao.mapper.bo.CpFullReduce;
import com.ai.baas.bmc.dao.mapper.bo.CpFullReduceCriteria;
@Service
@Transactional
public class CpFullReduceBusiImpl implements ICpFullReduceBusi {
	@Autowired
	private CpFullReduceMapper cpFullReduceMapper;
	@Override
	public Integer add(CpFullReduce present) {
		//需要添加到缓存中一份
		return cpFullReduceMapper.insert(present);
	}
	@Override
	public CpFullReduce getFullReduce(String detailCode) {
		CpFullReduceCriteria sql=new CpFullReduceCriteria();
		CpFullReduceCriteria.Criteria  criteria=sql.createCriteria();
		criteria.andDetailCodeEqualTo(detailCode);
		return cpFullReduceMapper.selectByExample(sql).get(0);
	}
	@Override
	public void updateFullReduce(CpFullReduce present) {
		CpFullReduceCriteria sql=new CpFullReduceCriteria();
		CpFullReduceCriteria.Criteria  criteria=sql.createCriteria();
		criteria.andReduceIdEqualTo(present.getReduceId());
		cpFullReduceMapper.updateByExample(present, sql);
		
	}
	@Override
	public CpFullReduce getFullReduce(Long id) {
		CpFullReduceCriteria sql=new CpFullReduceCriteria();
		CpFullReduceCriteria.Criteria  criteria=sql.createCriteria();
		criteria.andReduceIdEqualTo(id);
		return cpFullReduceMapper.selectByExample(sql).get(0);
	}

}
