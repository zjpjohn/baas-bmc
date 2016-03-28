package com.ai.baas.bmc.api.proferentialprocuct.params;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.ai.opt.base.vo.BaseInfo;

public class ProductQueryVO extends BaseInfo {

	private static final long serialVersionUID = 1L;
	
	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotNull(message="消息流水号不能为空")
	private String tradeSeq;

	/**
	 * 优惠产品Id
	 */
	private String productId;
	
	/**
	 * 优惠产品名称
	 */
	private String productName;
	
	/**
	 * 优惠类型
	 */
	private String proferType;
	
	/**
	 * 生效日期
	 */
	private Timestamp activeDate;
	/**
	 * 失效日期
	 */
	private Timestamp invalidDate;
	
	 /**
     * 当前第几页,必填
     */
    private Integer pageNo;

    /**
     * 每页数据条数,必填
     */
    private Integer pageSize;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProferType() {
		return proferType;
	}
	public void setProferType(String proferType) {
		this.proferType = proferType;
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
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
