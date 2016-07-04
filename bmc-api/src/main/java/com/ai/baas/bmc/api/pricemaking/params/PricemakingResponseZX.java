package com.ai.baas.bmc.api.pricemaking.params;

import java.io.Serializable;
import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class PricemakingResponseZX extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<CostInfo> detail_costs;

    public List<CostInfo> getDetail_costs() {
        return detail_costs;
    }

    public void setDetail_costs(List<CostInfo> detail_costs) {
        this.detail_costs = detail_costs;
    }
}
