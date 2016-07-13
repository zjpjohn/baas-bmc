package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryRouterule;

public interface IBmcDrqueryRouteruleAtomSV {

	List<BmcDrqueryRouterule> queryBmcDrqueryRouterules(BmcDrqueryRouterule req);
	
}
