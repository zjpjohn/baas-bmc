package com.ai.baas.bmc.dao.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BmcQueryBill;
import com.ai.baas.bmc.dao.mapper.bo.BmcQueryBillCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmcQueryBillMapper {
    int countByExample(BmcQueryBillCriteria example);

    int deleteByExample(BmcQueryBillCriteria example);

    int deleteByPrimaryKey(Integer uniqueId);

    int insert(BmcQueryBill record);

    int insertSelective(BmcQueryBill record);

    List<BmcQueryBill> selectByExample(BmcQueryBillCriteria example);

    BmcQueryBill selectByPrimaryKey(Integer uniqueId);

    int updateByExampleSelective(@Param("record") BmcQueryBill record, @Param("example") BmcQueryBillCriteria example);

    int updateByExample(@Param("record") BmcQueryBill record, @Param("example") BmcQueryBillCriteria example);

    int updateByPrimaryKeySelective(BmcQueryBill record);

    int updateByPrimaryKey(BmcQueryBill record);
}