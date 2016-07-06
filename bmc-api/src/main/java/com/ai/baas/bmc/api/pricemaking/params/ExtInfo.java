package com.ai.baas.bmc.api.pricemaking.params;

import java.io.Serializable;

public class ExtInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String extName;

    /**
     * 值
     */
    private String extValue;

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }
}
