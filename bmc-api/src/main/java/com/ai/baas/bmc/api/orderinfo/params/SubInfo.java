package com.ai.baas.bmc.api.orderinfo.params;

import java.io.Serializable;
import java.util.List;

public class SubInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 扩展信息的类型
     */
    private String extType;

    /**
     * 子信息列表
     */
    private List<Info> infolist;

    public String getExtType() {
        return extType;
    }

    public void setExtType(String extType) {
        this.extType = extType;
    }

    public List<Info> getInfolist() {
        return infolist;
    }

    public void setInfolist(List<Info> infolist) {
        this.infolist = infolist;
    }

}
