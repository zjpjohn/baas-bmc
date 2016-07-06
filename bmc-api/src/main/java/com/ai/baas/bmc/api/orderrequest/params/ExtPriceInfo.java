package com.ai.baas.bmc.api.orderrequest.params;

import java.io.Serializable;

public class ExtPriceInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String extName;

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
