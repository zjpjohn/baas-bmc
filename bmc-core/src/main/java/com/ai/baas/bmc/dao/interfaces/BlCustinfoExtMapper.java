package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BlCustinfoExt;
import com.ai.baas.bmc.dao.mapper.bo.BlCustinfoExtCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlCustinfoExtMapper {
    int countByExample(BlCustinfoExtCriteria example);

    int deleteByExample(BlCustinfoExtCriteria example);

    int deleteByPrimaryKey(Long extId);

    int insert(BlCustinfoExt record);

    int insertSelective(BlCustinfoExt record);

    List<BlCustinfoExt> selectByExample(BlCustinfoExtCriteria example);

    BlCustinfoExt selectByPrimaryKey(Long extId);

    int updateByExampleSelective(@Param("record") BlCustinfoExt record, @Param("example") BlCustinfoExtCriteria example);

    int updateByExample(@Param("record") BlCustinfoExt record, @Param("example") BlCustinfoExtCriteria example);

    int updateByPrimaryKeySelective(BlCustinfoExt record);

    int updateByPrimaryKey(BlCustinfoExt record);
}