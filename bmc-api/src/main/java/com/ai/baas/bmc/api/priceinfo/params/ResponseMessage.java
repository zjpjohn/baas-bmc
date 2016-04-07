package com.ai.baas.bmc.api.priceinfo.params;

import java.io.Serializable;
import java.util.List;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class ResponseMessage extends BaseResponse {

    private static final long serialVersionUID = -433299863493979L;
    private String returnCode;
    private String tradeSeq;
    private String tenantId;
    private PageInfo<StandardList> standardList;
    
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
    public PageInfo<StandardList> getStandardList() {
        return standardList;
    }
    public void setStandardList(PageInfo<StandardList> standardList) {
        this.standardList = standardList;
    }
    
    
}
