package com.ai.baas.bmc.checking;

import com.ai.baas.bmc.checking.thead.CheckTask;
import com.ai.baas.bmc.checking.util.DBUtil;
import com.ai.baas.bmc.checking.util.HBaseUtil;
import com.ai.baas.bmc.checking.vo.BatchInfo;
import com.ai.baas.bmc.checking.vo.CheckResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * Created by xin on 16-3-30.
 */
public class CheckDriver {

    private static Logger logger = LogManager.getLogger(CheckDriver.class);
    private static Properties config = new Properties();

    public static void initConfig() {
        InputStream inputStream = CheckDriver.class.getResourceAsStream("/checker.cfg");
        if (inputStream != null) {
            try {
                config.load(inputStream);
            } catch (IOException e) {
                logger.error("Failed to load the checker.cfg", e);
                System.exit(-1);
            }
        }

        //print the config
        for (Map.Entry<Object, Object> entry : config.entrySet()) {
            logger.info("{}={}", entry.getKey(), entry.getValue());
        }

        HBaseUtil.init(config);
        DBUtil.init(config);
    }

    public static void main(String[] args) {
        // 初始化参数
        initConfig();
        // 开启多线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            // 读取批次号
            List<BatchInfo> batchInfoList = DBUtil.queryUnCheckedBatchInfo();
            CountDownLatch countDownLatch = new CountDownLatch(batchInfoList.size());
            List<Future<CheckResult>> futures = new ArrayList<Future<CheckResult>>();
            for (BatchInfo batchInfo : batchInfoList) {
                Future<CheckResult> future = executorService.submit(new CheckTask(batchInfo, countDownLatch));
                futures.add(future);
            }

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                logger.error("Failed to wait the result", e);
                break;
            } finally {
                //TODO
            }

            // 汇总结果
            for (Future<CheckResult> result : futures) {
                try {
                    CheckResult checkResult = result.get();
                    checkResult.doReportCheckResult();
                } catch (InterruptedException e) {
                    logger.error("Failed to get checkResult from executor pool", e);
                    continue;
                } catch (ExecutionException e) {
                    logger.error("Failed to get checkResult from executor pool", e);
                    continue;
                }

            }
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                logger.error("Failed to sleep", e);
                break;
            }
        }

        // 结束资源,
        executorService.shutdown();
    }
}
