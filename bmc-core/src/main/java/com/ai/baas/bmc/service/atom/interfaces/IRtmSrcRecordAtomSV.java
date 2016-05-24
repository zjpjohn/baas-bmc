package com.ai.baas.bmc.service.atom.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.RtmSrcRecord;

public interface IRtmSrcRecordAtomSV {

    /**
     * 新增数据
     * @param srcRecord
     * @author wangyx13
     */
    void addRecord(RtmSrcRecord srcRecord);
}
