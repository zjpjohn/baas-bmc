package com.ai.baas.bmc.api.priceinfo.params;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.opt.base.vo.BaseInfo;

/**
 * 标准资费更新服务输入类 Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public class StandardPriceInfoParams extends BaseInfo {
    private static final long serialVersionUID = -4989482599863493979L;

    /**
     * 交易流水<br>
     * 必填<br>
     */
    @NotBlank(message = "交易流水不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
    //@Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String tradeSeq;

    /**
     * 标准资费ID<br>
     * 每个标准资费都需要一个对应且唯一的ID，<br>
     * 在新建标准资费保存后系统自动生成，为不必填项<br>
     * 修改和删除的时候，为必填项<br>
     * VARCHAR(32)
     */
    //@NotNull(message = "标准资费ID不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String standardId;

    /**
     * 标准资费名称<br>
     * 在新建标准资费时需填写名称，后台将其名称与ID匹配后存储<br>
     * 必填<br>
     * VARCHAR(64)
     */
    @NotBlank(message = "标准资费名称不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
    @Size(max = 64,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String priceName;

    /**
     * 业务类型<br>
     * 必填<br>
     * VARCHAR(32)
     */
    @NotBlank(message = "业务类型不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String serviceType;

    /**
     * 标准资费使用量列表<br>
     * 至少有一个
     */
    private List<StanderdPriceInfoUsage> usageList;

    /**
     * 单次/周期类型<br>
     * 取值范围：TIME：次,CYCLE：周期<br>
     * 必填<br>
     * VARCHAR(33)
     */
//    @NotNull(message = "单次/周期类型不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
//    @Size(max = 33,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String cycleType;

    /**
     * 单次/周期数量<br>
     * 必填<br>
     * NUMBER(32)
     */
//    @NotNull(message = "单次/周期数量不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
//    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private double cycleAmount;

    /**
     * 单次/周期标识<br>
     * 取值范围：TIME：次,MONTH：月,YEAR：年,DAY：日<br>
     * 必填<br>
     * VARCHAR(32)
     */
//    @NotNull(message = "单次/周期标识不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
//    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String cycleId;

    /**
     * 价格类型<br>
     * 取值范围：UNIT：单价,ALL：总价<br>
     * 必填<br>
     * VARCHAR(33)
     */
//    @NotNull(message = "价格类型不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
//    @Size(max = 33,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String priceType;

    /**
     * 价格<br>
     * 标准资费的价格分为单价和总价，根据周期的选择进行单价或总价的确定<br>
     * 必填<br>
     * NUMBER(32)
     */
    @NotNull(message = "价格不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
//    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private double price;

    /**
     * 资费描述<br>
     * 每新建一个标准资费时需要进行描述说明<br>
     * VARCHAR(32)
     */
    @Size(max = 1024,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String comments;

    /**
     * 状态<br>
     * 取值范围：,INACTIVE：待生效,  ACTIVE：生效<br>
     * 必填<br>
     * VARCHAR(32)
     */
//    @NotNull(message = "状态不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
//    @Size(max = 32,groups = { IPriceInfoSV.UpdatePriceInfo.class  })
    private String status;

    /**
     * 更新标识<br>
     * 取值范围：,UPDATE：更新,CREATE：创建,DELETE：删除<br>
     * 必填<br>
     * VARCHAR(32)
     */
    @NotBlank(message = "更新标识不能为空", groups = { IPriceInfoSV.UpdatePriceInfo.class })
    @Size(max = 32)
    private String updateId;

    public String getTradeSeq() {
        return tradeSeq;
    }

    public void setTradeSeq(String tradeSeq) {
        this.tradeSeq = tradeSeq;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public List<StanderdPriceInfoUsage> getUsageList() {
        return usageList;
    }

    public void setUsageList(List<StanderdPriceInfoUsage> usageList) {
        this.usageList = usageList;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public double getCycleAmount() {
        return cycleAmount;
    }

    public void setCycleAmount(double cycleAmount) {
        this.cycleAmount = cycleAmount;
    }

    public String getCycleId() {
        return cycleId;
    }

    public void setCycleId(String cycleId) {
        this.cycleId = cycleId;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

}
