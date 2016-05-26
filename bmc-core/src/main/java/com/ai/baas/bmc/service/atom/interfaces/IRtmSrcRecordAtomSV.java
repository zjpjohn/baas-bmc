package com.ai.baas.bmc.service.atom.interfaces;

import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcRecord;

import java.util.List;

public interface IRtmSrcRecordAtomSV {

    /**
     * 新增数据
     * @param srcRecords
     * @author wangyx13
     */
    void addRecordList(List<BmcRecord> srcRecords);



}
