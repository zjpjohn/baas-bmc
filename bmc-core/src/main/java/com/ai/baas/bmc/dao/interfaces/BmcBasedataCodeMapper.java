package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BmcBasedataCode;
import com.ai.baas.bmc.dao.mapper.bo.BmcBasedataCodeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmcBasedataCodeMapper {
    int countByExample(BmcBasedataCodeCriteria example);

    int deleteByExample(BmcBasedataCodeCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(BmcBasedataCode record);

    int insertSelective(BmcBasedataCode record);

    List<BmcBasedataCode> selectByExample(BmcBasedataCodeCriteria example);

    BmcBasedataCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BmcBasedataCode record, @Param("example") BmcBasedataCodeCriteria example);

    int updateByExample(@Param("record") BmcBasedataCode record, @Param("example") BmcBasedataCodeCriteria example);

    int updateByPrimaryKeySelective(BmcBasedataCode record);

    int updateByPrimaryKey(BmcBasedataCode record);
}