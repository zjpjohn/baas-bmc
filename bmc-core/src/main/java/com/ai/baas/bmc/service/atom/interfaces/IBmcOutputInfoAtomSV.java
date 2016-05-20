package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.BmcOutputInfo;

public interface IBmcOutputInfoAtomSV {

	List<BmcOutputInfo> getOutputInfo(String tenantId,String tablePrefix);
}
