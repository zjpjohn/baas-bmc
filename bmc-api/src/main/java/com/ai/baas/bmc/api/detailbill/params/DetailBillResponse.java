package com.ai.baas.bmc.api.detailbill.params;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class DetailBillResponse extends BaseResponse {

	
	private static final long serialVersionUID = 1L;
	/**
	 * 语音
	 */
	private VoiceResponse voice;
	/**
	 * 数据
	 */
	private GPRSResponse gprs;
	/**
	 * 总钱数
	 */
	private Double totalCount;
	/**
	 * 产品名称
	 */
	private List<String> productNames;
	public VoiceResponse getVoice() {
		return voice;
	}
	public void setVoice(VoiceResponse voice) {
		this.voice = voice;
	}
	public GPRSResponse getGprs() {
		return gprs;
	}
	public void setGprs(GPRSResponse gprs) {
		this.gprs = gprs;
	}
	
	public Double getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Double totalCount) {
		this.totalCount = totalCount;
	}
	public List<String> getProductNames() {
		return productNames;
	}
	public void setProductNames(List<String> productNames) {
		this.productNames = productNames;
	}
	
	
}
