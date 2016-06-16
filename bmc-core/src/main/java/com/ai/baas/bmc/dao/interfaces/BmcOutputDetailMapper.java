package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BmcOutputDetail;
import com.ai.baas.bmc.dao.mapper.bo.BmcOutputDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmcOutputDetailMapper {
    int countByExample(BmcOutputDetailCriteria example);

    int deleteByExample(BmcOutputDetailCriteria example);

    int deleteByPrimaryKey(Long detailCode);

    int insert(BmcOutputDetail record);

    int insertSelective(BmcOutputDetail record);

    List<BmcOutputDetail> selectByExample(BmcOutputDetailCriteria example);

    BmcOutputDetail selectByPrimaryKey(Long detailCode);

    int updateByExampleSelective(@Param("record") BmcOutputDetail record, @Param("example") BmcOutputDetailCriteria example);

    int updateByExample(@Param("record") BmcOutputDetail record, @Param("example") BmcOutputDetailCriteria example);

    int updateByPrimaryKeySelective(BmcOutputDetail record);

    int updateByPrimaryKey(BmcOutputDetail record);
}