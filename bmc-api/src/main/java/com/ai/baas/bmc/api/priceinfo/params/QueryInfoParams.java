package com.ai.baas.bmc.api.priceinfo.params;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

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
    private static final long serialVersionUID = 37L;
    
    /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     */
    @NotBlank(message="消息流水不能为空")
   //@Size(max=32)
    private String tradeSeq;
    
    /**
     * 标准资费ID
     * VARCHAR(32)
     */
    @Size(max=32)
    private String standardId;
    
    /**
     * 资费名称
     * VARCHAR(64)
     */
    @Size(max=64)
    private String priceName;
    
    /**
     * 业务类型
     * VARCHAR(32)
     */
   @Size(max=32)
    private String serviceType;
   
   /**
    * 业务类型细分
    * VARCHAR(32)
    */
   @Size(max=32)
   private String subServiceType;
    /**
     * 资费状态
     * VARCHAR(32)
     */
  @Size(max=32)
    private String priceState;
    
    /**
     * 请求查询的页码
     */
    //@Size(max=32)
    private Integer pageNo;
    
    /**
     * 每页显示条数
     */
    //@Size(max=32)
    private Integer pageSize;
    
    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    
    public String getSubServiceType() {
        return subServiceType;
    }

    public void setSubServiceType(String subServiceType) {
        this.subServiceType = subServiceType;
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
