package com.ai.baas.bmc.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.dao.interfaces.BmcDrqueryRouteruleMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryRouterule;
import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryRouteruleCriteria;
import com.ai.baas.bmc.service.atom.interfaces.IBmcDrqueryRouteruleAtomSV;
import com.ai.paas.ipaas.util.StringUtil;

@Component
public class BmcDrqueryRouteruleAtomSVImpl implements IBmcDrqueryRouteruleAtomSV {

	@Autowired
	private BmcDrqueryRouteruleMapper bmcDrqueryRouteruleMapper;
	@Override
	public List<BmcDrqueryRouterule> queryBmcDrqueryRouterules(
			BmcDrqueryRouterule req) {
		BmcDrqueryRouteruleCriteria criteria = new BmcDrqueryRouteruleCriteria();
		if (req!=null) {
			BmcDrqueryRouteruleCriteria.Criteria sql = criteria.createCriteria();
			if (!StringUtil.isBlank(req.getTenantid())) {
				sql.andTenantidEqualTo(req.getTenantid());
			}
			if (!StringUtil.isBlank(req.getSystemid())) {
				sql.andSystemidEqualTo(req.getSystemid());
			}
			if (!StringUtil.isBlank(req.getServicetype())) {
				sql.andServicetypeEqualTo(req.getServicetype());
			}
			if (!StringUtil.isBlank(req.getTableid())) {
				sql.andTableidEqualTo(req.getTableid());
			}
			if (!StringUtil.isBlank(req.getTablename())) {
				sql.andTablenameEqualTo(req.getTablename());
			}
		}
		return bmcDrqueryRouteruleMapper.selectByExample(criteria);
	}

}
