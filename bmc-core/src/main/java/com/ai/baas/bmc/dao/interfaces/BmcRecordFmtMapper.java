package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmt;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmtCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmcRecordFmtMapper {
    int countByExample(BmcRecordFmtCriteria example);

    int deleteByExample(BmcRecordFmtCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BmcRecordFmt record);

    int insertSelective(BmcRecordFmt record);

    List<BmcRecordFmt> selectByExample(BmcRecordFmtCriteria example);

    BmcRecordFmt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BmcRecordFmt record, @Param("example") BmcRecordFmtCriteria example);

    int updateByExample(@Param("record") BmcRecordFmt record, @Param("example") BmcRecordFmtCriteria example);

    int updateByPrimaryKeySelective(BmcRecordFmt record);

    int updateByPrimaryKey(BmcRecordFmt record);
}