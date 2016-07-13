package com.ai.baas.bmc.api.drmanager.parameters;

import java.io.Serializable;
import java.util.List;

/**
 * Date: 2015年12月28日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author linhan
 */
public class Bills implements Serializable{

    private static final long serialVersionUID = -4166289404621266010L;

    /**
     * 账期，月账期格式：YYYYMM
     */
    private String billMonth;
    
    /**
     * 优惠费用，
     * 折扣费用，单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
     */
    private Long disFee;
    
    /**
     * 调整费用
     * 调整费用，单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入。正数为调增、负数为调减，0为未调整。
     */
    private Long adjustFee;
    
    /**
     * 总费用
     * 该用户当前账单总额。单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
     */
    private Long totalFee; 
    
    /**
     * 账单明细列表，可空
     */
    private List<SubjectDetail> subjectDetailList;
    
    public String getBillMonth() {
        return billMonth;
    }
    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
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
    public List<SubjectDetail> getSubjectDetailList() {
        return subjectDetailList;
    }
    public void setSubjectDetailList(List<SubjectDetail> subjectDetailList) {
        this.subjectDetailList = subjectDetailList;
    }
    
    @Override
    public String toString() {
        return "Bills [billMonth=" + billMonth + ", disFee=" + disFee + ", adjustFee=" + adjustFee
                + ", totalFee=" + totalFee + ", subjectDetailList=" + subjectDetailList + "]";
    }
    
    
}
