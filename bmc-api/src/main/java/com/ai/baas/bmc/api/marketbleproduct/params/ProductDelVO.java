package com.ai.baas.bmc.api.marketbleproduct.params;

import javax.validation.constraints.NotNull;

import com.ai.baas.bmc.api.marketbleproduct.interfaces.IProductManageSV;
import com.ai.opt.base.vo.BaseInfo;
/**
 * 删除产品入参
 *
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author gaogang
 */
public class ProductDelVO extends BaseInfo {

	private static final long serialVersionUID = 1L;
	
	 /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     * VARCHAR(32)
     */
	@NotNull(message="消息流水号不能为空",groups={IProductManageSV.DelProduct.class})
	private String tradeSeq;
	/**
	 * 产品Id
	 */
	@NotNull(message="产品Id不能为空",groups={IProductManageSV.DelProduct.class})
	private String producntId;

	public String getProducntId() {
		return producntId;
	}

	public void setProducntId(String producntId) {
		this.producntId = producntId;
	}

	public String getTradeSeq() {
		return tradeSeq;
	}

	public void setTradeSeq(String tradeSeq) {
		this.tradeSeq = tradeSeq;
	}
	
	
}
