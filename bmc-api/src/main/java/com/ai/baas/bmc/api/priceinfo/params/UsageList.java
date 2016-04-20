package com.ai.baas.bmc.api.priceinfo.params;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;

public class UsageList implements Serializable{
    
    private static final long serialVersionUID = -4989482563493979L;
    
    /**
     * 使用量
     */
    private Double amount;
    
    /**
     * 业务类型细分
     */
    private String subServiceType;
    
    /**
     * 单位
     */
    private String unit;
    
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
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
