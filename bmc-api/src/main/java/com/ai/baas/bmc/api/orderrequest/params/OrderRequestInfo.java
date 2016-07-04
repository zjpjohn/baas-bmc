package com.ai.baas.bmc.api.orderrequest.params;

import java.io.Serializable;
import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

public class OrderRequestInfo extends BaseInfo implements Serializable {

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
     * 订购时间
     */
    private String orderTime;

    /**
     * 价格信息列表
     */
    private List<PriceInfo> priceInfoList;

    /**
     * 类型列表
     */
    private List<OrderTypeInfo> orderTypeList;

    /**
     * 产品定价扩展信息列表
     */
    private List<ExtPriceInfo> extPriceInfoList;

    /**
     * 订购扩展信息列表
     */
    private List<ExtOrderInfo> extOrderInfoList;

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

    public List<PriceInfo> getPriceInfoList() {
        return priceInfoList;
    }

    public void setPriceInfoList(List<PriceInfo> priceInfoList) {
        this.priceInfoList = priceInfoList;
    }

    public List<OrderTypeInfo> getOrderTypeList() {
        return orderTypeList;
    }

    public void setOrderTypeList(List<OrderTypeInfo> orderTypeList) {
        this.orderTypeList = orderTypeList;
    }

    public List<ExtPriceInfo> getExtPriceInfoList() {
        return extPriceInfoList;
    }

    public void setExtPriceInfoList(List<ExtPriceInfo> extPriceInfoList) {
        this.extPriceInfoList = extPriceInfoList;
    }

    public List<ExtOrderInfo> getExtOrderInfoList() {
        return extOrderInfoList;
    }

    public void setExtOrderInfoList(List<ExtOrderInfo> extOrderInfoList) {
        this.extOrderInfoList = extOrderInfoList;
    }

}
