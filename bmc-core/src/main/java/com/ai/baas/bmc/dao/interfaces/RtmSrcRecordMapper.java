package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.RtmSrcRecord;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RtmSrcRecordMapper {
    int countByExample(RtmSrcRecordCriteria example);

    int deleteByExample(RtmSrcRecordCriteria example);

    int insert(RtmSrcRecord record);

    int insertSelective(RtmSrcRecord record);

    List<RtmSrcRecord> selectByExample(RtmSrcRecordCriteria example);

    int updateByExampleSelective(@Param("record") RtmSrcRecord record, @Param("example") RtmSrcRecordCriteria example);

    int updateByExample(@Param("record") RtmSrcRecord record, @Param("example") RtmSrcRecordCriteria example);
}