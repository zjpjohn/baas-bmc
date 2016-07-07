package com.ai.baas.bmc.api.drmanager.parameters;

public class DrQueryOutputObjectList implements java.io.Serializable {
	private String productId;		
	private String roamType;
	private String longType;
	private String fee;
	private String visitArea;
	private String upStream;
	private String downStream;
	private String beganTime;
	private String duration;
	private String apnCode;
	
	
	public String getApnCode() {
		return apnCode;
	}
	public void setApnCode(String apnCode) {
		this.apnCode = apnCode;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getRoamType() {
		return roamType;
	}
	public void setRoamType(String roamType) {
		this.roamType = roamType;
	}
	public String getLongType() {
		return longType;
	}
	public void setLongType(String longType) {
		this.longType = longType;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String strfee) {
		fee = strfee;
	}
	public String getVisitArea() {
		return visitArea;
	}
	public void setVisitArea(String visitArea) {
		this.visitArea = visitArea;
	}
	public String getUpStream() {
		return upStream;
	}
	public void setUpStream(String upStream) {
		this.upStream = upStream;
	}
	public String getDownStream() {
		return downStream;
	}
	public void setDownStream(String downStream) {
		this.downStream = downStream;
	}
	public String getBeganTime() {
		return beganTime;
	}
	public void setBeganTime(String beganTime) {
		this.beganTime = beganTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "DrQueryOutputObjectList [productId=" + productId + ", roamType=" + roamType + ", longType=" + longType
				+ ", fee=" + fee + ", visitArea=" + visitArea + ", upStream=" + upStream + ", downStream=" + downStream
				+ ", beganTime=" + beganTime + ", duration=" + duration + "]";
	}
}