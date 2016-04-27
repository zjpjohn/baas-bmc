package com.ai.baas.bmc.api.proferentialprocuct.params;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.baas.bmc.api.proferentialprocuct.interfaces.IProferProductManageSV;
import com.ai.opt.base.vo.BaseInfo;
/**
 * 优惠产品添加入参
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProferProductVO extends BaseInfo {

	
	 
	private static final long serialVersionUID = 1L;

	/**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotBlank(message="消息流水号不能为空",groups={IProferProductManageSV.AddProferProduct.class,IProferProductManageSV.AddDiscontProduct.class})
	private String tradeSeq;
	
	/**
	 * 产品Id
	 */
	@NotNull(message="产品Id不能为空",groups={IProferProductManageSV.UpdateProferProduct.class})
	private Long productId;
	
	/**
	 * 优惠产品类型，必填
	 */
	@NotBlank(message="优惠产品类型不能为空",groups={IProferProductManageSV.AddProferProduct.class,IProferProductManageSV.AddDiscontProduct.class})
	private String productType;
	
	
	/**
	 * 优惠活动名称
	 */
	@NotBlank(message="优惠活动名称不能为空",groups={IProferProductManageSV.AddProferProduct.class,IProferProductManageSV.AddDiscontProduct.class})
	@Size(max=64,message="活动名称不能超过64")
	private String programName;
	
	/**
	 * 规则金额
	 */
	@NotNull(message="优惠规则不能为空",groups={IProferProductManageSV.AddProferProduct.class,IProferProductManageSV.AddDiscontProduct.class})
	private double ruleAmount;
	/**
	 * 规则单位
	 */
	@NotBlank(message="优惠单位不能为空",groups={IProferProductManageSV.AddProferProduct.class,IProferProductManageSV.AddDiscontProduct.class})
	private String ruleUnit;
	/**
	 * 满减金额
	 */
	@NotNull(message="满减金额不能为空",groups={IProferProductManageSV.AddDiscontProduct.class})
	private double reduceAmount;
	
	/**
	 * 生效日期，必填
	 */
	@NotNull(message="生效日期不能为空",groups={IProferProductManageSV.AddProferProduct.class,IProferProductManageSV.AddDiscontProduct.class})
	private Timestamp activeDate;
	
	/**
	 * 失效时间，必填
	 */
	@NotNull(message=" 失效时间不能为空",groups={IProferProductManageSV.AddProferProduct.class,IProferProductManageSV.AddDiscontProduct.class})
	private Timestamp invalidDate;
	/**
	 * 备注
	 */
	@Size(max=1024,message="备注长度不能超过1024")
	private String comments;
	/**
	 * 已选择的产品列表,必填
	 */
	private List<String> productList;

	/**
	 * 操作员Id
	 */
	private String operatorId;
	
	/**
	 * 满赠数据
	 */
	private List<FullPresent> presentList;
	/**
	 * 资费编码
	 */
	private String priceCode;
	/**
	 * 满减Id
	 */
	private Long reduceId;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public double getRuleAmount() {
		return ruleAmount;
	}
	public void setRuleAmount(double ruleAmount) {
		this.ruleAmount = ruleAmount;
	}
	public String getRuleUnit() {
		return ruleUnit;
	}
	public void setRuleUnit(String ruleUnit) {
		this.ruleUnit = ruleUnit;
	}
	public double getReduceAmount() {
		return reduceAmount;
	}
	public void setReduceAmount(double reduceAmount) {
		this.reduceAmount = reduceAmount;
	}
	public Timestamp getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(Timestamp activeDate) {
		this.activeDate = activeDate;
	}
	public Timestamp getInvalidDate() {
		return invalidDate;
	}
	public void setInvalidDate(Timestamp invalidDate) {
		this.invalidDate = invalidDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	
	
	
	public List<String> getProductList() {
		return productList;
	}
	public void setProductList(List<String> productList) {
		this.productList = productList;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public List<FullPresent> getPresentList() {
		return presentList;
	}
	public void setPresentList(List<FullPresent> presentList) {
		this.presentList = presentList;
	}
	public String getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}
	public Long getReduceId() {
		return reduceId;
	}
	public void setReduceId(Long reduceId) {
		this.reduceId = reduceId;
	}
	
	
}
