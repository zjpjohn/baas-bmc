package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpFullPresent;
import com.ai.baas.bmc.dao.mapper.bo.CpFullPresentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpFullPresentMapper {
    int countByExample(CpFullPresentCriteria example);

    int deleteByExample(CpFullPresentCriteria example);

    int deleteByPrimaryKey(Long presentId);

    int insert(CpFullPresent record);

    int insertSelective(CpFullPresent record);

    List<CpFullPresent> selectByExample(CpFullPresentCriteria example);

    CpFullPresent selectByPrimaryKey(Long presentId);

    int updateByExampleSelective(@Param("record") CpFullPresent record, @Param("example") CpFullPresentCriteria example);

    int updateByExample(@Param("record") CpFullPresent record, @Param("example") CpFullPresentCriteria example);

    int updateByPrimaryKeySelective(CpFullPresent record);

    int updateByPrimaryKey(CpFullPresent record);
}