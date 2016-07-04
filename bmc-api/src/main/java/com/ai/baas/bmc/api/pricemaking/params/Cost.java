package com.ai.baas.bmc.api.pricemaking.params;

import java.io.Serializable;

public class Cost implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cost_name;

    private String cost_value;

    private String cost_unit;

    public String getCost_name() {
        return cost_name;
    }

    public void setCost_name(String cost_name) {
        this.cost_name = cost_name;
    }

    public String getCost_value() {
        return cost_value;
    }

    public void setCost_value(String cost_value) {
        this.cost_value = cost_value;
    }

    public String getCost_unit() {
        return cost_unit;
    }

    public void setCost_unit(String cost_unit) {
        this.cost_unit = cost_unit;
    }
}
