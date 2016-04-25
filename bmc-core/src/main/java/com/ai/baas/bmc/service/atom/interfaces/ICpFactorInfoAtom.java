package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfo;


/**
 * 资费参考因素
 * Date: 2016年4月25日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author wangkai16
 */
public interface ICpFactorInfoAtom {
    
    /**
     * 通过factorCode查询
     * @param factorCode
     * @param factorName
     * @return
     * @author wangkai16
     * @ApiDocMethod
     */
    List<CpFactorInfo>  getFactorInfo (String factorCode, String factorName);
    
    

}
