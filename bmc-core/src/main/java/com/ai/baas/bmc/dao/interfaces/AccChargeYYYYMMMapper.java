package com.ai.baas.bmc.dao.interfaces;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.baas.bmc.dao.mapper.bo.AccChargeYYYYMM;
import com.ai.baas.bmc.dao.mapper.bo.AccChargeYYYYMMCriteria;

public interface AccChargeYYYYMMMapper {
    int countByExample(@Param("currentMonth") String currentMonth,@Param("accChargeYYYYMMCriteria") AccChargeYYYYMMCriteria example);

    int deleteByExample(AccChargeYYYYMMCriteria example);

    int insert(AccChargeYYYYMM record);

    int insertSelective(AccChargeYYYYMM record);

    List<AccChargeYYYYMM> selectByExample(@Param("currentMonth") String currentMonth,@Param("accChargeYYYYMMCriteria") AccChargeYYYYMMCriteria example);

    int updateByExampleSelective(@Param("record") AccChargeYYYYMM record, @Param("example") AccChargeYYYYMMCriteria example);

    int updateByExample(@Param("record") AccChargeYYYYMM record, @Param("example") AccChargeYYYYMMCriteria example);
}