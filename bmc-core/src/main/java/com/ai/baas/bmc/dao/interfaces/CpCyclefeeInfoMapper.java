package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpCyclefeeInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpCyclefeeInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpCyclefeeInfoMapper {
    int countByExample(CpCyclefeeInfoCriteria example);

    int deleteByExample(CpCyclefeeInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(CpCyclefeeInfo record);

    int insertSelective(CpCyclefeeInfo record);

    List<CpCyclefeeInfo> selectByExample(CpCyclefeeInfoCriteria example);

    CpCyclefeeInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CpCyclefeeInfo record, @Param("example") CpCyclefeeInfoCriteria example);

    int updateByExample(@Param("record") CpCyclefeeInfo record, @Param("example") CpCyclefeeInfoCriteria example);

    int updateByPrimaryKeySelective(CpCyclefeeInfo record);

    int updateByPrimaryKey(CpCyclefeeInfo record);
}