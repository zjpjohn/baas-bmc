package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpFullReduce;
import com.ai.baas.bmc.dao.mapper.bo.CpFullReduceCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpFullReduceMapper {
    int countByExample(CpFullReduceCriteria example);

    int deleteByExample(CpFullReduceCriteria example);

    int deleteByPrimaryKey(Long reduceId);

    int insert(CpFullReduce record);

    int insertSelective(CpFullReduce record);

    List<CpFullReduce> selectByExample(CpFullReduceCriteria example);

    CpFullReduce selectByPrimaryKey(Long reduceId);

    int updateByExampleSelective(@Param("record") CpFullReduce record, @Param("example") CpFullReduceCriteria example);

    int updateByExample(@Param("record") CpFullReduce record, @Param("example") CpFullReduceCriteria example);

    int updateByPrimaryKeySelective(CpFullReduce record);

    int updateByPrimaryKey(CpFullReduce record);
}