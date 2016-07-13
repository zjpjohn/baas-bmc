package com.ai.baas.bmc.api.drmanager.parameters;



/**
 * Date: 2015年12月5日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author Administrator
 */
public class CodeInfoQuery {

    
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
     * 编码类型 编码类型，取值：FACTOR:参考因素类;EXT:扩展信息类;
     */
    private String codeType;
    /**
     * 页码 页码，缺省是第一页
     */
    private String pageNum;
    /**
     * 每页条数 每页条数，缺省是每页20行
     */
    private String pagecountNum;
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
    public String getCodeType() {
        return codeType;
    }
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
    public String getPageNum() {
        return pageNum;
    }
    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }
    public String getPagecountNum() {
        return pagecountNum;
    }
    public void setPagecountNum(String pagecountNum) {
        this.pagecountNum = pagecountNum;
    }
    @Override
    public String toString() {
        return "CodeInfoQuery [tenantId=" + tenantId + ", systemId=" + systemId + ", msgSeq="
                + msgSeq + ", codeType=" + codeType + ", pageNum=" + pageNum + ", pagecountNum="
                + pagecountNum + "]";
    }
    
    
    
}
