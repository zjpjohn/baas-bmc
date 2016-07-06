package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpPriceInfoMapper {
    int countByExample(CpPriceInfoCriteria example);

    int deleteByExample(CpPriceInfoCriteria example);

    int deleteByPrimaryKey(Long priceInfoId);

    int insert(CpPriceInfo record);

    int insertSelective(CpPriceInfo record);

    List<CpPriceInfo> selectByExample(CpPriceInfoCriteria example);

    CpPriceInfo selectByPrimaryKey(Long priceInfoId);

    int updateByExampleSelective(@Param("record") CpPriceInfo record, @Param("example") CpPriceInfoCriteria example);

    int updateByExample(@Param("record") CpPriceInfo record, @Param("example") CpPriceInfoCriteria example);

    int updateByPrimaryKeySelective(CpPriceInfo record);

    int updateByPrimaryKey(CpPriceInfo record);
}