package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryFieldrule;


public interface IBmcDrqueryFieldruleAtomSV {

	List<BmcDrqueryFieldrule> queryBmcDrqueryFieldrules(BmcDrqueryFieldrule req);
	
}
