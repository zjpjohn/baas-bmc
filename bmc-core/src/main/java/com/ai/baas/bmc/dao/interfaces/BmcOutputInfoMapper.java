package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BmcOutputInfo;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmcOutputInfoMapper {
    int countByExample(BmcOutputInfoCriteria example);

    int deleteByExample(BmcOutputInfoCriteria example);

    int deleteByPrimaryKey(Long infoCode);

    int insert(BmcOutputInfo record);

    int insertSelective(BmcOutputInfo record);

    List<BmcOutputInfo> selectByExample(BmcOutputInfoCriteria example);

    BmcOutputInfo selectByPrimaryKey(Long infoCode);

    int updateByExampleSelective(@Param("record") BmcOutputInfo record, @Param("example") BmcOutputInfoCriteria example);

    int updateByExample(@Param("record") BmcOutputInfo record, @Param("example") BmcOutputInfoCriteria example);

    int updateByPrimaryKeySelective(BmcOutputInfo record);

    int updateByPrimaryKey(BmcOutputInfo record);
}