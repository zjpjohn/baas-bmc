package com.ai.baas.bmc.api.orderrequest.params;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class ResponseMessage extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private String returnCode;

    /**
     * 产品实例ID
     */
    private String subsProductId;

    /**
     * 是否可以订购
     */
    private String enableOrdered;

    /**
     * 扩展信息
     */
    private List<ExtInfo> ExtInfoList;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getSubsProductId() {
        return subsProductId;
    }

    public void setSubsProductId(String subsProductId) {
        this.subsProductId = subsProductId;
    }

    public String getEnableOrdered() {
        return enableOrdered;
    }

    public void setEnableOrdered(String enableOrdered) {
        this.enableOrdered = enableOrdered;
    }

    public List<ExtInfo> getExtInfoList() {
        return ExtInfoList;
    }

    public void setExtInfoList(List<ExtInfo> extInfoList) {
        ExtInfoList = extInfoList;
    }

}
