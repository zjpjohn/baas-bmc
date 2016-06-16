package com.ai.baas.bmc.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet.STRONG;


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
    
    /**
     * 根据rowkey进行模糊查询  TR_VOICE_TEST_201604
     *
     */
    public static Map<String, Object> resGetData(String tableName,String resRowKey){
    	System.out.println("the rowkey is ............ "+resRowKey);
    	LoggerUtil.log.debug("     rowKey is       "+resRowKey);
    	Scan scan = new Scan();
    	Table table=getTable(tableName);
    	StringBuilder regRowKey=new StringBuilder();
    	regRowKey.append("^").append(resRowKey).append(".*");
    	//Filter filter= new RowFilter(CompareOp.EQUAL, new SubstringComparator(resRowKey));
    	Filter filter= new RowFilter(CompareOp.EQUAL, new RegexStringComparator(regRowKey.toString()));
    	scan.setFilter(filter);
    	ResultScanner resultScan;
    	Map<String, Object> drMap=new HashMap<String, Object>();
		try {
			resultScan = table.getScanner(scan);
			for(Result result:resultScan){
				String rowKey=new String(result.getRow());
				//System.out.println("the real rowkey is "+rowKey);
				Map<String, String> dataMap=new HashMap<String,String>();
				for(Cell r:result.rawCells()){
					dataMap.put(new String(CellUtil.cloneQualifier(r)),new String(CellUtil.cloneValue(r)));
				}
				//将map转换成json
				Object data=JSONObject.fromObject(dataMap);
				System.out.println("the data is "+data);
				drMap.put(rowKey, data);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
    	return drMap;
    }

//   public static void main(String[] args){
//    	String tableName="VIV-BYD_GPRS_DR_201606";
//    	String rowkeyString="^iccid1063s10631063GPRS.*";
//   	//String rowkeyString="iccid1063s10631063GPRS20160601230901iccid106320160601110BYDBILL20160602153703.zip";
//    	Scan scan = new Scan();
//   	    Table table=getTable(tableName);
//    	//Filter filter= new RowFilter(CompareOp.EQUAL, new SubstringComparator(resRowKey));
//   	Filter filter= new RowFilter(CompareOp.EQUAL, new RegexStringComparator(rowkeyString));
//   	scan.setFilter(filter);
//   	ResultScanner resultScan;
//   	try {
//			resultScan = table.getScanner(scan);
//			for(Result result:resultScan){
//				
//				String rowKey=new String(result.getRow());
//				System.out.println("the real rowkey is "+rowKey);
//				Map<String, String> dataMap=new HashMap<String,String>();
//				for(Cell r:result.rawCells()){
//					//dataMap.put(CellUtil.cloneQualifier(r).toString(),CellUtil.cloneValue(r).toString());
//					System.out.println("qualifier is"+new String(CellUtil.cloneQualifier(r))+"   value is "+new String(CellUtil.cloneValue(r)));
//				}
//			}
//   	}catch(Exception e){
//				e.printStackTrace();
//		}
//   }

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
