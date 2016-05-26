package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BmcAccuDealer;
import com.ai.baas.bmc.dao.mapper.bo.BmcAccuDealerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmcAccuDealerMapper {
    int countByExample(BmcAccuDealerCriteria example);

    int deleteByExample(BmcAccuDealerCriteria example);

    int insert(BmcAccuDealer record);

    int insertSelective(BmcAccuDealer record);

    List<BmcAccuDealer> selectByExample(BmcAccuDealerCriteria example);

    int updateByExampleSelective(@Param("record") BmcAccuDealer record, @Param("example") BmcAccuDealerCriteria example);

    int updateByExample(@Param("record") BmcAccuDealer record, @Param("example") BmcAccuDealerCriteria example);
}