package com.ai.baas.bmc.dao.mapper.bo;

public class BmcQueryBill {
    private Integer uniqueId;

    private String tenantId;

    private String systemId;

    private Integer custId;

    private Integer subsId;

    private Long disFee;

    private Long adjustFee;

    private Long totalFee;

    private Long subjectId;

    private Long subjectAisFee;

    private Long subjectAdjustFee;

    private Long subjectFee;

    private Integer pageNum;

    private String queryMon;

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getSubsId() {
        return subsId;
    }

    public void setSubsId(Integer subsId) {
        this.subsId = subsId;
    }

    public Long getDisFee() {
        return disFee;
    }

    public void setDisFee(Long disFee) {
        this.disFee = disFee;
    }

    public Long getAdjustFee() {
        return adjustFee;
    }

    public void setAdjustFee(Long adjustFee) {
        this.adjustFee = adjustFee;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getSubjectAisFee() {
        return subjectAisFee;
    }

    public void setSubjectAisFee(Long subjectAisFee) {
        this.subjectAisFee = subjectAisFee;
    }

    public Long getSubjectAdjustFee() {
        return subjectAdjustFee;
    }

    public void setSubjectAdjustFee(Long subjectAdjustFee) {
        this.subjectAdjustFee = subjectAdjustFee;
    }

    public Long getSubjectFee() {
        return subjectFee;
    }

    public void setSubjectFee(Long subjectFee) {
        this.subjectFee = subjectFee;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getQueryMon() {
        return queryMon;
    }

    public void setQueryMon(String queryMon) {
        this.queryMon = queryMon == null ? null : queryMon.trim();
    }
}