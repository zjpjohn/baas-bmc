package com.ai.baas.bmc.api.acctinfo.params;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
/**
 * 账户查询出参.<br>
 * Date: 2016年7月4日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author luoxuan
 */

public class ResponseMessage extends BaseResponse{

	private static final long serialVersionUID = 3106422348245997630L;
    private String returnCode;
    private String tradeSeq;
    private String tenantId;
    private PageInfo<AcctInfoParams> acctInfoParamsList;
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public PageInfo<AcctInfoParams> getAcctInfoParamsList() {
		return acctInfoParamsList;
	}
	public void setAcctInfoParamsList(PageInfo<AcctInfoParams> acctInfoParamsList) {
		this.acctInfoParamsList = acctInfoParamsList;
	}
    
}
