package com.ai.baas.bmc.api.feeReBatch.params;

/**
 * 费用批量回退入參
 * @author wangluyang
 *
 */
public class FeeReBatchParam {

	/**
	 * 查询条件
	 */
	private FeeReBatchCriteria criteria;
	
	public FeeReBatchCriteria getCriteria() {
		return criteria;
	}
	public void setCriteria(FeeReBatchCriteria criteria) {
		this.criteria = criteria;
	}
}
