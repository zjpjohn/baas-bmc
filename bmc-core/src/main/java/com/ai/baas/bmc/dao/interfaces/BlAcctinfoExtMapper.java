package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BlAcctinfoExt;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctinfoExtCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlAcctinfoExtMapper {
    int countByExample(BlAcctinfoExtCriteria example);

    int deleteByExample(BlAcctinfoExtCriteria example);

    int deleteByPrimaryKey(Integer extId);

    int insert(BlAcctinfoExt record);

    int insertSelective(BlAcctinfoExt record);

    List<BlAcctinfoExt> selectByExample(BlAcctinfoExtCriteria example);

    BlAcctinfoExt selectByPrimaryKey(Integer extId);

    int updateByExampleSelective(@Param("record") BlAcctinfoExt record, @Param("example") BlAcctinfoExtCriteria example);

    int updateByExample(@Param("record") BlAcctinfoExt record, @Param("example") BlAcctinfoExtCriteria example);

    int updateByPrimaryKeySelective(BlAcctinfoExt record);

    int updateByPrimaryKey(BlAcctinfoExt record);
}