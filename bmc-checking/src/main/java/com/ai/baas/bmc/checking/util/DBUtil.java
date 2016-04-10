package com.ai.baas.bmc.checking.util;

import com.ai.baas.bmc.checking.vo.BatchInfo;
import com.ai.baas.bmc.checking.vo.CheckResult;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by xin on 16-3-30.
 */
public class DBUtil {

    private static Logger logger = LogManager.getLogger(DBUtil.class);

    private static final String JDBC_URL = "jdbc.url";
    private static final String JDBC_USERNAME = "jdbc.username";
    private static final String JDBC_PASSWD = "jdbc.password";
    private static final String JDBC_DRIVER_CLASS = "jdbc.driverClassName";

    private static String baseTableName = "";
    private static int switch_wait_interval;

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

        baseTableName = config.getProperty("mysql.rtm.basetableName");
        if (StringUtils.isBlank(baseTableName)) {
            throw new RuntimeException("mysql.rtm.basetableName is null");
        }
        switch_wait_interval = Integer.parseInt(config.getProperty("switch.wait.interval", "30"));
    }

    public static List<BatchInfo> queryUnCheckedBatchInfo() throws SQLException {
        List<BatchInfo> batchInfoList = new ArrayList<BatchInfo>();
        String[] tableNameSuffixes = new String[]{new SimpleDateFormat("YYYYMM").format(new Date()),
                new SimpleDateFormat("YYYYMM").format(getLastDate())};
        Connection connection = dataSource.getConnection();
        try {
            for (String suffix : tableNameSuffixes) {
                final String querySql = "SELECT BSN, DATA_COUNT FROM " + baseTableName +
                        suffix + " WHERE IS_SWITCH = 'Y' AND CHECK_STATE='N' AND SWITCH_TIME < DATE_SUB(NOW(),INTERVAL ? MINUTE)";
                logger.info("query uncheck batch info SQL :{}", querySql);
                PreparedStatement preparedStatement = connection.prepareStatement(querySql);
                preparedStatement.setInt(1, switch_wait_interval);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    BatchInfo batchInfo = new BatchInfo(resultSet.getString("BSN"), baseTableName);
                    batchInfo.setTableSuffix(suffix);
                    batchInfo.setTotalSize(resultSet.getInt("DATA_COUNT"));
                    batchInfoList.add(batchInfo);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to query unchecked bath info", e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        logger.info("query uncheck batch info size: {}", batchInfoList.size());
        return batchInfoList;
    }


    private static Date getLastDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    public static void updateBatchCheckResult(CheckResult checkResult) throws SQLException {
        Connection connection = dataSource.getConnection();
        final String querySql = "UPDATE " + checkResult.getTableName() + " SET CHECK_STATE=?, CHECK_RESULT=?, REASON=?, aduit_finish_time =? WHERE BSN=?";
        logger.info("query updateBatchCheckResult SQL :{}", querySql);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setString(1, checkResult.getAuditState());
            preparedStatement.setString(2, checkResult.getAuditResult());
            preparedStatement.setString(3, checkResult.getAuditMessage());
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setString(5, checkResult.getBSN());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Failed to update checkResult", e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
