package com.ai.baas.bmc.api.proferentialprocuct.params;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
/**
 * 满赠表的相关信息
 *
 * Date: 2016年4月6日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class FullPresent implements Serializable{

	
	private static final long serialVersionUID = 1L;

	/**
	 * Id
	 */
	private Long presentId;
	
	/**
	 * 赠品类型
	 */
	private String giftType;
	/**
	 * 赠品数量
	 */
	private double gitfAmount;
	
	/**
	 * 赠品生效日期
	 */
	private Timestamp giftActiveDate;
	/**
	 * 赠品失效日期
	 */
	private Timestamp giftInvalidDate;
	/**
	 *参与赠品产品列表
	 */
	private List<String> giftProList;
	/**
	 * 赠送业务周期
	 */
	private String activeCycle;
	/**
	 * 生效方式标记：
	 */
	private String activeFlag;
	
	public String getGiftType() {
		return giftType;
	}
	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}
	public double getGitfAmount() {
		return gitfAmount;
	}
	public void setGitfAmount(double gitfAmount) {
		this.gitfAmount = gitfAmount;
	}
	public Timestamp getGiftActiveDate() {
		return giftActiveDate;
	}
	public void setGiftActiveDate(Timestamp giftActiveDate) {
		this.giftActiveDate = giftActiveDate;
	}
	public Timestamp getGiftInvalidDate() {
		return giftInvalidDate;
	}
	public void setGiftInvalidDate(Timestamp giftInvalidDate) {
		this.giftInvalidDate = giftInvalidDate;
	}
	
	
	public List<String> getGiftProList() {
		return giftProList;
	}
	public void setGiftProList(List<String> giftProList) {
		this.giftProList = giftProList;
	}
	public Long getPresentId() {
		return presentId;
	}
	public void setPresentId(Long presentId) {
		this.presentId = presentId;
	}
	
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getActiveCycle() {
		return activeCycle;
	}
	public void setActiveCycle(String activeCycle) {
		this.activeCycle = activeCycle;
	}
	
	
	
}
