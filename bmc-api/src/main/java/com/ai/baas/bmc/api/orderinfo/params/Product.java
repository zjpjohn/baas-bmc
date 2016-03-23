package com.ai.baas.bmc.api.orderinfo.params;

import java.io.Serializable;
import java.util.List;

/**
 * 产品列表<br>
 * Date: 2016年3月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 2814045806780260212L;

    /**
     * 产品ID<br>
     * 必填<br>
     * VARCHAR(32)
     */
    private String productId;

    /**
     * 产品数量<br>
     * 同一个产品被客户订购的数量<br>
     * 必填<br>
     * NUMBER(9)
     */
    private Integer productNumber;

    /**
     * 赠送标识<br>
     * 标识该产品是否为一个赠送的产品。取值范围：Y：是赠送；N：不是赠送。<br>
     * VARCHAR(1)
     */
    private String resBonusFlag;

    /**
     * 生效日期<br>
     * 格式：YYYYMMDDHH24MISS<br>
     * 必填<br>
     * VARCHAR(14)
     */
    private String activeTime;

    /**
     * 失效日期<br>
     * 格式：YYYYMMDDHH24MISS<br>
     * 必填<br>
     * VARCHAR(14)
     */
    private String inactiveTime;

    /**
     * 产品扩展信息列表<br>
     * list
     */
    private List<ProductExt> productExtInfoList;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public String getResBonusFlag() {
        return resBonusFlag;
    }

    public void setResBonusFlag(String resBonusFlag) {
        this.resBonusFlag = resBonusFlag;
    }

    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public String getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(String inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public List<ProductExt> getProductExtInfoList() {
        return productExtInfoList;
    }

    public void setProductExtInfoList(List<ProductExt> productExtInfoList) {
        this.productExtInfoList = productExtInfoList;
    }

}
