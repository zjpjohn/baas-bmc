package com.ai.baas.bmc.api.drmanager.parameters;

import java.io.Serializable;

/**
 * Date: 2015年12月28日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author linhan
 */
public class SubjectDetail implements Serializable{

    
    private static final long serialVersionUID = 1462207911656172530L;

    /**
     * 科目
     */
    private String subjectId;
    
    /**
     * 科目优惠费用
     * 单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
     */
    private Long subjectDisFee;
    
    /**
     * 科目调整费用
     * 单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
     */
    private Long subjcetAdjustFee;
    
    /**
     * 科目费用
     * 单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
     */
    private Long subjectFee;
    
    public String getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
    public Long getSubjectDisFee() {
        return subjectDisFee;
    }
    public void setSubjectDisFee(Long subjectDisFee) {
        this.subjectDisFee = subjectDisFee;
    }
    public Long getSubjcetAdjustFee() {
        return subjcetAdjustFee;
    }
    public void setSubjcetAdjustFee(Long subjcetAdjustFee) {
        this.subjcetAdjustFee = subjcetAdjustFee;
    }
    public Long getSubjectFee() {
        return subjectFee;
    }
    public void setSubjectFee(Long subjectFee) {
        this.subjectFee = subjectFee;
    }
    
    @Override
    public String toString() {
        return "SubjectDetail [subjectId=" + subjectId + ", subjectDisFee=" + subjectDisFee
                + ", subjcetAdjustFee=" + subjcetAdjustFee + ", subjectFee=" + subjectFee + "]";
    }
    
    
}
