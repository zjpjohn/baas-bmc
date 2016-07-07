package com.ai.baas.bmc.api.drmanager.parameters;

import java.io.Serializable;

import com.ai.opt.base.vo.BaseInfo;

public class DrQueryInputObject extends BaseInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4782749753888195552L;
	//父节点名称 	详单查询请求
	public static String strInParent = "DrQuery";
	//private String tenantId;
	private String systemId;
	private String msgSeq;
	private String custId;
	private String subsId;
	private String serviceNum;
	private String serviceType;
	private String pageNum;
	private String pagecountNum;
	private String beginDate;
	private String endDate;
	/**
	 * 服务通道类型
	 */
	private String apnCode;
	
	

	public String getApnCode() {
		return apnCode;
	}

	public void setApnCode(String apnCode) {
		this.apnCode = apnCode;
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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
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

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String toString() {
        return "DrQueryInputObject [systemId=" + systemId + 
        		", msgSeq=" + msgSeq + ", custId=" + custId + ", serviceNum=" + serviceNum + 
        		", serviceType=" + serviceType + ", pageNum=" + pageNum + ", pagecountNum=" + pagecountNum + 
        		", beginDate=" + beginDate + ", endDate=" + endDate+ "]";  
    }  
}
