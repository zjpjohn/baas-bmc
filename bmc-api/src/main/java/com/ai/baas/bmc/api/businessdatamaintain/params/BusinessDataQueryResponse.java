package com.ai.baas.bmc.api.businessdatamaintain.params;

import com.ai.opt.base.vo.BaseResponse;

import java.util.List;

public class BusinessDataQueryResponse extends BaseResponse{

    /**
     * 计费数据格式结果集
     */
    List<BmcRecord> recordList;

    public List<BmcRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<BmcRecord> recordList) {
        this.recordList = recordList;
    }
}
