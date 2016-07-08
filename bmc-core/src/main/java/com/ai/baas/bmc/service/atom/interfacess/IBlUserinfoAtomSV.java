package com.ai.baas.bmc.service.atom.interfacess;

import com.ai.baas.bmc.dao.mapper.bo.BlUserinfo;

public interface IBlUserinfoAtomSV {

    /**
     * 新建用户后，写入dshm
     * @param blUserinfo
     * @author mayt
     * @ApiDocMethod
     */
    void addDshmData(BlUserinfo blUserinfo);

}
