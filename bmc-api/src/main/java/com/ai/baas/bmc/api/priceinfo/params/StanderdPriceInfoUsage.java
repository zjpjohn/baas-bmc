package com.ai.baas.bmc.api.priceinfo.params;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;

/**
 * 标准资费使用量列表 Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public class StanderdPriceInfoUsage implements Serializable {
    private static final long serialVersionUID = -4771351964732320056L;

    /**
     * 标准资费使用量<br>
     * 使用量为固定值，需量化到最小颗粒<br>
     * 必填<br>
     * NUMBER(32)
     */
    @NotNull(message = "标准资费使用量不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
//    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private double amount;

    /**
     * 业务类型细分<br>
     * 在新建标准资费时需选择业务类型，根据业务类型的选择进行业务类型的细分，业务类型与业务类型细分为两级联动关系<br>
     * 必填<br>
     * VARCHAR(32)
     */
    @NotBlank(message = "业务类型细分不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String subServiceType;

    /**
     * 单位<br>
     * 标准资费单位根据业务类型及业务类型细分进行联动，需内置<br>
     * 必填<br>
     * VARCHAR(32)
     */
    @NotBlank(message = "单位不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class })
    private String unit;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubServiceType() {
        return subServiceType;
    }

    public void setSubServiceType(String subServiceType) {
        this.subServiceType = subServiceType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
