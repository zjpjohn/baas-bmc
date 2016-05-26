package com.ai.baas.bmc.dao.mapper.bo;

public class BmcAccuDealer {
    private String tenantid;

    private String systemid;

    private String dealercode;

    private String dealerareacode;

    private Integer amount;

    private String channel;

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid == null ? null : tenantid.trim();
    }

    public String getSystemid() {
        return systemid;
    }

    public void setSystemid(String systemid) {
        this.systemid = systemid == null ? null : systemid.trim();
    }

    public String getDealercode() {
        return dealercode;
    }

    public void setDealercode(String dealercode) {
        this.dealercode = dealercode == null ? null : dealercode.trim();
    }

    public String getDealerareacode() {
        return dealerareacode;
    }

    public void setDealerareacode(String dealerareacode) {
        this.dealerareacode = dealerareacode == null ? null : dealerareacode.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }
}