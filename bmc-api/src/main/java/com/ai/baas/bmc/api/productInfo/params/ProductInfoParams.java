package com.ai.baas.bmc.api.productInfo.params;

import java.util.List;

import com.ai.opt.base.vo.BaseInfo;


/**
 * 客户基本信息.<br>
 * Date: 2015年10月29日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author biancx
 */
public class ProductInfoParams extends BaseInfo{
	private static final long serialVersionUID = 4282823455434286688L;
	/**
	 * 产品编码
	 */
	private String productId;
	/**
	 * 
	 */
	private Long cycleFee;
	/**
	 * 周期费类型  MONTH,YEAR,DAY
	 */
	private String cycleFeeTpye;
	/**
	 * 产品包列表
	 */
	private List<PackgeListParams> packgeList;
	/**
	 * 初始计费方式
	 * 取值：
	 *	HALF：半月套餐方式
	 *	FULL：全月套餐方式
	 *	OUTP：套外资费方式
	 *	PDAY：首月按天收取
	 * 
	 */
	private String billingType;
	/**
	 * 优惠类型    取值：1：总费用优惠；如果【用户订购信息接口】填写该字段，则【套餐包产品信息接口】中的取值将失效，以这里的取值为准
	 */
	private String disItem;
	/**
	 * 优惠方式       与优惠类型联用，取值：
	 *	RET：返还
	 * DIS：折扣
	 */
	private String disType;
	/**
	 * 优惠值类型   与优惠类型联用。取值：
	 *	USGP：使用量的百分比
	 * FIX：固定值
	 */
	private String disValueType;
	/**
	 * 优惠值    与优惠类型联用
	 */
	private String disValue;
	/**
	 * 生效日期     YYYYMMDDHH24MISS
	 */
	private String activeTime;
	/**
	 * 失效日期   YYYYMMDDHH24MISS 
	 */
	private String inactiveTime;
	/**
	 * 套餐原始费用
	 */
	private String orginFee;
	/**
	 * 套餐优惠后费用   
	 */
	private String discountFee;
	/**
	 * 系统ID
	 */
	private String systemId;
	/**
	 * 消息流水
	 */
	private String msgSeq;
	/*
	 * 商品类型
	 */
	private String productType;
	
	public String getProductType(){
	    return productType;
	}
	public void setProductType(String productType){
	    this.productType = productType;
	}
	public String getProductId() {
		return productId==null?null:productId.trim();
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Long getCycleFee(){
		return cycleFee;
	}
	public void setCycleFee(Long cycleFee){
		this.cycleFee = cycleFee;
	}
	public String getCycleFeeTpye() {
		return cycleFeeTpye;
	}
	public void setCycleFeeTpye(String cycleFeeTpye) {
		this.cycleFeeTpye = cycleFeeTpye;
	}
	public List<PackgeListParams> getPackgeList() {
		return packgeList;
	}
	public void setPackgeList(List<PackgeListParams> packgeList) {
		this.packgeList = packgeList;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getDisItem() {
		return disItem;
	}
	public void setDisItem(String disItem) {
		this.disItem = disItem;
	}
	public String getDisType() {
		return disType;
	}
	public void setDisType(String disType) {
		this.disType = disType;
	}
	public String getDisValueType() {
		return disValueType;
	}
	public void setDisValueType(String disValueType) {
		this.disValueType = disValueType;
	}
	public String getDisValue() {
		return disValue;
	}
	public void setDisValue(String disValue) {
		this.disValue = disValue;
	}
	public String getActiveTime() {
		return activeTime==null?null:activeTime.trim();
	}
	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	public String getInactiveTime() {
		return inactiveTime==null?null:inactiveTime.trim();
	}
	public void setInactiveTime(String inactiveTime) {
		this.inactiveTime = inactiveTime;
	}
	public String getOrginFee() {
		return orginFee;
	}
	public void setOrginFee(String orginFee) {
		this.orginFee = orginFee;
	}
	public String getDiscountFee() {
		return discountFee;
	}
	public void setDiscountFee(String discountFee) {
		this.discountFee = discountFee;
	}
	public String getSystemId() {
		return systemId==null?null:systemId.trim();
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

}
