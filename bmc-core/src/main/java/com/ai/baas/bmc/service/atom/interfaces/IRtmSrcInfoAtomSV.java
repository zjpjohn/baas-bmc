package com.ai.baas.bmc.service.atom.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.RtmSrcInfo;

public interface IRtmSrcInfoAtomSV {

    /**
     * 新增数据
     * @param srcInfo
     * @author wangyx13
     */
    void addRecord(RtmSrcInfo srcInfo);
}
