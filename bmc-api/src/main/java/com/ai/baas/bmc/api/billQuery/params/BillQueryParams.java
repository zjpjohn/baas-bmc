package com.ai.baas.bmc.api.billQuery.params;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ai.baas.bmc.api.billQuery.interfaces.IBillQuerySV;
import com.ai.baas.bmc.api.priceinfo.interfaces.IPriceInfoSV;
import com.ai.opt.base.vo.BaseInfo;

/**
 * 账单查询入参
 * Date: 2016年4月1日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author KAI
 */
public class BillQueryParams extends BaseInfo{

    /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
    @NotNull(message="消息流水不能为空",groups={IBillQuerySV.GetBillInfo.class})
    @Size(max=32,groups={IBillQuerySV.GetBillInfo.class})
    private String tradeSeq;
    
    /**
     * 租户ID<br>
     * 必填<br>
     * VARCHAR(32)
     */
    @NotNull(message="租户",groups={IBillQuerySV.GetBillInfo.class})
    @Size(max=32,groups={IBillQuerySV.GetBillInfo.class})
    private String tenantId;
    
    /**
     * 外部客户ID<br>
     * 必填<br>
     * VARCHAR(32)
     */
    @NotNull(message="消息流水不能为空",groups={IBillQuerySV.GetBillInfo.class})
    @Size(max=32,groups={IBillQuerySV.GetBillInfo.class})
    private String extCustId;
    
    /**
     * 服务标识<br>
     * VARCHAR(32)
     */
    @NotNull(message="消息流水不能为空",groups={IBillQuerySV.GetBillInfo.class})
    @Size(max=32,groups={IBillQuerySV.GetBillInfo.class})
    private String serviceId;
    
    /**
     * 是否分页 <br>
     * 组成：NO：表示不支持分页查询全部   YES：表示支持分页按照分页参数查询
     * 必填<br>
     * VARCHAR(32)
     */
    @NotNull(message="消息流水不能为空",groups={IBillQuerySV.GetBillInfo.class})
    @Size(max=32,groups={IBillQuerySV.GetBillInfo.class})
    private int paging;
    
    /**
     * 页码<br>
     * NUMBER(9)
     */
    @NotNull(message="消息流水不能为空",groups={IBillQuerySV.GetBillInfo.class})
    @Size(max=32,groups={IBillQuerySV.GetBillInfo.class})
    private String pageNumber;
    
    /**
     * 每页条数<br>
     * NUMBER(32)
     */
    @NotNull(message="消息流水不能为空",groups={IBillQuerySV.GetBillInfo.class})
    @Size(max=32,groups={IBillQuerySV.GetBillInfo.class})
    private String pagecountNumber;
    
    /**
     * 查询开始时间<br>
     * 缺省是系统时间，格式YYYYMMDDHH24MISS
     * VARCHAR(14)
     */
    @NotNull(message="消息流水不能为空",groups={IBillQuerySV.GetBillInfo.class})
    @Size(max=32,groups={IBillQuerySV.GetBillInfo.class})
    private String queryStartTime;
    
    /**
     * 查询结束时间<br>
     * 缺省是系统时间,格式同上
     * VARCHAR(14)
     */
    @NotNull(message="消息流水不能为空",groups={IBillQuerySV.GetBillInfo.class})
    @Size(max=32,groups={IBillQuerySV.GetBillInfo.class})
    private String queryEndTime;
    
}
