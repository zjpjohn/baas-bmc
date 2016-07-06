package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpPricemakingFactor;
import com.ai.baas.bmc.dao.mapper.bo.CpPricemakingFactorCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPricemakingFactorKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpPricemakingFactorMapper {
    int countByExample(CpPricemakingFactorCriteria example);

    int deleteByExample(CpPricemakingFactorCriteria example);

    int deleteByPrimaryKey(CpPricemakingFactorKey key);

    int insert(CpPricemakingFactor record);

    int insertSelective(CpPricemakingFactor record);

    List<CpPricemakingFactor> selectByExample(CpPricemakingFactorCriteria example);

    CpPricemakingFactor selectByPrimaryKey(CpPricemakingFactorKey key);

    int updateByExampleSelective(@Param("record") CpPricemakingFactor record, @Param("example") CpPricemakingFactorCriteria example);

    int updateByExample(@Param("record") CpPricemakingFactor record, @Param("example") CpPricemakingFactorCriteria example);

    int updateByPrimaryKeySelective(CpPricemakingFactor record);

    int updateByPrimaryKey(CpPricemakingFactor record);
}