package com.ai.baas.bmc.checking.vo;

/**
 * Created by xin on 16-3-30.
 */
public class BatchInfo {
    private String tableSuffix;
    private String BSN;
    private int totalSize;
    private String tableName;

    public BatchInfo(String bsn, String tableName) {
        this.BSN = bsn;
        this.tableName = tableName;
    }

    public String getBSN() {
        return BSN;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    public String getTableSuffix() {
        return tableSuffix;
    }

    public String getTableName() {
        if (tableSuffix != null && tableSuffix.length() > 0)
            return tableName + tableSuffix;
        return tableName;
    }
}
