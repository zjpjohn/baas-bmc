package com.ai.baas.bmc.api.drmanager.parameters;



import java.util.List;

/**
 * Date: 2015年12月5日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author Administrator
 */
public class ResponseMessage {

    
    /**
     * 返回码 BMC-000000成功；其他失败
     */
    private String returnCode;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 系统ID
     */
    private String systemId;
    /**
     * 消息流水
     */
    private String msgSeq;
    /**
     * 编码列表 列表的大小可以为0,1，或者多个
     */
    private List<Code> codeList;
    
    /**
     * 当前页码 当前页码
     */
    private String pageNum;
    /**
     * 总页码 总条数
     */
    private String totalcount;
    public String getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    public String getSystemId() {
        return systemId;
    }
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
    public String getMsgSeq() {
        return msgSeq;
    }
    public void setMsgSeq(String msgSeq) {
        this.msgSeq = msgSeq;
    }
    public List<Code> getCodeList() {
        return codeList;
    }
    public void setCodeList(List<Code> codeList) {
        this.codeList = codeList;
    }
    public String getPageNum() {
        return pageNum;
    }
    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }
    public String getTotalcount() {
        return totalcount;
    }
    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }
    @Override
    public String toString() {
        return "ResponseMessage [returnCode=" + returnCode + ", tenantId=" + tenantId
                + ", systemId=" + systemId + ", msgSeq=" + msgSeq + ", codeList=" + codeList
                + ", pageNum=" + pageNum + ", totalcount=" + totalcount + "]";
    }
    
    
}
