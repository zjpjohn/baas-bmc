package com.ai.opt.baas.failbill;


import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;


public class HbaseTools {

	public final static String FIELD_SPLIT = new String(new char[] {(char) 1 });
	public final static String RECORD_SPLIT = new String(new char[] {(char) 2 });
	//create 'RTM_OUTPUT_DETAIL_SMC_201604','bsn','detail'
	
	public void insertData(){
		Connection conn = HBaseProxy.getConnection();
		byte[] rowKey = String.valueOf(System.currentTimeMillis()).getBytes();
		Table table = null;
		try {
			table = conn.getTable(TableName
					.valueOf("RTM_OUTPUT_DETAIL_201604"));

			Put put = new Put(rowKey);
			put.addColumn("bsn".getBytes(), "value".getBytes(), "1456281622845".getBytes());
			String data = getData();
			put.addColumn("detail".getBytes(), "record".getBytes(), data.getBytes());
			table.put(put);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (table != null) {
				try {
					table.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void query(){
		Table table;
		try {
			table = HBaseProxy.getConnection().getTable(TableName.valueOf("RTM_OUTPUT_DETAIL_201604"));
			Scan scan = new Scan();
			scan.setFilter(new SingleColumnValueFilter("bsn".getBytes(),
					"value".getBytes(), CompareFilter.CompareOp.EQUAL,
					new BinaryComparator("JSBIUGZT20160412124".getBytes())));
			ResultScanner rs = table.getScanner(scan);
			for (Result r : rs) {// 按行去遍历
				String line = "";
				for (KeyValue kv : r.raw()) {// 遍历每一行的各列
					if (Bytes.toString(kv.getQualifier()).equals("record")) {
						line = Bytes.toString(kv.getValue());
						System.out.println("---"+line);
					}
				}
			}
			rs.close();
			table.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getData(){
		StringBuilder sb = new StringBuilder();
		sb.append("MVNE").append(FIELD_SPLIT);
		sb.append("msg").append(FIELD_SPLIT);
		sb.append("msg").append(FIELD_SPLIT);
		sb.append("20150401001").append(FIELD_SPLIT);
		sb.append("1064802120010120060709230900113").append(FIELD_SPLIT);
		sb.append("201604").append(FIELD_SPLIT);
		sb.append("20160410").append(FIELD_SPLIT);
		sb.append("20150401001").append(FIELD_SPLIT);
		sb.append("1").append(FIELD_SPLIT);
		sb.append("1064802120010120060709230900116").append(FIELD_SPLIT);
		sb.append("hx").append(FIELD_SPLIT);
		sb.append("bw").append(FIELD_SPLIT);
		sb.append("13012345678").append(FIELD_SPLIT);
		sb.append("20160405").append(FIELD_SPLIT);
		sb.append("abcfdafsdaf").append(FIELD_SPLIT);
		sb.append("1");
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		HbaseTools demo = new HbaseTools();
		//demo.insertData();
		demo.query();
	}

}
