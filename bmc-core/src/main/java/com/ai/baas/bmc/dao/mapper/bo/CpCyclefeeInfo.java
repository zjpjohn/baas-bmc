package com.ai.baas.bmc.dao.mapper.bo;

public class CpCyclefeeInfo {
    private Long id;

    private String cycleFeeTpye;

    private Long cycleFee;

    private String detailCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCycleFeeTpye() {
        return cycleFeeTpye;
    }

    public void setCycleFeeTpye(String cycleFeeTpye) {
        this.cycleFeeTpye = cycleFeeTpye == null ? null : cycleFeeTpye.trim();
    }

    public Long getCycleFee() {
        return cycleFee;
    }

    public void setCycleFee(Long cycleFee) {
        this.cycleFee = cycleFee;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode == null ? null : detailCode.trim();
    }
}