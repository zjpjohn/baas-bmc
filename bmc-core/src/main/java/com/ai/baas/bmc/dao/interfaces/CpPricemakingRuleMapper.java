package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.CpPricemakingRule;
import com.ai.baas.bmc.dao.mapper.bo.CpPricemakingRuleCriteria;
import com.ai.baas.bmc.dao.mapper.bo.CpPricemakingRuleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpPricemakingRuleMapper {
    int countByExample(CpPricemakingRuleCriteria example);

    int deleteByExample(CpPricemakingRuleCriteria example);

    int deleteByPrimaryKey(CpPricemakingRuleKey key);

    int insert(CpPricemakingRule record);

    int insertSelective(CpPricemakingRule record);

    List<CpPricemakingRule> selectByExample(CpPricemakingRuleCriteria example);

    CpPricemakingRule selectByPrimaryKey(CpPricemakingRuleKey key);

    int updateByExampleSelective(@Param("record") CpPricemakingRule record, @Param("example") CpPricemakingRuleCriteria example);

    int updateByExample(@Param("record") CpPricemakingRule record, @Param("example") CpPricemakingRuleCriteria example);

    int updateByPrimaryKeySelective(CpPricemakingRule record);

    int updateByPrimaryKey(CpPricemakingRule record);
}