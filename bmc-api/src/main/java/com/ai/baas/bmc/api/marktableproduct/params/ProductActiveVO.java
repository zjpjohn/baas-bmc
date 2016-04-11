package com.ai.baas.bmc.api.marktableproduct.params;

import javax.validation.constraints.NotNull;

import com.ai.baas.bmc.api.marktableproduct.interfaces.IProductManageSV;
import com.ai.opt.base.vo.BaseInfo;
/**
 * 修改产品状态入参
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProductActiveVO extends BaseInfo {

	
	private static final long serialVersionUID = 1L;
	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotNull(message="消息流水号不能为空",groups={IProductManageSV.UpdateProductStatus.class})
	private String tradeSeq;
	/**
	 * 产品Id
	 */
	@NotNull(message="产品Id不能为空",groups={IProductManageSV.UpdateProductStatus.class})
	private String productId;
	/**
	 * 状态
	 */
	@NotNull(message="状态不能为空",groups={IProductManageSV.UpdateProductStatus.class})
	private String status;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTradeSeq() {
		return tradeSeq;
	}
	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	
}
