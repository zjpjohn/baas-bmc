package com.ai.baas.bmc.business.impl;

import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBill;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillCriteria;
import com.ai.baas.bmc.api.failedbillmaintain.params.FailedBillParam;
import com.ai.baas.bmc.business.interfaces.IFailedBillMaintainBusi;
import com.ai.baas.bmc.dao.interfaces.BmcRecordFmtMapper;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmt;
import com.ai.baas.bmc.dao.mapper.bo.BmcRecordFmtCriteria;
import com.ai.baas.bmc.util.MDSUtil;
import com.ai.baas.bmc.util.MyHbaseUtil;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.HBasePager;
import com.ai.opt.sdk.util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xin on 16-4-11.
 */
@Service
public class FailedBillMaintainBusiImpl implements IFailedBillMaintainBusi {
    private Logger logger = LogManager.getLogger(FailedBillMaintainBusiImpl.class);

    private final String tableName = "bmc_failure_bill";
    @Autowired
    private BmcRecordFmtMapper bmcRecordFmtMapper;

    @Override
    public List<FailedBill> queryFailedBills(FailedBillCriteria criteria) throws IOException {
        Table table = MyHbaseUtil.getTable(tableName);
        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
        if (criteria.getTenantId() != null && criteria.getTenantId().length() > 0) {
            Filter filter = new SingleColumnValueFilter("failure_bill".getBytes(), "tenant_id".getBytes(),
                    CompareFilter.CompareOp.EQUAL, new BinaryComparator(criteria.getTenantId().getBytes()));
            filterList.addFilter(filter);
        }
        if (criteria.getServiceType() != null && criteria.getServiceType().length() > 0) {
            Filter filter = new SingleColumnValueFilter("failure_bill".getBytes(), "service_id".getBytes(),
                    CompareFilter.CompareOp.EQUAL, new BinaryComparator(criteria.getServiceType().getBytes()));
            filterList.addFilter(filter);
        }
        if (criteria.getErrorCode() != null && criteria.getErrorCode().length() > 0) {
            Filter filter = new SingleColumnValueFilter("failure_bill".getBytes(), "fail_code".getBytes(),
                    CompareFilter.CompareOp.EQUAL, new BinaryComparator(criteria.getErrorCode().getBytes()));
            filterList.addFilter(filter);
        }

        HBasePager<FailedBill> pager = criteria.getPager();
        Scan scan = new Scan();

        //Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator(stringBuilder.toString()));
        Filter columnFilter = new SingleColumnValueFilter("failure_bill".getBytes(), "fail_step".getBytes(),
                CompareFilter.CompareOp.EQUAL, new RegexStringComparator("BMC*"));

        filterList.addFilter(columnFilter);
        if (pager != null) {
            //查询第一页
            if (StringUtil.isBlank(pager.getStartRow())
                    && StringUtil.isBlank(pager.getPreviousRow())) {
                PageFilter pageFilter = new PageFilter(pager.getPageSize());
                filterList.addFilter(pageFilter);
            } else {
                // 向后查一页
                if (StringUtil.isBlank(pager.getStartRow())
                        && !StringUtil.isBlank(pager.getPreviousRow())) {
                    PageFilter pageFilter = new PageFilter(pager.getPageSize() + 1);
                    filterList.addFilter(pageFilter);
                    scan.setStartRow(pager.getPreviousRow().getBytes());
                } else {
                    // 向前查一页
                    if (!StringUtil.isBlank(pager.getStartRow())) {
                        PageFilter pageFilter = new PageFilter(pager.getPageSize());
                        filterList.addFilter(pageFilter);
                        scan.setStartRow(pager.getStartRow().getBytes());
                    } else {
                        throw new BusinessException("500", "分页器参数不合法");
                    }
                }
            }
        }

        scan.setFilter(filterList);
        ResultScanner resultScanner = table.getScanner(scan);
        Iterator<Result> resultIterator = resultScanner.iterator();
        List<FailedBill> failedBills = new ArrayList<FailedBill>();
        while (resultIterator.hasNext()) {
            Result result = resultIterator.next();
            FailedBill failedBill = fillFailedBillValue(result);
            failedBills.add(failedBill);
        }
        return failedBills;
    }

    public static void main(String[] args) throws IOException {
        FailedBillMaintainBusiImpl failedBillMaintainBusi = new FailedBillMaintainBusiImpl();
        FailedBillCriteria criteria = new FailedBillCriteria();
        criteria.setErrorCode("BMC-B0001");
        criteria.setServiceType("VOICE");
        criteria.setTenantId("TR");
        failedBillMaintainBusi.queryFailedBills(criteria);
    }

    @Override
    public FailedBill queryFailedBillById(String failedBillRowKey) throws IOException {
        Table table = MyHbaseUtil.getTable(tableName);
        Get get = new Get(failedBillRowKey.getBytes());
        Result result = table.get(get);
        if (result.rawCells().length == 0) {
            return null;
        }
        return fillFailedBillValue(result);
    }

    @Override
    public void doResendFailedBill(FailedBillParam param) throws IOException {
        FailedBill failedBill = queryFailedBillById(param.buildFailedBillRowKey());
        if (failedBill != null) {
            String message = generateMessage(param);
            MDSUtil.sendMessage(message);
            Table table = MyHbaseUtil.getTable(tableName);
            Delete delete = new Delete(param.buildFailedBillRowKey().getBytes());
            table.delete(delete);
        }
    }

    private String generateMessage(FailedBillParam param) {
        param.validateRowKeyParam();
        StringBuilder stringBuilder = new StringBuilder();
        BmcRecordFmtCriteria criteria = new BmcRecordFmtCriteria();
        criteria.createCriteria().andFormatTypeEqualTo((short) 1);
        criteria.setOrderByClause(" r.field_serial ");
        List<BmcRecordFmt> bmcRecordFmts = bmcRecordFmtMapper.selectByExample(criteria);

        stringBuilder.append(param.getTenantId() + "\1");
        stringBuilder.append(param.getService_id() + "\1");
        stringBuilder.append(param.getSource() + "\1");
        stringBuilder.append(param.getBsn() + "\1");
        stringBuilder.append(param.getSn() + "\1");
        stringBuilder.append(param.getArrivalTime() + "\1");
        stringBuilder.append(param.getAccountPeriod() + "\1");

        for (BmcRecordFmt bmcRecordFmt : bmcRecordFmts) {
            String value = param.getFailPacket().get(bmcRecordFmt.getFieldName());
            if (value == null || value.length() == 0)
                throw new BusinessException("400", bmcRecordFmt.getFieldName() + " 不能被找到或者值为空");
            stringBuilder.append(param.getAccountPeriod() + "\1");
        }

        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    private void fillFailPacketValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "fail_packet".getBytes());
        if (cell != null) {
            logger.debug("failedPacket : " + Bytes.toString(cell.getValueArray(),
                    cell.getValueOffset(),
                    cell.getValueLength()));
            Map<String, String> failedPacket = new Gson().fromJson(
                    Bytes.toString(cell.getValueArray(),
                            cell.getValueOffset(),
                            cell.getValueLength()),
                    new TypeToken<Map<String, String>>() {
                    }.getType());
            failedBill.setFail_packet(failedPacket);
        }
    }

    private void fillAccountPeriodValue(FailedBill failedBill, Result result) {
        Cell cell = result.getColumnLatestCell("failure_bill".getBytes(), "account_period".getBytes());
        if (cell != null) {
            failedBill.setAccountPeriod(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
        }
    }

    private FailedBill fillFailedBillValue(Result result) {
        FailedBill failedBill = new FailedBill();
        fillAccountPeriodValue(failedBill, result);
        fillArrivalTimeValue(failedBill, result);
        fillBSNValue(failedBill, result);
        fillFailCodeValue(failedBill, result);
        fillFailDateValue(failedBill, result);
        fillFailReasonValue(failedBill, result);
        fillFailStepValue(failedBill, result);
        fillServiceIdValue(failedBill, result);
        fillSNValue(failedBill, result);
        fillSourceValue(failedBill, result);
        fillTenantIdValue(failedBill, result);
        fillFailPacketValue(failedBill, result);
        return failedBill;
    }

    private void fillTenantIdValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "tenant_id".getBytes());
        if (cell != null) {
            failedBill.setTenantId(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
        }
    }

    private void fillSourceValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "source".getBytes());
        if (cell != null) {
            failedBill.setSource(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
        }
    }

    private void fillSNValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "sn".getBytes());
        if (cell != null) {
            failedBill.setSn(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
        }
    }

    private void fillServiceIdValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "service_id".getBytes());
        if (cell != null) {
            failedBill.setServiceId(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
        }
    }

    private void fillFailStepValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "fail_step".getBytes());
        if (cell != null) {
            failedBill.setFailStep(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
        }
    }

    private void fillFailReasonValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "fail_reason".getBytes());
        if (cell != null) {
            failedBill.setFailReason(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
        }
    }

    private void fillFailDateValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "fail_date".getBytes());
        if (cell != null) {
            String arrivalTime = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
            if (arrivalTime != null && arrivalTime.length() > 0)
                failedBill.setFailDate(Long.parseLong(arrivalTime));
        }
    }

    private void fillFailCodeValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "fail_code".getBytes());
        if (cell != null) {
            failedBill.setFailCode(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
        }
    }

    private void fillBSNValue(FailedBill failedBill, Result result) {
        Cell cell;
        cell = result.getColumnLatestCell("failure_bill".getBytes(), "bsn".getBytes());
        if (cell != null) {
            failedBill.setBsn(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
        }
    }

    private void fillArrivalTimeValue(FailedBill failedBill, Result result) {
        Cell cell = result.getColumnLatestCell("failure_bill".getBytes(), "arrival_time".getBytes());
        if (cell != null) {
            String arrivalTime = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
            if (arrivalTime != null && arrivalTime.length() > 0)
                failedBill.setArrivalTime(Long.parseLong(arrivalTime));
        }
    }
}
