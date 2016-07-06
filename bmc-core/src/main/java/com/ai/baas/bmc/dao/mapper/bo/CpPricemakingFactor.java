package com.ai.baas.bmc.dao.mapper.bo;

public class CpPricemakingFactor extends CpPricemakingFactorKey {
    private Long id;

    private String factorValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(String factorValue) {
        this.factorValue = factorValue == null ? null : factorValue.trim();
    }
}