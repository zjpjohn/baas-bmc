package com.ai.baas.bmc.api.pricemaking.params;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class ResponseMessage extends BaseResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private String returnCode;

    /**
     * 价格信息列表
     */
    private List<PriceInfo> priceInfoList;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public List<PriceInfo> getPriceInfoList() {
        return priceInfoList;
    }

    public void setPriceInfoList(List<PriceInfo> priceInfoList) {
        this.priceInfoList = priceInfoList;
    }

}
