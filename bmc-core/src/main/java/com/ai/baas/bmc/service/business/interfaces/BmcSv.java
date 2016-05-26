package com.ai.baas.bmc.service.business.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.drmanager.parameters.OperatorFlowQueryInputObject;
import com.ai.baas.bmc.dao.mapper.bo.BmcAccuDealer;
//import com.ai.runner.center.bmc.vo.SaveScoPolicyVo;



public interface BmcSv {

	/**
	 * operatorAccuQuery()
	 * 查询运营商的流量累计信息
	 * @param operatorFlowObject
	 * @return
	 */
	public List<BmcAccuDealer> operatorAccuQuery(OperatorFlowQueryInputObject aOperatorFlowQueryInputObject);
	public int operatorAccuQueryCount(OperatorFlowQueryInputObject aOperatorFlowQueryInputObject);
	
}
