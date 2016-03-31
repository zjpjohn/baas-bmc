package com.ai.baas.bmc.checking.vo;

import java.util.ArrayList;
import java.util.List;

public class CheckResult {

    private boolean isLost;

    private List<TransFlowInfo> transFlowInfos;

    public CheckResult() {
        this.isLost = false;
        transFlowInfos = new ArrayList<TransFlowInfo>();
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public void doReportCheckResult() {
        // save to kafka
        //Save to Mysql
    }

    public void addTransFlowInfos(List<TransFlowInfo> orginInfoList) {
        transFlowInfos.addAll(orginInfoList);
    }
}
