package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpFactorInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpFactorInfoMapper {
    int countByExample(CpFactorInfoCriteria example);

    int deleteByExample(CpFactorInfoCriteria example);

    int deleteByPrimaryKey(Integer factorInfoId);

    int insert(CpFactorInfo record);

    int insertSelective(CpFactorInfo record);

    List<CpFactorInfo> selectByExample(CpFactorInfoCriteria example);

    CpFactorInfo selectByPrimaryKey(Integer factorInfoId);

    int updateByExampleSelective(@Param("record") CpFactorInfo record, @Param("example") CpFactorInfoCriteria example);

    int updateByExample(@Param("record") CpFactorInfo record, @Param("example") CpFactorInfoCriteria example);

    int updateByPrimaryKeySelective(CpFactorInfo record);

    int updateByPrimaryKey(CpFactorInfo record);
}