package com.ai.baas.bmc.checking.thead;

import com.ai.baas.bmc.checking.util.HBaseUtil;
import com.ai.baas.bmc.checking.vo.BatchInfo;
import com.ai.baas.bmc.checking.vo.CheckResult;
import com.ai.baas.bmc.checking.vo.RecordItem;
import com.ai.baas.bmc.checking.vo.ScanCriteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by xin on 16-3-30.
 */
public class CheckTask implements Callable<CheckResult> {
    private Logger logger = LogManager.getLogger(CheckTask.class);
    private BatchInfo batchInfo;
    private CountDownLatch countDownLatch;

    public CheckTask(BatchInfo batchInfo, CountDownLatch countDownLatch) {
        this.batchInfo = batchInfo;
        this.countDownLatch = countDownLatch;

    }

    @Override
    public CheckResult call() throws Exception {
        CheckResult checkResult = new CheckResult(batchInfo.getBSN(), batchInfo.getTableName());
        // 读取明细对账表
        List<RecordItem> auditItems = HBaseUtil.queryAuditItems(batchInfo.getBSN(),
                ScanCriteria.getAuditScanCriteria(batchInfo.getTableSuffix()));

        logger.info("Thread:{}, batchId:{} size from hbase :{}", Thread.currentThread().getName(),
                batchInfo.getBSN(), auditItems.size());
        logger.info("Thread:{} batchId :{} size from mysql :{}", Thread.currentThread().getName(),
                batchInfo.getBSN(), batchInfo.getTotalSize());

        // 先比较个数
        if (auditItems.size() != batchInfo.getTotalSize()) {
            checkResult.setLost(true);
            // 读取原始对账明细表
            List<RecordItem> recordItems = HBaseUtil.queryRecodeItems(batchInfo.getBSN(), ScanCriteria
                    .getRecordScanCriteria(batchInfo.getTableSuffix()));
            // 如果个数不一样则，比各个明细
            for (RecordItem recordItem : auditItems) {
                //重写hashcode方法
                recordItems.remove(recordItem);
            }

            logger.info("Thread:{} batchId :{} lost size: {}", Thread.currentThread().getName(),
                    batchInfo.getBSN(), recordItems.size());

            //从错单表中去掉重复的
            Iterator<RecordItem> recordItemIterator = recordItems.iterator();
            while (recordItemIterator.hasNext()) {
                RecordItem recordItem = recordItemIterator.next();
                if (HBaseUtil.checkSNInFailedBill(recordItem.getSN(), ScanCriteria.getFailedScanCriteria())) {
                    recordItemIterator.remove();
                }
            }
            logger.info("afterFailedBilled : Thread:{} batchId :{} lost size: {} ", Thread.currentThread().getName(),
                    batchInfo.getBSN(), recordItems.size());

            checkResult.addTransFlowInfos(recordItems);

            StringBuilder stringBuilder = new StringBuilder("Has lost sn: ");
            for (RecordItem recordItem : checkResult.getRecordItems()) {
                stringBuilder.append(recordItem.getSN() + " ");
            }
            logger.info("audit message : {}", stringBuilder.toString());
            checkResult.setAuditMessage(stringBuilder.toString());
        }

        countDownLatch.countDown();
        return checkResult;
    }
}
