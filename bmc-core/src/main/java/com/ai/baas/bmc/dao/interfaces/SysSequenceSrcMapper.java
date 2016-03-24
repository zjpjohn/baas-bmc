package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.SysSequenceSrc;
import com.ai.baas.bmc.dao.mapper.bo.SysSequenceSrcCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSequenceSrcMapper {
    int countByExample(SysSequenceSrcCriteria example);

    int deleteByExample(SysSequenceSrcCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(SysSequenceSrc record);

    int insertSelective(SysSequenceSrc record);

    List<SysSequenceSrc> selectByExample(SysSequenceSrcCriteria example);

    SysSequenceSrc selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysSequenceSrc record, @Param("example") SysSequenceSrcCriteria example);

    int updateByExample(@Param("record") SysSequenceSrc record, @Param("example") SysSequenceSrcCriteria example);

    int updateByPrimaryKeySelective(SysSequenceSrc record);

    int updateByPrimaryKey(SysSequenceSrc record);
}