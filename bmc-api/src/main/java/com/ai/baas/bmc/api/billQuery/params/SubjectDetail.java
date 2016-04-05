package com.ai.baas.bmc.api.billQuery.params;

public class SubjectDetail {
/**
 * 科目   subjcetDetailList   subjectId   Y   VARCHAR(32) 按服务方约定填写
科目原始费用  subjcetDetailList   subjectOrgFee   N   NUMBER(32)  
科目优惠费用  subjcetDetailList   subjectDisFee   N   NUMBER(32)  单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
科目调整费用  subjcetDetailList   subjcetAdjustFee    N   NUMBER(32)  单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
科目费用    subjcetDetailList   subjectFee  Y   NUMBER(32)  单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入

 */
    private String subjectId;
    private String subjectOrgFee;
    private String subjectDisFee;
    private String subjectAdjustFee;
    private String subjectFee;
    
    public String getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
    public String getSubjectOrgFee() {
        return subjectOrgFee;
    }
    public void setSubjectOrgFee(String subjectOrgFee) {
        this.subjectOrgFee = subjectOrgFee;
    }
    public String getSubjectDisFee() {
        return subjectDisFee;
    }
    public void setSubjectDisFee(String subjectDisFee) {
        this.subjectDisFee = subjectDisFee;
    }
    public String getSubjectAdjustFee() {
        return subjectAdjustFee;
    }
    public void setSubjectAdjustFee(String subjectAdjustFee) {
        this.subjectAdjustFee = subjectAdjustFee;
    }
    public String getSubjectFee() {
        return subjectFee;
    }
    public void setSubjectFee(String subjectFee) {
        this.subjectFee = subjectFee;
    }
    
}
