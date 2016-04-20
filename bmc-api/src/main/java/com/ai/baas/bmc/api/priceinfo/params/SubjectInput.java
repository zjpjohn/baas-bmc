package com.ai.baas.bmc.api.priceinfo.params;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 科目关联入参
 * Date: 2016年3月28日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangkai16
 */
public class SubjectInput extends BaseInfo {
    private static final long serialVersionUID = 34565673487L;
    /**
     * 消息流水<br>
     * 组成：租户ID + YYMMDDHH24MISS + SSS(毫秒) + 9位序列号<br>
     * 必填<br>
     */
    @NotBlank(message="消息流水不能为空")
   //@Size(max=32)
    private String tradeSeq;
    
    /**
     * 标准资费ID
     * VARCHAR(32)
     */
    @NotBlank(message="标准资费ID不能为空")
    @Size(max=32)
    private String standardId;
    
    /**
     * 科目ID
     * VARCHAR(64)
     */
    @NotBlank(message="科目ID不能为空")
    @Size(max=8)
    private String subjectCode;

    public String getTradeSeq() {
        return tradeSeq;
    }

    public void setTradeSeq(String tradeSeq) {
        this.tradeSeq = tradeSeq;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }


    
}
