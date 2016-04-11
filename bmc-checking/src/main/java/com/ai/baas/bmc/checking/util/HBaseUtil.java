package com.ai.baas.bmc.checking.util;

import com.ai.baas.bmc.checking.vo.RecordItem;
import com.ai.baas.bmc.checking.vo.ScanCriteria;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Created by xin on 16-3-30.
 */
public final class HBaseUtil {

    private static Connection connection;

    public static void init(Properties config) {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", config.getProperty("zookeeper.quorum"));
        configuration.set("hbase.zookeeper.property.clientPort", config.getProperty("hbase.client.port"));
        try {
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            throw new RuntimeException("initHBaseClient failure", e);
        }
    }


    public static List<RecordItem> queryAuditItems(String bsn, ScanCriteria.Criteria clause) throws IOException {
        List<RecordItem> recordItems = new ArrayList<RecordItem>();
        Scan scan = new Scan();
        SingleColumnValueFilter filterList1 = new SingleColumnValueFilter(Bytes.toBytes(clause.getColumnFamily()),
                Bytes.toBytes(clause.getColumnName()),
                CompareFilter.CompareOp.EQUAL, Bytes.toBytes(bsn));
        scan.setFilter(filterList1);

        Table table = connection.getTable(TableName.valueOf(clause.getTableName()));
        ResultScanner resultScanner = table.getScanner(scan);
        Iterator<Result> results = resultScanner.iterator();
        while (results.hasNext()) {
            Result result = results.next();
            RecordItem recordItem = new RecordItem(Bytes.toString(result.getRow()),
                    Bytes.toString(result.getValue(clause.getColumnFamily().getBytes(),
                            clause.getColumnName().getBytes())));

            recordItems.add(recordItem);
        }
        return recordItems;
    }

    public static List<RecordItem> queryRecodeItems(String bsn, ScanCriteria.Criteria clause) throws IOException {
        List<RecordItem> recordItems = new ArrayList<RecordItem>();
        Scan scan = new Scan();
        SingleColumnValueFilter filterList1 = new SingleColumnValueFilter(Bytes.toBytes(clause.getColumnFamily()),
                Bytes.toBytes(clause.getColumnName()),
                CompareFilter.CompareOp.EQUAL, Bytes.toBytes(bsn));
        scan.setFilter(filterList1);

        Table table = connection.getTable(TableName.valueOf(clause.getTableName()));
        ResultScanner resultScanner = table.getScanner(scan);
        Iterator<Result> results = resultScanner.iterator();
        while (results.hasNext()) {
            Result result = results.next();
            RecordItem recordItem = new RecordItem(Bytes.toString(result.getRow()),
                    Bytes.toString(result.getValue(clause.getColumnFamily().getBytes(),
                            clause.getColumnName().getBytes())));

            Cell detailCell = result.getColumnLatestCell(clause.getColumnFamily().getBytes()
                    , clause.getDetailColumnName().getBytes());
            // 获取详情
            recordItem.setDetail(Bytes.toString(detailCell.getValueArray()));

            recordItems.add(recordItem);
        }
        return recordItems;
    }

    public static boolean checkSNInFailedBill(String sn, ScanCriteria.Criteria clause) throws IOException {
        Scan scan = new Scan();
        SingleColumnValueFilter filterList1 = new SingleColumnValueFilter(Bytes.toBytes(clause.getColumnFamily()),
                Bytes.toBytes(clause.getColumnName()),
                CompareFilter.CompareOp.EQUAL, Bytes.toBytes(sn));
        scan.setFilter(filterList1);
        Table table = connection.getTable(TableName.valueOf(clause.getTableName()));
        ResultScanner resultScanner = table.getScanner(scan);
        Iterator<Result> results = resultScanner.iterator();
        if (results.hasNext()) {
            return true;
        }
        return false;
    }
}
