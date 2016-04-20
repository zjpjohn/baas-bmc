package com.ai.baas.bmc.api.priceinfo.params;

import java.io.Serializable;
import java.util.List;

public class StandardList  implements Serializable{
    private static final long serialVersionUID = -49891863493979L;
    /**
     * 标准资费ID
     */
    private String standardId;
    /**
     * 标准资费名称
     */
    private String priceName;
    /**
     * 业务类型
     */
    private String serviceType;
    /**
     * 标准资费使用量列表
     */
    private List<UsageList> usageList;
    /**
     * 单次/周期类型
     */
    private String cycleType;
    /**
     * 单次/周期数量
     */
    private Double cycleAmount;
    /**
     * 单次/周期标识
     */
    private String cycleId;
    /**
     * 价格类型
     */
    private String priceType;
    /**
     * 价格
     */
    private Double price;
    /**
     * 科目ID
     */
    private String subjectCode;
    /**
     * 资费描述
     */
    private String comments;
    /**
     * 状态
     */
    private String status;
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
    public List<UsageList> getUsageList() {
        return usageList;
    }
    public void setUsageList(List<UsageList> usageList) {
        this.usageList = usageList;
    }
    public String getCycleType() {
        return cycleType;
    }
    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }
    public Double getCycleAmount() {
        return cycleAmount;
    }
    public void setCycleAmount(Double cycleAmount) {
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
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
    public String getSubjectCode() {
        return subjectCode;
    }
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
    
    
}
