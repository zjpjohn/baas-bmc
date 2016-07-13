package com.ai.baas.bmc.api.drmanager.parameters;

public class OperatorFlowQueryOutputObjectList implements java.io.Serializable{
	private String dealerCode;
	private String dealerAreaCode;
	private int amount;
	private String channel;

	public String getDealerCode() {
		return dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}
	public String getDealerAreaCode() {
		return dealerAreaCode;
	}
	public void setDealerAreaCode(String dealerAreaCode) {
		this.dealerAreaCode = dealerAreaCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "OperatorFlowQueryOutputObjectList [dealerCode=" + dealerCode + ", dealerAreaCode=" + dealerAreaCode
				+ ", amount=" + amount + ", channel=" + channel + "]";
	}

}
