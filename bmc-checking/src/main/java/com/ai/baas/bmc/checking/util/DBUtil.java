package com.ai.baas.bmc.checking.util;

import com.ai.baas.bmc.checking.vo.BatchInfo;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by xin on 16-3-30.
 */
public final class DBUtil {

    private final String JDBC_URL = "jdbc.url";
    private final String JDBC_USERNAME = "jdbc.username";
    private final String JDBC_PASSWD = "jdbc.password";
    private final String JDBC_DRIVER_CLASS = "jdbc.driverClassName";

    private DBUtil() {

    }

    private static HikariDataSource dataSource;

    public static void init(Properties config) {
        try {
            if (dataSource == null) {
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setJdbcUrl(config.getProperty(JDBC_URL));
                hikariConfig.setUsername(config.getProperty(JDBC_USERNAME));
                hikariConfig.setPassword(config.getProperty(JDBC_PASSWD));
                hikariConfig.setDriverClassName(config.getProperty(JDBC_DRIVER_CLASS));
                hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
                hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
                hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
                dataSource = new HikariDataSource(hikariConfig);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create datasource.", e);
        }
    }

    public static List<BatchInfo> queryUnCheckedBatchInfo() {
        List<BatchInfo> batchInfoList = new ArrayList<BatchInfo>();
        //TODO
        return batchInfoList;
    }
}
