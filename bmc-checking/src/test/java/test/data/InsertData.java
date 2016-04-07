package test.data;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by xin on 16-4-7.
 */
public class InsertData {


    private Connection connection;
    private final String quorum = "BIU-DEV-BaaS-app1,BIU-DEV-BaaS-app2,BIU-DEV-BaaS-app3";
    private final String clientPort = "49181";
    private Properties properties;

    @Before
    public void initConnect() throws IOException {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", quorum);
        configuration.set("hbase.zookeeper.property.clientPort", clientPort);
        try {
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            throw new RuntimeException("initHBaseClient failure", e);
        }

        properties = new Properties();
        InputStream inputStream = InsertData.class.getResourceAsStream("/checker.cfg");
        if (inputStream != null) {
            properties.load(inputStream);
        }


    }

    @Test
    public void createTable() throws IOException {
        Admin admin = connection.getAdmin();
        createRecordTable(admin);
        createAuditTable(admin);
        createFailedBillTable(admin);

    }

    public void createFailedBillTable(Admin admin) throws IOException {
        String tableName = properties.getProperty
                ("hbase.failed.tableName");
        if (!admin.tableExists(TableName.valueOf(tableName))) {
            HTableDescriptor tableDesc = new HTableDescriptor(
                    TableName.valueOf(tableName));
            tableDesc.addFamily(new HColumnDescriptor(properties.getProperty("hbase.failed.columnFamilyName")));
            admin.createTable(tableDesc);
        }
    }

    private void createAuditTable(Admin admin) throws IOException {
        String tableName = properties.getProperty
                ("hbase.audit.tableName") + "201603";
        if (!admin.tableExists(TableName.valueOf(tableName))) {
            HTableDescriptor tableDesc = new HTableDescriptor(
                    TableName.valueOf(tableName));
            tableDesc.addFamily(new HColumnDescriptor(properties.getProperty("hbase.audit.columnFamilyName")));
            admin.createTable(tableDesc);
        }

        tableName = properties.getProperty
                ("hbase.audit.tableName") + "201604";
        if (!admin.tableExists(TableName.valueOf(tableName))) {
            HTableDescriptor tableDesc = new HTableDescriptor(
                    TableName.valueOf(tableName));
            tableDesc.addFamily(new HColumnDescriptor(properties.getProperty("hbase.audit.columnFamilyName")));
            admin.createTable(tableDesc);
        }
    }

    private void createRecordTable(Admin admin) throws IOException {
        String tableName = properties.getProperty
                ("hbase.record.detail.tableName") + "201603";
        if (!admin.tableExists(TableName.valueOf(tableName))) {
            HTableDescriptor tableDesc = new HTableDescriptor(
                    TableName.valueOf(tableName));
            tableDesc.addFamily(new HColumnDescriptor(properties.getProperty("hbase.record.detail.columnFamilyName")));
            admin.createTable(tableDesc);
        }

        tableName = properties.getProperty
                ("hbase.record.detail.tableName") + "201604";
        if (!admin.tableExists(TableName.valueOf(tableName))) {
            HTableDescriptor tableDesc = new HTableDescriptor(
                    TableName.valueOf(tableName));
            tableDesc.addFamily(new HColumnDescriptor(properties.getProperty("hbase.record.detail.columnFamilyName")));
            admin.createTable(tableDesc);
        }
    }

    @Test
    public void insertData() throws IOException {
        insertRecordData();
        insertAduitData();
    }

    private void insertAduitData() throws IOException {
        String tableName = properties.getProperty
                ("hbase.audit.tableName") + "201604";
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put("tst-001-001".getBytes());
        put.addColumn(properties.getProperty("hbase.audit.columnFamilyName").getBytes(),
                properties.getProperty("hbase.audit.bsn.columnName").getBytes(),
                "tst-001".getBytes());
        table.put(put);

        Put putA = new Put("tst-002-001".getBytes());
        putA.addColumn(properties.getProperty("hbase.audit.columnFamilyName").getBytes(),
                properties.getProperty("hbase.audit.bsn.columnName").getBytes(),
                "tst-002".getBytes());
        table.put(putA);
    }

    private void insertRecordData() throws IOException {
        String tableName = properties.getProperty
                ("hbase.record.detail.tableName") + "201604";
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put("tst-001-001".getBytes());
        put.addColumn(properties.getProperty("hbase.record.detail.columnFamilyName").getBytes(),
                properties.getProperty("hbase.recode.detail.bsn.columnName").getBytes(),
                "tst-001".getBytes());
        put.addColumn(properties.getProperty("hbase.record.detail.columnFamilyName").getBytes(),
                properties.getProperty("hbase.recode.detail.value.columnName").getBytes(),
                "tst-001".getBytes());
        table.put(put);

        Put putA = new Put("tst-002-001".getBytes());
        putA.addColumn(properties.getProperty("hbase.record.detail.columnFamilyName").getBytes(),
                properties.getProperty("hbase.recode.detail.bsn.columnName").getBytes(),
                "tst-002".getBytes());
        putA.addColumn(properties.getProperty("hbase.record.detail.columnFamilyName").getBytes(),
                properties.getProperty("hbase.recode.detail.value.columnName").getBytes(),
                "tst-002".getBytes());
        table.put(putA);

        Put putB = new Put("tst-002-002".getBytes());
        putB.addColumn(properties.getProperty("hbase.record.detail.columnFamilyName").getBytes(),
                properties.getProperty("hbase.recode.detail.bsn.columnName").getBytes(),
                "tst-002".getBytes());
        putB.addColumn(properties.getProperty("hbase.record.detail.columnFamilyName").getBytes(),
                properties.getProperty("hbase.recode.detail.value.columnName").getBytes(),
                "tst-002".getBytes());
        table.put(putB);
    }
}
