package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryFieldrule;
import com.ai.baas.bmc.dao.mapper.bo.BmcDrqueryFieldruleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmcDrqueryFieldruleMapper {
    int countByExample(BmcDrqueryFieldruleCriteria example);

    int deleteByExample(BmcDrqueryFieldruleCriteria example);

    int insert(BmcDrqueryFieldrule record);

    int insertSelective(BmcDrqueryFieldrule record);

    List<BmcDrqueryFieldrule> selectByExample(BmcDrqueryFieldruleCriteria example);

    int updateByExampleSelective(@Param("record") BmcDrqueryFieldrule record, @Param("example") BmcDrqueryFieldruleCriteria example);

    int updateByExample(@Param("record") BmcDrqueryFieldrule record, @Param("example") BmcDrqueryFieldruleCriteria example);
}