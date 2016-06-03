package com.ai.baas.bmc.api.detailbill.params;

import java.io.Serializable;
import java.util.List;

public class VoiceResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 通话 总钱数
	 */
	private Double totalMoney;
	/**
	 * 总秒数
	 */
	private Long voiceTotal;
	/**
	 * 语音详细信息
	 */
	private List<VoiceParam> voice;
	
	public Long getVoiceTotal() {
		return voiceTotal;
	}
	public void setVoiceTotal(Long voiceTotal) {
		this.voiceTotal = voiceTotal;
	}
	public List<VoiceParam> getVoice() {
		return voice;
	}
	public void setVoice(List<VoiceParam> voice) {
		this.voice = voice;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
