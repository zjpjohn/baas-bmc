package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.dao.interfaces.BmcDrqueryFieldruleMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryFieldrule;
import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryFieldruleCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBmcDrqueryFieldruleAtomSV;
import com.ai.paas.ipaas.util.StringUtil;

@Component
public class BmcDrqueryFieldruleAtomSVImpl implements
		IBmcDrqueryFieldruleAtomSV {
	@Autowired
	private BmcDrqueryFieldruleMapper bmcDrqueryFieldruleMapper;
	@Override
	public List<BmcDrqueryFieldrule> queryBmcDrqueryFieldrules(
			BmcDrqueryFieldrule req) {
		BmcDrqueryFieldruleCriteria criteria = new BmcDrqueryFieldruleCriteria();
		if (req!=null) {
			BmcDrqueryFieldruleCriteria.Criteria sql = criteria.createCriteria();
			if (!StringUtil.isBlank(req.getTableid())) {
				sql.andTableidEqualTo(req.getTableid());
			}
			if (!StringUtil.isBlank(req.getFieldDesc())) {
				sql.andFieldDescEqualTo(req.getFieldDesc());
			}
			if (!StringUtil.isBlank(req.getFieldName())) {
				sql.andFieldNameEqualTo(req.getFieldName());
			}
		}
		return bmcDrqueryFieldruleMapper.selectByExample(criteria);
	}

}
