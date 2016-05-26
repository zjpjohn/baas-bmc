package com.ai.baas.bmc.service.atom.interfaces;

import com.ai.baas.bmc.api.businessdatamaintain.params.BmcRecord;
import com.ai.baas.bmc.dao.mapper.bo.RtmSrcInfo;

import java.util.List;

public interface IRtmSrcInfoAtomSV {

    /**
     * 新增数据
     * @param srcInfos
     * @author wangyx13
     */
    void addRecordList(List<BmcRecord> srcInfos);
}
