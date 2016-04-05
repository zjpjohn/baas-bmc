package com.ai.baas.bmc.api.billQuery.params;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 账单查询入参
 * Date: 2016年4月5日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author KAI
 */
public class BillInfo extends BaseInfo{
   
    private String returnCode;
    private String tradeSeq;
    private String extCustId;
    private List<ServiceId> serviceIdList;
    private String pageNumber;
    private String totalCount;
    private String queryStartTime;
    private String queryEndTime;
    /*
     *  响应报文 返回码 responseMessage returnCode  Y   VARCHAR(14) BaaS-000000成功；其他失败
            响应报文    消息流水    responseMessage tradeSeq    Y   VARCHAR(32) 等于请求报文中的消息流水
            响应报文    租户ID    responseMessage tenantId    Y   VARCHAR(32) 
            响应报文    外部客户ID  responseMessage extCustId   Y   VARCHAR(32) 
            响应报文    服务标识列表  responseMessage serviceIdList   *   List    可以是空链表
            响应报文    账单列表    serviceIDList   billList    *   List    可以是空链表，按账期的账单列表
            响应报文    账期  billList    billDuration    Y   VARCHAR(32) 月账期：YYYYMM
            响应报文    原始费用    billList    orgFee  N   NUMBER(32)  
            响应报文    优惠费用    billList    disFee  N   NUMBER(32)  折扣费用，单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
            响应报文    调整费用    billList    adjustFee   N   NUMBER(32)  调整费用，单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入。正数为调增、负数为调减，0为未调整。
            响应报文    总费用 billList    totalfee    Y   NUMBER(32)  该用户本月账单总额。单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
            响应报文    账单明细列表  billList    subjcetDetailList   *   List    可以是空链表，按科目的维度列出账单明细
            响应报文    科目  subjcetDetailList   subjectId   Y   VARCHAR(32) 按服务方约定填写
            响应报文    科目原始费用  subjcetDetailList   subjectOrgFee   N   NUMBER(32)  
            响应报文    科目优惠费用  subjcetDetailList   subjectDisFee   N   NUMBER(32)  单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
            响应报文    科目调整费用  subjcetDetailList   subjcetAdjustFee    N   NUMBER(32)  单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
            响应报文    科目费用    subjcetDetailList   subjectFee  Y   NUMBER(32)  单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
            响应报文    当前页码    responseMessage pageNumber  N   VARCHAR(32) 当前页码
            响应报文    总页码 responseMessage totalCount  N   VARCHAR(32) 总条数(billList的条数)
            响应报文    查询开始时间  responseMessage queryStartTime  N   VARCHAR(14) 
            响应报文    查询结束时间  responseMessage queryEndTime    N   VARCHAR(14) 

     */
    public String getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
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
    public List<ServiceId> getServiceIdList() {
        return serviceIdList;
    }
    public void setServiceIdList(List<ServiceId> serviceIdList) {
        this.serviceIdList = serviceIdList;
    }
    public String getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }
    public String getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
    public String getQueryStartTime() {
        return queryStartTime;
    }
    public void setQueryStartTime(String queryStartTime) {
        this.queryStartTime = queryStartTime;
    }
    public String getQueryEndTime() {
        return queryEndTime;
    }
    public void setQueryEndTime(String queryEndTime) {
        this.queryEndTime = queryEndTime;
    }
 
    

}
