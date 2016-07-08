package com.ai.baas.bmc.api.queryidinfo.params;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class BlAcctInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * BlAcctInfo对象列表
     */
    private List<BlAcctInfoInfo> blAcctInfoInfos;

    public List<BlAcctInfoInfo> getBlAcctInfoInfos() {
        return blAcctInfoInfos;
    }

    public void setBlAcctInfoInfos(List<BlAcctInfoInfo> blAcctInfoInfos) {
        this.blAcctInfoInfos = blAcctInfoInfos;
    }

}
