package com.ai.baas.bmc.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class MyHbaseUtil {
    private static Connection connection;

    static {
        Configuration configuration = HBaseConfiguration.create();
        // configuration.set("hbase.zookeeper.property.clientPort", "2181");
        // configuration.set("hbase.zookeeper.quorum", "node01,node02,node03");
        // configuration.set("hbase.master", "node01");
        try {
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
            LoggerUtil.log.error(e);
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * 获得表
     */
    public static Table getTable(String tableName) {
        try {
            return connection.getTable(TableName.valueOf(tableName));
        } catch (IOException e) {
            e.printStackTrace();
            LoggerUtil.log.error(e);
            return null;
        }
    }

    /**
     * 判断rowkey是否存在
     * 
     * @throws IOException
     */
    public static boolean hasExists(Table tableName, String rowkey) throws IOException {
        return hasExists(tableName, rowkey.getBytes("UTF-8"));
    }

    /**
     * 判断rowkey是否存在
     * 
     * @throws IOException
     */
    public static boolean hasExists(Table tableName, byte[] rowkey) throws IOException {
        return tableName.exists(new Get(rowkey));
    }

    /**
     * 获取值（family名字与qualifier名字相同）
     */
    public static String getCellValue(Result r, String name) {
        return getCellValue(r, name, name);
    }

    /**
     * 获取值（family名字与qualifier名字不同）
     */
    public static String getCellValue(Result r, String family, String qualifier) {
        return Bytes.toString(CellUtil.cloneValue(
                r.getColumnLatestCell(Bytes.toBytes(family), Bytes.toBytes(qualifier))));
    }

    /**
     * 写入hbase
     */
    public static void addData(Table tableName,String rowKey,CellTemp... cell) throws IOException {
        try {
            byte[] rowkey = rowKey.getBytes("UTF-8");
            addData(tableName, rowkey, cell);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    /**
     * 写入hbase
     */
    public static void addData(Table tableName,byte[] rowKey,CellTemp... cell) throws IOException {
        Put put = new Put(rowKey);
        for(CellTemp c : cell){
            put.addColumn(c.getFamily(), c.getQualifier(), c.getData());
        }
        tableName.put(put);
    }

    public static class CellTemp {
        private byte[] family;

        private byte[] qualifier;

        private byte[] data;

        private CellTemp() {
        }

        public static CellTemp inst(byte[] family,byte[] qualifier,byte[] data) {
            CellTemp cell = new CellTemp();
            cell.family=family;
            cell.qualifier=qualifier;
            cell.data=data;
            return cell;
        }
        public static CellTemp inst(String family,String qualifier,String data) {
            try {
                return inst(family.getBytes("UTF-8"), qualifier.getBytes("UTF-8"), data.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        public static CellTemp inst(String colum,String data) {
            try {
                return inst(colum.getBytes("UTF-8"), colum.getBytes("UTF-8"), data.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }

        public byte[] getFamily() {
            return family;
        }

        public byte[] getQualifier() {
            return qualifier;
        }

        public byte[] getData() {
            return data;
        }

    }
}
