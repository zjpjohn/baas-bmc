package com.ai.baas.bmc.api.marktableproduct.params;

import java.sql.Timestamp;

public class CpPriceDetailParamVo {
    private Long detailId;

    private String priceCode;

    private String detailName;

    private String chargeType;

    private Timestamp activeTime;

    private Timestamp inactiveTime;

    private String detailCode;

    private String comments;

    private String serviceType;
    
    private CpStepInfoParamVo cpStepInfoParamVo;
	public CpStepInfoParamVo getCpStepInfoParamVo() {
		return cpStepInfoParamVo;
	}

	public void setCpStepInfoParamVo(CpStepInfoParamVo cpStepInfoParamVo) {
		this.cpStepInfoParamVo = cpStepInfoParamVo;
	}

	public CpPackageInfoParamVo getCpPackageInfoParamVo() {
		return cpPackageInfoParamVo;
	}

	public void setCpPackageInfoParamVo(CpPackageInfoParamVo cpPackageInfoParamVo) {
		this.cpPackageInfoParamVo = cpPackageInfoParamVo;
	}

	private CpPackageInfoParamVo cpPackageInfoParamVo;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode == null ? null : priceCode.trim();
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName == null ? null : detailName.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }

    public Timestamp getInactiveTime() {
        return inactiveTime;
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        this.inactiveTime = inactiveTime;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode == null ? null : detailCode.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }
}