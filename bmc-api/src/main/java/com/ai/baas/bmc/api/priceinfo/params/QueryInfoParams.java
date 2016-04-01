package com.ai.baas.bmc.api.priceinfo.params;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.PageInfo;

/**
 * 标准资费查询入参
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author KAI
 */
public class QueryInfoParams extends BaseInfo {
    //private static final long serialVersionUID = 37L;
    
    /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
    @NotNull(message="消息流水不能为空",groups={IPriceInfoSV.GetPriceInfo.class})
    @Size(max=32,groups={IPriceInfoSV.GetPriceInfo.class})
    private String tradeSeq;
    
    /**
     * 标准资费ID
     * VARCHAR(32)
     */
    @Size(max=32,groups={IPriceInfoSV.GetPriceInfo.class})
    private String standardId;
    
    /**
     * 资费名称
     * VARCHAR(64)
     */
    @Size(max=64,groups={IPriceInfoSV.GetPriceInfo.class})
    private String priceName;
    
    /**
     * 业务类型
     * VARCHAR(32)
     */
    @Size(max=32,groups={IPriceInfoSV.GetPriceInfo.class})
    private String serviceType;
    
    /**
     * 资费状态
     * VARCHAR(32)
     */
    @Size(max=32,groups={IPriceInfoSV.GetPriceInfo.class})
    private String priceState;
    
    PageInfo<QueryInfoParams> pageInfo;

    public PageInfo<QueryInfoParams> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<QueryInfoParams> pageInfo) {
        this.pageInfo = pageInfo;
    }

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

    public String getPriceState() {
        return priceState;
    }

    public void setPriceState(String priceState) {
        this.priceState = priceState;
    }
    

}
