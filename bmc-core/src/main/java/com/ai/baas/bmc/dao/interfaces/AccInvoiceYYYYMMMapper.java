package com.ai.baas.bmc.dao.interfaces;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.baas.bmc.dao.mapper.bo.AccInvoiceYYYYMM;
import com.ai.baas.bmc.dao.mapper.bo.AccInvoiceYYYYMMCriteria;

public interface AccInvoiceYYYYMMMapper {
    int countByExample(@Param("currentMonth") String currentMonth,@Param("accInvoiceYYYYMMCriteria") AccInvoiceYYYYMMCriteria example);

    int deleteByExample(AccInvoiceYYYYMMCriteria example);

    int insert(AccInvoiceYYYYMM record);

    int insertSelective(AccInvoiceYYYYMM record);

    List<AccInvoiceYYYYMM> selectByExample(@Param("currentMonth") String currentMonth, @Param("accInvoiceYYYYMMCriteria") AccInvoiceYYYYMMCriteria example);

    int updateByExampleSelective(@Param("record") AccInvoiceYYYYMM record, @Param("example") AccInvoiceYYYYMMCriteria example);

    int updateByExample(@Param("record") AccInvoiceYYYYMM record, @Param("example") AccInvoiceYYYYMMCriteria example);
}