package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItem;
import com.ai.baas.bmc.dao.mapper.bo.CpUnitpriceItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpUnitpriceItemMapper {
    int countByExample(CpUnitpriceItemCriteria example);

    int deleteByExample(CpUnitpriceItemCriteria example);

    int deleteByPrimaryKey(Integer unitItemId);

    int insert(CpUnitpriceItem record);

    int insertSelective(CpUnitpriceItem record);

    List<CpUnitpriceItem> selectByExample(CpUnitpriceItemCriteria example);

    CpUnitpriceItem selectByPrimaryKey(Integer unitItemId);

    int updateByExampleSelective(@Param("record") CpUnitpriceItem record, @Param("example") CpUnitpriceItemCriteria example);

    int updateByExample(@Param("record") CpUnitpriceItem record, @Param("example") CpUnitpriceItemCriteria example);

    int updateByPrimaryKeySelective(CpUnitpriceItem record);

    int updateByPrimaryKey(CpUnitpriceItem record);
}