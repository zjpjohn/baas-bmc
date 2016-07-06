package com.ai.baas.bmc.api.orderinfo.params;

import java.io.Serializable;

public class ElementInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 元素名称
     */
    private String name;

    /**
     * 元素值
     */
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
