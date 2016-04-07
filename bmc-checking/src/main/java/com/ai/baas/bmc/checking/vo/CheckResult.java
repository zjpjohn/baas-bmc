package com.ai.baas.bmc.checking.vo;

import com.ai.baas.bmc.checking.util.DBUtil;
import com.ai.baas.bmc.checking.util.MDSUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckResult {
    private Logger logger = LogManager.getLogger(CheckResult.class);

    private String BSN;
    private boolean isLost;
    private List<RecordItem> recordItems;
    private String auditMessage;
    private String auditResult;
    private String auditState;
    private String tableName;

    public CheckResult(String bsn, String tableName) {
        this.BSN = bsn;
        this.isLost = false;
        this.tableName = tableName;
        recordItems = new ArrayList<RecordItem>();
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public void doReportCheckResult() throws SQLException {
        auditState = "Y";
        if (isLost) {
            for (RecordItem recordItem : recordItems) {
                logger.info("send message for bsn : " + recordItem.getDetail());
                MDSUtil.sendMessage(recordItem.getDetail());
            }
            auditResult = "Failed";
        } else {
            auditMessage = "Audit Success";
            auditResult = "Success!";
        }

        //Save to Mysql
        DBUtil.updateBatchCheckResult(this);
    }

    public void addTransFlowInfos(List<RecordItem> orginInfoList) {
        recordItems.addAll(orginInfoList);
    }

    public void setAuditMessage(String auditMessage) {
        this.auditMessage = auditMessage;
    }

    public String getTableName() {
        return tableName;
    }

    public String getBSN() {
        return BSN;
    }

    public String getAuditMessage() {
        return auditMessage;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public String getAuditState() {
        return auditState;
    }

    public List<RecordItem> getRecordItems() {
        return recordItems;
    }
}
