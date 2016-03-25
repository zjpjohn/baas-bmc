package com.ai.baas.bmc.api.orderinfo.params;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;


/**
 * 输入类名称<br>
 * Date: 2016年3月22日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author caoyf
 */
public class OrderInfoParams extends BaseInfo {
    private static final long serialVersionUID = -6666115297878537537L;

    /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
    private String tradeSeq;

    /**
     * 外部客户ID<br>
     * 必填<br>
     * VARCHAR(32)
     */
    private String extCustId;

    /**
     * 订购类型<br>
     * 取值范围：Test:测试；Normal：正式<br>
     * 必填<br>
     * VARCHAR(32)
     */
    private String usetype;

    /**
     * 订购状态<br>
     * 取值范围：Normal：正常；Stop：停机；Cancel：销户<br>
     * VARCHAR(32)
     */
    private String state;

    /**
     * 服务标识<br>
     * 必填<br>
     * VARCHAR(64)
     */
    private String serviceId;

    /**
     * 订购时间<br>
     * 格式：YYYYMMDDHH24MISS<br>
     * VARCHAR(14)
     */
    private String orderTime;

    /**
     * 归属省<br>
     * 参考省份定义表<br>
     * VARCHAR(6)
     */
    private String provinceCode;

    /**
     * 归属地区<br>
     * 以0开头的地区号<br>
     * VARCHAR(6)
     */
    private String cityCode;

    /**
     * 发展渠道<br>
     * VARCHAR(32)
     */
    private String chlId;

    /**
     * 发展人<br>
     * VARCHAR(32)
     */
    private String devId;

    /**
     * 生效时间<br>
     * 格式：YYYYMMDDHH24MISS<br>
     * 必填<br>
     * VARCHAR(14)
     */
    private String activeTime;

    /**
     * 失效时间<br>
     * 格式：YYYYMMDDHH24MISS<br>
     * 必填<br>
     * VARCHAR(14)
     */
    private String inactiveTime;

    /**
     * 订购扩展信息列表<br>
     * list
     */
    private List<OrderExt> orderExtInfo;

    /**
     * 备注<br>
     * varchar(1024)
     */
    private String remark;

    /**
     * 产品列表<br>
     * list
     */
    private List<Product> productList;

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

    public String getUsetype() {
        return usetype;
    }

    public void setUsetype(String usetype) {
        this.usetype = usetype;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getChlId() {
        return chlId;
    }

    public void setChlId(String chlId) {
        this.chlId = chlId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public String getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(String inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public List<OrderExt> getOrderExtInfo() {
        return orderExtInfo;
    }

    public void setOrderExtInfo(List<OrderExt> orderExtInfo) {
        this.orderExtInfo = orderExtInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
