package com.ai.baas.bmc.service.atom.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BlCustinfo;

public interface IBlCustinfoAtomSV {

    /**
     * 创建客户后，数据写入dshm
     * @param blCustinfo
     * @author mayt
     * @ApiDocMethod
     */
    void addDshmData(BlCustinfo blCustinfo);

}
