package com.ai.baas.bmc.service.atom.interfaces;

import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.api.businessdatamaintain.params.BusinessDataQueryRequest;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmt;

import java.util.List;

public interface IBmcRecordFmtAtomSV {
    
    /**
     * 新增数据
     * @param records
     * @author liangbs
     */
	public void addRecordList(List<BmcRecord> records);

    /**
     * 新增数据
     * @param businessDataQueryRequest
     * @author wangyx13
     */
    List<BmcRecordFmt> query(BusinessDataQueryRequest businessDataQueryRequest);
}
