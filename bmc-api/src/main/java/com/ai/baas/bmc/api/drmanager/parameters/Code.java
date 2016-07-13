package com.ai.baas.bmc.api.drmanager.parameters;



import java.io.Serializable;

/**
 * Date: 2015年12月5日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author Administrator
 */
public class Code implements Serializable{

    /**
     * 编码类型
     */
    private String codeType;
    /**
     * 代码名称 代码名称
     */
    private String codeName;
    /**
     * 代码标签
     */
    private String labelName;
    /**
     * 缺省值
     */
    private String defaultValue;
    /**
     * 参考代码描述 代码含义描述
     */
    private String comments;
    public String getCodeType() {
        return codeType;
    }
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
    public String getCodeName() {
        return codeName;
    }
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    public String getLabelName() {
        return labelName;
    }
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    public String getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
    
}
