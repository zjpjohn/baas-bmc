package com.ai.baas.bmc.api.queryidinfo.params;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class BlCustinfoResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /**
     * BlCustinfo对象列表
     */
    private List<BlCustinfoInfo> blCustinfoInfos;

    public List<BlCustinfoInfo> getBlCustinfoInfos() {
        return blCustinfoInfos;
    }

    public void setBlCustinfoInfos(List<BlCustinfoInfo> blCustinfoInfos) {
        this.blCustinfoInfos = blCustinfoInfos;
    }

}
