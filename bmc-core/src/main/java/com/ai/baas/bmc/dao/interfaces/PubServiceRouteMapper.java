package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.PubServiceRoute;
import com.ai.baas.bmc.dao.mapper.bo.PubServiceRouteCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PubServiceRouteMapper {
    int countByExample(PubServiceRouteCriteria example);

    int deleteByExample(PubServiceRouteCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PubServiceRoute record);

    int insertSelective(PubServiceRoute record);

    List<PubServiceRoute> selectByExample(PubServiceRouteCriteria example);

    PubServiceRoute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PubServiceRoute record, @Param("example") PubServiceRouteCriteria example);

    int updateByExample(@Param("record") PubServiceRoute record, @Param("example") PubServiceRouteCriteria example);

    int updateByPrimaryKeySelective(PubServiceRoute record);

    int updateByPrimaryKey(PubServiceRoute record);
}