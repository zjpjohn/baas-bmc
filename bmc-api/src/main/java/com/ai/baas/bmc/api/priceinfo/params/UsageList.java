package com.ai.baas.bmc.api.priceinfo.params;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;

public class UsageList implements Serializable{
    
    private static final long serialVersionUID = -4989482563493979L;
    
    //@NotNull(message = "使用量不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })  
    private Double amount;
    
//    @NotNull(message = "业务类型细分不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
//    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String subServiceType;
    
//    @NotNull(message = "单位不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
//    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
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
