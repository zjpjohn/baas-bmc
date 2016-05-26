package com.ai.baas.bmc.api.drmanager.parameters;

import com.ai.opt.base.vo.BaseInfo;

/**账单查询输入信息类
 * 
 * Date: 2015年12月31日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author ygz
 */
public class BillQueryInputObject extends BaseInfo {
	private static final long serialVersionUID = 2469873566093239374L;
    public static String strInParent = "BillQuery";
	//private String tenantId;
    /**
     * 系统ID，必填，最长32字节
     */
	private String systemId;
    /**
     * 消息流水，必填，最长32字节
     */
	private String msgSeq;
	
    /**客户ID
     *  必填，最长32字节
     */
	private String custId;
	
    /**用户订购标识
     *  非必填，最长32字节
     */
	private String subsId;
	
    /**服务号码
     * 非必填，最长32字节，电信行业使用|充电桩业务填写卡号
     */
	private String serviceNum;
	
	/**是否分页
	 * 必填，1表示不支持分页查询全部，0表示支持分页按照分页参数查询
	 */
	private Integer flag;
	
    /**页码
     *非必填，
     */
	private Integer pageNum;
	
    /**每页条数
     *非必填，
     */
	private Integer pageCountNum;
	
    /**查询开始时间
     *查询开始时间，格式YYYYMMDDHH24MISS，例如：20151001000000。
     *返回的结果是从这个开始时间到结束时间的所有账期的账单。
     *缺省是系统时间
     */
    private String queryStartTime;
    
    /**查询结束时间，格式YYYYMMDDHH24MISS，例如：20151001000000。
     *缺省是系统时间
     */
    private String queryEndTime;
    

	public Integer getFlag() {
        return flag;
    }
    public void setFlag(Integer flag) {
        this.flag = flag;
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
	
	public String getSubsId() {
		return subsId;
	}
	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}
	
	public String getServiceNum() {
		return serviceNum;
	}
	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}
	
    public Integer getPageNum() {
        return pageNum;
    }
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    
    public Integer getPageCountNum() {
        return pageCountNum;
    }
    public void setPagecountNum(Integer pagecountNum) {
        this.pageCountNum = pagecountNum;
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
        return "BillQueryInput [tenantId=" + super.getTenantId() + ", systemId=" + systemId + ", msgSeq="
                + msgSeq + ", custId=" + custId + ", subsId=" + subsId + ", serviceNum="
                + serviceNum + ", pageNum=" + pageNum + ", pagecountNum=" + pageCountNum
                + ", queryStartTime=" + queryStartTime + ", queryEndTime=" + queryEndTime + "]";
	}	

}
