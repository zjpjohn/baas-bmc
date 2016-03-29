package com.ai.baas.bmc.api.marketbleproduct.params;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.ai.baas.bmc.api.marketbleproduct.interfaces.IProductManageSV;
import com.ai.opt.base.vo.BaseInfo;

/**
 * 新建产品入参
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProductVO extends BaseInfo{

	
	private static final long serialVersionUID = 1L;
	
	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotNull(message="消息流水号不能为空",groups={IProductManageSV.AddProduct.class})
	private String tradeSeq;

	/**
	 * 计费类型
	 */
	@NotNull(message="计费类型不能为空",groups={IProductManageSV.AddProduct.class})
	private String billingType;
	
	/**
	 * 产品（包）名称,必填
	 */
	@NotNull(message="产品（包）名称不能为空",groups={IProductManageSV.AddProduct.class})
	private String productName;
	/**
	 * 主产品使用量，必填
	 */
	private List<ServiceVO> majorProductAmount;
	
	/**
	 * 关联产品使用量
	 */
	private List<ServiceVO> relatedProductAmount;
	/**
	 * 阶梯价格是否相同
	 */
	private String isPriceEqual;
	
	/**
	 * 执行资费标准，取值范围：1，资源透支时 2，超出资源后
	 */
	private String standardPriceType;
	
	/**
	 * 产品生效日期 
	 */
	@NotNull(message="生效日期不能为空",groups={IProductManageSV.AddProduct.class})
	private Timestamp activeDate;
	/**
	 * 产品失效日期
	 */
	@NotNull(message="失效日期不能为空",groups={IProductManageSV.AddProduct.class})
	private Timestamp invalidDate;
	
	/**
	 * 创建标识，取值范围：UPDATE：更新；CREATE：创建；DELETE：删除
	 */
	private String updateId;
	
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public List<ServiceVO> getMajorProductAmount() {
		return majorProductAmount;
	}
	public void setMajorProductAmount(List<ServiceVO> majorProductAmount) {
		this.majorProductAmount = majorProductAmount;
	}
	public List<ServiceVO> getRelatedProductAmount() {
		return relatedProductAmount;
	}
	public void setRelatedProductAmount(List<ServiceVO> relatedProductAmount) {
		this.relatedProductAmount = relatedProductAmount;
	}
	public String getStandardPriceType() {
		return standardPriceType;
	}
	public void setStandardPriceType(String standardPriceType) {
		this.standardPriceType = standardPriceType;
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
	public String getIsPriceEqual() {
		return isPriceEqual;
	}
	public void setIsPriceEqual(String isPriceEqual) {
		this.isPriceEqual = isPriceEqual;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	
	
}