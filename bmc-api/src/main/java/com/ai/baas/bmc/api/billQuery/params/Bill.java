package com.ai.baas.bmc.api.billQuery.params;

import java.util.List;

import javax.security.auth.Subject;

public class Bill {

    private String billDuration;
    private String orgFee;
    private String disFee;
    private String adjustFee;
    private String totalfee;
    private List<SubjectDetail> subjcetDetailList;
    /**
     * 账期   billList    billDuration    Y   VARCHAR(32) 月账期：YYYYMM
            原始费用    billList    orgFee  N   NUMBER(32)  
            优惠费用    billList    disFee  N   NUMBER(32)  折扣费用，单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
            调整费用    billList    adjustFee   N   NUMBER(32)  调整费用，单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入。正数为调增、负数为调减，0为未调整。
            总费用 billList    totalfee    Y   NUMBER(32)  该用户本月账单总额。单位：厘，整数。计费中心在接口中转换时不足1厘的小数部分四舍五入
            账单明细列表  billList    subjcetDetailList   *   List    可以是空链表，按科目的维度列出账单明细

     */
    public String getBillDuration() {
        return billDuration;
    }
    public void setBillDuration(String billDuration) {
        this.billDuration = billDuration;
    }
    public String getOrgFee() {
        return orgFee;
    }
    public void setOrgFee(String orgFee) {
        this.orgFee = orgFee;
    }
    public String getDisFee() {
        return disFee;
    }
    public void setDisFee(String disFee) {
        this.disFee = disFee;
    }
    public String getAdjustFee() {
        return adjustFee;
    }
    public void setAdjustFee(String adjustFee) {
        this.adjustFee = adjustFee;
    }
    public String getTotalfee() {
        return totalfee;
    }
    public void setTotalfee(String totalfee) {
        this.totalfee = totalfee;
    }
    public List<SubjectDetail> getSubjcetDetailList() {
        return subjcetDetailList;
    }
    public void setSubjcetDetailList(List<SubjectDetail> subjcetDetailList) {
        this.subjcetDetailList = subjcetDetailList;
    }
    
}
