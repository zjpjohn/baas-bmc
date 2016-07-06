package com.ai.baas.bmc.api.orderinfo.params;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.baas.bmc.api.orderinfo.interfaces.IOrderInfoSV;

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
    @NotBlank(message = "产品ID不能为空", groups = { IOrderInfoSV.OrderInfo.class })
    @Size(max = 32, groups = { IOrderInfoSV.OrderInfo.class })
    private String productId;

    /**
     * 产品类型
     */
    private String productType;

    /**
     * 产品数量<br>
     * 同一个产品被客户订购的数量<br>
     * 必填<br>
     * NUMBER(9)
     */
    @NotBlank(message = "产品数量不能为空", groups = { IOrderInfoSV.OrderInfo.class })
    @Size(max = 9, groups = { IOrderInfoSV.OrderInfo.class })
    private Integer productNumber;

    /**
     * 产品实例ID
     */
    private String subsProductId;

    /**
     * 产品价格,整数，单位分
     */
    private long subsProductPrice;

    /**
     * 是否触发抵扣
     */
    private String deductable;

    /**
     * 赠送标识<br>
     * 标识该产品是否为一个赠送的产品。取值范围：Y：是赠送；N：不是赠送。<br>
     * VARCHAR(1)
     */
    @NotBlank(message = "赠送标识不能为空", groups = { IOrderInfoSV.OrderInfo.class })
    // @Pattern(regexp="^[Y|N]$",message="取值范围：Y：是赠送；N：不是赠送",groups={IOrderInfoSV.OrderInfo.class})
    @Size(max = 1, groups = { IOrderInfoSV.OrderInfo.class })
    private String resBonusFlag;

    /**
     * 生效日期<br>
     * 格式：YYYYMMDDHH24MISS<br>
     * 必填<br>
     * VARCHAR(14)
     */
    @NotBlank(message = "生效日期不能为空", groups = { IOrderInfoSV.OrderInfo.class })
    @Size(min = 14, max = 14, groups = { IOrderInfoSV.OrderInfo.class })
    private String activeTime;

    /**
     * 失效日期<br>
     * 格式：YYYYMMDDHH24MISS<br>
     * 必填<br>
     * VARCHAR(14)
     */
    @NotBlank(message = "失效日期不能为空", groups = { IOrderInfoSV.OrderInfo.class })
    @Size(min = 14, max = 14, groups = { IOrderInfoSV.OrderInfo.class })
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSubsProductId() {
        return subsProductId;
    }

    public void setSubsProductId(String subsProductId) {
        this.subsProductId = subsProductId;
    }

    public long getSubsProductPrice() {
        return subsProductPrice;
    }

    public void setSubsProductPrice(long subsProductPrice) {
        this.subsProductPrice = subsProductPrice;
    }

    public String getDeductable() {
        return deductable;
    }

    public void setDeductable(String deductable) {
        this.deductable = deductable;
    }

}
