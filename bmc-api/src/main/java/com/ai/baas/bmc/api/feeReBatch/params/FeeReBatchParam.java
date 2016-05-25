package com.ai.baas.bmc.api.feeReBatch.params;

import java.util.List;

/**
 * 费用批量回退入參
 * @author wangluyang
 *
 */
public class FeeReBatchParam {

	/**
	 * 回退费用项
	 */
	private List<FeeParam> params;
	/**
	 * 查询条件
	 */
	private FeeReBatchCriteria criteria;
	
	public List<FeeParam> getParams() {
		return params;
	}
	public void setParams(List<FeeParam> params) {
		this.params = params;
	}
	public FeeReBatchCriteria getCriteria() {
		return criteria;
	}
	public void setCriteria(FeeReBatchCriteria criteria) {
		this.criteria = criteria;
	}
}
