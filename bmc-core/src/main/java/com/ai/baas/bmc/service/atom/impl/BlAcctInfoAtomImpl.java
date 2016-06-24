package com.ai.baas.bmc.service.atom.impl;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.baas.bmc.api.initbasedata.params.InitBaseParam;
import com.ai.baas.bmc.dao.interfaces.BlAcctInfoMapper;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.service.atom.interfaces.IBlAcctInfoAtom;
import com.ai.baas.bmc.util.DshmUtil;
import com.ai.opt.sdk.util.DateUtil;
@Component
public class BlAcctInfoAtomImpl implements IBlAcctInfoAtom{
	@Autowired
	private BlAcctInfoMapper acctInfoMapper;
	@Override
	public int acctInfoInsert(InitBaseParam param) {
		BlAcctInfo acctInfo=new BlAcctInfo();
		acctInfo.setAcctId(param.getAcctId());
		acctInfo.setAcctType("POST");
		acctInfo.setCreateTime(DateUtil.getSysDate());
		acctInfo.setOwnerId(param.getCustId());
		acctInfo.setOwnerType("CUST");
		acctInfo.setTenantId(param.getTenantId());
		if(acctInfoMapper.insert(acctInfo)!=0){
			//开始刷新dshm
			JSONObject json=new JSONObject();
			json.put("tenant_id", acctInfo.getTenantId());
			json.put("acct_id", acctInfo.getAcctId());
			json.put("owner_type", acctInfo.getOwnerType());
			json.put("owner_id", acctInfo.getOwnerId());
			json.put("acct_name", acctInfo.getAcctName());
			json.put("acct_id", acctInfo.getAcctId());
			json.put("create_time", acctInfo.getCreateTime().toString());
			return DshmUtil.getIdshmSV().initLoader("bl_acct_info", json.toString(),1);
		}
		return 0;
	}

}
