package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfo;
import com.ai.baas.bmc.dao.mapper.bo.CpPriceInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpPriceInfo2Mapper {

    List<CpPriceInfo> findByName(@Param("code") String record, @Param("name") String name);


}
