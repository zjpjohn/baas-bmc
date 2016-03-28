package com.ai.baas.bmc.api.priceinfo.params;

public class UsageList {

    private String amount;
    private String subServiceType;
    private String unit;
    
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
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
