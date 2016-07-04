package com.ai.baas.bmc.api.pricemaking.params;

import java.io.Serializable;
import java.util.List;

public class CostInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String list_id;

    private List<Cost> cost;

    public String getList_id() {
        return list_id;
    }

    public void setList_id(String list_id) {
        this.list_id = list_id;
    }

    public List<Cost> getCost() {
        return cost;
    }

    public void setCost(List<Cost> cost) {
        this.cost = cost;
    }
}
