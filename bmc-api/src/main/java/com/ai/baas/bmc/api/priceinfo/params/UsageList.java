package com.ai.baas.bmc.api.priceinfo.params;

import java.io.Serializable;

public class UsageList implements Serializable{
    
    private static final long serialVersionUID = -4989482563493979L;
            
    private Double amount;
    private String subServiceType;
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
