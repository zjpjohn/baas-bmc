package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryRouterule;
import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryRouteruleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmcDrqueryRouteruleMapper {
    int countByExample(BmcDrqueryRouteruleCriteria example);

    int deleteByExample(BmcDrqueryRouteruleCriteria example);

    int insert(BmcDrqueryRouterule record);

    int insertSelective(BmcDrqueryRouterule record);

    List<BmcDrqueryRouterule> selectByExample(BmcDrqueryRouteruleCriteria example);

    int updateByExampleSelective(@Param("record") BmcDrqueryRouterule record, @Param("example") BmcDrqueryRouteruleCriteria example);

    int updateByExample(@Param("record") BmcDrqueryRouterule record, @Param("example") BmcDrqueryRouteruleCriteria example);
}