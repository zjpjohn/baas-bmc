package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.AccOweInfo;
import com.ai.baas.bmc.dao.mapper.bo.AccOweInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccOweInfoMapper {
    int countByExample(AccOweInfoCriteria example);

    int deleteByExample(AccOweInfoCriteria example);

    int insert(AccOweInfo record);

    int insertSelective(AccOweInfo record);

    List<AccOweInfo> selectByExample(AccOweInfoCriteria example);

    int updateByExampleSelective(@Param("record") AccOweInfo record, @Param("example") AccOweInfoCriteria example);

    int updateByExample(@Param("record") AccOweInfo record, @Param("example") AccOweInfoCriteria example);
}