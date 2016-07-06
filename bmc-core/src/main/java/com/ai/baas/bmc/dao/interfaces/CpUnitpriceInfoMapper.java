package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpUnitpriceInfoMapper {
    int countByExample(CpUnitpriceInfoCriteria example);

    int deleteByExample(CpUnitpriceInfoCriteria example);

    int deleteByPrimaryKey(Integer unitPriceId);

    int insert(CpUnitpriceInfo record);

    int insertSelective(CpUnitpriceInfo record);

    List<CpUnitpriceInfo> selectByExample(CpUnitpriceInfoCriteria example);

    CpUnitpriceInfo selectByPrimaryKey(Integer unitPriceId);

    int updateByExampleSelective(@Param("record") CpUnitpriceInfo record, @Param("example") CpUnitpriceInfoCriteria example);

    int updateByExample(@Param("record") CpUnitpriceInfo record, @Param("example") CpUnitpriceInfoCriteria example);

    int updateByPrimaryKeySelective(CpUnitpriceInfo record);

    int updateByPrimaryKey(CpUnitpriceInfo record);
}