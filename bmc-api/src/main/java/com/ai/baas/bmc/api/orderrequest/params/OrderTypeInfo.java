package com.ai.baas.bmc.api.orderrequest.params;

import java.io.Serializable;
import java.util.List;

public class OrderTypeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 定价类型
     */
    private String priceType;

    /**
     * 定价元素列表
     */
    private List<ElementInfo> elementInfoList;

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public List<ElementInfo> getElementInfoList() {
        return elementInfoList;
    }

    public void setElementInfoList(List<ElementInfo> elementInfoList) {
        this.elementInfoList = elementInfoList;
    }
}
