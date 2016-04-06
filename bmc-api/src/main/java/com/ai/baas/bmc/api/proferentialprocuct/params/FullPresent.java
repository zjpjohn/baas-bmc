package com.ai.baas.bmc.api.proferentialprocuct.params;

import java.sql.Timestamp;
import java.util.List;
/**
 * 满减表的相关信息
 *
 * Date: 2016年4月6日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class FullPresent {

	
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
	private List<Integer> giftProList;
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
	public List<Integer> getGiftProList() {
		return giftProList;
	}
	public void setGiftProList(List<Integer> giftProList) {
		this.giftProList = giftProList;
	}
	
	
	
}
