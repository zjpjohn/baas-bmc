package com.ai.baas.bmc.api.drmanager.parameters;

public class BillQueryOutputObjectListsubjcetDetail implements java.io.Serializable {
	private int subjectId;
	private int subjectAisFee;
	private int subjcetAdjustFee;
	private int subjectfee;	
	private String pageNum;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getSubjectAisFee() {
		return subjectAisFee;
	}

	public void setSubjectAisFee(int subjectAisFee) {
		this.subjectAisFee = subjectAisFee;
	}

	public int getSubjcetAdjustFee() {
		return subjcetAdjustFee;
	}

	public void setSubjcetAdjustFee(int subjcetAdjustFee) {
		this.subjcetAdjustFee = subjcetAdjustFee;
	}

	public int getSubjectfee() {
		return subjectfee;
	}

	public void setSubjectfee(int subjectfee) {
		this.subjectfee = subjectfee;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "BillQueryOutputObjectListsubjcetDetail [subjectId=" + subjectId + ", subjectAisFee=" + subjectAisFee
				+ ", subjcetAdjustFee=" + subjcetAdjustFee + ", subjectfee=" + subjectfee + ", pageNum=" + pageNum
				+ "]";
	}

}
