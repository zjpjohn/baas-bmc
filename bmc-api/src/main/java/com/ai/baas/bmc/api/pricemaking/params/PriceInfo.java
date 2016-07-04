package com.ai.baas.bmc.api.pricemaking.params;

import java.io.Serializable;
import java.util.List;

public class PriceInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String listId;

    private List<FeeInfo> feeInfos;

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public List<FeeInfo> getFeeInfos() {
        return feeInfos;
    }

    public void setFeeInfos(List<FeeInfo> feeInfos) {
        this.feeInfos = feeInfos;
    }

}
