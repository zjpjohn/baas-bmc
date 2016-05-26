package com.ai.baas.bmc.api.drmanager.parameters;

import java.util.List;

public class BillQueryOutputObjectList implements java.io.Serializable {
	private String subsId;	
	private int disFee;
	private int adjustFee;
	private int totalfee;
	private List<BillQueryOutputObjectListsubjcetDetail> subjcetDetails;

	public String getSubsId() {
		return subsId;
	}

	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}

	public int getDisFee() {
		return disFee;
	}

	public void setDisFee(int disFee) {
		this.disFee = disFee;
	}

	public int getAdjustFee() {
		return adjustFee;
	}

	public void setAdjustFee(int adjustFee) {
		this.adjustFee = adjustFee;
	}

	public int getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(int totalfee) {
		this.totalfee = totalfee;
	}

	public List<BillQueryOutputObjectListsubjcetDetail> getSubjcetDetails() {
		return subjcetDetails;
	}

	public void setSubjcetDetails(List<BillQueryOutputObjectListsubjcetDetail> subjcetDetails) {
		this.subjcetDetails = subjcetDetails;
	}

	@Override
	public String toString() {
		return "BillQueryOutputObjectList [subsId=" + subsId + ", disFee=" + disFee + ", adjustFee=" + adjustFee
				+ ", totalfee=" + totalfee + ", subjcetDetails=" + subjcetDetails + "]";
	}

}
