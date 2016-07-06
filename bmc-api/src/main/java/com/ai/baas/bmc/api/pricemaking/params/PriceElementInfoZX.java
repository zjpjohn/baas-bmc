package com.ai.baas.bmc.api.pricemaking.params;

import java.io.Serializable;
import java.util.List;

public class PriceElementInfoZX implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<ShoppingList> shopping_lists;

    public List<ShoppingList> getShopping_lists() {
        return shopping_lists;
    }

    public void setShopping_lists(List<ShoppingList> shopping_lists) {
        this.shopping_lists = shopping_lists;
    }

}
