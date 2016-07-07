package com.ai.baas.bmc.service.atom.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;

public interface IBlAcctInfoAtomSV {

    /**
     * 创建账户后，写入dshm
     * @param blAcctInfo
     * @author mayt
     * @ApiDocMethod
     */
    void addDshmData(BlAcctInfo blAcctInfo);

}
