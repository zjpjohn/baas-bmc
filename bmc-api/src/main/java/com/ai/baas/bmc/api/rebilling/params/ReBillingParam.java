package com.ai.baas.bmc.api.rebilling.params;

import com.ai.opt.base.vo.BaseInfo;
/**
 * 重批价参数
 * Date: 2016年5月26日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author LiangMeng
 */
public class ReBillingParam extends BaseInfo{

    private static final long serialVersionUID = 6742696473959123245L;
    //1、  租户
    private String tenantId;
    
    //2、  业务
    private String busiType;
    
    //3、  subs_id,即对哪个用户回退。目前支持到按用户回退。
    private String subsId;
    //4、  账期月， 
    private String billMonth;
    //5、  回退类型：费用，资源（语音、流量、虚拟币），编码以前台传入的为准，他们都配置到基础数据表中。
    private String reBillingType;
    //
    private String serviceId;
    public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    public String getBusiType() {
        return busiType;
    }
    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }
    public String getSubsId() {
        return subsId;
    }
    public void setSubsId(String subsId) {
        this.subsId = subsId;
    }
    public String getBillMonth() {
        return billMonth;
    }
    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }
    public String getReBillingType() {
        return reBillingType;
    }
    public void setReBillingType(String reBillingType) {
        this.reBillingType = reBillingType;
    }
    
}
