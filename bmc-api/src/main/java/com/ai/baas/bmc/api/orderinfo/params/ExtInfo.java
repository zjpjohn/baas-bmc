package com.ai.baas.bmc.api.orderinfo.params;

import java.io.Serializable;
import java.util.List;

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

    /**
     * 子列表
     */
    private List<SubInfo> sublist;

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

    public List<SubInfo> getSublist() {
        return sublist;
    }

    public void setSublist(List<SubInfo> sublist) {
        this.sublist = sublist;
    }
}
