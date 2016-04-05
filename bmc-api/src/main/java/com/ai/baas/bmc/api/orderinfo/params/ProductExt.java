package com.ai.baas.bmc.api.orderinfo.params;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.baas.bmc.api.orderinfo.interfaces.IOrderInfoSV;

/**
 * 产品扩展信息<br>
 * Date: 2016年3月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public class ProductExt implements Serializable {
    private static final long serialVersionUID = -7022651698883021106L;

    /**
     * 名称<br>
     * 必填<br>
     * VARCHAR(32)
     */
    @NotNull(message="名称不能为空",groups={IOrderInfoSV.OrderInfo.class})
    @Size(max=32,groups={IOrderInfoSV.OrderInfo.class})
    private String extName;

    /**
     * 值<br>
     * 必填<br>
     * VARCHAR(64)
     */
    @NotNull(message="值不能为空",groups={IOrderInfoSV.OrderInfo.class})
    @Size(max=64,groups={IOrderInfoSV.OrderInfo.class})
    private String extValue;

    /**
     * 更新标识<br>
     * 取值范围：D：删除，U：更新，N：新增<br>
     * 必填<br>
     * VARCHAR(1)
     */
    @NotNull(message="更新标识不能为空",groups={IOrderInfoSV.OrderInfo.class})
//    @Pattern(regexp="^[DUN]$",message="取值范围：D：删除，U：更新，N：新增",groups={IOrderInfoSV.OrderInfo.class})
    @Size(max=1,groups={IOrderInfoSV.OrderInfo.class})
    private String updateFlag;

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }

    public String getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag;
    }
}
