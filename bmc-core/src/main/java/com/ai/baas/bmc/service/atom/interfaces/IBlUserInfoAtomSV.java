package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.custInfo.params.UserInfoRequest;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;

public interface IBlUserInfoAtomSV {

	int getUserInfoCount(UserInfoRequest param);
	List<BlUserinfo> getUserInfo(UserInfoRequest param);
	
}
