package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpExtInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpExtInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpExtInfoMapper {
    int countByExample(CpExtInfoCriteria example);

    int deleteByExample(CpExtInfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CpExtInfo record);

    int insertSelective(CpExtInfo record);

    List<CpExtInfo> selectByExample(CpExtInfoCriteria example);

    CpExtInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CpExtInfo record, @Param("example") CpExtInfoCriteria example);

    int updateByExample(@Param("record") CpExtInfo record, @Param("example") CpExtInfoCriteria example);

    int updateByPrimaryKeySelective(CpExtInfo record);

    int updateByPrimaryKey(CpExtInfo record);
}