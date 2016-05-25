package com.ai.baas.bmc.api.feeReBatch.params;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.HBasePager;

/**
 * Created by xin on 16-4-11.
 */
public class FeeReBatchCriteria extends BaseInfo {
    private HBasePager<FeeParam> pager;
    
    /**
     * 回退类型
     */
    private String reBatchType;
    /**
     * 账期
     */
    private String accountPeriod;
    /**
     * 业务类型
     */
    private String serviceType;
    /**
     * 服务号
     */
    private String serviceId;
    
	public String getReBatchType() {
		return reBatchType;
	}

	public void setReBatchType(String reBatchType) {
		this.reBatchType = reBatchType;
	}

	public String getAccountPeriod() {
		return accountPeriod;
	}

	public void setAccountPeriod(String accountPeriod) {
		this.accountPeriod = accountPeriod;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public HBasePager<FeeParam> getPager() {
		return pager;
	}

	public void setPager(HBasePager<FeeParam> pager) {
		this.pager = pager;
	}
}
