package com.ai.baas.bmc.api.orderrequest.params;

import java.io.Serializable;

public class PriceInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 价格描述
     */
    private String priceDesc;

    /**
     * 价格
     */
    private String price;

    public String getPriceDesc() {
        return priceDesc;
    }

    public void setPriceDesc(String priceDesc) {
        this.priceDesc = priceDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
