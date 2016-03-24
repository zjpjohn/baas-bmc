package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BlSubsComm;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsCommCriteria;
import com.ai.baas.bmc.dao.mapper.bo.BlSubsCommKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlSubsCommMapper {
    int countByExample(BlSubsCommCriteria example);

    int deleteByExample(BlSubsCommCriteria example);

    int deleteByPrimaryKey(BlSubsCommKey key);

    int insert(BlSubsComm record);

    int insertSelective(BlSubsComm record);

    List<BlSubsComm> selectByExample(BlSubsCommCriteria example);

    BlSubsComm selectByPrimaryKey(BlSubsCommKey key);

    int updateByExampleSelective(@Param("record") BlSubsComm record, @Param("example") BlSubsCommCriteria example);

    int updateByExample(@Param("record") BlSubsComm record, @Param("example") BlSubsCommCriteria example);

    int updateByPrimaryKeySelective(BlSubsComm record);

    int updateByPrimaryKey(BlSubsComm record);
}