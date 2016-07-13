package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BmcUseQuery;
import com.ai.baas.bmc.dao.mapper.bo.BmcUseQueryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmcUseQueryMapper {
    int countByExample(BmcUseQueryCriteria example);

    int deleteByExample(BmcUseQueryCriteria example);

    int deleteByPrimaryKey(Integer uniqueId);

    int insert(BmcUseQuery record);

    int insertSelective(BmcUseQuery record);

    List<BmcUseQuery> selectByExample(BmcUseQueryCriteria example);

    BmcUseQuery selectByPrimaryKey(Integer uniqueId);

    int updateByExampleSelective(@Param("record") BmcUseQuery record, @Param("example") BmcUseQueryCriteria example);

    int updateByExample(@Param("record") BmcUseQuery record, @Param("example") BmcUseQueryCriteria example);

    int updateByPrimaryKeySelective(BmcUseQuery record);

    int updateByPrimaryKey(BmcUseQuery record);
}