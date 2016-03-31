package com.ai.baas.bmc.checking.thead;

import com.ai.baas.bmc.checking.util.HBaseUtil;
import com.ai.baas.bmc.checking.vo.BatchInfo;
import com.ai.baas.bmc.checking.vo.CheckResult;
import com.ai.baas.bmc.checking.vo.TransFlowInfo;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by xin on 16-3-30.
 */
public class CheckTask implements Callable<CheckResult> {
    private BatchInfo batchInfo;
    private CountDownLatch countDownLatch;

    public CheckTask(BatchInfo batchInfo, CountDownLatch countDownLatch) {
        this.batchInfo = batchInfo;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public CheckResult call() throws Exception {
        CheckResult checkResult = new CheckResult();
        //
        // 读取明细对账表
        List<TransFlowInfo> checkingTransFlowInfos = HBaseUtil.queryCheckingTransFlowInfos(batchInfo.getBSN());

        // 先比较个数
        if (checkingTransFlowInfos.size() != batchInfo.getTotalSize()) {
            checkResult.setLost(true);
            // 读取原始对账明细表
            List<TransFlowInfo> orginInfoList = HBaseUtil.queryOriginTransFlowInfo(batchInfo.getBSN());
            // 如果个数不一样则，比各个明细
            for (TransFlowInfo transFlowInfo : checkingTransFlowInfos) {
                //重写hashcode方法
                orginInfoList.remove(orginInfoList);
            }

            checkResult.addTransFlowInfos(orginInfoList);
        }

        countDownLatch.countDown();
        return checkResult;
    }
}
