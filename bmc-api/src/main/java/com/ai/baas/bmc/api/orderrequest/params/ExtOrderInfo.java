package com.ai.baas.bmc.api.orderrequest.params;

import java.io.Serializable;
import java.util.List;

public class ExtOrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 扩展信息的类型
     */
    private String extType;

    /**
     * 子信息列表
     */
    private List<SubInfo> infolist;

    public String getExtType() {
        return extType;
    }

    public void setExtType(String extType) {
        this.extType = extType;
    }

    public List<SubInfo> getInfolist() {
        return infolist;
    }

    public void setInfolist(List<SubInfo> infolist) {
        this.infolist = infolist;
    }

}
