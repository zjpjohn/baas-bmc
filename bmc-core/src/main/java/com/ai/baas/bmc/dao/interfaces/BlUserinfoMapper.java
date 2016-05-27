package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;
import com.ai.baas.bmc.dao.mapper.bo.BlUserinfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlUserinfoMapper {
    int countByExample(BlUserinfoCriteria example);

    int deleteByExample(BlUserinfoCriteria example);

    int deleteByPrimaryKey(String subsId);

    int insert(BlUserinfo record);

    int insertSelective(BlUserinfo record);

    List<BlUserinfo> selectByExample(BlUserinfoCriteria example);

    BlUserinfo selectByPrimaryKey(String subsId);

    int updateByExampleSelective(@Param("record") BlUserinfo record, @Param("example") BlUserinfoCriteria example);

    int updateByExample(@Param("record") BlUserinfo record, @Param("example") BlUserinfoCriteria example);

    int updateByPrimaryKeySelective(BlUserinfo record);

    int updateByPrimaryKey(BlUserinfo record);
}