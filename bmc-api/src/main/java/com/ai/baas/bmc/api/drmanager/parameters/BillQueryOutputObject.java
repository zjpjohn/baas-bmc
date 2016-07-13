package com.ai.baas.bmc.api.drmanager.parameters;

import java.util.List;


/**账单查询输出信息类
 * 
 * Date: 2015年12月31日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author ygz
 */
public class BillQueryOutputObject implements java.io.Serializable {
	private static final long serialVersionUID = 930851648622668266L;

    public static String strOutParent = "responseMessage";
	
    /**返回码
     *必填，14字节，BMC-000000成功；其他失败
     */
	private String returnCode;

    /**租户ID
     *必填，32字节
     */
	private String tenantId;
	
    /**系统ID
     *必填，32字节
     */
	private String systemId;
	
    /**消息流水
     * 必填，32字节
     */
	private String msgSeq;
	
    /**客户ID
     * 必填，32字节
     */
	private String custId;
	
    /**用户列表
     * 可空
     */
    private List<Subs> subList;
    
    /**当前页码
     * 非必填，32字节
     */
    private String pageNum;
    
    /**总条数(billList的条数)
     *非必填，32字节
     */
    private String totalCount;
    
    /**查询开始时间
     *非必填，格式YYYYMMDDHH24MISS，例如：20151001000000。
     */
    private String queryStartTime;
    
    /**查询结束时间
     *非必填，格式YYYYMMDDHH24MISS，例如：20151001000000。
     */
    private String queryEndTime;
    
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
	public String getCustId() {
		return custId;
	}
	
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
    public List<Subs> getSubList() {
        return subList;
    }
    public void setSubList(List<Subs> subList) {
        this.subList = subList;
    }
    public String getPageNum() {
        return pageNum;
    }
    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
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
    
	@Override
	public String toString() {
        return "BillQueryOutput [returnCode=" + returnCode + ", tenantId=" + tenantId
                + ", systemId=" + systemId + ", msgSeq=" + msgSeq + ", custId=" + custId
                + ", subList=" + subList + ", pageNum=" + pageNum + ", totalCount=" + totalCount
                + ", queryStartTime=" + queryStartTime + ", queryEndTime=" + queryEndTime + "]";
	}	
}
