package com.ai.baas.bmc.api.drmanager.parameters;

public class UseQueryOutputObjectSubListProductList implements java.io.Serializable {
	private String productId;
	private String visitArea;
	private String resType;
	private String amount;
	private String productAmount;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getVisitArea() {
		return visitArea;
	}
	public void setVisitArea(String visitArea) {
		this.visitArea = visitArea;
	}
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}
	@Override
	public String toString() {
		return "UseQueryOutputObjectSubsIdProductList [productId=" + productId + ", visitArea=" + visitArea
				+ ", resType=" + resType + ", amount=" + amount + ", productAmount=" + productAmount + "]";
	}
	
}
