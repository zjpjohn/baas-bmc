//package com.ai.opt.baas.bmc.test.hbase;
//
//import java.io.IOException;
//import java.util.Map.Entry;
//import java.util.NavigableMap;
//
//import org.apache.hadoop.hbase.Cell;
//import org.apache.hadoop.hbase.TableName;
//import org.apache.hadoop.hbase.client.Connection;
//import org.apache.hadoop.hbase.client.Get;
//import org.apache.hadoop.hbase.client.Put;
//import org.apache.hadoop.hbase.client.Result;
//import org.apache.hadoop.hbase.client.ResultScanner;
//import org.apache.hadoop.hbase.client.Scan;
//import org.apache.hadoop.hbase.client.Table;
//import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
//import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
//import org.apache.hadoop.hbase.filter.Filter;
//import org.apache.hadoop.hbase.filter.FilterList;
//import org.apache.hadoop.hbase.filter.PageFilter;
//import org.apache.hadoop.hbase.filter.RowFilter;
//import org.apache.hadoop.hbase.util.Bytes;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class HbaseClientTest {
//
//    private static Logger logger = LoggerFactory.getLogger(HbaseClientTest.class);
//
//    public static final String FIELD_SPLIT = new String(new char[] { (char) 1 });
//
//    public void run() throws Exception {
//        String tableName = "smc-test";
//        String column = "col-test";
//        String tenantId = "MVNE";
//        String billId = "261";
//        String billMonth = "201604";
//        // HbaseClient.getInstance().creatTable(tableName, new String[] { column });
//        StringBuffer str = new StringBuffer();
//        str.append(tenantId).append("_").append(billId).append("_").append(billMonth);
//        String rowkey = str.toString();
//        System.out.println("rowkey=============================" + rowkey);
//        logger.debug("rowkey=============================" + rowkey);
//        Connection conn = HbaseClient.getInstance().getConnection();
//        Table table = conn.getTable(TableName.valueOf(tableName));
//        for (int i = 1; i < 25; i++) {
//            rowkey = tenantId + SmcHbaseConstant.ROWKEY_SPLIT + billId
//                    + SmcHbaseConstant.ROWKEY_SPLIT + i;
//            Put put = new Put(rowkey.getBytes());
//            put.addColumn(column.getBytes(), "tenant_id".getBytes(), tenantId.getBytes());
//            put.addColumn(column.getBytes(), "bill_id".getBytes(), billId.getBytes());
//            put.addColumn(column.getBytes(), "bill_month".getBytes(), Bytes.toBytes(i));
//            table.put(put);
//        }
//
//        Get get = new Get(rowkey.getBytes());
//        Result result = table.get(get);
//        byte[] tenant_id = result.getValue(column.getBytes(), "tenant_id".getBytes());
//        if (tenant_id == null) {
//            System.out.println("------------------------------");
//            logger.debug("------------------------------");
//        } else {
//            System.out.println("tenant_id=" + new String(tenant_id));
//        }
//
//        Scan scan = new Scan();
//        Filter filter = new RowFilter(CompareOp.EQUAL,
//                new BinaryPrefixComparator("MVNE".getBytes()));
//        scan.setFilter(filter);
//        ResultScanner rs = table.getScanner(scan);
//        System.out.println("rs=============================" + rs);
//        for (Result rt : rs) {
//            System.out.println(new String(rt.getRow()));
//            tenant_id = rt.getValue(column.getBytes(), "tenant_id".getBytes());
//            if (tenant_id == null) {
//                System.out.println("------------------------------");
//                logger.debug("------------------------------");
//            } else {
//                System.out.println("tenant_id=" + new String(tenant_id));
//            }
//        }
//
//    }
//
//    public static void main(String[] args) throws Exception {
//        // HbaseClientTest client = new HbaseClientTest();
//        // client.run();
//        // scanTest();
//        // getTest();
//        test();
//    }
//
//    private static void test() throws IOException {
//        String rowKey = "MVNE_261_1";
//        String tableName = "smc-test";
//        String column = "col-test";
//        Table table = HbaseClient.getInstance().getConnection()
//                .getTable(TableName.valueOf("smc-test"));
//        Get get = new Get(rowKey.getBytes());
//        Result result = table.get(get);
//        NavigableMap<byte[], byte[]> navigableMap = result.getFamilyMap(column.getBytes());
//        for (Entry<byte[], byte[]> entry : navigableMap.entrySet()) {
//            System.out.println(new String(entry.getKey()));
//            System.out.println(new String(entry.getValue()));
//        }
//        for (Entry<byte[], byte[]> entry : navigableMap.entrySet()) {
//            System.out.println(new String(entry.getKey()));
//            System.out.println(new String(entry.getValue()));
//        }
//    }
//
//    private static void getTest() throws IOException {
//        Get get = new Get("MVNE_261_4".getBytes());
//        Table table = HbaseClient.getInstance().getConnection()
//                .getTable(TableName.valueOf("smc-test"));
//        Result s = table.get(get);
//        System.out.println(new String(s.getRow()));
//    }
//
//    private static void scanTest() throws IOException {
//        Filter filter = new RowFilter(CompareOp.EQUAL,
//                new BinaryPrefixComparator("MVNE".getBytes()));
//
//        PageFilter filter1 = new PageFilter(10);
//
//        FilterList list = new FilterList(FilterList.Operator.MUST_PASS_ALL);
//        list.addFilter(filter1);
//        list.addFilter(filter);
//
//        Scan scan = new Scan();
//        scan.setFilter(list);
//        // scan.setStartRow("MVNE_261_18".getBytes());
//        // scan.setStopRow("MVNE_261_3".getBytes());
//
//        Connection conn = HbaseClient.getInstance().getConnection();
//
//        Table table = conn.getTable(TableName.valueOf("smc-test"));
//
//        ResultScanner rs = table.getScanner(scan);
//        for (Result rt : rs) {
//            NavigableMap<byte[], byte[]> map = rt.getFamilyMap("col-test".getBytes());
//
//            Cell cell = rt.getColumnLatestCell("col-test".getBytes(), "tenant_id".getBytes());
//            System.out.println(new String(cell.getFamilyArray(), "gbk"));
//            System.out.println(new String(cell.getQualifierArray()));
//            System.out.println(new String(cell.getRowArray()));
//            System.out.println(new String(cell.getTagsArray()));
//            System.out.println(new String(cell.getValueArray()));
//            String rowKey = new String(rt.getRow());
//            System.out.println(rowKey);
//            System.out.println(new String(rt.getFamilyMap("col-test".getBytes()).get(
//                    "tenant_id".getBytes())));
//
//            Put put = new Put((rowKey + "_copy").getBytes());
//            Entry<byte[], byte[]> entry = map.pollFirstEntry();
//            while (entry != null) {
//                put.addColumn("col-test".getBytes(), entry.getKey(), entry.getValue());
//                entry = map.pollFirstEntry();
//            }
//            table.put(put);
//        }
//    }
//
//}
