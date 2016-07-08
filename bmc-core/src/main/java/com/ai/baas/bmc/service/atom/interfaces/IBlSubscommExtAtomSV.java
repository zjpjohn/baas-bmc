package com.ai.baas.bmc.service.atom.interfaces;

import com.ai.baas.bmc.dao.mapper.bo.BlSubscommExt;

public interface IBlSubscommExtAtomSV {

    /**
     * 新增产品订购扩展信息后，写入dshm
     * @param blSubscommExt
     * @author mayt
     * @ApiDocMethod
     */
    void addDshmData(BlSubscommExt blSubscommExt);

}
