package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetail;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpPriceDetailMapper {
    int countByExample(CpPriceDetailCriteria example);

    int deleteByExample(CpPriceDetailCriteria example);

    int deleteByPrimaryKey(Long detailId);

    int insert(CpPriceDetail record);

    int insertSelective(CpPriceDetail record);

    List<CpPriceDetail> selectByExample(CpPriceDetailCriteria example);

    CpPriceDetail selectByPrimaryKey(Long detailId);

    int updateByExampleSelective(@Param("record") CpPriceDetail record, @Param("example") CpPriceDetailCriteria example);

    int updateByExample(@Param("record") CpPriceDetail record, @Param("example") CpPriceDetailCriteria example);

    int updateByPrimaryKeySelective(CpPriceDetail record);

    int updateByPrimaryKey(CpPriceDetail record);
}