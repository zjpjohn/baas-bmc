package com.ai.baas.bmc.service.atom.interfaces;

import java.util.List;

import com.ai.baas.bmc.api.acctinfo.params.AcctQueryRequest;
import com.ai.baas.bmc.dao.mapper.bo.BlAcctInfo;
import com.ai.opt.base.vo.PageInfo;

public interface IBlAcctInfoAtomSV {

    /**
     * 创建账户后，写入dshm
     * @param blAcctInfo
     * @author mayt
     * @ApiDocMethod
     */
    void addDshmData(BlAcctInfo blAcctInfo);
    /**
     * 查询 BlAcctInfo<br>
     * 
     * @param acctQueryRequest
     * @return
     * @author luoxuan
     * @ApiDocMethod
     */
    List<BlAcctInfo> queryBlAcctinfo(AcctQueryRequest acctQueryRequest);
    /**
     * 分页查询 BlAcctInfo<br>
     * 
     * @param acctQueryRequest
     * @return
     * @author luoxuan
     * @ApiDocMethod
     */
    PageInfo<BlAcctInfo> queryBlAcctinfoPageInfo(AcctQueryRequest acctQueryRequest);

}
