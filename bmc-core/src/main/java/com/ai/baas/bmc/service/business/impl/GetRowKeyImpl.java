package com.ai.baas.bmc.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.baas.bmc.api.rebilling.params.ReBillingParam;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputDetail;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputInfo;
import com.ai.baas.bmc.service.atom.interfaces.IBmcOutputDetailAtomSV;
import com.ai.baas.bmc.service.atom.interfaces.IBmcOutputInfoAtomSV;
import com.ai.baas.bmc.service.business.interfaces.IGetRowKey;
import com.ai.baas.bmc.util.LoggerUtil;

@Service
@Transactional
public class GetRowKeyImpl implements IGetRowKey{
	@Autowired
	private IBmcOutputDetailAtomSV bmcOutDetail;
	@Autowired
	private IBmcOutputInfoAtomSV bmcOutInfo;
	List<BmcOutputDetail> outputDetails=new ArrayList<BmcOutputDetail>();
	@Override
	public String getRowKey(ReBillingParam param) {
		List<BmcOutputInfo> infoCodes=bmcOutInfo.getInfoCode(param);
		if(infoCodes.size()>2){
			LoggerUtil.log.error("bmc_output_info tenant_id "+param.getTenantId()+" the service_type"+param.getBusiType()+" is more than one ....");
		}
		for(BmcOutputInfo infoCode:infoCodes){
			outputDetails=bmcOutDetail.getRowKeys(infoCode);
			break;
		}
		StringBuilder snName=new StringBuilder();
		if(outputDetails.isEmpty()){
			LoggerUtil.log.error("bmc_output_detail doesn't hava the detail_code.......");
			return null;
		}else{
			for(BmcOutputDetail outputDetail:outputDetails){
				if("".equals(snName.toString())||snName.toString()==null){
					snName.append(outputDetail.getColumnName());
				}else{
					snName.append(":").append(outputDetail.getColumnName());
				}
			}
			return snName.toString();
		}
	}

}
