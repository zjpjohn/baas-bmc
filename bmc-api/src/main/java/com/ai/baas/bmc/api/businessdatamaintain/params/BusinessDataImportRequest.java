package com.ai.baas.bmc.api.businessdatamaintain.params;

import com.ai.opt.base.vo.BaseInfo;

import java.util.List;

public class BusinessDataImportRequest extends BaseInfo{
    /**
     * 导入数据列表
     */
    private List<BmcRecord> importData;

    public List<BmcRecord> getImportData() {
        return importData;
    }

    public void setImportData(List<BmcRecord> importData) {
        this.importData = importData;
    }
}
