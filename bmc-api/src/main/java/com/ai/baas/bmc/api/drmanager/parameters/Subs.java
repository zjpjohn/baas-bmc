package com.ai.baas.bmc.api.drmanager.parameters;

import java.io.Serializable;
import java.util.List;

/**
 * Date: 2015年12月28日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author linhan
 */
public class Subs implements Serializable{

    /**
     * 用户订购标识
     * 必填，32字节
     */
    private String subsId;
    
    /**
     * 账期列表，可空
     */
    private List<Bills> billList;
    
    public String getSubsId() {
        return subsId;
    }
    public void setSubsId(String subsId) {
        this.subsId = subsId;
    }
    public List<Bills> getBillList() {
        return billList;
    }
    public void setBillList(List<Bills> billList) {
        this.billList = billList;
    }
    
    @Override
    public String toString() {
        return "Subs [subsId=" + subsId + ", billList=" + billList + "]";
    }
    
    
}
