package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlAcctInfoMapper {
    int countByExample(BlAcctInfoCriteria example);

    int deleteByExample(BlAcctInfoCriteria example);

    int deleteByPrimaryKey(String acctId);

    int insert(BlAcctInfo record);

    int insertSelective(BlAcctInfo record);

    List<BlAcctInfo> selectByExample(BlAcctInfoCriteria example);

    BlAcctInfo selectByPrimaryKey(String acctId);

    int updateByExampleSelective(@Param("record") BlAcctInfo record, @Param("example") BlAcctInfoCriteria example);

    int updateByExample(@Param("record") BlAcctInfo record, @Param("example") BlAcctInfoCriteria example);

    int updateByPrimaryKeySelective(BlAcctInfo record);

    int updateByPrimaryKey(BlAcctInfo record);
}