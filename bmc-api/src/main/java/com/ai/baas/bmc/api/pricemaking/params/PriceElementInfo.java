package com.ai.baas.bmc.api.pricemaking.params;

import java.io.Serializable;
import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

public class PriceElementInfo extends BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 交易流水
     */
    private String tradeSeq;

    /**
     * 外部客户ID
     */
    private String extCustId;

    /**
     * 服务标识
     */
    private String serviceId;

    /**
     * 查询时间
     */
    private String orderTime;

    /**
     * 类型列表
     */
    private List<OrderTypeInfo> orderTypeList;

    /**
     * 扩展信息列表
     */
    private List<ExtInfo> extInfoList;

    public String getTradeSeq() {
        return tradeSeq;
    }

    public void setTradeSeq(String tradeSeq) {
        this.tradeSeq = tradeSeq;
    }

    public String getExtCustId() {
        return extCustId;
    }

    public void setExtCustId(String extCustId) {
        this.extCustId = extCustId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public List<ExtInfo> getExtInfoList() {
        return extInfoList;
    }

    public void setExtInfoList(List<ExtInfo> extInfoList) {
        this.extInfoList = extInfoList;
    }

    public List<OrderTypeInfo> getOrderTypeList() {
        return orderTypeList;
    }

    public void setOrderTypeList(List<OrderTypeInfo> orderTypeList) {
        this.orderTypeList = orderTypeList;
    }

}
