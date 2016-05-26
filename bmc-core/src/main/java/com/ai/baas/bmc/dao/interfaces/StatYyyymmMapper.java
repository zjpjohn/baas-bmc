package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.StatYyyymm;
import com.ai.baas.bmc.dao.mapper.bo.StatYyyymmCriteria;
import com.ai.baas.bmc.dao.mapper.bo.StatYyyymmKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatYyyymmMapper {
	int countByExample(@Param("tbPrefix") String tbPrefix,@Param("currentMonth") String currentMonth,@Param("statYyyymmCriteria") StatYyyymmCriteria statYyyymmCriteria);

    int deleteByExample(StatYyyymmCriteria example);

    int deleteByPrimaryKey(StatYyyymmKey key);

    int insert(StatYyyymm record);

    int insertSelective(StatYyyymm record);

    List<StatYyyymm> selectByExample(@Param("tbPrefix") String tbPrefix,@Param("currentMonth") String currentMonth,@Param("statYyyymmCriteria") StatYyyymmCriteria example);

    StatYyyymm selectByPrimaryKey(StatYyyymmKey key);

    int updateByExampleSelective(@Param("record") StatYyyymm record, @Param("example") StatYyyymmCriteria example);

    int updateByExample(@Param("record") StatYyyymm record, @Param("example") StatYyyymmCriteria example);

    int updateByPrimaryKeySelective(StatYyyymm record);

    int updateByPrimaryKey(StatYyyymm record);
}