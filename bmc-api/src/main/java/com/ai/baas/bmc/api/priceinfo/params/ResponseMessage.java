package com.ai.baas.bmc.api.priceinfo.params;

import java.io.Serializable;
import java.util.List;

public class ResponseMessage  implements Serializable {

    private String returnCode;
    private String tradeSeq;
    private String tenantId;
    private List<StandardList> standardList;
    
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
    public List<StandardList> getStandardList() {
        return standardList;
    }
    public void setStandardList(List<StandardList> standardList) {
        this.standardList = standardList;
    }
    
    
}
