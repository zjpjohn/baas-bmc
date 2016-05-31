package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.RtmSrcInfo;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtmSrcInfoMapper {
    int countByExample(RtmSrcInfoCriteria example);

    int deleteByExample(RtmSrcInfoCriteria example);

    int insert(RtmSrcInfo record);

    int insertSpec(RtmSrcInfo record);

    int insertSelective(RtmSrcInfo record);

    List<RtmSrcInfo> selectByExample(RtmSrcInfoCriteria example);

    int updateByExampleSelective(@Param("record") RtmSrcInfo record, @Param("example") RtmSrcInfoCriteria example);

    int updateByExample(@Param("record") RtmSrcInfo record, @Param("example") RtmSrcInfoCriteria example);
}