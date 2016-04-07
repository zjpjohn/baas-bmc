package com.ai.baas.bmc.checking.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by xin on 16-3-31.
 */
public class ScanCriteria {

    private static final String RECORD_CRITERIA = "RECORD_SCAN_CRITERIA";
    private static final String AUDIT_CRITERIA = "AUDIT_SCAN_CRITERIA";
    private static final String FAILED_CRITERIA = "FAILED_CRITERIA";

    private static Map<String, Criteria> clauses = new HashMap<String, Criteria>();

    private ScanCriteria() {
        //DO NOTHING
    }

    public static void initClause(Properties properties) {
        String tableName = properties.getProperty("hbase.audit.tableName");
        String columnFamilyName = properties.getProperty("hbase.audit.columnFamilyName");
        String columnName = properties.getProperty("hbase.audit.bsn.columnName");
        Criteria auditCriteria = new Criteria(tableName, columnFamilyName, columnName);
        clauses.put(AUDIT_CRITERIA, auditCriteria);

        tableName = properties.getProperty("hbase.record.detail.tableName");
        columnFamilyName = properties.getProperty("hbase.record.detail.columnFamilyName");
        columnName = properties.getProperty("hbase.recode.detail.bsn.columnName");
        String detailColumnName = properties.getProperty("hbase.recode.detail.value.columnName");
        Criteria recordCriteria = new Criteria(tableName, columnFamilyName, columnName);
        recordCriteria.setDetailColumnName(detailColumnName);
        clauses.put(RECORD_CRITERIA, recordCriteria);

        tableName = properties.getProperty("hbase.failed.tableName");
        columnFamilyName = properties.getProperty("hbase.failed.columnFamilyName");
        columnName = properties.getProperty("hbase.audit.bsn.columnName");
        Criteria failedCriteria = new Criteria(tableName, columnFamilyName, columnName);
        recordCriteria.setDetailColumnName(detailColumnName);
        clauses.put(FAILED_CRITERIA, failedCriteria);
    }

    public static Criteria getRecordScanCriteria(String tableSuffix) {
        return clauses.get(RECORD_CRITERIA).setSuffix(tableSuffix);
    }

    public static Criteria getAuditScanCriteria(String tableSuffix) {
        return clauses.get(AUDIT_CRITERIA).setSuffix(tableSuffix);
    }

    public static Criteria getFailedScanCriteria() {
        return clauses.get(FAILED_CRITERIA);
    }

    public static class Criteria {
        Criteria(String baseTableName, String columnFamily, String columnName) {
            this.baseTableName = baseTableName;
            this.columnFamily = columnFamily;
            this.columnName = columnName;
        }

        private String baseTableName;
        private String columnFamily;
        private String columnName;
        private String detailColumnName;
        private String suffix;

        public String getColumnFamily() {
            return columnFamily;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getTableName() {
            if (suffix == null || suffix.length() == 0)
                return baseTableName;
            return baseTableName + suffix;
        }

        public String getDetailColumnName() {
            return detailColumnName;
        }

        void setDetailColumnName(String detailColumnName) {
            this.detailColumnName = detailColumnName;
        }

        public Criteria setSuffix(String tableSuffix) {
            this.suffix = tableSuffix;
            return this;
        }
    }
}
